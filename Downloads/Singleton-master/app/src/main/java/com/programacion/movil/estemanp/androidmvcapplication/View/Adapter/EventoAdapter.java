package com.programacion.movil.estemanp.androidmvcapplication.View.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.programacion.movil.estemanp.androidmvcapplication.Domain.Evento;
import com.programacion.movil.estemanp.androidmvcapplication.R;

import java.util.List;

/**
 * Created by User on 15/09/2017.
 */

public class EventoAdapter extends RecyclerView.Adapter<EventoAdapter.EventViewHolder> {

    private List<Evento> eventList;
    Context context;

    public EventoAdapter(Context context, List<Evento> eventList){
        this.context = context;
        this.eventList = eventList;
    }

    @Override
    public EventoAdapter.EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.eventos, parent, false);
        EventViewHolder vh = new EventViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(EventoAdapter.EventViewHolder holder, int position) {
        holder.txtIdEvent.setText(Integer.toString(eventList.get(position).get_id()));
        holder.txtNameEvent.setText(eventList.get(position).getNombre());
        holder.txtTypeEvent.setText(eventList.get(position).getTipo());
        holder.txtDateEvent.setText(eventList.get(position).getFecha());
        holder.txtHoraEvent.setText(eventList.get(position).getHora());
    }

    @Override
    public int getItemCount() {
        if(eventList!= null){
            return eventList.size();
        }
        return 0;
    }

    class EventViewHolder extends RecyclerView.ViewHolder {
        private TextView
                txtIdEvent,
                txtNameEvent,
                txtTypeEvent,
                txtDateEvent,
                txtHoraEvent;

        public EventViewHolder(View v) {
            super(v);
            txtIdEvent = (TextView) v.findViewById(R.id.txtIdEvento);
            txtNameEvent = (TextView) v.findViewById(R.id.txtNameEvento);
            txtTypeEvent =(TextView) v.findViewById(R.id.txtTipoEvento);
            txtDateEvent = (TextView) v.findViewById(R.id.txtFechaEvento);
            txtHoraEvent = (TextView) v.findViewById(R.id.txtHoraEvento);
        }
    }

}
