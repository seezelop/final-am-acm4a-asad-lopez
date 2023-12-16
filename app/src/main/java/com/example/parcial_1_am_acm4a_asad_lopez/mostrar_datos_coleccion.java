package com.example.parcial_1_am_acm4a_asad_lopez;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Map;

public class mostrar_datos_coleccion extends AppCompatActivity {
    private TextView info_nombre;
    private TextView info_apellido;
    private TextView info_dni;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_coleccion);

        info_nombre=findViewById(R.id.info_nombre);

        Intent intent = getIntent();
        if (intent != null) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                // Obtener datos del HashMap
                Map<String, Object> datosDocumento = (Map<String, Object>) extras.getSerializable("Nombre");

                // Mostrar datos en el TextView
                if (datosDocumento != null) {
                    StringBuilder textoMostrar = new StringBuilder();
                    for (Map.Entry<String, Object> entry : datosDocumento.entrySet()) {
                        textoMostrar.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
                    }
                    info_nombre.setText(textoMostrar.toString());
                }
            }
        }
    }
}

