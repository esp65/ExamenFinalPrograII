package com.chenao.registrtienda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.chenao.registrtienda.db.DbHelper;

public class MainActivity extends AppCompatActivity {

    Button btnCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCrear=findViewById(R.id.btnCrar);

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DbHelper dbhelper = new DbHelper(MainActivity.this);
                SQLiteDatabase db =  dbhelper.getWritableDatabase();
                if (db != null){
                    Toast.makeText(MainActivity.this, "BASE DE DATOS FUE CREADA",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this, "HUBO UN ERROR AL CREAR BASE DE DATOS",Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu){

        //getMenuInflater().inflate(R.menu.menu_principal,menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal,menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menuNuevo:
                nuevoRegistro();
            case R.id.menu_nue:
                nuevoRegistro();

            case R.id.menu_Nuevo:
                nuevoRegistro();

                return true;

            default:
                return super.onOptionsItemSelected(item);



        }
    }



    private void nuevoRegistro(){
        Intent intent = new Intent (this,Usuario.class);
        startActivity(intent);

        Intent intent1 = new Intent (this,Cliente.class);
        startActivity(intent1);

    }

}