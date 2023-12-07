package com.example.examen1evaluaciondanielmartinez;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

public class LapsoAdapter extends RecyclerView.Adapter<LapsoViewHolder> {



    Context context;
    List<Lapso> lapsos;

    public LapsoAdapter(Context context, List<Lapso> lapsos) {
        this.context = context;
        this.lapsos = lapsos;
    }

    @NonNull
    @Override
    public LapsoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LapsoViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_lapso_adapter, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LapsoViewHolder holder, int position) {
        holder.numeroTiempo.setText(lapsos.get(position).getNumeroTiempo());
        holder.unidadTiempo.setText(lapsos.get(position).getTiempo());

    }

    @Override
    public int getItemCount() {
        return lapsos.size();
    }
}