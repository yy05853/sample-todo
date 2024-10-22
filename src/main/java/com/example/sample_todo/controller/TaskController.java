package com.example.sample_todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sample_todo.entity.Task;
import com.example.sample_todo.repository.TaskRepository;
import com.example.sample_todo.service.TaskService;

@Controller
public class TaskController {

    private final TaskRepository taskRepository;
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskRepository taskRepository, TaskService taskService) {
        this.taskRepository = taskRepository;
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("tasks", taskService.getTasks());
        model.addAttribute("inputTask", new Task());
        return "index";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("inputTask") Task inputTask, Model model) {
        taskService.addTask(inputTask);

        model.addAttribute("tasks", taskService.getTasks());
        model.addAttribute("inputTask", new Task());
        return "index";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam String id, Model model) {
        taskService.deleteTask(Long.parseLong(id));
        model.addAttribute("tasks", taskService.getTasks());
        model.addAttribute("inputTask", new Task());
        return "index";
    }
}
