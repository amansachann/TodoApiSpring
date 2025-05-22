package com.codewithaman.todoapispring;


import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {
    private static List<Todo> todos;

    public TodoController() {
        todos = new ArrayList<>();
        todos.add(new Todo("Go to gym", 1, false, 101));
        todos.add(new Todo("Go to school", 2, true, 102));
    }
}
