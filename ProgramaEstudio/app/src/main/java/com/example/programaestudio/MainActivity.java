package com.example.programaestudio;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;


import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public static int num_imag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botonCambiar = findViewById(R.id.botonCambiarImagen);
        Button botonCrear = findViewById(R.id.botonCrearWidget);

        botonCambiar.setOnClickListener(new View.OnClickListener(){
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                num_imag = (++num_imag) % 3;
                AppWidgetManager mAppWidgetManager = v.getContext().getSystemService(AppWidgetManager.class);
                Intent intent = new Intent(getApplication(), EstudioWidget.class);
                intent.setAction(mAppWidgetManager.ACTION_APPWIDGET_UPDATE);
                int[] ids = mAppWidgetManager.getAppWidgetIds(new ComponentName(getApplication(), EstudioWidget.class));
                intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, ids);
                sendBroadcast(intent);
            }
        });

        botonCrear.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                AppWidgetManager mAppWidgetManager = v.getContext().getSystemService(AppWidgetManager.class);
                ComponentName myProvider = new ComponentName(v.getContext(), EstudioWidget.class);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    if (mAppWidgetManager.isRequestPinAppWidgetSupported()){
                        mAppWidgetManager.requestPinAppWidget(myProvider, null, null);
                    }
                }

            }
        });
    }
}