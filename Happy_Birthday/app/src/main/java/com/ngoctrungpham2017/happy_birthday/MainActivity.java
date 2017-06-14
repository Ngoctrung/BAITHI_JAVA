package com.ngoctrungpham2017.happy_birthday;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {


    RelativeLayout mh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mh = (RelativeLayout)findViewById(R.id.manhinh);
        mh.setBackgroundResource(R.drawable.hong);

        Button btnsinhnhat = (Button) findViewById(R.id.buttonsinhnhat);
        btnsinhnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SinhNhat.class));
            }
        });

        Button btnweb = (Button) findViewById(R.id.buttonweb);
        btnweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Webmini.class));
            }
        });

    }
}
