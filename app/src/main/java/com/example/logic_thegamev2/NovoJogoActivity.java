package com.example.logic_thegamev2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class NovoJogoActivity extends AppCompatActivity implements View.OnClickListener{

    private viewHolder mViewHolder = new viewHolder();

    Jogador jogador = new Jogador();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_jogo2);

        this.mViewHolder.textNome = findViewById(R.id.txtNome);
        this.mViewHolder.buttonComecar = findViewById(R.id.btnComecar);


        this.mViewHolder.buttonComecar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnComecar){
            salvarApelido();
            Intent intent = new Intent(this, MundoActivity.class);
            startActivity(intent);
        }
    }

    public void salvarApelido(){
        jogador.apelido =this.mViewHolder.textNome.getText().toString();
        String fileName = "db_logic";

        String separator = System.getProperty("line.separator");

        FileOutputStream outputStream = null;
        try {
            FileOutputStream fos = openFileOutput(fileName, Context.MODE_APPEND);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fos);
            outputStreamWriter.write(jogador.apelido);
            outputStreamWriter.append(separator);
            outputStreamWriter.close();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private static class viewHolder{
        EditText textNome;
        Button buttonComecar;
    }


}