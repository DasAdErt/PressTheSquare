package com.example.pressthesquare;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;

// создана игра о квадратике при нажатии на него прибавляются очки и он появляется после нажатия на него

public class PressTheSquare extends Application {

    private int score = 0;
    private Random random = new Random();

    @Override
    public void start(Stage primaryStage) {
        // Создаем корневой узел с помощью класса Pane
        Pane root = new Pane();
        Scene scene = new Scene(root, 600, 600);

        // Создаем квадратик
        Rectangle square = new Rectangle(50, 50, 50, 50);
        square.setFill(Color.RED);
        root.getChildren().add(square);

        // Добавляем счетчик очков
        Text scoreText = new Text("Score: 0");
        scoreText.setFont(Font.font(20));
        scoreText.setFill(Color.BLACK);
        scoreText.setLayoutX(20);
        scoreText.setLayoutY(30);
        root.getChildren().add(scoreText);

        // Обрабатываем событие клика на квадратик
        square.setOnMouseClicked(event -> {
            score++; // Увеличиваем счетчик очков на 1
            scoreText.setText("Score: " + score); // Обновляем текст счетчика очков
            square.relocate(random.nextInt(550), random.nextInt(550)); // Перемещаем квадратик в случайное место
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
