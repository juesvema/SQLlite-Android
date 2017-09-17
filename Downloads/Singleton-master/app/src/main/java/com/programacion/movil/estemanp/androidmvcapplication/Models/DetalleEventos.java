package com.programacion.movil.estemanp.androidmvcapplication.Models;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.programacion.movil.estemanp.androidmvcapplication.Domain.Evento;

/**
 * Created by User on 17/09/2017.
 */

public class DetalleEventos {

    private Evento event;

    public DetalleEventos(Evento event) {
        this.event = event;
    }

    public String getNameEvent() {
        return event.getNombre();
    }

    public String getAttenEvent() {

        return event.getEncargado();
    }

    public String getTipeEvent() {

        return event.getTipo();
    }
    public String getCityEvent() {

        return event.getCiudad();
    }

    public String getDateEvent() {
        return event.getFecha();
    }

    public String getHourEvent() {
        return event.getHora();
    }

    public String getRequirementEvent() {
        return event.getRequerimientos();
    }
    public String getDescriptionEvent() {
        return event.getDescripcion();
    }
    public String getPictureProfile() {
        return event.getFecha();
    }

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext()).load(imageUrl).into(view);
    }
}
