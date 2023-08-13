package com.example.practico1.Recursividad.Ejercicio17;

import java.util.concurrent.Callable;

public class MaxNumberFinder implements Callable<Integer> {
    private int [] numbers;

    public MaxNumberFinder(int[]numbers){
        this.numbers = numbers;
    }
    @Override
    public Integer call() throws Exception {
        return findMaxNumber(numbers,0,numbers[0]);
    }

    private int findMaxNumber(int[] numbers, int index, int currentMax) {
        if(index == numbers.length){
            return currentMax;
        }else{
            return findMaxNumber(numbers, index + 1, Math.max(currentMax,numbers[index]));
        }
    }
}
