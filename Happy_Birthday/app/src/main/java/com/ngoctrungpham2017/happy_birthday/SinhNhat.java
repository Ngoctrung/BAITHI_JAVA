package com.ngoctrungpham2017.happy_birthday;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class SinhNhat extends AppCompatActivity {


    RelativeLayout mh;
    MediaPlayer song;
    ImageView imgtam;


    public  void Anhxa()
    {
        mh = (RelativeLayout)findViewById(R.id.manhinh);
        imgtam = (ImageView)findViewById(R.id.imageViewtam);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinh_nhat);

        Anhxa();
        //background
        mh.setBackgroundResource(R.drawable.phuong);

        // nhacnen
         song = MediaPlayer.create(getApplicationContext(),R.raw.beethoven);
        song.start();

        // hieu ung hinh
       Animation f = AnimationUtils.loadAnimation(this,R.anim.fade);
        f.reset();
        imgtam.clearAnimation();
        imgtam.startAnimation(f);

        //-----------------
        imgtam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                song.stop();
                startActivity(new Intent(SinhNhat.this, Music.class));

            }
        });

        mh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                song.stop();
                startActivity(new Intent(SinhNhat.this, MainActivity.class));
            }
        });


    }
}
