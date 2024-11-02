package com.example.todo.service;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> listTodos() {
        return todoRepository.findAll();
    }

    public void addTodo(Todo todo) {
        todoRepository.insert(todo);
    }

    public Todo getTodoById(Long id) {
        return todoRepository.findById(id);
    }

    public void updateTodo(Todo todo) {
        todoRepository.update(todo);
    }

    public void deleteTodoById(Long id) {
        todoRepository.delete(id);
    }
}
