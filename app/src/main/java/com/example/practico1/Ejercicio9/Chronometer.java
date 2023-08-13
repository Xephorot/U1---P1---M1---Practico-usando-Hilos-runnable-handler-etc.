package com.example.practico1.Ejercicio9;

public class Chronometer {
    private long startTime, elapsedTime;
    private boolean isRunning=false;

    public void start(){
        if(!isRunning){
            startTime=System.currentTimeMillis() - elapsedTime;
            isRunning = true;
        }
    }

    public void pause() {
        if(isRunning){
            elapsedTime = System.currentTimeMillis() - startTime;
            isRunning = false;
        }
    }
    public void reset(){
        elapsedTime=0;
    }
    public long getElapsedTime(){
        if(isRunning){
            return System.currentTimeMillis()-startTime;
        }else{
            return elapsedTime;
        }
    }
}
