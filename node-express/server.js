const express = require('express');
const app = express();

const port = 3001;

app.get('/timestamp',
    (_req, res) => res.json(
        {
            timestamp: new Date().getTime()
        }
    )
);

const mongoose = require('mongoose');
const url = 'mongodb://localhost:27017/nodejs';

mongoose.connect(url, { useNewUrlParser: true });
const db = mongoose.connection;
db.on('error', console.error.bind(console, 'MongoDB connection error:'));

const Schema = mongoose.Schema;

const DocumentSchema = new Schema({ title: String });

const DocumentModel = mongoose.model('Document', DocumentSchema );

app.post('/documents', (req, res) => {

    const document = new DocumentModel({
        title: `Document ${new Date().getTime()}`
    });
    document.save().catch(error => { console.log(error) });

    res.json(document);
});

app.get('/documents', (req, res) => {
    DocumentModel
        .findOne({})
        .exec(function (err, document) {
            if (err) console.log(err);
            res.json(document);
        });
});

app.listen(port, () => console.log(`Listening on port ${port}`));
