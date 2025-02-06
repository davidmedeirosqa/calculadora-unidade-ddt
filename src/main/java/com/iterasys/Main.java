// 1- Pacotes do projeto
package com.iterasys;

// 2- Bibliotecas / Imports

// 3- Classe
public class Main {
    // 3.1- Atributos

    // 3.2 - Métodos e Funções
    public static void main(String[] args) {
        System.out.println("Hello world!");
        // float result = somar(5,7);
        // System.out.println("A soma de 5 + 7 = " + result);
    }

    public static float somar(float num1, float num2) {
        float result = num1 + num2;
        System.out.println("Soma de " + num1 + " + " + num2 + " = " + result);
        return result;
    }

    public static float subtrair(float num1, float num2) {
        float result = num1 - num2;
        System.out.println("Subtração de " + num1 + " - " + num2 + " = " + result);
        return result;
    }

    public static float multiplicar(float num1, float num2) {
        return num1 * num2;
    }

    // public static float dividir(float num1, float num2){
    // if (num2 != 0){
    // return num1 / num2;
    // }else{
    // System.out.println("Não é possível dividir por zero");
    // return 0;
    // }

    // }

    public static String dividirTry(int num1, int num2) {
        try {
            return String.valueOf(num1 / num2);
        } catch (Exception e) {
            return "Não é possível dividir por zero";
        }
    }
}