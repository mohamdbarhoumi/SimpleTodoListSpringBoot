package com.example.simpletodolist.service;

import com.example.simpletodolist.model.todoList;
import com.example.simpletodolist.repo.todoListRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class todoListService {

    private final todoListRepo repo;

    public todoListService(todoListRepo repo) {
        this.repo = repo;
    }


    public String greet() {
        return "hello there detective";
    }

    public List<todoList> getAllTasks() {
        return repo.findAll();
    }

    public Optional<todoList> getTaskByID(int id) {
        return repo.findById(id);

    }

    public todoList addTask(todoList t) {
        return repo.save(t);
    }

    public todoList updateTask(todoList t) {
        return repo.save(t);
    }
    public void delTask(int id){
        repo.deleteById(id);
    }
}