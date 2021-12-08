package com.example.logic_thegamev2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class ContinuarActivity extends AppCompatActivity implements View.OnClickListener{

    private viewHolder mViewHolder = new viewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continuar);

        this.mViewHolder.buttonContinuar=findViewById(R.id.btnContinue);
        this.mViewHolder.spinnerApelido=findViewById(R.id.SelectNome);



        this.mViewHolder.buttonContinuar.setOnClickListener(this);


        try {
            popularSpinner();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void popularSpinner() throws IOException {

        FileInputStream fis = openFileInput("db_logic");
        List<String> spinnerArray =  new ArrayList<String>();

        Scanner scanner = new Scanner(fis);
        scanner.useDelimiter("\n");
        while (scanner.hasNext()) {

             String content = scanner.next();
             spinnerArray.add(content);

        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) findViewById(R.id.SelectNome);
        sItems.setAdapter(adapter);

        scanner.close();
    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnContinue){
            Intent intent = new Intent(this, MundoActivity.class);
            startActivity(intent);
        }
    }

    private static class viewHolder{
        Spinner spinnerApelido;
        Button buttonContinuar;
    }
}