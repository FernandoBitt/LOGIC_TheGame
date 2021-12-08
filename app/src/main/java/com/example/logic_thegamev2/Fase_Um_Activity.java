package com.example.logic_thegamev2;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Fase_Um_Activity extends AppCompatActivity implements View.OnClickListener {

    private viewHolder mViewHolder = new viewHolder();

    private AlertDialog alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fase_um);

        this.mViewHolder.editTextResposta = findViewById(R.id.editResposta);
        this.mViewHolder.buttonValidar = findViewById(R.id.btnValidar);

        this.mViewHolder.buttonValidar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnValidar){
            Editable resposta = mViewHolder.editTextResposta.getText();
            if(resposta.toString().equals("111")){
                Intent intent = new Intent(this,Fase_Dois_Activity.class);
                popUp(intent);
            }else{
                Toast.makeText(getApplicationContext(), "Resposta Errada\nTente Novamente",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }



    private static class viewHolder{
        EditText editTextResposta;
        Button buttonValidar;
    }

    public void popUp(Intent intent){
        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(this);
        builder.setTitle("CORRETO");
        builder.setMessage("Deseja Seguir para Próxima Fase?");
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(intent);
            }
        });
        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alerta = builder.create();
        alerta.show();
    }


}