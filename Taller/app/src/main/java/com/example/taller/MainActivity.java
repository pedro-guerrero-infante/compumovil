package com.example.taller;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText posiciones;
    private Spinner numeroFactorial;

    public static int openFibonacci = 0;
    public static int openFactorial = 0;
    public static String fechaFibonacci = new String("Jeje");
    public static String fechaFactorial = new String("Jojo");

    private TextView vistaVisitasFact;
    private TextView vistaVisitasFibo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        posiciones = (EditText) findViewById(R.id.Posiciones);
        numeroFactorial = (Spinner) findViewById(R.id.Numeros);

        vistaVisitasFact = (TextView) findViewById(R.id.vecesFactorial);
        vistaVisitasFact.setText("Veces factorial: "+ openFactorial +" "+ fechaFactorial);

        vistaVisitasFibo = (TextView) findViewById(R.id.vecesFibonacci);
        vistaVisitasFibo.setText("Veces fibonacci: "+ openFibonacci +" "+ fechaFibonacci);
    }
    @Override
    protected void onPause() {
        super.onPause();

        //Guarda valor de variable cont.
        SharedPreferences prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("contadorFibonacci", openFibonacci);
        editor.putInt("contadorFactorial", openFactorial);
        editor.putString("fechaFactorial", fechaFactorial);
        editor.putString("fechaFibonacci", fechaFibonacci);
        editor.apply();
    }

    @Override
    public void onResume(){
        super.onResume();
        //Obtiene valor guardado para la variable cont.
        SharedPreferences prefs = getSharedPreferences("MisPreferencias",  Context.MODE_PRIVATE);
        openFibonacci = prefs.getInt("contadorFibonacci", 0);
        openFactorial = prefs.getInt("contadorFactorial", 0);
        String s = "";
        fechaFibonacci = prefs.getString("fechaFibonacci",s);
        fechaFactorial = prefs.getString("fechaFactorial",s);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void fibonacci(View v)
    {
        openFibonacci++;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        fechaFibonacci = new String (dtf.format(LocalDateTime.now()));

        Toast.makeText(v.getContext(), "Bienvenido a Fibonacci", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(v.getContext(), Fibonacci.class);
        intent.putExtra("dato", posiciones.getText().toString());
        startActivity(intent);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void factorial(View v)
    {
        openFactorial++;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        fechaFactorial = new String (dtf.format(LocalDateTime.now()));

        Toast.makeText(v.getContext(), "Bienvenido a Factorial", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(v.getContext(), Factorial.class);
        intent.putExtra("numeroSpiner", numeroFactorial.getSelectedItem().toString());
        startActivity(intent);
    }

    public void paises(View v)
    {
        Toast.makeText(v.getContext(), "Bienvenido a Paises", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(v.getContext(), Paises.class);
        startActivity(intent);
    }
}