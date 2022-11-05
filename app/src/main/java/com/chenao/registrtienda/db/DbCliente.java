package com.chenao.registrtienda.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbCliente extends DbHelper{
    Context context;

    public DbCliente(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarCliente(String nombre,String apellido,String email, String telefono){
        long id = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            values.put("apellido", apellido);
            values.put("email", email);
            values.put("telefono", telefono);


            id = db.insert(TABLE_Cliente, null, values);

        }catch(Exception ex){
            ex.toString();
        }
        return id;

    }
}
