package com.example.sample_todo.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// @Entityアノテーションを付与することで、このクラスがエンティティであることを示す
// これはSpring Bootのアノテーションではなく、JPAのアノテーションである(import文を見るとわかる)
@Entity
public class Task {
    // 主キーを示す@Idアノテーションを付与する
    @Id
    // @GeneratedValueアノテーションを付与することで、主キーの値が自動で生成されることを示す
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private LocalDate dueDate;

    // JPAでは空のコンストラクタ(デフォルトコンストラクタ)が必要になる
    // 他にコンストラクタがなければ、デフォルトコンストラクタは暗黙的に生成されるので、今回は書いてない

    // JPAを動かすためにgetter,setterも必要なので以下に記述する
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}