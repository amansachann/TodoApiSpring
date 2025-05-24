package com.codewithaman.todoapispring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {
    private static List<Todo> todoList;

    private TodoService todoService;
    private TodoService todoService2;

    public TodoController(
            @Qualifier("fakeTodoService") TodoService todoService,
            @Qualifier("anotherTodoService") TodoService todoService2
    ) {
        this.todoService = todoService;
        this.todoService2 = todoService2;
        todoList = new ArrayList<>();
        todoList.add(new Todo("Go to gym", 1, false, 101));
        todoList.add(new Todo("Go to school", 2, true, 102));
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos() {
        System.out.println(todoService.doSomething());
        System.out.println(todoService2.doSomething());
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

    @PatchMapping("/{todoId}")
    public ResponseEntity<Todo> updateTodoById(@PathVariable  int todoId, @RequestBody Todo updatedTodo) {
        for(Todo todo: todoList) {
            if(todo.getId() == todoId) {
                if(updatedTodo.getUserId() != null) todo.setUserId(updatedTodo.getUserId());
                if(updatedTodo.getTodo() != null) todo.setTodo(updatedTodo.getTodo());
                if(updatedTodo.isCompleted() != null) todo.setCompleted(updatedTodo.isCompleted());
            }
            return ResponseEntity.ok(todo);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity<Todo> deleteTodoById(@PathVariable int todoId) {
        for(Todo todo: todoList) {
            if(todo.getId() == todoId) {
                todoList.remove(todo);
                return ResponseEntity.ok(todo);
            }
        }
        return ResponseEntity.notFound().build();
    }
}
