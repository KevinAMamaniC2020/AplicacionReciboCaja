package com.cdp.rcaja;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;

import com.cdp.rcaja.Adapter.Adaptador;
import com.cdp.rcaja.entidades.Recibos;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class lista_items_recibo extends AppCompatActivity {

    List<Recibos> elementos;
    RecyclerView listaRecibos;
    SearchView busquedaRecibo;
    FloatingActionButton addNuevo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_items_recibo);

        init();
        addNuevo = findViewById(R.id.addRecibo);

        addNuevo.setOnClickListener(view ->{
            onClick(view);
        });
    }

    public void init(){
        elementos = new ArrayList<>();
        elementos.add(new Recibos("#775457","Rodolfo Juancracio","Juan@gmail.com","Activo"));
        elementos.add(new Recibos("#775457","Juancracio Perez","Perez@gmail.com","Inactivo"));
        elementos.add(new Recibos("#775457","Perez Lopez","Lopez@gmail.com","*"));

        Adaptador listAdapter = new Adaptador(elementos,this);
        RecyclerView recyclerView = findViewById(R.id.listaContactos);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }

    private void onClick(View view){
        Intent intent = new Intent(this, nuevo_recibo.class);
        startActivity(intent);
    }
}