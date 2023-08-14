package com.example.practico1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.practico1.Ejercicio13.AdministradorTareas;

public class Ejercicio_13 extends AppCompatActivity {
    private AdministradorTareas administradorTareas;
    private ArrayAdapter<String> adapter;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio13);

        administradorTareas = new AdministradorTareas();
        EditText editTextTarea = findViewById(R.id.editTextTarea);
        Button botonAgregar = findViewById(R.id.boton_agregar);
        ListView listViewTareas = findViewById(R.id.listViewTareas);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, administradorTareas.obtenerTareas());
        listViewTareas.setAdapter(adapter);

        handler = new Handler();

        botonAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tarea = editTextTarea.getText().toString();
                administradorTareas.agregarTarea(tarea);
                adapter.notifyDataSetChanged();
                editTextTarea.setText("");
            }
        });

        listViewTareas.setOnItemClickListener((parent, view, position, id) -> {
            administradorTareas.eliminarTarea(position);
            adapter.notifyDataSetChanged();
        });
    }
}