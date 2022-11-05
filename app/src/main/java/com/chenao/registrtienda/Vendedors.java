package com.chenao.registrtienda;

import static com.chenao.registrtienda.R.id.txtnom;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.chenao.registrtienda.db.DbUsuarios;
import com.chenao.registrtienda.db.DbVendedor;

public class Vendedors extends AppCompatActivity {

    EditText txtnom, txtcontra;
    Button btnGuard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendedors);

        txtnom= findViewById(R.id.txtNomb);
        txtcontra= findViewById(R.id.txtcontra);
        btnGuard= findViewById(R.id.btnGuard);

        btnGuard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbVendedor dbvendedor = new DbVendedor(Vendedors.this);
                long id = dbvendedor.insertarVendedor(txtnom.getText().toString(), txtcontra.getText().toString());
                if(id > 0){
                    Toast.makeText(Vendedors.this, "ESTE REGISTRO FUE GUARDADO", Toast.LENGTH_LONG).show();
                    limpiar();
                }else{
                    Toast.makeText(Vendedors.this, "ESTE REGISTRO NO FUE GUARDADO", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void limpiar(){
        txtnom.setText("");
        txtcontra.setText("");

    }
}