package com.example.shspk.fly;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.content.Intent;

import static com.baidu.location.d.j.v;

public class JingyuanActivity extends AppCompatActivity
{
    private CardView cardView=null;
    private final int REQUEST_CODE=1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jingyuan);
        cardView=(CardView)findViewById(R.id.jingyuan);

       cardView.setOnClickListener(new View.OnClickListener()
       {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(JingyuanActivity.this,JingyuanshowActivity.class);
                JingyuanActivity.this.startActivity(intent);
                //finish();

            }
        });


    }


}



