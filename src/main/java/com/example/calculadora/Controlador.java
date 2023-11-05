package com.example.calculadora;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
        } else if (valor.equals("AC")) {
            vaciar();
        } else {
            borrarUltimo();
        }
    }

    public boolean isNum(String valor) {
        return "0123456789x-+/.".contains(valor);
    }

    public void insertToTextField(String valor) {
        textField.appendText(valor);
    }


    public void resolver(String expresion) {
        String m;
        try {
            textField.setText(modelo.calcular(expresion));
            return;
        } catch (NumberFormatException e) {
            m = "No se puede introducir dos puntos seguidos";
        } catch (IllegalArgumentException e) {
            m = "No se puede introducir dos simbolos seguidos.";
        } catch (ArithmeticException e) {
            m = "division entre 0 es infinito.";
        }
        instanceVentanaError(m);
    }

    public void instanceVentanaError(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
    public boolean isValidExpression(String expression) {
        return !expression.contains("x/") && !expression.contains("/x") && !expression.contains("+x") && !expression.contains("-x") && !expression.contains("-/") && !expression.contains("+/") && !expression.contains("//") && !expression.contains("xx") && !expression.contains("..");
    }

    public void vaciar(){
        textField.setText("");
    }

    public void borrarUltimo() {
        textField.setText(textField.getText().substring(0, textField.getText().length()-1));
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
    public void borrar(MouseEvent mouseEvent){
        vista.getPanelTexto().setText(vista.getPanelTexto().getText().substring(0,vista.getPanelTexto().getText().length()-1));
    }
     */
}

