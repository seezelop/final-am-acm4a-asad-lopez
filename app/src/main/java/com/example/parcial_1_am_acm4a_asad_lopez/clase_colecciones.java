package com.example.parcial_1_am_acm4a_asad_lopez;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class clase_colecciones extends AppCompatActivity {
    private EditText nombre;
    private EditText apellido;
    private EditText dni;
    private Button boton;
    private DatabaseReference reference;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llenar_datos);

        reference = FirebaseDatabase.getInstance().getReference();

        // Obtener referencias a los elementos de la interfaz de usuario
        nombre = findViewById(R.id.edittext_nombre);
        apellido = findViewById(R.id.edittext_apellido);
        dni = findViewById(R.id.edittext_dni);
        boton = findViewById(R.id.boton_enviar);

        // Mostrar la info de la bbdd
        reference.child("usuarios").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // Obtener el primer hijo del nodo usuarios
                for (DataSnapshot ds : snapshot.getChildren()) {
                    Usuario usuario = ds.getValue(Usuario.class);

                    // Actualizar los EditText con los valores obtenidos
                    nombre.setText(usuario.getNombre());
                    apellido.setText(usuario.getApellido());
                    dni.setText(usuario.getDni());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Manejar errores, si es necesario
                Toast.makeText(clase_colecciones.this, "Error al leer datos desde Firebase", Toast.LENGTH_SHORT).show();
            }
        });

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener el texto de los EditText
                String textoNombre = nombre.getText().toString();
                String textoApellido = apellido.getText().toString();
                String textoDni = dni.getText().toString();

                // Insertar datos en Firebase
                ingresarDatos(textoNombre, textoApellido, textoDni);
            }
        });
    }

    private void ingresarDatos(String textoNombre, String textoApellido, String textoDni) {
        Map<String, Object> informacion = new HashMap<>();
        informacion.put("nombre", textoNombre);
        informacion.put("apellido", textoApellido);
        informacion.put("dni", textoDni);

        // Nombre de la referencia en la bbdd con la info ingresada
        reference.child("usuarios").push().setValue(informacion)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(getApplicationContext(), "Datos ingresados correctamente", Toast.LENGTH_SHORT).show();
                        //Intent intent = new Intent(clase_colecciones.this, mostrar_datos_coleccion.class);
                        //startActivity(intent);
                        //finish();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), "Error al ingresar datos: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}



