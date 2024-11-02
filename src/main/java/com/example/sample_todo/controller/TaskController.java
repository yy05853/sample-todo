package com.example.sample_todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sample_todo.entity.Task;
import com.example.sample_todo.service.TaskService;

// @Controllerアノテーションを付与することで、Spring Bootがコンポーネントスキャンを行い、このクラスをコントローラとして認識する。
@Controller
public class TaskController {

    // TaskControllerクラスのフィールド
    // 後述の@Autowiredアノテーションにより、TaskServiceクラスのインスタンスが自動で注入される
    // 「自動で」とは、Spring Bootが起動時にTaskServiceクラスのインスタンスを生成してくれるので、
    // 明示的にnew TaskService()する必要がないということ
    private final TaskService taskService;

    // TaskControllerクラスのコンストラクタ
    // @Autowiredアノテーションを付与することで、TaskServiceクラスのインスタンスが自動で注入される
    // 上述のフィールド宣言とはセットで使う
    // これをコンストラクタインジェクションという
    // https://qiita.com/yuto-hatano/items/69d01343f710117e4243
    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // @GetMappingアノテーションを付与するだけで、`http://localhost:8080/` にアクセスしたHTTP GETリクエストを受け取ることができる
    @GetMapping("/")
    // 引数に `Model model` を指定することで、画面とデータやりとりすることができる
    public String index(Model model) {
        // `tasks` という属性に `taskService.getTasks()` の戻り値をセットする
        model.addAttribute("tasks", taskService.getTasks());
        // `inputTask` という属性に 空のTaskインスタンスをセットする
        model.addAttribute("inputTask", new Task());
        // src/main/resources/templates/index.htmlというテンプレートファイルを使って画面を表示する
        return "index";
    }

    // @PostMappingアノテーションを付与するだけで、`http://localhost:8080/register` にアクセスしたHTTP POSTリクエストを受け取ることができる
    @PostMapping("/register")
    // 引数に `@ModelAttribute("inputTask")` を指定することで、画面からPOST送信されたデータをTaskクラスのインスタンスとして受け取ることができる
    public String register(@ModelAttribute("inputTask") Task inputTask, Model model) {
        // TaskServiceクラスのaddTaskメソッドを呼び出し、画面から受け取ったデータを登録する
        taskService.addTask(inputTask);

        // DBに登録した値を再取得した上でindex.htmlを再表示する
        model.addAttribute("tasks", taskService.getTasks());
        model.addAttribute("inputTask", new Task());
        return "index";
    }

    // @PostMappingアノテーションを付与するだけで、`http://localhost:8080/update` にアクセスしたHTTP POSTリクエストを受け取ることができる
    @PostMapping("/delete")
    // 引数に `@RequestParam` を指定することでも、画面からPOST送信されたデータを受け取ることができる
    public String delete(@RequestParam String id, Model model) {
        // TaskServiceクラスのdeleteTaskメソッドを呼び出し、画面から受け取ったデータを削除する
        taskService.deleteTask(Long.parseLong(id));

        // DBに登録した値を再取得した上でindex.htmlを再表示する
        model.addAttribute("tasks", taskService.getTasks());
        model.addAttribute("inputTask", new Task());
        return "index";
    }
}
