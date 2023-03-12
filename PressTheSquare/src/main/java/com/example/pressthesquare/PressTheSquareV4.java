package com.example.pressthesquare;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.geometry.Insets;

import java.util.Random;

//Добавлена кнопка Information при нажатии которой вылазет окно с информацией о программе и её создателя

public class PressTheSquareV4 extends Application {
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

        // Добавляем кнопку для открытия второго окна
        Button button = new Button("Information");
        button.setOnAction(event -> {
            // Создаем второе окно
            Stage secondStage = new Stage();
            secondStage.setTitle("Information");
            secondStage.setX(primaryStage.getX() + primaryStage.getWidth() + 10); // Устанавливаем положение второго окна справа от первого окна
            secondStage.setY(primaryStage.getY());
            // Создаем объект класса Image с помощью ссылки на URL-адрес
            Image icon = new Image("https://i.imgur.com/Z90PM4N.png");
            // Устанавливаем иконку для второго окна
            secondStage.getIcons().add(icon);

            // Добавляем текстовое описание программы во второе окно
            Text description = new Text("Training Aim - игра, в которой вам нужно\n" +
                    "нажимать на квадрат, чтобы заработать очки.");
            description.setFont(Font.font(16));
            description.setFill(Color.BLACK);
            VBox vbox = new VBox(description);
            vbox.setAlignment(Pos.CENTER);

            // Добавляем текст "Никнейм создателя: DasAdErt" в нижнюю часть окна "Нажми меня"
            Text creatorText = new Text("Никнейм создателя: DasAdErt");
            creatorText.setFont(Font.font(16));
            creatorText.setFill(Color.BLACK);
            VBox.setMargin(creatorText, new Insets(20, 0, 20, 0)); // устанавливаем отступы для текста создателя
            vbox.getChildren().add(creatorText);

            secondStage.setScene(new Scene(vbox, 350, 150));
            secondStage.show();
        });

        button.setLayoutX(scene.getWidth() - 95);
        button.setLayoutY(10);
        root.getChildren().add(button);

        // Обрабатываем событие клика на квадратик
        square.setOnMouseClicked(event -> {
            if (square.contains(event.getX(), event.getY())) {
                score++; // Увеличиваем счетчик очков на 1, если пользователь попал по квадратику
                scoreText.setText("Score: " + score); // Обновляем текст счетчика очков
                square.setFill(Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256))); // Генерируем случайный цвет для квадратика
                square.setLayoutY(event.getY() + random.nextInt((int) scene.getHeight() - 100)); // Генерируем случайные координаты для квадратика, чтобы он переместился на новую позицию
            }
        });
        primaryStage.setTitle("Training Aim");
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("https://i.imgur.com/mOBbpYV.png"));
        primaryStage.show();
    }
}