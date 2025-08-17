package com.prasanth.todoapp.controller;

import com.prasanth.todoapp.model.TodoEntity;
import com.prasanth.todoapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping({"","/","/home"})
    public String HomePage(Model model){
        model.addAttribute("todos", todoService.getAllTodos());
        return "index";
    }

    @PostMapping("/add")
    private String add(@ModelAttribute TodoEntity todoEntity){
        todoService.addTodos(todoEntity);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    private String update(@PathVariable Long id){
        todoService.updateTodo(id);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    private String delete(@PathVariable Long id){
        todoService.deleteTodo(id);
        return "redirect:/";
    }
}
