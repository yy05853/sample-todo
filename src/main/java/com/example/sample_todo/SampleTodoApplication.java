package com.example.sample_todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// このクラスはSpring Initializrで勝手に作成されるが、重要なので消してはいけない。
// このクラスがある階層以下のクラスはSpring Bootのコンポーネントスキャンの対象となる。
// 簡単に言うと、このクラスがないとSpring Bootが起動しないし、@Controllerや@Serviceなどのアノテーションの意味がなくなる。
// https://zenn.dev/simsim/articles/52a65b7189cfe2#1.-%40springbootapplication
@SpringBootApplication
public class SampleTodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleTodoApplication.class, args);
	}

}
