package com.example.programaestudio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class EstudioBotones extends AppCompatActivity {

    public void Enviar(View view){
        Log.i("info", "boton presionado");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) { //Se ejecutará cada vez que se inicie la actividad
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estudio_botones); //Esto proporciona el layout
    }
}