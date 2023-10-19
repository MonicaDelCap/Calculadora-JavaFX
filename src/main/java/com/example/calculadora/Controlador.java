package com.example.calculadora;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controlador {


    @FXML private TextField textField;
    private CalculadoraModelo modelo;

    public Controlador() {
        this.modelo = new CalculadoraModelo();
    }

    @FXML
    public void onAction(MouseEvent mouseEvent) {
        String valor = ((Button) mouseEvent.getSource()).getText();
        if (isNum(valor)) {
            insertToTextField(valor);
        } else if (valor.equals("=")) {
            resolver(textField.getText());
        }
    }

    public boolean isNum(String valor) {
        return "0123456789x-+/.".contains(valor);
    }

    public void insertToTextField(String valor) {
        textField.appendText(valor);
    }


    public void resolver(String expresion){
        textField.setText(modelo.calcular(expresion));
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

