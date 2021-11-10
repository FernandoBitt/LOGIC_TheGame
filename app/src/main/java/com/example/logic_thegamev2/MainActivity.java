package com.example.logic_thegamev2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private viewHolder mViewHolder = new viewHolder();

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
        if (v.getId() == R.id.btnSair){
            Intent intent = new Intent(this, SairActivity.class );
            startActivity(intent);
        }
    }

    private static class viewHolder {
        Button btnNovoJogo;
        Button btnContinuar;
        Button btnConfiguracoes;
        Button btnSair;


    }
}