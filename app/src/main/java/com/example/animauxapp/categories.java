package com.example.animauxapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class categories extends AppCompatActivity {
    ImageButton a3;
    ImageButton a4;
    ImageButton a5;
    ImageButton a6;
    ImageButton a7;
    ImageButton a8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        a3=(ImageButton)findViewById(R.id.a3);
        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),birds.class);
                startActivity(i);
            }
        });
    }
}