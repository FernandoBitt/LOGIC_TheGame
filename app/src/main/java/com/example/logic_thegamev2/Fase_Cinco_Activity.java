package com.example.logic_thegamev2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Fase_Cinco_Activity extends AppCompatActivity implements View.OnClickListener{

    private AlertDialog alerta;

    ImageView imageView3;
    SwitchCompat Switch3;
    ImageView imageView4;
    SwitchCompat Switch4;
    ImageView imageView5;
    SwitchCompat Switch5;
    ImageView imageView6;
    SwitchCompat Switch6;

    Button buttonValidar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fase_cinco);
        imageView3 = findViewById(R.id.lamp3);
        Switch3 = findViewById(R.id.btnlamp3);
        imageView4 = findViewById(R.id.lamp4);
        Switch4 = findViewById(R.id.btnlamp4);
        imageView5 = findViewById(R.id.lamp5);
        Switch5 = findViewById(R.id.btnlamp5);
        imageView6 = findViewById(R.id.lamp6);
        Switch6 = findViewById(R.id.btnlamp6);

        imageView3.setImageDrawable(getResources().getDrawable(R.drawable.lamp_off));
        imageView4.setImageDrawable(getResources().getDrawable(R.drawable.lamp_off));
        imageView5.setImageDrawable(getResources().getDrawable(R.drawable.lamp_off));
        imageView6.setImageDrawable(getResources().getDrawable(R.drawable.lamp_off));

        buttonValidar = findViewById(R.id.btnValidar5);

        buttonValidar.setOnClickListener(this);

        Switch3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (Switch3.isChecked()) {
                    imageView3.setImageDrawable(getResources().getDrawable(R.drawable.lamp_on));
                } else {
                    imageView3.setImageDrawable(getResources().getDrawable(R.drawable.lamp_off));
                }
            }
        });

        Switch4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (Switch4.isChecked()) {
                    imageView4.setImageDrawable(getResources().getDrawable(R.drawable.lamp_on));
                } else {
                    imageView4.setImageDrawable(getResources().getDrawable(R.drawable.lamp_off));
                }
            }
        });

        Switch5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (Switch5.isChecked()) {
                    imageView5.setImageDrawable(getResources().getDrawable(R.drawable.lamp_on));
                } else {
                    imageView5.setImageDrawable(getResources().getDrawable(R.drawable.lamp_off));
                }
            }
        });

        Switch6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (Switch6.isChecked()) {
                    imageView6.setImageDrawable(getResources().getDrawable(R.drawable.lamp_on));
                } else {
                    imageView6.setImageDrawable(getResources().getDrawable(R.drawable.lamp_off));
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnValidar5){
            if((Switch3.isChecked() || Switch4.isChecked()) ^
                    (Switch5.isChecked() && Switch6.isChecked())){
                        Intent intent = new Intent(this,MainActivity.class);
                        popUp(intent);
                    }else{
                        Toast.makeText(getApplicationContext(), "Resposta Errada\nTente Novamente",
                        Toast.LENGTH_SHORT).show();
                    }
            }
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