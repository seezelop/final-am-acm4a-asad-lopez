package com.example.parcial_1_am_acm4a_asad_lopez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class martes_visitas extends AppCompatActivity {

    private TextView textView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_martes_visitas);


        textView = findViewById(R.id.formInstruccion);
        imageView = findViewById(R.id.imagenVisitas);

        imageView.setImageResource(R.drawable.planetario);
    }
    // activar boton enviar
    public void enviar(View view){
        Intent enviar= new Intent(this, greeting.class);
        startActivity(enviar);
    }

}