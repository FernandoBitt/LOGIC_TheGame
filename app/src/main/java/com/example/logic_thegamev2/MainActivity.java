package com.example.logic_thegamev2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private viewHolder mViewHolder = new viewHolder();

    public MediaPlayer mp = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.btnNovoJogo = findViewById(R.id.btnNovoJogo);
        this.mViewHolder.btnContinuar = findViewById(R.id.btnContinuar);
        this.mViewHolder.btnConfiguracoes = findViewById(R.id.btnConfiguracoes);
        this.mViewHolder.btnSair = findViewById(R.id.btnSair);

        this.mViewHolder.btnNovoJogo.setOnClickListener(this);
        this.mViewHolder.btnContinuar.setOnClickListener(this);
        this.mViewHolder.btnConfiguracoes.setOnClickListener(this);
        this.mViewHolder.btnSair.setOnClickListener(this);

        this.mp = MediaPlayer.create(this, R.raw.mainmusic);
        this.mp.setLooping(true);
        this.mp.start();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnNovoJogo){
            Intent intent = new Intent(this, NovoJogoActivity.class );
            startActivity(intent);
        }
        if (v.getId() == R.id.btnContinuar){
            Intent intent = new Intent(this, ContinuarActivity.class );
            startActivity(intent);
        }
        if (v.getId() == R.id.btnConfiguracoes){
            Intent intent = new Intent(this, ConfiguracoesActivity.class );
            startActivity(intent);
        }
        if (v.getId() == R.id.btnSair){
            exibirConfirmação();
        }
    }

    private static class viewHolder {
        Button btnNovoJogo;
        Button btnContinuar;
        Button btnConfiguracoes;
        Button btnSair;

    }

    public void exibirConfirmação(){
        AlertDialog.Builder msgBox = new AlertDialog.Builder(this);
        msgBox.setTitle("saindo");
        msgBox.setMessage("Tem certeza que deseja sair?");
        msgBox.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mp.stop();
                finishAffinity();
            }
        });
        msgBox.setNegativeButton("Voltar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        msgBox.show();
    }
}