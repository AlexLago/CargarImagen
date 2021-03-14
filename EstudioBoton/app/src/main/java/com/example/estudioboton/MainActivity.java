package com.example.estudioboton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{ //Necesitamos añadirle el implements para el 2º botón

    public void enviar(View view){
        Log.i("info", "Boton presionado");
    }

    Button boton1, boton2; //Declaramos los dos objetos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //Esto indica que layout es el que se enlazará

        boton1 = findViewById(R.id.botonAnonima); //Con esto enlazamos el objeto al boton del layout por su ID
        boton2 = findViewById(R.id.botonImplements);
        boton2.setOnClickListener(this); //Con esto seremos capaces de que el 2º boton entre al onClick para mostrar el Toast

        boton1.setOnClickListener(new View.OnClickListener() { //Aquí adentro le decimos que tendrá un listener y que queremos que haga al clickar sobre él
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Desde la Anonima", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getApplicationContext(), "Desde el onClick de implements", Toast.LENGTH_LONG).show();
    }


    public void eventoBoton(View view) { //Ahora solo haría falta añadirle lo que queremos que haga
        Toast.makeText(getApplicationContext(), "Desde el evento OnClick del metodo", Toast.LENGTH_LONG).show();
    }
}