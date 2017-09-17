package com.programacion.movil.estemanp.androidmvcapplication.View;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.programacion.movil.estemanp.androidmvcapplication.Controller.EventoController;
import com.programacion.movil.estemanp.androidmvcapplication.Models.EventoVistaModelo;
import com.programacion.movil.estemanp.androidmvcapplication.R;
import com.programacion.movil.estemanp.androidmvcapplication.View.Adapter.EventoAdapter;
import com.programacion.movil.estemanp.androidmvcapplication.databinding.EventoBinding;

import java.util.Calendar;
import java.util.Observable;
import java.util.Observer;


/**
 * Created by User on 17/09/2017.
 */

public class Evento_activity extends AppCompatActivity implements Observer, View.OnClickListener {

    private EventoBinding eventActivityBinding;
    private EventoVistaModelo eventViewModel;
    public TextView fechaFiltro;
    private int dia, mes, año, AmPm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataBinding();
        setupListPeopleView(eventActivityBinding.listaEvento);
        setupObserver(eventViewModel);
        eventViewModel.onClickFabLoad(null);
        fechaFiltro = (TextView) findViewById(R.id.fechaFiltro);
        fechaFiltro.setOnClickListener(this);
    }

    private void initDataBinding() {
        eventActivityBinding = DataBindingUtil.setContentView(this, R.layout.evento);
        eventViewModel = new EventoVistaModelo(this);
        eventActivityBinding.setMainViewModel(eventViewModel);
    }

    private void setupListPeopleView(RecyclerView listPeople) {
        EventoAdapter adapter = new EventoAdapter();
        listPeople.setAdapter(adapter);
        listPeople.setLayoutManager(new LinearLayoutManager(this));
    }

    public void setupObserver(Observable observable) {
        observable.addObserver(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void startActivityActionView() {
        //  startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(PeopleFactory.PROJECT_URL)));
    }

    @Override
    public void update(Observable observable, Object data) {
        if (observable instanceof EventoVistaModelo) {
            EventoAdapter eventAdapter = (EventoAdapter) eventActivityBinding.listaEvento.getAdapter();
            EventoVistaModelo eventViewModel = (EventoVistaModelo) observable;
            eventAdapter.setEventList(eventViewModel.getEventList());
        }
    }

    /*public void filtrarporTipo(RecyclerView listPeople){
        String text = inputSearch.getText().toString();
        EventoAdapter adapter = new EventoAdapter();

        eventoFiltrar = new EventoAdapter(this, appController.filtrarporTipo(text));
        String blank = "";
        if (blank.equals(text)){
            listPeople.setAdapter(adapter);
            listPeople.setLayoutManager(new LinearLayoutManager(this));
        }else{
            recyclerStudents.setAdapter(eventoFiltrar);
        }
    }

    public void filtrarporFecha(){
        String fecha = fechaFiltro.getText().toString();
        // eventoFiltrarFecha = new EventoAdapter(this, appController.filtrarporFecha(fecha));
        String blank = "";
        if (blank.equals(fecha)){
            recyclerStudents.setAdapter(eventoAdapter);
        }else{
            recyclerStudents.setAdapter(eventoFiltrarFecha);
        }
    }*/

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
                    //filtrarporFecha();
                }
            }
                    , dia, mes, año);
            datePickerDialog.show();
        }

    }
}
