package com.example.parcial_1_am_acm4a_asad_lopez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button miBoton;
    private Spinner spinner1;
    private Spinner spinner2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         TextView contenido_d = findViewById(R.id.contenido_dia);
         contenido_d.setText(R.string.contenido_dia);

        miBoton = findViewById(R.id.btn_contenido_buscar);
        spinner1 = findViewById(R.id.opciones_dia);
        spinner2 = findViewById(R.id.opciones_actividad);

        // arraylist primer spinner
        ArrayList<String> dias = new ArrayList<>();
        dias.add("Lunes");
        dias.add("Martes");

        //arraylist segundo spinner
        ArrayList<String> actividades = new ArrayList<>();
        actividades.add("Visitas guiadas");
        actividades.add("Gastronomia");
        //actividades.add("Deportes");

        // 1 adaptador por cada spinner
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dias);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, actividades);


        spinner1.setAdapter(adapter1);
        spinner2.setAdapter(adapter2);

        miBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //aca capturo la opcion seleccionada en cada spinner
                CharSequence diaSeleccionado= (CharSequence) spinner1.getSelectedItem();
                CharSequence actividadSeleccionada=(CharSequence) spinner2.getSelectedItem();


                //si selecciono lunes como dia y visitas guiadas como actividad
                if(diaSeleccionado.equals("Lunes") && actividadSeleccionada.equals("Visitas guiadas")){
                    Intent intent = new Intent(MainActivity.this, lunes_visitas.class);
                    startActivity(intent);
                }else{//Seba, aca pone un else if con tu opcion despues este else
                   // Toast.makeText(this, "seleccione una opcion valida").show();
                    Toast toast;
                    int duracion = Toast.LENGTH_SHORT;
                    String mensaje="No hay actividades en el dia seleccionado";
                    toast = Toast.makeText(getApplicationContext(),mensaje, duracion);
                    toast.show();

                }


                //si selecciono martes y gastronomia
        }
        });
    }
}






