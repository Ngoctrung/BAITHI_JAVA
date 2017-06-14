package com.ngoctrungpham2017.happy_birthday;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Webmini extends AppCompatActivity {

    EditText addressBar;
    Button btngo, btnduongdan;
    ImageView imgback,imgnext, imgreload;
    WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webmini);


        btngo =(Button)findViewById(R.id.buttongo);
        btnduongdan =(Button)findViewById(R.id.buttonduongdan);
        imgback = (ImageView)findViewById(R.id.imageViewback);
        imgnext = (ImageView)findViewById(R.id.imageViewnet);
        imgreload = (ImageView)findViewById(R.id.imageViewreload);

        addressBar =(EditText)findViewById(R.id.edittexturl);
        addressBar.setText("https://google.com.vn/");
        web =(WebView)findViewById(R.id.web);

        web.setWebViewClient(new MyWebViewClient(addressBar));

    btngo.setOnClickListener(new Button.OnClickListener() {
        @Override
            public void onClick(View view) {
                goUrl();
            }
        });

    btnduongdan.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                showStaticContent();
            }
        });

        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(web.canGoBack()){
                    web.goBack();
                    addressBar.setText(web.getUrl());
                    Toast.makeText(Webmini.this,"Trang trước",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Webmini.this,"Không có trang trước",Toast.LENGTH_SHORT).show();
                }
            }
        });

        imgnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(web.canGoForward()){
                    web.goForward();
                    addressBar.setText(web.getUrl());
                    Toast.makeText(Webmini.this,"Trang trước",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Webmini.this,"Không có trang trước",Toast.LENGTH_SHORT).show();
                }
            }
        });

        imgreload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                web.reload();
                addressBar.setText(web.getUrl());
            }
        });

    }

    private void goUrl() {
        String url = addressBar.getText().toString().trim();
        if(url.isEmpty()){
        Toast.makeText(this,"Please enter url",Toast.LENGTH_SHORT).show();
            return;
        }
        web.getSettings().setLoadsImagesAutomatically(true);
        web.getSettings().setJavaScriptEnabled(true);
        web.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        web.loadUrl(url);
        }


        private void showStaticContent() {
        String staticContent="<h2>Select web page</h2>"
        + "<ul><li><a href='http://eclipse.org'>Eclipse</a></li>"
        +"<li><a href='http://google.com'>Google</a></li></ul>";
    web.loadData(staticContent, "text/html", "UTF-8");
    }

}
