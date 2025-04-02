package com.example.To_Do.List.repository;

import com.example.To_Do.List.model.Status;
import com.example.To_Do.List.model.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoListRepository extends JpaRepository<TodoList, Long> {

    List<TodoList> findByStatus(Status status);

}