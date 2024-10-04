package com.example.sample_todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.sample_todo.entity.Task;
import com.example.sample_todo.repository.TaskRepository;

@Controller
public class TaskController {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskController(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @GetMapping("/")
    public String index() {
        Task task = taskRepository.findById(1);
        System.out.println(task.getTitle() + " : " + task.getDueDate());
        return "index";
    }
}
