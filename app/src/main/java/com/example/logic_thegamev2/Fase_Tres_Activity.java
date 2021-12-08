package com.example.logic_thegamev2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Fase_Tres_Activity extends AppCompatActivity implements View.OnClickListener{

    private viewHolder mViewHolder = new viewHolder();

    private AlertDialog alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fase_tres);

        this.mViewHolder.editTextResposta = findViewById(R.id.editResposta3);
        this.mViewHolder.buttonValidar = findViewById(R.id.btnValidar3);

        this.mViewHolder.buttonValidar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnValidar3){
            Editable resposta = mViewHolder.editTextResposta.getText();
            if(resposta.toString().equals("10010")){
                Intent intent = new Intent(this,Fase_Quatro_Activity.class);
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