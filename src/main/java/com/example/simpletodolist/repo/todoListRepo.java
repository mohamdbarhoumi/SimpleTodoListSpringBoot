package com.example.simpletodolist.repo;
import com.example.simpletodolist.model.todoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface todoListRepo extends JpaRepository<todoList, Integer> {
}
