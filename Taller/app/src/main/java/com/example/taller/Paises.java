package com.example.taller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.JsonToken;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Paises extends AppCompatActivity {

    private ListView lista;
    private ArrayAdapter adapter;
    private static ArrayList<String> paises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paises);

        lista = (ListView) findViewById(R.id.ListaPaises);
        initPaisesJson();
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,paises);
        lista = (ListView) findViewById(R.id.ListaPaises);
        lista.setAdapter(adapter);
        detallePaises();
    }

    private void initPaisesJson()
    {
        JSONObject json = null;
        try
        {
            json = new JSONObject(loadJSONFromAsset());
            JSONArray paisesJsonArray = json.getJSONArray("paises");
            paises = new ArrayList<String>();

            int n = 0;
            while(n < paisesJsonArray.length())
            {
                JSONObject jsonObject = paisesJsonArray.getJSONObject(n);
                paises.add(jsonObject.getString("nombre_pais").toString());
                n++;
            }
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
    }

    public String loadJSONFromAsset()
    {  String json = null;
        try {
            InputStream is = this.getAssets().open("paises.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();  return null;
        }
        return json;
    }

    public void volver(View v)
    {
        Toast.makeText(v.getContext(), "Bienvenido a main", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(v.getContext(), MainActivity.class);
        startActivity(intent);
    }

    public void detallePaises()
    {
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                JSONObject json = null;
                try
                {
                    json = new JSONObject(loadJSONFromAsset());
                    JSONArray paisesJsonArray = json.getJSONArray("paises");
                    JSONObject jsonObject = paisesJsonArray.getJSONObject(position);

                    Intent intent = new Intent(view.getContext(), DetallePais.class);

                    intent.putExtra("capital", jsonObject.getString("capital").toString());
                    intent.putExtra("nombrepais", jsonObject.getString("nombre_pais").toString());
                    intent.putExtra("nombrepaisint", jsonObject.getString("nombre_pais_int").toString());
                    intent.putExtra("sigla", jsonObject.getString("sigla").toString());

                    startActivity(intent);
                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }
            }
        });
    }
}