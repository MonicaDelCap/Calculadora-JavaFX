package com.example.calculadora;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CalculadorExpresiones {


    private double resultadoFinal =0;
    //String ristra ="";
    private ArrayList<Double> numeros = new ArrayList<>();
    private ArrayList<String> simbolos = new ArrayList<>();


    public  DecimalFormat calcular (String expresionCalcular){

         setResultadoFinal(0);
        //ristra=calculadoraCodigo.getPanelTexto().getText();
        String numeroActual="";
        numeros=new ArrayList<>();
        simbolos=new ArrayList<>();

        //Aqui los guardo en cada variable
        for (int i = 0; i < expresionCalcular.length(); i++) {

            char lugar = expresionCalcular.charAt(i);

            if (i==expresionCalcular.length()-1){
                numeroActual=numeroActual+lugar;
                numeros.add(Double.valueOf(numeroActual));
                numeroActual="";

            } else if (isNumber(lugar)||(lugar==46)) {

                numeroActual=numeroActual+lugar;



            } else {
                simbolos.add(String.valueOf(lugar));
                numeros.add(Double.valueOf(numeroActual));
                numeroActual="";
            }



        }

        //Recorro la variable simbolos para ver si hay signos de multiplicacion o division

        ArrayList<Integer> simbolosquesonesos=new ArrayList<>();
        for (int i = 0; i < simbolos.size(); i++) {

            if (simbolos.get(i).equals("x")){

                double variable1=numeros.get(i);
                double variable2=numeros.get(i+1);
                double ecuacion= variable1*variable2;
                numeros.remove(i);
                numeros.remove(i);
                numeros.add(i,ecuacion);
                // simbolosquesonesos.add(i);
                simbolos.remove(i);
                if (i!=0){
                    i=i-1;
                }else {
                    i=0;
                }

            }else if (simbolos.get(i).equals("/")){

                double variable1=numeros.get(i);
                double variable2=numeros.get(i+1);
                double ecuacion= variable1/variable2;
                numeros.remove(i);
                numeros.remove(i);
                numeros.add(i,ecuacion);
                //simbolosquesonesos.add(i);
                simbolos.remove(i);


                if (i!=0){
                    i=i-1;
                }else {
                    i=0;
                }

            }


        }

        //Suma final de los numeros

        while (numeros.size()>0) {
            if (numeros.size() >= 2) {
                double variable1 = numeros.get(0);
                double variable2 = numeros.get(0 + 1);
                double resultado = 0;

                switch (simbolos.get(0)) {
                    case "+":
                        resultado = variable1 + variable2;
                        resultadoFinal = resultadoFinal + resultado;
                        numeros.remove(0);
                        numeros.remove(0);
                        simbolos.remove(0);
                        resultado = 0;
                        break;
                    case "-":
                        resultado = variable1 - variable2;
                        if (resultadoFinal ==0){
                            resultadoFinal =resultado;
                        }else {
                            resultadoFinal = resultadoFinal - resultado;

                        }
                        numeros.remove(0);
                        numeros.remove(0 );
                        simbolos.remove(0);

                        resultado = 0;
                        break;
                }
            } else if ((numeros.size() == 1)&&(simbolos.size()==1)) {

                switch (simbolos.get(0)) {
                    case "+":
                        resultadoFinal = resultadoFinal + numeros.get(0);
                        numeros.remove(0);
                        break;
                    case "-":
                        resultadoFinal = resultadoFinal - numeros.get(0);
                        numeros.remove(0);

                        break;
                }
            }else {
                resultadoFinal =numeros.get(0);
                numeros.remove(0);
            }
        }
        DecimalFormat finalCount= new DecimalFormat("0.0000");

        return finalCount;

    }

    public boolean isNumber(char letra){

        boolean esNumero=false;
        if (letra<58&&letra>47) {
            esNumero=true;
        }


        return esNumero;
    }

    public double getResultadoFinal() {
        return resultadoFinal;
    }

    public void setResultadoFinal(double resultadoFinal) {
        this.resultadoFinal = resultadoFinal;
    }

    public ArrayList<Double> getNumeros() {
        return numeros;
    }

    public void setNumeros(ArrayList<Double> numeros) {
        this.numeros = numeros;
    }

    public ArrayList<String> getSimbolos() {
        return simbolos;
    }

    public void setSimbolos(ArrayList<String> simbolos) {
        this.simbolos = simbolos;
    }
}
