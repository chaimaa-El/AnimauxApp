package com.example.animauxapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class birds extends AppCompatActivity {

    GridView gridview1;
    MediaPlayer media;
    String[] birds={"Hoopoe","Kingfisher","Loon","Parrot","Nightingale","Peacock"};
    int[] audio = {
        R.raw.a4, R.raw.a2, R.raw.a3, R.raw.a4, R.raw.a5, R.raw.a6};
    int[] img={R.drawable.b1,R.drawable.b2,R.drawable.b3,R.drawable.b4,R.drawable.b5,R.drawable.b6};
    String[] desc={ "Hoopoes are colourful birds found across Africa, Asia, and Europe, notable for their distinctive 'crown' of feathers.",
            "Kingfishers are small unmistakable bright blue and orange birds of slow moving or still water. They fly rapidly, low over water, and hunt fish from riverside perches, occasionally hovering above the water's surface.",
            "Loons, which are the size of a big duck or a small goose, resemble these birds in shape when swimming. Like ducks and geese, but unlike coots (which are Rallidae) and grebes (Podicipedidae), the loon's toes are connected by webbing. The loons may be confused with the cormorants (Phalacrocoracidae), but can be distinguished from them by their distinct call.",
            "Parrots are not very heavy, in relation to their size, and compact body with a large head and a short neck. Their beaks are short, strong and curved. The two parts of the beak are very strong and used to break fruits and seeds.",
            "Nightingale, any of several small Old World thrushes, belonging to the family Turdidae (order Passeriformes), renowned for their song. The name refers in particular to the Eurasian nightingale (Erithacus, or Luscinia, megarhynchos), a brown bird, 16 centimetres (61/2 inches) long, with a rufous tail.",
            "The peacock is brightly coloured, with a predominantly blue fan-like crest of spatula-tipped wire-like feathers and is best known for the long train made up of elongated upper-tail covert feathers which bear colourful eyespots."};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birds);


        gridview1 = (GridView) findViewById(R.id.mainGridView1);
        GridAdapter gridAdapter=new GridAdapter(birds,img,desc,audio,this);
        gridview1.setAdapter(gridAdapter);
        gridview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedbird=birds[i];
                int selectedimg=img[i];
                String description=desc[i];
                int selectedaudio=audio[i];

                startActivity(new Intent(getApplicationContext(),birds_items.class).putExtra("bird",selectedbird).putExtra("img",selectedimg).putExtra("desc",description).putExtra("audio",audio));
                switch(i){
                    case 0:
                        media=MediaPlayer.create(getApplicationContext(),R.raw.a1);
                        media.start();
                        break;
                    case 1:
                        media=MediaPlayer.create(getApplicationContext(),R.raw.a2);
                        media.start();
                        break;
                    case 2:
                        media=MediaPlayer.create(getApplicationContext(),R.raw.a3);
                        media.start();
                        break;
                    case 3:
                        media=MediaPlayer.create(getApplicationContext(),R.raw.a4);
                        media.start();
                        break;
                    case 4:
                        media=MediaPlayer.create(getApplicationContext(),R.raw.a5);
                        media.start();
                        break;
                    case 5:
                        media=MediaPlayer.create(getApplicationContext(),R.raw.a6);
                        media.start();
                        break;

                }


            }


        });
    }

    public class GridAdapter extends BaseAdapter {
        private String[] imageNames;
        private int[] imagesPhoto;
        private String[] imagesdesc;
        private int[] imagesAudio;
        private Context context;
        private LayoutInflater layoutInflater;

        public GridAdapter(String[] imageNames,int[] imagesPhoto,String[] imagesdesc,int[] imagesAudio,Context context) {
            this.imageNames = imageNames;
            this.imagesPhoto = imagesPhoto;
            this.imagesdesc = imagesdesc;
            this.imagesAudio = imagesAudio;
            this.context = context;
            this.layoutInflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        }

        public int getCount() {
            return imagesPhoto.length;
        }
        public Object getItem(int position) {
            return null;
        }
        public long getItemId(int position) {
            return 0;
        }
        public View getView(int i, View view, ViewGroup viewGroup) {

            if (view == null) {
                view = layoutInflater.inflate(R.layout.listview_layout, viewGroup,false);
            }

            TextView txtview = (TextView) view.findViewById(R.id.listitemTextView1);
            ImageView imgview = (ImageView) view.findViewById(R.id.listitemImageView1);

            txtview.setText(imageNames[i]);
            imgview.setImageResource(imagesPhoto[i]);

            return view;
        }
    }

}





