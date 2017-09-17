package com.programacion.movil.estemanp.androidmvcapplication.Models;

import android.content.Context;
import android.databinding.ObservableInt;

import com.programacion.movil.estemanp.androidmvcapplication.Controller.EventoController;
import com.programacion.movil.estemanp.androidmvcapplication.Domain.Evento;
import android.content.Context;
import android.databinding.ObservableInt;
import android.support.annotation.NonNull;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.List;

/**
 * Created by User on 17/09/2017.
 */

public class EventoVistaModelo extends Observable {
    public ObservableInt eventRecycler;

    private List<Evento> eventList;
    private Context context;
    private EventoController appController;

    public EventoVistaModelo(@NonNull Context context) {
        this.context = context;
        this.eventList = new ArrayList<>();
        eventRecycler = new ObservableInt(View.GONE);
        eventRecycler.set(View.GONE);
    }

    public void onClickFabLoad(View view) {
        eventRecycler.set(View.GONE);
        fetchEventList();
    }

    public void fetchEventList() {
        appController = new EventoController(context);
        eventList.addAll(appController.llenarEventos());
        System.out.println("lista: " + eventList);
        setChanged();
        notifyObservers();
        eventRecycler.set(View.VISIBLE);
    }

    public List<Evento> getEventList() {
        return eventList;
    }
}
