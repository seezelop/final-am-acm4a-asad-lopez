package com.example.parcial_1_am_acm4a_asad_lopez;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class mostrar_datos_coleccion extends AppCompatActivity {
    private TextView nombreTextView;
    private TextView apellidoTextView;
    private TextView dniTextView;
    private DatabaseReference reference;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_coleccion);

        reference = FirebaseDatabase.getInstance().getReference().child("usuario");

        // Obtain references to TextViews
        nombreTextView = findViewById(R.id.info_nombre);
        apellidoTextView = findViewById(R.id.info_apellido);
        dniTextView = findViewById(R.id.info_dni);

        // Retrieve data from Firebase
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    // Assuming you have a Usuario class with appropriate getters and setters
                    Usuario usuario = snapshot.getValue(Usuario.class);

                    // Get the values and set them to TextViews
                    String nombre = usuario.getNombre();
                    String apellido = usuario.getApellido();
                    String dni = usuario.getDni();

                    nombreTextView.setText(nombre);
                    apellidoTextView.setText(apellido);
                    dniTextView.setText(dni);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle error
                Toast.makeText(getApplicationContext(), "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}



