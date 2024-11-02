package com.example.sample_todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sample_todo.entity.Task;
import com.example.sample_todo.repository.TaskRepository;

@Service
public class TaskService {

    // TaskRepositoryをインスタンス化
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // TaskRepositoryの(というよりCrudRepositoryの)メソッドを使ってDB操作を行う

    public List<Task> getTasks() {
        return (List<Task>) taskRepository.findAll();
    }
    
    public void addTask(Task task) {
        taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
