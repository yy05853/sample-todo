package com.example.sample_todo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.sample_todo.entity.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {}
