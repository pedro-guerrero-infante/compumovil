package com.example.taller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class DetallePais extends AppCompatActivity {

    private static String capital;
    private static String nombrePais;
    private static String nombrePaisInt;
    private static String sigla;

    private TextView capitalTextView;
    private TextView nombrePaisTextView;
    private TextView nombrePaisIntTextView;
    private TextView siglaTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_pais);

        recibirDatos();

        capitalTextView = (TextView) findViewById(R.id.capital);
        capitalTextView.setText("Capital: "+capital);

        nombrePaisTextView = (TextView) findViewById(R.id.nombrePais);
        nombrePaisTextView.setText("Nombre pais: "+nombrePais);

        nombrePaisIntTextView = (TextView) findViewById(R.id.nombrePaisInt);
        nombrePaisIntTextView.setText("Nombre pais int: "+ nombrePaisInt);

        siglaTextView = (TextView) findViewById(R.id.sigla);
        siglaTextView.setText("Sigla: "+ sigla);
    }

    public void recibirDatos()
    {
        Bundle parametros = getIntent().getExtras();
        capital = new String(parametros.getString("capital"));
        nombrePais = new String(parametros.getString("nombrepais"));
        nombrePaisInt = new String(parametros.getString("nombrepaisint"));
        sigla = new String(parametros.getString("sigla"));
    }

    public void volver(View v)
    {
        Toast.makeText(v.getContext(), "Bienvenido a Paises", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(v.getContext(), Paises.class);
        startActivity(intent);
    }
}