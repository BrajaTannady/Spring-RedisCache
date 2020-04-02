package com.example.SpringRedisCache.repository;

import com.example.SpringRedisCache.entity.ListTodo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ListRepository extends MongoRepository<ListTodo, String> {
    List<ListTodo> findAllByStatus(boolean status);
}
