package com.example.parcial_1_am_acm4a_asad_lopez;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Spinner s;
    private Spinner s2 = findViewById(R.id.opciones_actividad);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            s= findViewById(R.id.opciones_dia);
        ArrayList<String> dias = new ArrayList<>();
            dias.add("Lunes");//agrego los dias a la lista
            dias.add("Martes");
            dias.add("Miercoles");

            ArrayList<String> actividades=new ArrayList<>();
            actividades.add("Visitas guiadas");
            actividades.add("Gastronomia");
            actividades.add("Deporte");

            //parametros: contexto, ubicacion de los items del spinner, arraylist
            ArrayAdapter<String> adaptador=new ArrayAdapter(this,
                    android.R.layout.simple_spinner_item, dias);

            ArrayAdapter<String> adaptador2=new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, actividades);

            s.setAdapter(adaptador);//agregar adaptador al spinner
            s2.setAdapter(adaptador2);
            //s.setGravity(Gravity.BOTTOM);

            s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    String mensaje=(String)s.getAdapter().getItem(i);

                    Toast.makeText(MainActivity.this, "posicion: "+mensaje, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });

            s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    String mensaje=(String)s.getAdapter().getItem(i);

                    Toast.makeText(MainActivity.this, "posicion: "+mensaje, Toast.LENGTH_SHORT).show();

                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });






        }
}