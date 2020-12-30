package com.fastcampus.todo.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class Todo {
    Long id;
    String title;
    String description;
    String owner;
    String category;
    LocalDate dueDate;
}