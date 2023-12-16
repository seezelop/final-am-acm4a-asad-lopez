// activity_login_exitoso.java

package com.example.parcial_1_am_acm4a_asad_lopez;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class login_exitoso extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_exitoso);

    }

    // activar boton inicio
    public void ir_al_inicio(View view){
        Intent ir_al_inicio= new Intent(this, MainActivity.class);
        startActivity(ir_al_inicio);
    }
}
