package com.example.taller_2;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.widget.Toast;

public class Permisos
{
    public static void requestPermission(Activity context, String permiso, String justificacion, int idCode) {

        // Revisar si tengo permisos
        int permission = ContextCompat.checkSelfPermission(context, permiso);
        //Validar si ya tengo el permiso
        if (permission != PackageManager.PERMISSION_GRANTED) {
            //Validar si el ususario denego el permiso y reintento solicitarlo nuevamente
            if (!ActivityCompat.shouldShowRequestPermissionRationale(context, permiso)) {
                Toast.makeText(context, "Se requiere habilitar los permisos", Toast.LENGTH_SHORT).show();
            }
            // request the permission.
            ActivityCompat.requestPermissions(context, new String[]{permiso}, idCode);
        }
    }
}