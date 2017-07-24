package com.example.alvin.w2_d1_ex01;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.Image;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_IMAGE_CAPTURE = 1;
    public static final String DETAIL_EXTRA = "com.example.alvin.w2_d1_ex01.DETAIL_EXTRA";
    ImageView mainImage;
    EditText firstName;
    EditText lastName;
    Bitmap imageBitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainImage = (ImageView) findViewById(R.id.topImage);
        firstName = (EditText) findViewById(R.id.firstName);
        lastName = (EditText) findViewById(R.id.lastName);

    }

    public void goToCamera(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            imageBitmap = (Bitmap) extras.get("data");
            mainImage.setImageBitmap(imageBitmap);
        }
    }

    public void goToDetails(View view) {
        String firstNameValue = firstName.getText().toString();
        String lastNameValue = lastName.getText().toString();
        Picture pic = new Picture(firstNameValue, lastNameValue, imageBitmap);
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra(DETAIL_EXTRA, pic);
        startActivity(intent);
    }
}
