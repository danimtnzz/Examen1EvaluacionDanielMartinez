package com.example.examen1evaluaciondanielmartinez;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LapsoViewHolder extends RecyclerView.ViewHolder{
    TextView numeroTiempo, unidadTiempo;

    public LapsoViewHolder(@NonNull View itemView) {
        super(itemView);
        numeroTiempo = itemView.findViewById(R.id.numeroTiempo);
        unidadTiempo = itemView.findViewById(R.id.unidadTiempo);

    }
}
