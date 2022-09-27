package com.example.animauxapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class birds_items extends AppCompatActivity {
    TextView textView;
    TextView textView2;
    ImageView imageView;
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birds_items);

        textView=(TextView) findViewById(R.id.listitemTextView1);
        textView2=(TextView) findViewById(R.id.TextView);
        imageView=(ImageView) findViewById(R.id.listitemImageView1);
        imageButton=(ImageButton) findViewById(R.id.imageButton2);
        Intent intent=getIntent();
        if(intent.getExtras() !=null){
            String selectedbird=intent.getStringExtra("bird");
            String description=intent.getStringExtra("desc");
            int selectedimg= intent.getIntExtra("img",0);
            int selectedaudio= intent.getIntExtra("audio",0);

            textView.setText(selectedbird);
            textView2.setText(description);
            imageView.setImageResource(selectedimg);
            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    MediaPlayer media=new MediaPlayer();
                    media.setAudioSessionId(selectedaudio);
                    media.start();
                    Intent i=new Intent(getApplicationContext(),birds.class);
                    startActivity(i);


                }
            });

        }

    }
}