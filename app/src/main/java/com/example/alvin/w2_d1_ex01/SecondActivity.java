package com.example.alvin.w2_d1_ex01;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    ImageView detailImage;
    TextView detailFirstName;
    TextView detailLastName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        detailImage = (ImageView) findViewById(R.id.iv_detailImage);
        detailFirstName = (TextView) findViewById(R.id.tv_detail_firstName);
        detailLastName = (TextView) findViewById(R.id.tv_detail_lastName);

        Intent intent = getIntent();
        if(intent != null) {
            Picture pic = intent.getParcelableExtra(MainActivity.DETAIL_EXTRA);
            Bitmap newImage = Bitmap.createScaledBitmap(
                    pic.getImage(), 500, 500, false);
            detailImage.setImageBitmap(newImage);
            detailFirstName.setText(pic.getFirstName());
            detailLastName.setText(pic.getLastName());
        }
    }
}
