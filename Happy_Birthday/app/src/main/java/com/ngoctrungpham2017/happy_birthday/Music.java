package com.ngoctrungpham2017.happy_birthday;

import android.content.Intent;
import android.media.MediaPlayer;
import android.nfc.tech.MifareUltralight;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Music extends AppCompatActivity {

    TextView txtloinhan;
    Button btndunng, btntiep;
    ListView lvbaihat;
    RelativeLayout mh;
    MediaPlayer song;

    ArrayList<String> mangTenBH, mangLoiNhan;
    ArrayList<Integer> mangMp3;

    public void AnhXa()
    {
        txtloinhan =(TextView)findViewById(R.id.textviewloinhan);
        btndunng = (Button)findViewById(R.id.buttondung);
        lvbaihat = (ListView)findViewById(R.id.listviewnhac);
        mh = (RelativeLayout)findViewById(R.id.mannhinhnhac);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        //anh xa

        AnhXa();

        //hinh nen

            mh.setBackgroundResource(R.drawable.da);

        //play nhac nen

        song = MediaPlayer.create(getApplicationContext(),R.raw.khuchatmungsinhnhat);
        song.start();


        //loi nhan

        txtloinhan.setText("chuc mung sinh nhat");
        Taoanimation();

        //tao mang
         TaoMang();

        //Listview
        ArrayAdapter adapter = new ArrayAdapter(
          getApplicationContext(),android.R.layout.simple_list_item_1,mangTenBH
        );
        lvbaihat.setAdapter(adapter);

        //Listview onclick

        lvbaihat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                song.stop();
                song = MediaPlayer.create(getApplicationContext(),mangMp3.get(position));
                song.start();


                txtloinhan.setText(mangLoiNhan.get(position));
                Taoanimation();
            }
        });

        //dung nhac
       btndunng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                song.stop();
            }
        });


        // quay lai

        txtloinhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                song.stop();
                startActivity(new Intent(Music.this, SinhNhat.class));
            }
        });






    }

    public void Taoanimation(){
        Animation z = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom);
        z.reset();
        txtloinhan.clearAnimation();
        txtloinhan.startAnimation(z);
    }




    public void TaoMang()
    {
        mangTenBH = new ArrayList<String>();
        mangLoiNhan = new ArrayList<String>();
        mangMp3 = new ArrayList<Integer>();


        mangMp3.add(R.raw.anhthegioivaem);
        mangTenBH.add("Anh thế giới và em");
        mangLoiNhan.add("Sẽ có người yêu em hơn anh \n" +
                "Anh đã nói vậy ngày chia tay đứng chết lặng trông theo bóng dáng cứ xa dần \n" +
                "Đã lâu rồi trong em vẫn thế vẫn chưa phai chuyện cũ và anh \n" +
                "Giống như chỉ hôm qua đây thôi nỗi đau vẫn còn \n" +
                "Em muốn được quên muốn bên người mới ");

        mangMp3.add(R.raw.choemgananhthemchutnua);
        mangTenBH.add("Cho em gần anh thêm chút nữa");
        mangLoiNhan.add("Một chút nhớ anh đấy \n" +
                "Một chút mơ chưa đầy \n" +
                "Một chút thương anh mà xa như khói mây \n" +
                "Một chút ít hơi ấm \n" +
                "Một chút thương âm thầm \n" +
                "Một chút yêu thôi nằm sâu như sóng ngầm \n");

        mangMp3.add(R.raw.dieuanhbiet);
        mangTenBH.add("Điều anh biết");
        mangLoiNhan.add("Anh không biết bao nhiêu sao trên trời \n" +
                "Anh không biết cuộc đời mai ra sao \n" +
                "Dù gian lao dù ra sao thì anh vẫn luôn có \n" +
                "Có một người luôn bên cạnh anh mãi thôi \n" +
                "Anh không biết yêu em sao cho vừa \n");

        mangMp3.add(R.raw.emlacuaanh);
        mangTenBH.add("Em là của anh");
        mangLoiNhan.add("Có thấy bóng dáng ai nơi đây \n" +
                "Cho đam mê trong anh lại đầy \n" +
                "Nghe yêu thương cứ rót bên tai \n" +
                "Là ánh mắt này làm anh say \n" +
                "Hết bước đến bên nói em nghe \n");


        mangMp3.add(R.raw.ghen);
        mangTenBH.add("Ghen");
        mangLoiNhan.add("2 giờ sáng, anh gọi em không nhấc máy \n" +
                "Không một tin nhắn từ tối qua \n" +
                "Không hề biết em ngủ chưa hay vẫn thức \n" +
                "Hay đang ở một nơi rất xa \n");

        mangMp3.add(R.raw.khuchatmungsinhnhat);
        mangTenBH.add("Khúc hát mừng sinh nhật");
        mangLoiNhan.add("Chức mừng sinh nhật .........");

        mangMp3.add(R.raw.lacnhaucophaimuondoi);
        mangTenBH.add("Lạc nhau có phải muôn đời");
        mangLoiNhan.add("Thế giới bé thế nào \n" +
                "Mình gặp nhau có phải muôn đời \n" +
                "Ngày mà người mang đến một khúc hát không thể quên \n" +
                "Bài hát với những mơ mộng \n" +
                "Bài hát với những hy vọng");

        mangMp3.add(R.raw.yeulathathu);
        mangTenBH.add("Yêu là tha thứ");
        mangLoiNhan.add("Trong kí ức anh khi ấy \n" +
                "Lần đầu gặp gỡ làm tim nhớ nhung \n" +
                "Rồi từng ngày trôi qua \n" +
                "Trong thâm tâm bỗng chốc nhận ra ấm áp tràn về mỗi lúc \n" +
                "Khi em đến ngày hôm ấy \n" +
                "Một người đang đứng gần ngay kế bên vội cầm bàn tay em");


    }





}
