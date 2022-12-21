package com.cdp.rcaja;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;

import com.cdp.rcaja.Adapter.Adaptador;
import com.cdp.rcaja.db.DbRecibo;
import com.cdp.rcaja.entidades.Recibos;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class lista_items_recibo extends AppCompatActivity {

    ArrayList<Recibos> elementos;
    RecyclerView listaRecibos;
    SearchView busquedaRecibo;
    FloatingActionButton addNuevo;
    Adaptador adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_items_recibo);
        listaRecibos = findViewById(R.id.listaRecibos);
        addNuevo =findViewById(R.id.addRecibo);
        listaRecibos.setLayoutManager(new LinearLayoutManager(this));

        DbRecibo dbRecibo = new DbRecibo(lista_items_recibo.this);

        elementos = new ArrayList<>();

        adapter = new Adaptador(dbRecibo.mostrarContactos());
        listaRecibos.setAdapter(adapter);

        addNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nuevoRegistro();
            }
        });

        //txtBuscar.setOnQueryTextListener(this);

    }



    private void nuevoRegistro(){
        Intent intent = new Intent(this, nuevo_recibo.class);
        startActivity(intent);
    }

}