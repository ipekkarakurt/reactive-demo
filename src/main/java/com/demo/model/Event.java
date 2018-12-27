package com.demo;

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
    private long id;
    private Date date;

    public Event(long id, Date date) {
        this.id = id;
        this.date = date;
    }
}
