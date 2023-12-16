package com.example.parcial_1_am_acm4a_asad_lopez;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class clase_colecciones extends AppCompatActivity {
    private FirebaseFirestore bbdd;
    private EditText nombre;
    private EditText apellido;
    private EditText dni;
    private Button boton;
    private Map<String, Object> datosDocumento;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llenar_datos);

        // Inicializar Firestore
        bbdd = FirebaseFirestore.getInstance();

        // Obtener referencias a los elementos de la interfaz de usuario
        nombre = findViewById(R.id.edittext_nombre);
        apellido = findViewById(R.id.edittext_apellido);
        dni = findViewById(R.id.edittext_dni);
        boton = findViewById(R.id.boton_enviar);

        // Inicializar el HashMap
        datosDocumento = new HashMap<>();

        // Configurar el evento clic del botón
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarInformacion();
            }
        });
    }

    private void agregarInformacion() {
        // Obtener los textos de los EditText
        String valor1 = nombre.getText().toString();
        String valor2 = apellido.getText().toString();
        String valor3 = dni.getText().toString();

        // Agregar datos al HashMap
        datosDocumento.put("Nombre", valor1);
        datosDocumento.put("Apellido", valor2);
        datosDocumento.put("Dni", valor3);

        // Puedes imprimir el contenido del HashMap para verificar
        System.out.println("Contenido del HashMap: " + datosDocumento);

        Intent intent = new Intent(clase_colecciones.this, mostrar_datos_coleccion.class);
        intent.putExtra("datosDocumento", (Serializable) datosDocumento);
        startActivity(intent);
    }
}
