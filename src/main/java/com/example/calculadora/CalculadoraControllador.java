package com.example.calculadora;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class CalculadoraControllador {


    @FXML private TextField vista;
    private CalculadorModelo modelo;

    public CalculadoraControllador() {

        this.modelo = new CalculadorModelo();
    }

    @FXML
    public void onAction(MouseEvent mouseEvent) {
        String valor = ((Button) mouseEvent.getSource()).getText();
        if (isNum(valor)) {
            insertToBox(valor);
        } else {
            resolver(vista.getText());
        }

        System.out.println(vista.getText());

    }

    public boolean isNum(String valor) {
        return "0123456789x-+/.".contains(valor);
    }

    public void insertToBox(String valor) {
        vista.appendText(valor);
    }


    public void resolver(String expresion){
        vista.setText(modelo.calcular(expresion));
    }

    /*
    @FXML
    public void escribir(MouseEvent mouseEvent) {
        vista.getPanelTexto().setVisible(true);
        String valor = ((Button) mouseEvent.getSource()).getText();
        System.out.println(valor);
        vista.getPanelTexto().setText(vista.getPanelTexto().getText()+valor);
    }

    @FXML
    public void botonAC(MouseEvent mouseEvent){
        vista.getPanelTexto().setText("");
    }

    @FXML
    public void borrar(MouseEvent mouseEvent){
        vista.getPanelTexto().setText(vista.getPanelTexto().getText().substring(0,vista.getPanelTexto().getText().length()-1));
    }
     */
}

