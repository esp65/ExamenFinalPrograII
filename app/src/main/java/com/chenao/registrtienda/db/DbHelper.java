package com.chenao.registrtienda.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_Nombre = "Ventas.db";
    static final String TABLE_USUARIOS = "t_usuarios";
    static final String TABLE_Cliente = "t_cliente";
    static final String TABLE_Vendedor = "t_vendedor";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_Nombre, null,  DATABASE_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(("CREATE TABLE "+ TABLE_USUARIOS+"(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "contraseña TEXT NOT NULL)"));

        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLE_Cliente + "(" +
        "nombre TEXT NOT NULL," +
        "apellido TEXT NOT NULL," +
        "email TEXT NOT NULL," +
        "telefono TEXT NOT NULL)");

        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLE_Vendedor + "(" +
        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
        "nombre TEXT NOT NULL," +
        "contraseña TEXT NOT NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_USUARIOS);
        onCreate(sqLiteDatabase);

        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_Cliente);
        onCreate(sqLiteDatabase);

        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_Vendedor);
        onCreate(sqLiteDatabase);

    }
}
