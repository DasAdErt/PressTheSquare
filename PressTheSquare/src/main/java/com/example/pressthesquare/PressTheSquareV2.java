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

// была попытка сделать убавление очков при нажатии на открытую местность и добавили название окну приложения

public class PressTheSquareV2 extends Application {

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
            if (square.contains(event.getX(), event.getY())) {
                score++; // Увеличиваем счетчик очков на 1, если пользователь попал по квадратику
                scoreText.setText("Score: " + score); // Обновляем текст счетчика очков
                square.relocate(random.nextInt(550), random.nextInt(550)); // Перемещаем квадратик в случайное место
            } else {
                score--; // Уменьшаем счетчик очков на 1, если пользователь промахнулся
                scoreText.setText("Score: " + score); // Обновляем текст счетчика очков
                if (score < 0) {
                    score = 0; // Проверяем, что счетчик очков не становится меньше нуля
                }
                square.relocate(random.nextInt(550), random.nextInt(550)); // Перемещаем квадратик в случайное место
            }
        });

        primaryStage.setTitle("Training Aim");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
