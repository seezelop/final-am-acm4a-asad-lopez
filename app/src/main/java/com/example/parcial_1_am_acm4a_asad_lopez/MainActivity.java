package com.example.parcial_1_am_acm4a_asad_lopez;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button miBoton;
    private Spinner spinner1;
    private Spinner spinner2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setupNavegacion();
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
                }  //si selecciono martes y gastronomia
                else if (diaSeleccionado.equals("Martes") && actividadSeleccionada.equals("Gastronomia")) {
                    Intent intent = new Intent(MainActivity.this, martes_gastronomia.class);
                    startActivity(intent);
                } else if (diaSeleccionado.equals("Martes") && actividadSeleccionada.equals("Visitas guiadas")) {
                    Intent intent = new Intent(MainActivity.this, martes_visitas.class);
                    startActivity(intent);
                } else{
                    // Toast.makeText(this, "seleccione una opcion valida").show();
                    Toast toast;
                    int duracion = Toast.LENGTH_SHORT;
                    String mensaje="No hay actividades en el dia seleccionado";
                    toast = Toast.makeText(getApplicationContext(),mensaje, duracion);
                    toast.show();

                }



            }
        });


    }

    /*evento para que al apretar la casita,vaya a la interfaz de inicio de sesion*/



    public void ir_a_inicio_sesion(View view){
        /*Fragment inicioSesionFragment = new inicioSesion();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.contenedor_menu, inicioSesionFragment); // Reemplaza R.id.contenedor_fragment con el ID de tu contenedor de fragmentos
        fragmentTransaction.addToBackStack(null); // Opcional: agregar a la pila de retroceso
        fragmentTransaction.commit();*/
        Intent intent=new Intent(MainActivity.this, logica_login.class);
        startActivity(intent);
    }
    /*metodo para la configuracion de la navegacion*/
    /*private void setupNavegacion(){
        BottomNavigationView bottomNavigationView= findViewById(R.id.botonNavegacion);
        NavHostFragment navHostFragment= (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.contenedor_menu);
        NavigationUI.setupWithNavController(
                bottomNavigationView, navHostFragment.getNavController()

        );
    }*/
}





