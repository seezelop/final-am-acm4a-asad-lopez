package com.example.parcial_1_am_acm4a_asad_lopez;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class martes_gastronomia extends AppCompatActivity {

    private TextView textView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_martes_gastronomia);

        // Referencias a los elementos de la interfaz
        textView = findViewById(R.id.tituloGastronomia);
        imageView = findViewById(R.id.imagenGastronomia);

        // Establecer el texto del TextView desde los recursos de cadena
        textView.setText(getString(R.string.ofertas_gastronomicas));

        imageView.setImageResource(R.drawable.food);



    }
}

