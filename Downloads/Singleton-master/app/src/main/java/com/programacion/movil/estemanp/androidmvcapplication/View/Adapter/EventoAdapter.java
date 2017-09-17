package com.programacion.movil.estemanp.androidmvcapplication.View.Adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.programacion.movil.estemanp.androidmvcapplication.Controller.EventoController;
import com.programacion.movil.estemanp.androidmvcapplication.Domain.Evento;
import com.programacion.movil.estemanp.androidmvcapplication.Models.ItemModelo;
import com.programacion.movil.estemanp.androidmvcapplication.R;
import com.programacion.movil.estemanp.androidmvcapplication.View.Evento_activity;
import com.programacion.movil.estemanp.androidmvcapplication.databinding.ItemsBinding;

import java.util.Collections;
import java.util.List;

/**
 * Created by User on 15/09/2017.
 */

public class EventoAdapter extends RecyclerView.Adapter<EventoAdapter.EventAdapterViewHolder> {

    private List<Evento> eventList;


    public EventoAdapter() {
        this.eventList = Collections.emptyList();
    }

    public EventoAdapter(Evento_activity evento_activity, List<Evento> eventos) {
    }


    @Override
    public EventAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemsBinding itemEventBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.items,
                        parent, false);
        return new EventAdapterViewHolder(itemEventBinding);
    }

    @Override
    public void onBindViewHolder(EventAdapterViewHolder holder, int position) {
        holder.bindEvent(eventList.get(position));
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public void setEventList(List<Evento> eventList) {
        this.eventList = eventList;
        notifyDataSetChanged();
    }

    public static class EventAdapterViewHolder extends RecyclerView.ViewHolder {
        ItemsBinding itemEventBinding;

        public EventAdapterViewHolder(ItemsBinding itemEventBinding) {
            super(itemEventBinding.itemEvent);
            this.itemEventBinding = itemEventBinding;
        }

        void bindEvent(Evento event) {
            if (itemEventBinding.getEventViewModel() == null) {
                itemEventBinding.setEventViewModel(
                        new ItemModelo(event, itemView.getContext()));
            } else {
                itemEventBinding.getEventViewModel().setEvent(event);
            }
        }
    }

}
