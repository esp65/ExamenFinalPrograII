package com.chenao.registrtienda;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.chenao.registrtienda.db.DbUsuarios;

public class Usuario extends AppCompatActivity {

    EditText txtNombre, txtcontraseña;
    Button btnGuarda;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        txtNombre= findViewById(R.id.txtNomb);
        txtcontraseña= findViewById(R.id.txtcontra);
        btnGuarda= findViewById(R.id.btnGuard);

        btnGuarda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbUsuarios dbusuarios = new DbUsuarios(Usuario.this);
                long id = dbusuarios.insertarUsuario(txtNombre.getText().toString(), txtcontraseña.getText().toString());
                if(id > 0){
                    Toast.makeText(Usuario.this, "ESTE REGISTRO FUE GUARDADO", Toast.LENGTH_LONG).show();
                    limpiar();
                }else{
                    Toast.makeText(Usuario.this, "ESTE REGISTRO NO FUE GUARDADO", Toast.LENGTH_LONG).show();
                }



            }
        });


    }

    private void limpiar(){
        txtNombre.setText("");
        txtNombre.setText("");

    }

}