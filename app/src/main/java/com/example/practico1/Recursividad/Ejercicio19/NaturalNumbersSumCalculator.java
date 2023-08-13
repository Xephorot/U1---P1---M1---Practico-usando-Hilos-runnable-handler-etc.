package com.example.practico1.Recursividad.Ejercicio19;

import java.util.concurrent.Callable;

public class NaturalNumbersSumCalculator implements Callable<Integer> {
    private int n;
    public NaturalNumbersSumCalculator(int n){
        this.n=n;
    }
    @Override
    public Integer call() throws Exception {
        return sumNaturalNumbers(n);
    }

    private int sumNaturalNumbers(int n) {
        if(n<=1){
            return n;
        }else{
            return n+ sumNaturalNumbers(n-1);
        }
    }
}
