package com.example.taller;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;


public class Fibonacci extends AppCompatActivity
{

    private ListView lista;
    private ArrayAdapter adapter;
    private static ArrayList<String> fibonacci;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fibonacci);

        recibirDatos();
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,fibonacci);
        lista = (ListView) findViewById(R.id.Lista);
        lista.setAdapter(adapter);
    }

    public void recibirDatos()
    {
        Bundle parametros = getIntent().getExtras();
        String parametro = parametros.getString("dato");
        int numero = Integer.parseInt (parametro);

        ArrayList<Integer> listaNumeros = new ArrayList<Integer>();

        int n = 0, numero1 = 0, numero2 = 0, suma = 1;
        while( n < numero )
        {
            listaNumeros.add(numero2);
            numero1 = numero2;
            numero2 = suma;
            suma = numero1 + numero2;
            n++;
        }

        Collections.reverse(listaNumeros);

        fibonacci = new ArrayList<String>();
        for ( int n1 : listaNumeros) {
            fibonacci.add(String.valueOf(n1));
        }
    }

    public void fibonacci(View v)
    {
        Uri uri = Uri.parse("https://es.wikipedia.org/wiki/Leonardo_de_Pisa");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void volver(View v)
    {
        Toast.makeText(v.getContext(), "Bienvenido a main", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(v.getContext(), MainActivity.class);
        startActivity(intent);
    }
}