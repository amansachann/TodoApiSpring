package com.codewithaman.todoapispring;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {
    private static List<Todo> todoList;

    public TodoController() {
        todoList = new ArrayList<>();
        todoList.add(new Todo("Go to gym", 1, false, 101));
        todoList.add(new Todo("Go to school", 2, true, 102));
    }

    @GetMapping(path = "/todos")
    public ResponseEntity<List<Todo>> getAllTodos() {
        return ResponseEntity.ok(todoList);
    }

    @PostMapping("/todos")

    public ResponseEntity<Todo> createTodo(@RequestBody Todo newTodo) {
        /*
         * @ResponseStatus(HttpStatus.CREATED)
         * we can use this annotation to return status code.
         */
        todoList.add(newTodo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTodo);
    }
}
