package com.example.parcial_1_am_acm4a_asad_lopez;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class mapa_buses_turisticos extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_buses_turisticos);

        SupportMapFragment supportMapFragment=(SupportMapFragment) getSupportFragmentManager().
                findFragmentById(R.id.fragment_buses);
        supportMapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        // coordenadas del primer bus
        LatLng ubicacion = new LatLng(-34.587853, -58.390875);
        googleMap.addMarker(new MarkerOptions().position(ubicacion).title("probando"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ubicacion, 12));

    }

}