package com.programacion.movil.estemanp.androidmvcapplication.Models;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.view.View;

import com.programacion.movil.estemanp.androidmvcapplication.Domain.Evento;
import com.programacion.movil.estemanp.androidmvcapplication.View.Detalle;

/**
 * Created by User on 17/09/2017.
 */

public class ItemModelo extends BaseObservable {

    private Evento event;
    private Context context;

    public ItemModelo(Evento event, Context context) {
        this.event = event;
        this.context = context;
    }

    public String getNameEvent() {
        return event.getNombre();
    }

    public String getTypeEvent() {
        return event.getTipo();
    }

    public String getHourEvent() {
        return event.getHora();
    }

    public void onItemClick(View view) {
        context.startActivity(Detalle.launchDetail(view.getContext(), event));
    }

    public void setEvent(Evento event) {
        this.event = event;
        notifyChange();
    }
}
