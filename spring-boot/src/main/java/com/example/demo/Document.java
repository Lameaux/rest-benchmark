package com.example.demo;

import org.springframework.data.annotation.Id;

public class Document {
    @Id
    public String id;

    public String title;

    public Document() {}

    public Document(String title) {
        this.title = title;
    }
}
