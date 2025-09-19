package com.example.simpletodolist.controller;

import com.example.simpletodolist.model.todoList;
import com.example.simpletodolist.service.todoListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class todoListController {
    private final todoListService service;

    public todoListController(todoListService service) {
        this.service = service;
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<todoList>> getAllTasks() {
        return new ResponseEntity<>(service.getAllTasks(), HttpStatus.OK);
    }
    
    @GetMapping("/task/{id}")
    public ResponseEntity<Optional<todoList>> getAllTasks(@PathVariable int id) {
        Optional<todoList> task = service.getTaskByID(id);
        if(task.isPresent()){
            return new ResponseEntity<>(task,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/task/addTask")
    public ResponseEntity<todoList> addTask(@RequestBody todoList t){
        todoList task = service.addTask(t);
        return new ResponseEntity<>(task, HttpStatus.OK);


    }
    @PutMapping("/task/modTask")
    public ResponseEntity<todoList> updateTask(@RequestBody todoList t){
        todoList task = service.updateTask(t);
        if(task != null) {
            return new ResponseEntity<>(task, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/task/delTask{id}")
    public ResponseEntity<Optional<todoList>> deleteTask(@PathVariable int id){
        Optional<todoList> task = service.getTaskByID(id);
        if(task.isPresent()){
            service.delTask(id);
            return new ResponseEntity<>(task, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
