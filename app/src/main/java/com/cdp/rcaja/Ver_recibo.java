package com.cdp.rcaja;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.cdp.rcaja.db.DbRecibo;
import com.cdp.rcaja.entidades.Recibos;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Ver_recibo extends AppCompatActivity {

    EditText txtNombre, txtCajero, txtMonto,txtEstado;
    Button  btnGuardar;
    FloatingActionButton fabEditar, fabEliminar;

    Recibos recibos;
    int id = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_recibo);

        txtNombre = findViewById(R.id.txtCrearNom);
        txtCajero = findViewById(R.id.txtCrearBanc);
        txtMonto = findViewById(R.id.txtCrearMon);
        txtEstado = findViewById(R.id.txtCrearEstado);
        fabEditar = findViewById(R.id.btnEdit);
        fabEliminar = findViewById(R.id.btnDelete);
        btnGuardar = findViewById(R.id.btnGuardar);
        btnGuardar.setVisibility(View.INVISIBLE);


        if(savedInstanceState == null){
            Bundle extras = getIntent().getExtras();
            if(extras == null){
                id = Integer.parseInt(null);
            } else {
                id = extras.getInt("ID");
            }
        } else {
            id = (int) savedInstanceState.getSerializable("ID");
        }

        final DbRecibo dbRecibos = new DbRecibo(Ver_recibo.this);
        recibos = dbRecibos.verContacto(id);

        if(recibos != null){
            txtNombre.setText(recibos.getNombreCliente());
            txtCajero.setText(recibos.getNombreBanco());
            txtMonto.setText(recibos.getMonto());
            txtEstado.setText(recibos.getEstado());
            txtNombre.setInputType(InputType.TYPE_NULL);
            txtCajero.setInputType(InputType.TYPE_NULL);
            txtMonto.setInputType(InputType.TYPE_NULL);
            txtEstado.setInputType(InputType.TYPE_NULL);
        }

        fabEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ver_recibo.this, Editar_Recibo.class);
                intent.putExtra("ID", id);
                startActivity(intent);
            }
        });

        fabEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Ver_recibo.this);
                builder.setMessage("¿Desea eliminar este contacto?")
                        .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                if(dbRecibos.eliminarContacto(id)){
                                    lista();
                                }
                            }
                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        }).show();
            }
        });
    }
    private void lista(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}