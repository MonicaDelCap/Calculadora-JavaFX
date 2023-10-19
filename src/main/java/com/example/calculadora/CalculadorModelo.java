package com.example.calculadora;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
public class CalculadorModelo {
    public String calcular(String expression) {
        expression.replace("x", "*");
        // Crear un objeto ExpressionBuilder para construir la expresión
        ExpressionBuilder builder = new ExpressionBuilder(expression);

        // Crear un objeto Expression
        Expression expr = builder.build();

        double resultado = 0;
        try {
            // Evaluar la expresión y obtener el resultado
            resultado = expr.evaluate();
        } catch (ArithmeticException e) {
            // Manejar excepciones, por ejemplo, división por cero
            System.err.println("Error: " + e.getMessage());
        }
        return String.valueOf(resultado);
    }

}
