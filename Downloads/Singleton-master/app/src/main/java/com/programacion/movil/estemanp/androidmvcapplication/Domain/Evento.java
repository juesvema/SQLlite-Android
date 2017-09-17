package com.programacion.movil.estemanp.androidmvcapplication.Domain;

import android.content.ContentValues;
import android.database.Cursor;

import com.programacion.movil.estemanp.androidmvcapplication.Repositorio.EventContract;

import java.io.Serializable;

/**
 * Created by User on 14/09/2017.
 */

public class Evento implements Serializable {

    public   int _id;
    public   String nombre;
    public   String tipo;
    public   String encargado;
    public   String ciudad;
    public   String fecha;
    public   String hora;
    public   String requerimientos;
    public   String descripcion;

    public Evento(String nombre, String tipo, String encargado, String ciudad, String fecha, String hora, String requerimientos, String descripcion) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.encargado = encargado;
        this.ciudad = ciudad;
        this.fecha = fecha;
        this.hora = hora;
        this.requerimientos = requerimientos;
        this.descripcion = descripcion;
    }

    public Evento (Cursor cursor) {
        _id = cursor.getInt(cursor.getColumnIndex(EventContract.EventEntry._ID  ));
        nombre = cursor.getString(cursor.getColumnIndex(EventContract.EventEntry.nombre  ));
        tipo = cursor.getString(cursor.getColumnIndex(EventContract.EventEntry.tipo));
        encargado = cursor.getString(cursor.getColumnIndex(EventContract.EventEntry.encargado));
        ciudad = cursor.getString(cursor.getColumnIndex(EventContract.EventEntry.ciudad));
        fecha = cursor.getString(cursor.getColumnIndexOrThrow(EventContract.EventEntry.fecha));
        hora = cursor.getString(cursor.getColumnIndexOrThrow(EventContract.EventEntry.hora));
        requerimientos = cursor.getString(cursor.getColumnIndex(EventContract.EventEntry.requerimientos));
        descripcion = cursor.getString(cursor.getColumnIndex(EventContract.EventEntry.descripcion));
    }


    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(EventContract.EventEntry.nombre, getNombre());
        values.put(EventContract.EventEntry.tipo, getTipo());
        values.put(EventContract.EventEntry.encargado, getEncargado());
        values.put(EventContract.EventEntry.ciudad, getCiudad());
        values.put(EventContract.EventEntry.fecha, getFecha());
        values.put(EventContract.EventEntry.hora, getHora());
        values.put(EventContract.EventEntry.requerimientos, getRequerimientos());
        values.put(EventContract.EventEntry.descripcion, getDescripcion());
        return values;
    }


    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getRequerimientos() {
        return requerimientos;
    }

    public void setRequerimientos(String requerimientos) {
        this.requerimientos = requerimientos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
