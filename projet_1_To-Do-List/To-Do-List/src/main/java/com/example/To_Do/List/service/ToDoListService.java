package com.example.To_Do.List.service;

import com.example.To_Do.List.model.TodoList;

import java.util.List;

public interface ToDoListService {
    TodoList AddToDoList(TodoList toDoList);

    List<TodoList> getAllTodoList();

    List<TodoList> getElemByStatus(String status);

    TodoList deleteElemById(Long id);

    TodoList updateTodoList(Long id, TodoList updatedTodoList);


}