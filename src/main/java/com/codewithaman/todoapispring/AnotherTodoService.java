package com.codewithaman.todoapispring;

import org.springframework.stereotype.Service;

@Service
public class AnotherTodoService implements TodoService{

    @Override
    public String doSomething() {
        return "Doing something else";
    }
}
