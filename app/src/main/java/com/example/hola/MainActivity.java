package com.example.hola;

import android.content.Intent;
import android.net.Uri;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText texto, enlace;
    Button saludar, navegar;
    Intent i;
    public  static  final String DATO = "nombre";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);

        texto = (EditText) findViewById(R.id.editText);
        saludar = (Button) findViewById(R.id.button);
        saludar.setOnClickListener(this);
        enlace = (EditText) findViewById(R.id.editText2);
        navegar = (Button)findViewById(R.id.button2);
        navegar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == saludar) {
            i = new Intent (this, Segunda.class);
            i.putExtra(DATO, texto.getText().toString());
            startActivity(i);
        }

        if (view == navegar) {
            openWebPage(enlace.getText().toString());
        }
    }

    public void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        else
            Toast.makeText(this, "Error en la URL/No hay un navegador instalado", Toast.LENGTH_SHORT).show();
    }



}

