package com.cdp.rcaja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btnSesion);
        button.setOnClickListener(v->{
            onClick(v);
        });
    }
    public void onClick(View view){
        Intent intent = new Intent(this, lista_items_recibo.class);
        startActivity(intent);
    }
}