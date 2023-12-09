package com.example.parcial_1_am_acm4a_asad_lopez;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class registrar_usuario extends AppCompatActivity {
    ImageView imageView;
    EditText usuario;
    EditText contra;
    Button boton_inicio;

    FirebaseAuth fAuth;//uso del firebase authentication

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);

        fAuth=FirebaseAuth.getInstance();//se crea una instancia

        imageView=findViewById(R.id.imagen_logo_ba);
        usuario=findViewById(R.id.edittext_usuario_registro);
        contra=findViewById(R.id.edittext_contrasena_registro);
        boton_inicio=findViewById(R.id.boton_registro);

        boton_inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailUsuario= usuario.getText().toString().trim();

                //obtengo lo que el usuario registro como contrasena
                String contraUsuario= contra.getText().toString().trim();

                registrarUsuario(emailUsuario, contraUsuario);
            }
        });
    }

    public void registrarUsuario(String mail, String contrasena){
            fAuth.createUserWithEmailAndPassword(mail, contrasena).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(registrar_usuario.this, "Usted se ha registrado correctamente", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(registrar_usuario.this, "Registro no realizado", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }


