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

app.listen(port, () => console.log(`Listening on port ${port}`));
