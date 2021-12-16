package com.example.evaluacion1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity2 extends AppCompatActivity {

    private TextView reloj, tuser,reserva,tcancha;
   private DatePicker calendario;
    private  int hora, minuto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        reloj = findViewById(R.id.Hora);
        tuser = findViewById(R.id.tuser);
        reserva =findViewById(R.id.Reservas1);
        calendario =findViewById(R.id.Calendario);
        tcancha = findViewById(R.id.tcancha);

        String user = getIntent().getStringExtra("Usuario");
        tuser.setText(user);
    }
    public void seleccionaHora(View view){

        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int horaSeleccionada, int minutoSeleccionado) {
                hora = horaSeleccionada;
                minuto = minutoSeleccionado;

                // botonreloj.setText(hora +":"+minuto);
                reloj.setText(String.format(Locale.getDefault(),"%02d:%02d",hora,minuto));
            }
        };

        TimePickerDialog timePickerDialog =new TimePickerDialog(this, onTimeSetListener, hora, minuto, false);
        timePickerDialog.show();
    }
    public void GuardarReserva(View view){
        if (reloj.getText().toString().equals("Seleccione Hora") || tcancha.getText().toString().equals("")){
            Toast.makeText(MainActivity2.this,"Debe Completar Los Datos", Toast.LENGTH_LONG).show();
        }

        else{
        String r =reserva.getText().toString();
        String cadena =tuser.getText().toString()+ " "+ calendario.getDayOfMonth()+"/"+(calendario.getMonth()+1)+"/"+calendario.getYear() +" "+ reloj.getText().toString()+" "+tcancha.getText().toString();
         reserva.setText(r+"\n" + cadena);
        Toast.makeText(MainActivity2.this,"Reserva Guardada Con Exito!!!!", Toast.LENGTH_LONG).show();
        reloj.setText("Seleccione Hora");
        tcancha.setText("");
        }
    }

}