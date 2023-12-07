package com.example.examen1evaluaciondanielmartinez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuPrincipal extends AppCompatActivity {
    Button btnCronometro;
    Button btnSalirPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        btnCronometro =findViewById(R.id.btnCronometro);
        btnSalirPrincipal = findViewById(R.id.btnSalirPrincipal);
    }

    //Función que crea un intent para ir a la nueva pantalla
    public void irCronometro(View v){
        Intent i = new Intent(this, Cronometro.class);
        startActivity(i);
    }

    //Función para salir de la app cerrando la ultima actividad (al solo haber una abierta sale)
    public void salir(View v){
        finish();
    }
}