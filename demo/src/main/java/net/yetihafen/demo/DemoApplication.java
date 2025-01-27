package net.yetihafen.demo;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import net.yetihafen.javafx.customcaption.CustomCaption;

import java.io.IOException;

public class DemoApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(DemoApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        AnimationTimer t = new AnimationTimer() {
            @Override
            public void handle(long now) {
                Color c = Color.hsb((now / 10000000.0) % 360, 1, 1);
                CustomCaption.setBorderColor(stage, c);
                CustomCaption.setCaptionColor(stage, c);
            }
        };
        t.start();
    }

    public static void main(String[] args) {
        launch();
    }
}