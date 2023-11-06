package com.example.persistencia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText nom = (EditText) findViewById(R.id.nom);
        EditText cognom = (EditText) findViewById(R.id.cognom);
        EditText tel = (EditText) findViewById(R.id.telefon);
        EditText email = (EditText) findViewById(R.id.email);
        final Button guardar = findViewById(R.id.button);
        Context context = getApplicationContext();

        guardar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String cadena= nom.getText().toString()+","+cognom.getText().toString()+";"+tel.getText().toString()+","+email.getText().toString();
                try {
                    FileOutputStream fos = null;
                    fos = context.openFileOutput("contactes.txt", Context.MODE_PRIVATE);
                    fos.write(cadena.getBytes(StandardCharsets.UTF_8));
                }catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });

    }
}