package com.example.examen1evaluaciondanielmartinez;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Cronometro extends AppCompatActivity {
    TextView contador;
    BigInteger cont = BigInteger.ZERO;
    int incrementoAutomatico = 1;
    private volatile boolean isPaused = false;
    Button btnPlay;
    RecyclerView rv;
    List<Lapso> lapsos = new ArrayList<Lapso>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        btnPlay = findViewById(R.id.btnPlay);
        setContentView(R.layout.activity_cronometro);
        contador = findViewById(R.id.textoContador);
        rv =  findViewById(R.id.recycler);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new LapsoAdapter(getApplicationContext(), lapsos));

    }

    public void añadirRecycler(View v){
        lapsos.add(new Lapso("segundos", Thread.activeCount()));
        //TODO: debería devolver los segundos que han pasado en vez del numero de hilos, y el primer parametro seria la unidad (segundos, minutos)
    }

    public void pausarHilo(View v){
        isPaused = true;
    }

    //Hilo para que arranque el cronometro
    public void ejecutarHilo(View v) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(() -> {
            //Background work here
            while (true){
                try {
                    Thread.sleep( 1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


                //TODO: SE PAUSA PARA SIEMPRE
                while (isPaused) {
                    try {
                        Thread.sleep(100); // Dormir el hilo si está pausado
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }


                cont = cont.add(BigInteger.valueOf(incrementoAutomatico));

                handler.post(() -> {
                    //UI Thread work here
                    contador.setText(actualizarTextoContador());
                });}
        });
    }

    private String actualizarTextoContador() {
        String textoContador;
        if (cont.compareTo(BigInteger.valueOf(1000)) >= 0) {


            textoContador = cont + " mil";
        } else {
            textoContador = cont.toString();
        }
        contador.setText(textoContador);
        return textoContador;
    }
}