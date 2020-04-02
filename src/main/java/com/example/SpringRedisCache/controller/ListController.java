package com.example.SpringRedisCache.controller;

import com.example.SpringRedisCache.entity.ListTodo;
import com.example.SpringRedisCache.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListController {
    @Autowired
    ListService service;

    @CacheEvict(value = "todos", allEntries = true)
    @PostMapping("/insertList")
    public String insertList(@RequestBody ListTodo listTodo){
        System.out.println("Insert record");
        return service.addList(listTodo);
    }

    @Cacheable(value = "todos")
    @GetMapping("/findAllList")
    public List<ListTodo> findAllList(){
        System.out.println("Getting all record");
        return service.allList();
    }

    @Cacheable(value = "todos", key = "#status")
    @GetMapping("/findAllListByStatus/{status}")
    public List<ListTodo> findAllListByStatus(@PathVariable boolean status){
        System.out.println("Getting record");
        return service.allListByStatus(status);
    }

    @CacheEvict(value = "todos", allEntries = true)
    @PutMapping("/updateListName/{listName}")
    public String updateList(@PathVariable String listName, @RequestBody ListTodo updatedList){
        System.out.println("Update record");
        return service.updateList(listName, updatedList);
    }

    @CacheEvict(value = "todos", allEntries = true)
    @PutMapping("/updateCompleted/{listName}")
    public String updateListStatusToCompleted(@PathVariable String listName){
        System.out.println("Update record");
        return service.updateListStatusToCompleted(listName);
    }

    @CacheEvict(value = "todos", allEntries = true)
    @PutMapping("/updateActive/{listName}")
    public String updateListStatusToActive(@PathVariable String listName){
        System.out.println("Update record");
        return service.updateListStatusToActive(listName);
    }

    @CacheEvict(value = "todos", allEntries = true)
    @PutMapping("/updateAllStatus/{status}")
    public String updateAllStatus(@PathVariable boolean status){
        System.out.println("Update record");
        return service.updateAllStatus(status);
    }

    @CacheEvict(value = "todos", allEntries = true)
    @DeleteMapping("/deleteList/{listName}")
    public String deleteByListName(@PathVariable String  listName){
        System.out.println("Delete record");
        return service.deleteByListName(listName);
    }

    @CacheEvict(value = "todos", allEntries = true)
    @DeleteMapping("/deleteAll")
    public String deleteAll(){
        System.out.println("Delete all record");
        return service.deleteAll();
    }
}
