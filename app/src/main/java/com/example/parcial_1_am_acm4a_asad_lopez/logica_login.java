package com.example.parcial_1_am_acm4a_asad_lopez;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class logica_login extends AppCompatActivity {

    ImageView imageView;
    EditText usuario;
    EditText contra;
    Button boton_inicio;

    FirebaseAuth fAuth;//uso del firebase authentication
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        fAuth=FirebaseAuth.getInstance();//se crea una instancia

        imageView=findViewById(R.id.imagen_logo_ba);
        usuario=findViewById(R.id.edittext_usuario);
        contra=findViewById(R.id.edittext_contrasena);
        boton_inicio=findViewById(R.id.boton_login);

    }

    public void ir_a_registro(View view){
        Intent intent = new Intent(this, registrar_usuario.class);
        startActivity(intent);
    }

    public void iniciar_sesion(View view) {
        //obtengo lo que el usuario ingreso como mail
        String emailUsuario= usuario.getText().toString().trim();

        //obtengo lo que el usuario ingreso como contrasena
        String contraUsuario= contra.getText().toString().trim();

        //condicional para saber si los campos estan vacios
        if (emailUsuario.isEmpty() || contraUsuario.isEmpty()) {
            Toast.makeText(logica_login.this, "Complete los campos en blanco", Toast.LENGTH_SHORT).show();
        } else {
            loginUsuarios(emailUsuario, contraUsuario);
        }


    }
    private void loginUsuarios(String emailUsuario, String contraUsuario) {
        fAuth.signInWithEmailAndPassword(emailUsuario, contraUsuario).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                //pregunta si hay una sesion
                if(task.isSuccessful()){
                    finish();
                    startActivity(new Intent(logica_login.this, MainActivity.class));//en main tenes que poner el activity de bienvenida
                    Toast.makeText(logica_login.this, "Bienvenido!", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(logica_login.this, "error" + task.getException(), Toast.LENGTH_SHORT).show();
                }
            }
            //linea 67 muestra los errores al loguearse
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(logica_login.this, "error al iniciar sesion", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
