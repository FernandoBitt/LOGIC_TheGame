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

public class Fase_Quatro_Activity extends AppCompatActivity implements View.OnClickListener{

    private AlertDialog alerta;

    ImageView imageView1;
    SwitchCompat Switch1;
    ImageView imageView2;
    SwitchCompat Switch2;

    Button buttonValidar4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fase_quatro);
        imageView1 = findViewById(R.id.lamp1);
        Switch1 = findViewById(R.id.btnlamp1);
        imageView2 = findViewById(R.id.lamp2);
        Switch2 = findViewById(R.id.btnlamp2);

        imageView1.setImageDrawable(getResources().getDrawable(R.drawable.lamp_off));
        imageView2.setImageDrawable(getResources().getDrawable(R.drawable.lamp_off));

        buttonValidar4 = findViewById(R.id.btnValidar4);

        buttonValidar4.setOnClickListener(this);


        Switch1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (Switch1.isChecked()) {
                    imageView1.setImageDrawable(getResources().getDrawable(R.drawable.lamp_on));
                } else {
                    imageView1.setImageDrawable(getResources().getDrawable(R.drawable.lamp_off));
                }
            }
        });

        Switch2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (Switch2.isChecked()) {
                    imageView2.setImageDrawable(getResources().getDrawable(R.drawable.lamp_on));
                } else {
                    imageView2.setImageDrawable(getResources().getDrawable(R.drawable.lamp_off));
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnValidar4){
            if(Switch1.isChecked() && Switch2.isChecked()){
                Intent intent = new Intent(this,Fase_Cinco_Activity.class);
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