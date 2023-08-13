package com.example.practico1.Recursividad.Ejercicio21;

import java.util.concurrent.Callable;

public class GCDCalculator implements Callable<Integer> {
    private int a,b;

    public GCDCalculator(int a, int b){
        this.a=a;
        this.b=b;
    }
    @Override
    public Integer call() throws Exception {
        return calculateGCD(a,b);
    }

    private Integer calculateGCD(int a, int b) {
        if(b==0){
            return a;
        }else{
            return calculateGCD(b,a%b);
        }
    }
}
