package com.example.simpletodolist.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Entity
@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
public class todoList {
    @Id
    private int id;
    private String title;
    private String description;
    private boolean done;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date dueDate;
}
