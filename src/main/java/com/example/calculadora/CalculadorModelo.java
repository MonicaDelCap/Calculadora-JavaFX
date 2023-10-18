package com.example.calculadora;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CalculadorModelo {

    public String resolve(String operacion) {
        if (operacion.startsWith("")) {
            operacion = new StringBuilder(operacion).insert(0, "0").toString();
        }
        String [] dm = operacion.split("[+-]");
        List<String> dimu = new ArrayList<>(Arrays.asList(dm));
        dimu = dimu.stream().map(o -> String.valueOf(resolveMultDiv(o))).collect(Collectors.toList());

        String [] sr = operacion.split("[^\\+\\-]");
        List<String> sure = new ArrayList<>(Arrays.asList(sr));
        sure.removeIf(String::isEmpty);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dimu.size(); i++) {
            sb.append(dimu.get(i));
            if (i != dimu.size()-1) {
                sb.append(sure.get(i));
            }
        }
        return String.valueOf(resolveMultDiv(sb.toString()));
    }

    public static double resolveMultDiv(String operation) {
        String[] auxNums = operation.split("[x/+-]");
        String [] auxSimbs = operation.split("[0-9.]+");

        List<Double> nums = Arrays.stream(auxNums).map(Double::parseDouble).collect(Collectors.toList());
        List<String> simbs = new ArrayList<>(List.of(auxSimbs));
        simbs.removeIf(String::isEmpty);

        double result = nums.get(0);
        boolean end = false;
        do {
            if (simbs.size() == 0) {
                break;
            }
            for (int i = 0; i < simbs.size(); i++) {
                double currentNum = nums.get(0);
                double nxtNum = nums.get(1);
                if (simbs.get(i).equals("x")) {
                    result = currentNum*nxtNum;
                } else if (simbs.get(i).equals("/")) {
                    result = currentNum/nxtNum;
                } else if (simbs.get(i).equals("+")) {
                    result = currentNum+nxtNum;
                } else if (simbs.get(i).equals("-")) {
                    result = currentNum-nxtNum;
                }
                nums.remove(currentNum);
                nums.remove(nxtNum);
                nums.add(0, result);
                if (nums.size() == 1) {
                    end = true;
                    break;
                }
            }
        } while (!end);
        return result;
    }

    public static boolean isFloatNum(String s) {
        return "1234567890.".contains(s);
    }

    public static boolean isSimbolo(char c) {
        return "x+-/".indexOf(c) != -1;
    }

}
