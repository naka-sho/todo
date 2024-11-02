package com.example.todo.controller;

import com.example.todo.model.Todo;
import com.example.todo.mapper.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TodoController {

    @Autowired
    private TodoMapper todoMapper;

    @GetMapping("/")
    public String listTodos(Model model) {
        List<Todo> todos = todoMapper.findAll();
        model.addAttribute("todos", todos);
        return "todo/list";
    }

    @PostMapping("/add")
    public String addTodo(@ModelAttribute Todo todo) {
        todoMapper.insert(todo);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editTodoForm(@PathVariable Long id, Model model) {
        Todo todo = todoMapper.findById(id);
        model.addAttribute("todo", todo);
        return "todo/edit";
    }

    @PostMapping("/edit/{id}")
    public String editTodo(@PathVariable Long id, @ModelAttribute Todo todo) {
        todo.setId(id);
        todoMapper.update(todo);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id) {
        todoMapper.delete(id);
        return "redirect:/";
    }
}
