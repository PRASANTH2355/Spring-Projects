package com.prasanth.todoapp.service;

import com.prasanth.todoapp.model.TodoEntity;
import com.prasanth.todoapp.repo.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    TodoRepo todoRepo;

    public List<TodoEntity> getAllTodos(){
        return todoRepo.findAll();
    }

    public void addTodos(TodoEntity todoEntity){
        todoEntity.setStatus(false);
        todoRepo.save(todoEntity);
    }

    public void updateTodo(Long id){
        TodoEntity todoEntity =  todoRepo.findById(id).orElseThrow(() ->
                        new RuntimeException("Todo not found : "+id));
        todoEntity.setStatus(!todoEntity.getStatus());
        todoRepo.save(todoEntity);
    }

    public void deleteTodo(Long id){
        todoRepo.deleteById(id);
    }
}
