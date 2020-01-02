package com.aprizal.submission;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.aprizal.submission.from.Wisata;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static com.aprizal.submission.MainActivity.EXTRA_IMAGE;
import static com.aprizal.submission.MainActivity.EXTRA_TEXT_DETAIL;
import static com.aprizal.submission.MainActivity.EXTRA_TEXT_NAME;

public class Main2Activity extends AppCompatActivity {

    public ArrayList<Wisata> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        if (getSupportActionBar()!=null){
            getSupportActionBar().setTitle(getIntent().getStringExtra(EXTRA_TEXT_NAME));
        }


        Intent intent = getIntent();
        String imgPhoto = intent.getStringExtra(EXTRA_IMAGE);
        String tvName = intent.getStringExtra(EXTRA_TEXT_NAME);
        String tvDetail = intent.getStringExtra(EXTRA_TEXT_DETAIL);

        ImageView imageView = findViewById(R.id.img_item_photo);
        TextView textView = findViewById(R.id.tv_item_name);
        TextView textView1 = findViewById(R.id.tv_item_detail);

        Glide.with(this).load(imgPhoto).into(imageView);
        textView.setText(tvName);
        textView1.setText(tvDetail);


    }
}
