package com.example.snehareddy.simple;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2 extends AppCompatActivity {
private static Button bmessage,bimage,bvideo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        onClickButtonListener();
    }
    public void onClickButtonListener(){
        bmessage=(Button)findViewById(R.id.button2);
        bimage=(Button)findViewById(R.id.button3);
        bvideo=(Button)findViewById(R.id.button4);
        bmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent("com.example.snehareddy.simple.Message");
                startActivity(i1);
            }
        });
        bimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent("com.example.snehareddy.simple.Image");
                startActivity(i2);
            }
        });
        bvideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3=new Intent("com.example.snehareddy.simple.Video");
                startActivity(i3);
            }
        });
    }
}
