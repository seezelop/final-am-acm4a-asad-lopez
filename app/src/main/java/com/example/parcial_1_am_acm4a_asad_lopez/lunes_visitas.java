package com.example.parcial_1_am_acm4a_asad_lopez;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class lunes_visitas extends AppCompatActivity implements OnMapReadyCallback {
    TextView titulo_1;
    TextView hora_dias_colon;
    TextView texto_colon;
    TextView titulo_2;
    TextView descripcion_buses;
    TextView horario_bus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunes_visitas);

        SupportMapFragment supportMapFragment=(SupportMapFragment) getSupportFragmentManager().
                findFragmentById(R.id.mapa_colon);
        supportMapFragment.getMapAsync(this);


        List<String> titulos=new ArrayList<String>();
        titulos.add("Visita guiada al colon");
        titulos.add("Bus turistico");

        titulo_1=findViewById(R.id.titulo_1);
        titulo_1.setText(titulos.get(0));/*aca se agrega titulo colon*/
        titulo_2=findViewById(R.id.titulo_2);
        titulo_2.setText(titulos.get(1));/*aca se agrega titulo bus*/

        List<String> horarios=new ArrayList<String>();
        horarios.add("De lunes a viernes, de 10 a 16:45 h. Sábado y domingo, de 11 a 16:45 h.");
        horarios.add("Todos los días, de 9 a 17 h. (el amarillo) y de 9:30 a 18 h (el rojo)");
        hora_dias_colon=findViewById(R.id.hora_dias_colon);
        hora_dias_colon.setText(horarios.get(0));/*aca se agrega horarios y dias del colon*/
        horario_bus=findViewById(R.id.horario_dias_buses);
        horario_bus.setText(horarios.get(1));/*aca se agrega horarios y dias del bus*/

        List<String> descripciones=new ArrayList<String>();
        descripciones.add("Recorré los rincones del Teatro Colón con quienes pueden enseñarte todos sus secretos e historia. Van a guiarte por la sala, el foyer principal, la galería de bustos y el salón dorado , y te contarán los detalles de la arquitectura de este magnífico edificio. El paseo dura aproximadamente unos 50 minutos.");
        descripciones.add("Una gran forma de recorrer los barrios más emblemáticos de la Ciudad y tener una gran vista panorámica. Dos circuitos, amarillo y rojo, para que puedas apreciar lugares históricos, espacios culturales y zonas únicas. Podés ascender y descender de los buses todas las veces que desees. Consultá la promoción que ofrecen en Vacaciones de Invierno");
        texto_colon=findViewById(R.id.texto_colon);
        texto_colon.setText(descripciones.get(0));/*aca se agrega la descripcion del colon*/
        descripcion_buses=findViewById(R.id.descripcion_buses);
        descripcion_buses.setText(descripciones.get(1));/*aca se agrega la descripcion de los buses*/
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        //coordenadas con la ubicacion del teatro colon
        LatLng ubicacion = new LatLng(-34.601083333333, -58.383083333333);
        googleMap.addMarker(new MarkerOptions().position(ubicacion).title("Teatro Colon"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ubicacion, 12));

    }
}