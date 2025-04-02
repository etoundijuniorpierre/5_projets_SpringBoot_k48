package com.example.To_Do.List.service;

import com.example.To_Do.List.model.TodoList;
import com.example.To_Do.List.model.Status;
import com.example.To_Do.List.repository.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoListServiceImpl implements ToDoListService {

    private final ToDoListRepository toDoListRepository;

    @Autowired
    public ToDoListServiceImpl(ToDoListRepository toDoListRepository) {
        this.toDoListRepository = toDoListRepository;
    }

    @Override
    public TodoList AddToDoList(TodoList toDoList) {
        return toDoListRepository.save(toDoList);
    }

    @Override
    public List<TodoList> getAllTodoList() {
        return this.toDoListRepository.findAll();
    }

    @Override
    public List<TodoList> getElemByStatus(String status) {
        return this.toDoListRepository.findByStatus(Status.valueOf(status));
    }

    @Override
    public TodoList deleteElemById(Long id) {
        TodoList todoList = this.toDoListRepository.findById(id).orElseThrow(() -> new RuntimeException("todoList with id(" + id +") don't exist") );
        this.toDoListRepository.deleteById(id);
        return todoList;
    }

    @Override
    public TodoList updateTodoList(Long id, TodoList updatedTodoList) {
        // Find the existing TodoList item by ID
        Optional<TodoList> existingTodoListOptional = toDoListRepository.findById(id);

        if (((java.util.Optional<?>) existingTodoListOptional).isPresent()) {
            // Update the existing item with the new data
            TodoList existingTodoList = existingTodoListOptional.get();
            existingTodoList.setTitle(updatedTodoList.getTitle());
            existingTodoList.setDescription(updatedTodoList.getDescription());
            existingTodoList.setStatus(updatedTodoList.getStatus());

            // Save the updated item
            return toDoListRepository.save(existingTodoList);
        } else {
            // If the item is not found, return null or throw an exception
            throw new RuntimeException("TodoList item not found with id: " + id);
        }
    }


}