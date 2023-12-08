package com.example.parcial_1_am_acm4a_asad_lopez;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link inicioSesion#newInstance} factory method to
 * create an instance of this fragment.
 */
public class inicioSesion extends Fragment {
    public inicioSesion() {
        // Required empty public constructor
    }

    public static inicioSesion newInstance(String param1, String param2) {
        inicioSesion fragment = new inicioSesion();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inicio_sesion, container, false);
    }
}