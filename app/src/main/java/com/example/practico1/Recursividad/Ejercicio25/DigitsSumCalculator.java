package com.example.practico1.Recursividad.Ejercicio25;

import java.util.concurrent.Callable;

public class DigitsSumCalculator implements Callable<Integer> {
    private int number;

    public DigitsSumCalculator(int number){
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        return calculateDigitsSum(number);
    }

    private int calculateDigitsSum(int n) {
        if (n<10){
            return n;

        }else {
            return n%10 + calculateDigitsSum(n/10);
        }
    }
}
