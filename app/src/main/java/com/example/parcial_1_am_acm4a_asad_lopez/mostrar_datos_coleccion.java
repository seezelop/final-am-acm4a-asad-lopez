package com.example.parcial_1_am_acm4a_asad_lopez;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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

        reference = FirebaseDatabase.getInstance().getReference();//nodo principal

        // Obtain references to TextViews
        nombreTextView = findViewById(R.id.info_nombre);
        apellidoTextView = findViewById(R.id.info_apellido);
        dniTextView = findViewById(R.id.info_dni);

        reference.child("usuarios").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // VALIDACION PARA SABER SI EXISTE
                if (snapshot.exists()) {
                    for (DataSnapshot usuarioSnapshot : snapshot.getChildren()) {
                        // Para cada usuario, obtenemos el nombre, apellido y dni
                        String nombre = usuarioSnapshot.child("nombre").getValue(String.class);
                        String apellido = usuarioSnapshot.child("apellido").getValue(String.class);
                        String dni = usuarioSnapshot.child("dni").getValue(String.class);

                        // Puedes hacer algo con el nombre, apellido y dni aquí
                        if (nombre != null) {
                            nombreTextView.append( nombre + "\n");
                        }

                        if (apellido != null) {
                            apellidoTextView.append(apellido + "\n");
                        }

                        if (dni != null) {
                            dniTextView.append( dni + "\n");
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Manejar errores de lectura de datos aquí
                Log.e("mostrar_datos_coleccion", "Error al leer datos", error.toException());
            }
        });
    }
}


