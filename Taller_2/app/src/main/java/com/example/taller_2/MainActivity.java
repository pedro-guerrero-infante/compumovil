package com.example.taller_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void contactos(View v)
    {
        Toast.makeText(v.getContext(), "Bienvenido a contactos", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(v.getContext(), Contactos.class);
        startActivity(intent);
    }

    public void galeria(View v)
    {
        Toast.makeText(v.getContext(), "Bienvenido a galeria", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(v.getContext(), Camara.class);
        startActivity(intent);
    }
}