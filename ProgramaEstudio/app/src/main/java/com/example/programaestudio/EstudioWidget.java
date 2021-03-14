package com.example.programaestudio;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Implementation of App Widget functionality.
 */
public class EstudioWidget extends AppWidgetProvider { //La clase AppWidgetProvider se encargará de recibir todos los eventos que lleguen a nuestro widget y la clase de EstudioWidget de actualizar

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds){ //Esta funcion recibe el contexto, in objeto de tipo AppWidgetManager y un conjunto de widgetsIds
        //Estas appWidgetIds son las ID's que tienen asignadas nuestras widgets
        final int N = appWidgetIds.length; //Aqui cada vez que añadan un nuevo widget este se incrementará

        for(int i = 0; i < N; i++){ //Este bucle es usado para cada uno de los widgets, en resumen. Actualizamos todos los widgets
            int appWidgetId = appWidgetIds[i];

            Intent intent = new Intent(context, MainActivity.class); //Creamos un Intent que tendrá como clase MainActivity
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0); //Creamos un PendingIntent que usara la funcion getActivity
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.estudio_widget); //Creamos un remoteViews donde le pasaremos la estructura de nuestro widget
            views.setOnClickPendingIntent(R.id.buttonAbrirApp, pendingIntent); // Con esto le asignamos a nuestro boton de abrir la app el pendingIntent

            SimpleDateFormat mdformat = new SimpleDateFormat("HH:mm:ss"); //Creamos un formato de horas, minutos y segundos
            String strDate = mdformat.format(Calendar.getInstance().getTime()); //Con esto obtenemos el tiempo actual y lo guardamos en strDate
            views.setTextViewText(R.id.horaUtlimaActualizacion, strDate); //Y a este le asignamos la hora actual a nuestro textView llamado horaUltimaActualizacion

            if(MainActivity.num_imag == 0){ //el valor num_imag sera una variable que puede tener de 0 a 2 de valor dependiendo de cuando se pulse el boton de cambiar
                views.setImageViewResource(R.id.imagenWidget, R.drawable.image_0);//estas funciones recogen el imagenWidget y le colocan la imagen de drawable
            }else if (MainActivity.num_imag == 1){
                views.setImageViewResource(R.id.imagenWidget, R.drawable.image_1);
            }else {
                views.setImageViewResource(R.id.imagenWidget, R.drawable.image_2);
            }

            appWidgetManager.updateAppWidget(appWidgetId, views); //Usando el appWidgetManager llamaremos a la funcion updateAppWidget y le vamos a pasar el ID actual de nuestro widget y el objeto remoteViews
        }
    }
}