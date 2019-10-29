package com.example.mynews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn1;
    Button btn2;
    Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.button);
        btn1.setOnClickListener(this);
        btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(this);
        btn3 = (Button) findViewById(R.id.button3);
        btn3.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.button:
                Intent intent = new Intent(this,ActyvityTwo.class);
                startActivity(intent);
                break;
            case R.id.button2:

                RelativeLayout bgElement = (RelativeLayout) findViewById(R.id.lay1);
                //if
                bgElement.setBackgroundColor(Color.DKGRAY);
                break;

            case  R.id.button3:
                finish();
                System.exit(0);

            default:
                break;
        }


        }
    }


