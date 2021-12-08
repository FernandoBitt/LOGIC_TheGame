package com.example.logic_thegamev2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MundoActivity extends AppCompatActivity implements View.OnClickListener {

    private viewHolder mViewHolder = new viewHolder();
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mundo);

        this.mViewHolder.buttonFase1 = findViewById(R.id.btnFase1);
        this.mViewHolder.buttonFase2 = findViewById(R.id.btnFase2);
        this.mViewHolder.buttonFase3 = findViewById(R.id.btnFase3);
        this.mViewHolder.buttonFase4 = findViewById(R.id.btnFase4);
        this.mViewHolder.buttonFase5 = findViewById(R.id.btnFase5);
        this.mViewHolder.buttonVoltar = findViewById(R.id.btnVoltar);

        this.mViewHolder.buttonFase1.setOnClickListener(this);
        this.mViewHolder.buttonFase2.setOnClickListener(this);
        this.mViewHolder.buttonFase3.setOnClickListener(this);
        this.mViewHolder.buttonFase4.setOnClickListener(this);
        this.mViewHolder.buttonFase5.setOnClickListener(this);
        this.mViewHolder.buttonVoltar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnFase1) {
            intent = new Intent(this, Fase_Um_Activity.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.btnFase2) {
            intent = new Intent(this, Fase_Dois_Activity.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.btnFase3) {
            intent = new Intent(this, Fase_Tres_Activity.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.btnFase4) {
            intent = new Intent(this, Fase_Quatro_Activity.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.btnFase5) {
            intent = new Intent(this, Fase_Cinco_Activity.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.btnVoltar) {
            intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    private static class viewHolder {
        Button buttonFase1;
        Button buttonFase2;
        Button buttonFase3;
        Button buttonFase4;
        Button buttonFase5;
        Button buttonVoltar;
    }
}