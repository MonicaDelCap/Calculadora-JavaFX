package com.example.calculadora;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CalculadoraVista extends Application {

    @FXML
    private TextArea panelTexto= new TextArea();
    CalculadorExpresiones calculadoraCodigo;

    public CalculadoraVista(Stage stage)throws Exception{

        FXMLLoader fxmlLoader = new FXMLLoader(CalculadoraVista.class.getResource("Calculadora.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 400);
        stage.setTitle("Calculadora");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void escribir(MouseEvent mouseEvent) {

        panelTexto.setVisible(true);
        String valor=((Button) mouseEvent.getSource()).getText();
        panelTexto.setText(panelTexto.getText()+valor);
    }

    @FXML
    public void igual(MouseEvent mouseEvent){

        String resultadoPrint = String.valueOf(calculadoraCodigo.calcular(panelTexto.getText()));
        setPanelTexto(resultadoPrint);

    }

    @FXML
    public void botonAC(MouseEvent mouseEvent){

        panelTexto.setText("");

    }


    public void borrar(MouseEvent mouseEvent){

        if (!panelTexto.getText().equals("")){

            panelTexto.setText(panelTexto.getText().substring(0,panelTexto.getText().length()-1));

        }


    }




        //Muestro por TextPanel






    public TextArea getPanelTexto() {
        return panelTexto;
    }

    public void setPanelTexto(TextArea panelTexto) {
        this.panelTexto = panelTexto;
    }
}





