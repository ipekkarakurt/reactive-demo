package com.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

import java.util.Date;

@Data
@Document(collection = "events")
public class Event {
    @Id
    private String id;
    private String description;

    public Event(String id, String description) {
        this.id = id;
        this.description = description;
    }
}
