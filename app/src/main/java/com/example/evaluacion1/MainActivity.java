package com.example.evaluacion1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public TextView user;
    public TextView pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.User);
        pass = findViewById(R.id.Pass);


    }
    public void EnviarDatos(View view){
        if(user.getText().toString().equals("") || pass.getText().toString().equals("")) {
            Toast.makeText(MainActivity.this, "Debe Completar Los Datos", Toast.LENGTH_LONG).show();
        }
        else {
            String usuario = user.getText().toString();
            Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra("Usuario", usuario);
            startActivity(intent);
            Toast.makeText(MainActivity.this, "Bienvenido :"+usuario  , Toast.LENGTH_LONG).show();
        }

    }

}