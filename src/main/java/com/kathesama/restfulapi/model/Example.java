package com.kathesama.restfulapi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

@Data
@Document
public class Example {
    @Id
    private String id;

    @Indexed(unique = true)
    private String name;

    private LocalDateTime created;

    public Example(String name, LocalDateTime created) {
        this.name = name;
        this.created = created;
    }
}
