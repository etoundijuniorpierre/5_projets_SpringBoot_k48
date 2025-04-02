package com.example.To_Do.List.controller;

import com.example.To_Do.List.model.TodoList;
import com.example.To_Do.List.service.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/toDoList")
public class ToDoListController {

    private final ToDoListService toDoListService;

    @Autowired
    public ToDoListController(ToDoListService toDoListService) {
        this.toDoListService = toDoListService;
    }

    @PostMapping("/addElem")
    public String add(@RequestBody TodoList toDoList) {
        toDoListService.AddToDoList(toDoList);
        return "Success";
    }

    @GetMapping("/getAllTodo")
    public List<TodoList> getAllTodoList() {
        return this.toDoListService.getAllTodoList();
    }

    @GetMapping("/getOneTodo/{status}")
    public ResponseEntity<List<TodoList>> getElemByStatus(@PathVariable String status) {
        List<TodoList> getElem = this.toDoListService.getElemByStatus(status);
        return ResponseEntity.ok(getElem);
    }

    @PutMapping("/updateTodo/{id}")
    public ResponseEntity<TodoList> updateTodoList(@PathVariable Long id, @RequestBody TodoList updatedTodoList) {
        TodoList updatedItem = toDoListService.updateTodoList(id, updatedTodoList);
        return ResponseEntity.ok(updatedItem);
    }

    @DeleteMapping("/deleteTodo/{id}")
    public ResponseEntity<Map<String, Object>> deleteElemById(@PathVariable Long id) {
        this.toDoListService.deleteElemById(id);
        List<TodoList> list = this.toDoListService.getAllTodoList();

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Element with id " + id + " deleted successfully.");
        response.put("updatedList", list);

        return ResponseEntity.ok(response);
    }
}