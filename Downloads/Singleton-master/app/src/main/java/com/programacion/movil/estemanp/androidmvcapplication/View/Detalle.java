package com.programacion.movil.estemanp.androidmvcapplication.View;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.programacion.movil.estemanp.androidmvcapplication.Domain.Evento;
import com.programacion.movil.estemanp.androidmvcapplication.Models.DetalleEventos;
import com.programacion.movil.estemanp.androidmvcapplication.databinding.DetalleBinding;
import com.programacion.movil.estemanp.androidmvcapplication.R;

/**
 * Created by User on 17/09/2017.
 */

public class Detalle extends AppCompatActivity {

    private static final String EXTRA_EVENT = "EXTRA_EVENT";

    private DetalleBinding eventDetailActivityBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        eventDetailActivityBinding = DataBindingUtil.setContentView(this, R.layout.detalle);
        displayHomeAsUpEnabled();
        getExtrasFromIntent();
    }

    public static Intent launchDetail(Context context, Evento event) {
        Intent intent = new Intent(context, Detalle.class);
        intent.putExtra(EXTRA_EVENT, event);
        return intent;
    }

    private void displayHomeAsUpEnabled() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void getExtrasFromIntent() {
        Evento event = (Evento) getIntent().getSerializableExtra(EXTRA_EVENT);
        DetalleEventos eventDetailViewModel = new DetalleEventos(event);
        eventDetailActivityBinding.setEventDetailViewModel(eventDetailViewModel);
    }
}
