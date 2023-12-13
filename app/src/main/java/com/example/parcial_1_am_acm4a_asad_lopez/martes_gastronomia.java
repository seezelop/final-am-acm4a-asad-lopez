package com.example.parcial_1_am_acm4a_asad_lopez;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class martes_gastronomia extends AppCompatActivity {

    private TextView textView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_martes_gastronomia);

        // Referencias a los elementos de la interfaz
        textView = findViewById(R.id.tituloGastronomia);
        imageView = findViewById(R.id.imagenGastro);

        // Establecer el texto del TextView desde los recursos de cadena
        textView.setText(getString(R.string.destacado_gastronomia));

        imageView.setImageResource(R.drawable.food);

        // Obtén una referencia al ImageView
        //ImageView imageView = findViewById(R.id.imagenGastro);

// URL de la imagen que deseas descargar
        String urlImagen = "https://dam.ngenespanol.com/wp-content/uploads/2018/11/5-gastronomia-paises-mundo.png";

// Usa Glide para cargar la imagen en el ImageView
        Glide.with(this)
                .load(urlImagen)
                .into(imageView);



    }
}

