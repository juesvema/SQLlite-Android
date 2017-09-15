package com.programacion.movil.estemanp.androidmvcapplication.View;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.programacion.movil.estemanp.androidmvcapplication.Controller.ApplicationController;
import com.programacion.movil.estemanp.androidmvcapplication.Controller.EventoController;
import com.programacion.movil.estemanp.androidmvcapplication.Domain.User;
import com.programacion.movil.estemanp.androidmvcapplication.R;
import com.programacion.movil.estemanp.androidmvcapplication.View.Adapter.EventoAdapter;

import java.sql.SQLOutput;
import java.util.Calendar;
import java.util.List;

public class LandingActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerStudents;
    private RecyclerView.LayoutManager mLayoutManager;
    private EventoAdapter eventoAdapter, eventoFiltrar, eventoFiltrarFecha;
    private EventoController appController;
    public Button buscar;
    public EditText inputSearch;
    public TextView fechaFiltro;
    private int dia, mes, año, AmPm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        inputSearch = (EditText) findViewById(R.id.inputSearch);
        fechaFiltro = (TextView) findViewById(R.id.fechaFiltro);
        appController= new EventoController(getApplicationContext());
        buscar = (Button) findViewById(R.id.button);
        recyclerStudents= (RecyclerView) findViewById(R.id.recyclerEventos);
        recyclerStudents.setHasFixedSize(true);
        mLayoutManager=new LinearLayoutManager(this);
        recyclerStudents.setLayoutManager(mLayoutManager);
        eventoAdapter = new EventoAdapter(this , appController.llenarEventos());
        recyclerStudents.setAdapter(eventoAdapter);
        fechaFiltro.setOnClickListener(this);
        buscar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                filtrarporTipo();
            }
        });
    }

    public void filtrarporTipo(){
        String text = inputSearch.getText().toString();
        eventoFiltrar = new EventoAdapter(this, appController.filtrarporTipo(text));
        String blank = "";
        if (blank.equals(text)){
            recyclerStudents.setAdapter(eventoAdapter);
        }else{
            recyclerStudents.setAdapter(eventoFiltrar);
        }
    }

    public void filtrarporFecha(){
        String fecha = fechaFiltro.getText().toString();
        eventoFiltrarFecha = new EventoAdapter(this, appController.filtrarporFecha(fecha));
        String blank = "";
        if (blank.equals(fecha)){
            recyclerStudents.setAdapter(eventoAdapter);
        }else{
            recyclerStudents.setAdapter(eventoFiltrarFecha);
        }
    }

    @Override
    public void onClick(View v) {
        if (v == fechaFiltro) {
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            año = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    String dates = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                    fechaFiltro.setText(dates);
                    filtrarporFecha();
                }
            }
                    , dia, mes, año);
            datePickerDialog.show();
        }

    }

}
