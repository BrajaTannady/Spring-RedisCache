package com.example.SpringRedisCache.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Getter
@Setter
@Document(collection = "List")
public class ListTodo implements Serializable {
    @Id
    private String listName;
    private boolean status;
}
