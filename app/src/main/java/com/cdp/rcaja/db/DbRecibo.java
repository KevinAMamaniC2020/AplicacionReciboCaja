package com.cdp.rcaja.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.cdp.rcaja.entidades.Recibos;

import java.util.ArrayList;


public class DbRecibo extends DbHelper {

    Context context;

    public DbRecibo(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarContacto(String nombre, String cajero, int monto, String estado) {

        long id = 0;

        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            values.put("cajero", cajero);
            values.put("monto",monto);
            values.put("estado",estado);

            id = db.insert(TABLE_RECIBOS, null, values);
        } catch (Exception ex) {
            ex.toString();
        }

        return id;
    }

    public ArrayList<Recibos> mostrarContactos() {

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Recibos> listaRecibos= new ArrayList<>();
        Recibos recibo = null;
        Cursor cursorRecibos = null;

        cursorRecibos = db.rawQuery("SELECT * FROM " + TABLE_RECIBOS + " ORDER BY nombre ASC", null);

        if (cursorRecibos.moveToFirst()) {
            do {
                recibo = new Recibos();
                recibo.setId(cursorRecibos.getInt(0));
                recibo.setNombreCliente(cursorRecibos.getString(1));
                recibo.setNombreBanco(cursorRecibos.getString(2));
                recibo.setMonto(cursorRecibos.getInt(3));
                recibo.setEstado(cursorRecibos.getString(4));
                listaRecibos.add(recibo);
            } while (cursorRecibos.moveToNext());
        }

        cursorRecibos.close();

        return listaRecibos;
    }

    public Recibos verContacto(int id) {

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Recibos recibo = null;
        Cursor cursorRecibo;

        cursorRecibo = db.rawQuery("SELECT * FROM " + TABLE_RECIBOS + " WHERE id = " + id + " LIMIT 1", null);

        if (cursorRecibo.moveToFirst()) {
            recibo = new Recibos();
            recibo.setId(cursorRecibo.getInt(0));
            recibo.setNombreCliente(cursorRecibo.getString(1));
            recibo.setNombreBanco(cursorRecibo.getString(2));
            recibo.setMonto(cursorRecibo.getInt(3));
            recibo.setEstado(cursorRecibo.getString(4));;
        }

        cursorRecibo.close();

        return recibo;
    }

    public boolean editarContacto(int id, String nombre, String caja,int monto ,String estado) {

        boolean correcto = false;

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        try {
            db.execSQL("UPDATE " + TABLE_RECIBOS + " SET nombre = '" + nombre + "', cajero = '" + caja + "', estado = '" + estado + "', monto ='"+ monto + "' WHERE id='" + id + "' ");
            correcto = true;
        } catch (Exception ex) {
            ex.toString();
            correcto = false;
        } finally {
            db.close();
        }

        return correcto;
    }

    public boolean eliminarContacto(int id) {

        boolean correcto = false;

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        try {
            db.execSQL("DELETE FROM " + TABLE_RECIBOS + " WHERE id = '" + id + "'");
            correcto = true;
        } catch (Exception ex) {
            ex.toString();
            correcto = false;
        } finally {
            db.close();
        }

        return correcto;
    }
}
