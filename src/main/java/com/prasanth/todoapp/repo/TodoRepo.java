package com.prasanth.todoapp.repo;

import com.prasanth.todoapp.model.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepo extends JpaRepository<TodoEntity, Long> {

}
