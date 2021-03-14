package com.example.recyclerview;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapterDatos extends RecyclerView.Adapter<adapterDatos.viewHolderDatos> {

    ArrayList<String> listDatos;

    public adapterDatos(ArrayList<String> listDatos) {
        this.listDatos = listDatos;
    }

    @NonNull
    @Override
    public viewHolderDatos onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);
        return new viewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapterDatos.viewHolderDatos holder, int position) {
        holder.asignarDatos(listDatos.get(position));
    }

    @Override
    public int getItemCount() {
        return listDatos.size();
    }

    public class viewHolderDatos extends RecyclerView.ViewHolder {

        TextView dato;

        public viewHolderDatos(View itemView) {
            super(itemView);
            dato = itemView.findViewById(R.id.idDato);
        }

        public void asignarDatos(String datos) {
            dato.setText(datos);
        }
    }
}
