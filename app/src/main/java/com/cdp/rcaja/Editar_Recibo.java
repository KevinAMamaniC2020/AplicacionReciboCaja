package com.cdp.rcaja;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cdp.rcaja.db.DbRecibo;
import com.cdp.rcaja.entidades.Recibos;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Editar_Recibo extends AppCompatActivity {

    EditText txtNombre, txtCajero, txtMonto,txtEstado;
    Button btnGuardar;
    //FloatingActionButton fabEditar, fabEliminar;
    boolean correcto = false;
    Recibos recibos;
    int id = 0;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_recibo);

        txtNombre = findViewById(R.id.txtCrearNom);
        txtCajero = findViewById(R.id.txtCrearBanc);
        txtMonto = findViewById(R.id.txtCrearMon);
        txtEstado = findViewById(R.id.txtModEstado);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                id = Integer.parseInt(null);
            } else {
                id = extras.getInt("ID");
            }
        } else {
            id = (int) savedInstanceState.getSerializable("ID");
        }

        final DbRecibo dbRecibo = new DbRecibo(Editar_Recibo.this);
        recibos = dbRecibo.verContacto(id);

        if (recibos != null) {
            txtNombre.setText(recibos.getNombreCliente());
            txtCajero.setText(recibos.getNombreBanco());
            txtMonto.setText(recibos.getMonto());
            txtEstado.setText(recibos.getEstado());
        }

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!txtNombre.getText().toString().equals("") && !txtCajero.getText().toString().equals("")) {
                    correcto =  dbRecibo.editarContacto(id,txtNombre.getText().toString(), txtCajero.getText().toString(), Integer.parseInt(txtMonto.getText().toString()),txtEstado.getText().toString());

                    if(correcto){
                        Toast.makeText(Editar_Recibo.this, "REGISTRO MODIFICADO", Toast.LENGTH_LONG).show();
                        verRegistro();
                    } else {
                        Toast.makeText(Editar_Recibo.this, "ERROR AL MODIFICAR REGISTRO", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(Editar_Recibo.this, "DEBE LLENAR LOS CAMPOS OBLIGATORIOS", Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    private void verRegistro(){
        Intent intent = new Intent(this, Ver_recibo.class);
        intent.putExtra("ID", id);
        startActivity(intent);
    }
}