package com.programacion.movil.estemanp.androidmvcapplication.View;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.programacion.movil.estemanp.androidmvcapplication.Controller.EventoController;
import com.programacion.movil.estemanp.androidmvcapplication.Domain.Evento;
import com.programacion.movil.estemanp.androidmvcapplication.R;

import java.util.Calendar;

public class Admin extends AppCompatActivity implements View.OnClickListener {

    TextView Edit_Fecha, Edit_hora;
    private int dia, mes, año, hora, minutos, AmPm;
    public Spinner spinner;
    EditText nombre, encargado, descripcion, lugar, requisitos;
    String nombres, encargados, descripciones, fecha, hour, tipos, ciudad, requi;
    Button aceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        nombre = (EditText) findViewById(R.id.nombre);
        descripcion = (EditText) findViewById(R.id.descripcion);
        encargado = (EditText) findViewById(R.id.encargado);
        lugar = (EditText) findViewById(R.id.lugar);
        requisitos = (EditText) findViewById(R.id.requisitos);
        Edit_Fecha = (TextView) findViewById(R.id.fechaText);
        Edit_hora = (TextView) findViewById(R.id.horaText);
        Edit_Fecha.setOnClickListener(this);
        Edit_hora.setOnClickListener(this);
        spinner = (Spinner) findViewById(R.id.spinner);
        aceptar = (Button) findViewById(R.id.button3);
        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombres= nombre.getText().toString();
                ciudad= lugar.getText().toString();
                requi= requisitos.getText().toString();
                encargados= encargado.getText().toString();
                descripciones= descripcion.getText().toString();
                fecha= Edit_Fecha.getText().toString();
                hour= Edit_hora.getText().toString();
                tipos= spinner.getSelectedItem().toString();
                Evento evento = new Evento(nombres, tipos, encargados, ciudad, fecha, hour, requi, descripciones);
                boolean controller = new EventoController(getApplicationContext()).create(evento);
                System.out.println("CONTROLADOR "+controller);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.sesion:
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public void onClick(View v) {
        if (v == Edit_Fecha) {
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            año = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    Edit_Fecha.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                }
            }
                    , dia, mes, año);
            datePickerDialog.show();
        }
        if (v == Edit_hora) {
            final Calendar c = Calendar.getInstance();
            hora = c.get(Calendar.HOUR_OF_DAY);
            minutos = c.get(Calendar.MINUTE);
            AmPm = c.get(Calendar.AM_PM);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    hora = hourOfDay;
                    minutos = minute;

                    String AM_PM;
                    if (hourOfDay < 12) {
                        AM_PM = "AM";

                    } else {
                        AM_PM = "PM";
                        hora = hora - 12;
                    }
                    Edit_hora.setText(hora + ":" + minutos + " " + AM_PM);

                }

            }, hora, minutos, false);
            timePickerDialog.show();
        }


    }
}
