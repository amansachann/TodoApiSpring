package com.codewithaman.todoapispring;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {
    private static List<Todo> todoList;

    public TodoController() {
        todoList = new ArrayList<>();
        todoList.add(new Todo("Go to gym", 1, false, 101));
        todoList.add(new Todo("Go to school", 2, true, 102));
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos() {
        return ResponseEntity.ok(todoList);
    }

    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Todo newTodo) {
        /*
         * @ResponseStatus(HttpStatus.CREATED)
         * we can use this annotation to return status code.
         */
        todoList.add(newTodo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTodo);
    }

    @GetMapping("/{todoId}")
    public ResponseEntity<?> getTodoById(@PathVariable("todoId") int id) {
        for(Todo todo: todoList) {
            if(todo.getId() == id) return ResponseEntity.ok(todo);
        }

        /*
         * return ResponseEntity.notFound().build();
         * This is the simpler way to return Not Found Status
         * without any custom message
         */

//        Return Not Found Status along with custom message
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("status", "404");
        errorResponse.put("message", "Todo with id " + id + " not found.");
        errorResponse.put("timestamp", String.valueOf(LocalDateTime.now()));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}
