package com.example.practico1.Ejercicio11;

import android.widget.ProgressBar;
import android.widget.TextView;

public class Descarga {
    public String url;
    public String rutaDestino;
    public ProgressBar progressBar;
    public TextView textView;

    public Descarga(String url, String rutaDestino, ProgressBar progressBar, TextView textView) {
        this.url = url;
        this.rutaDestino = rutaDestino;
        this.progressBar = progressBar;
        this.textView = textView;
    }
}
