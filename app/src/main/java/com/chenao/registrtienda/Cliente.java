package com.chenao.registrtienda;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.chenao.registrtienda.db.DbCliente;
import com.chenao.registrtienda.db.DbUsuarios;

public class Cliente extends AppCompatActivity {

    EditText txtnom, txtapellido, txtemail, txttelefono;
    Button btnGuard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);

        txtnom= findViewById(R.id.txtnom);
        txtapellido= findViewById(R.id.txtapellido);
        txtemail= findViewById(R.id.txtemail);
        txttelefono= findViewById(R.id.txttelefono);
        btnGuard = findViewById(R.id.btnGuard);

        btnGuard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbCliente dbcliente = new DbCliente(Cliente.this);
                long id = dbcliente.insertarCliente(txtnom.getText().toString(), txtapellido.getText().toString(), txtemail.getText().toString(), txttelefono.getText().toString());
                if(id > 0){
                    Toast.makeText(Cliente.this, "ESTE REGISTRO FUE GUARDADO", Toast.LENGTH_LONG).show();
                    limpiar();
                }else{
                    Toast.makeText(Cliente.this, "ESTE REGISTRO NO FUE GUARDADO", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
    private void limpiar(){
        txtnom.setText("");
        txtapellido.setText("");
        txtemail.setText("");
        txttelefono.setText("");

    }
}