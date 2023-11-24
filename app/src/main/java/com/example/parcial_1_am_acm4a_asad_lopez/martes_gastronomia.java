package com.example.parcial_1_am_acm4a_asad_lopez;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class martes_gastronomia extends AppCompatActivity {
    private TextView tituloGastronomia;
    private TextView horaGastronomia;
    private TextView descripcionGastronomia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_martes_gastronomia);

        List<String> titulos = new ArrayList<>();
        titulos.add("Experiencia Gastronómica en el Centro");
        // Agrega más títulos según sea necesario

        tituloGastronomia = findViewById(R.id.titulo_1);
        tituloGastronomia.setText(titulos.get(0)); /* Agrega el título de la experiencia gastronómica */

        List<String> horarios = new ArrayList<>();
        horarios.add("Martes y jueves, de 19:00 a 22:00 h");
        // Agrega más horarios según sea necesario

        horaGastronomia = findViewById(R.id.hora_dias_colon);
        horaGastronomia.setText(horarios.get(0)); /* Agrega los horarios y días de la experiencia gastronómica */

        List<String> descripciones = new ArrayList<>();
        descripciones.add("Descubre los sabores auténticos de la gastronomía local en nuestro recorrido por los restaurantes del centro. Degusta platos tradicionales y experimenta con nuevas creaciones culinarias. ¡Una experiencia única para los amantes de la buena comida!");
        // Agrega más descripciones según sea necesario

        descripcionGastronomia = findViewById(R.id.texto_colon);
        descripcionGastronomia.setText(descripciones.get(0)); /* Agrega la descripción de la experiencia gastronómica */
    }
}

