package com.example.calculadora;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class CalculadoraVista extends Application {
    @FXML
    private TextArea panelTexto = new TextArea();
    @Override
    public void start(Stage stage) {
        FXMLLoader fxmlLoader = new FXMLLoader(CalculadoraVista.class.getResource("Calculadora.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 320, 400);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setTitle("Calculadora");
        stage.setScene(scene);
        stage.show();
    }

    public TextArea getPanelTexto() {
        return panelTexto;
    }

}





