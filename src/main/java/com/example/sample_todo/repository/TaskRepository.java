package com.example.sample_todo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.sample_todo.entity.Task;

@Repository
// これはインターフェース。CrudRepositoryを継承するだけでDB操作が可能になる
// https://qiita.com/shukawam/items/6e379df031dccebddd36#repository-%E3%82%A4%E3%83%B3%E3%82%BF%E3%83%95%E3%82%A7%E3%83%BC%E3%82%B9%E3%82%92%E5%AE%9A%E7%BE%A9%E3%81%99%E3%82%8B
public interface TaskRepository extends CrudRepository<Task, Long> {}
