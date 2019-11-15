package com.example.basededatosconsqlite_act;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.renderscript.Short3;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etC, etD,etP;
    private Button btnR;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etC=(EditText)findViewById(R.id.etC);
        etD=(EditText)findViewById(R.id.etD);
        etP=(EditText)findViewById(R.id.etP);
        btnR=(Button) findViewById(R.id.btnR);
    }

    private void Registrar (View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);

        SQLiteDatabase BaseDeDatos = admin.getReadableDatabase();

        String codigo = etC.getText().toString();
        String desc = etD.getText().toString();
        String valor = etP.getText().toString();

        if (!codigo.isEmpty()&&!desc.isEmpty()&&!valor.isEmpty()){
            ContentValues registro = new ContentValues();

            registro.put("codigo", codigo);
            registro.put("desc", desc);
            registro.put("valor", valor);

            BaseDeDatos.insert("articulos", null, registro);

            BaseDeDatos.close();

            etC.setText("");
            etD.setText("");
            etP.setText("");

            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this, "No pueden haber campos vacios", Toast.LENGTH_SHORT).show();
        }
    }
}
