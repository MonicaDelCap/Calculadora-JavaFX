package com.example.calculadora;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CalculadoraControllador {

    private CalculadoraVista vista;
    private CalculadorModelo modelo;

    public CalculadoraControllador() {
        this.vista = new CalculadoraVista();
        this.modelo = new CalculadorModelo();
    }

    @FXML
    public void resolver(MouseEvent mouseEvent){
        vista.getPanelTexto().setText(modelo.resolve(vista.getPanelTexto().getText()));
    }

    @FXML
    public void escribir(MouseEvent mouseEvent) {
        vista.getPanelTexto().setVisible(true);
        String valor = ((Button) mouseEvent.getSource()).getText();
        vista.getPanelTexto().setText(vista.getPanelTexto().getText()+valor);
    }

    @FXML
    public void botonAC(MouseEvent mouseEvent){
        vista.getPanelTexto().setText("");
    }


    public void borrar(MouseEvent mouseEvent){
        vista.getPanelTexto().setText(vista.getPanelTexto().getText().substring(0,vista.getPanelTexto().getText().length()-1));
    }
}

