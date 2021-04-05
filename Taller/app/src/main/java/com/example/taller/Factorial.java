package com.example.taller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Factorial extends AppCompatActivity {

    private static String renglon1;
    private static String renglon2;
    private TextView renglon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factorial);

        recibirDatos();

        renglon = (TextView) findViewById(R.id.renglon);
        renglon.setText(renglon1+"\n"+renglon2);
    }

    public void recibirDatos()
    {
        Bundle parametros = getIntent().getExtras();
        String parametro = parametros.getString("numeroSpiner");
        int numero = Integer.parseInt (parametro);

        System.out.println("Numero: "+numero);

        renglon1 = new String("Multiplicación: ");
        renglon2 = new String("Resultado: ");

        int n = 0, factorial = 1;
        while( n < numero )
        {
            factorial = (n+1)*factorial;

            if(n < numero-1)
            {
                renglon1 = renglon1 + (n+1) + "*";
            }
            else {
                renglon1 = renglon1 + (n + 1);
            }
            n++;
        }

        renglon2 = renglon2 + factorial;
    }

    public void volver(View v)
    {
        Toast.makeText(v.getContext(), "Bienvenido a main", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(v.getContext(), MainActivity.class);
        startActivity(intent);
    }
}