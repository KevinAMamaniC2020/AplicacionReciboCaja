package com.cdp.rcaja;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.cdp.rcaja.db.DbRecibo;

public class nuevo_recibo extends AppCompatActivity {
    EditText txtNombre, txtCajero, txtMonto;
    Button btnCrear, btnCancel;
    RadioButton staActv, staInac, staElim;

    @Override
    protected void onCreate(Bundle savedInstaceState) {
        super.onCreate(savedInstaceState);
        setContentView(R.layout.activity_nuevo_recibo);

        txtNombre = findViewById(R.id.txtCrearNom);
        txtCajero = findViewById(R.id.txtCrearBanc);
        txtMonto = findViewById(R.id.txtCrearMon);
        btnCrear = findViewById(R.id.btnCrearRec);
        btnCancel = findViewById(R.id.btnCancelCre);
        staActv = findViewById(R.id.selectAct);
        staElim = findViewById(R.id.selectElim);
        staInac = findViewById(R.id.selectInac);

        btnCrear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(!txtNombre.getText().toString().equals("") && !txtCajero.getText().toString().equals("")) {

                    DbRecibo dbRecibo = new DbRecibo(nuevo_recibo.this);
                    long id = dbRecibo.insertarContacto(txtNombre.getText().toString(), txtCajero.getText().toString(), txtMonto.getText().toString(),);

                    if (id > 0) {
                        Toast.makeText(nuevo_recibo.this, "REGISTRO GUARDADO", Toast.LENGTH_LONG).show();
                        limpiar();
                    } else {
                        Toast.makeText(nuevo_recibo.this, "ERROR AL GUARDAR REGISTRO", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(nuevo_recibo.this, "DEBE LLENAR LOS CAMPOS OBLIGATORIOS", Toast.LENGTH_LONG).show();
                }
            }

        });

    }


    private void limpiar() {
        txtNombre.setText("");
        txtCajero.setText("");
        txtMonto.setText("");
    }
}
