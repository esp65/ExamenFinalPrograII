package com.chenao.registrtienda.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbVendedor extends DbHelper{
    Context context;

    public DbVendedor(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarVendedor(String nombre,String contraseña){
        long id = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            values.put("contraseña", contraseña);

            id = db.insert(TABLE_Vendedor, null, values);

        }catch(Exception ex){
            ex.toString();
        }
        return id;

    }
}
