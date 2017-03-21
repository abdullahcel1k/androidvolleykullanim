package com.example.abdullah.volleyarrayobject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by abdullah on 3/20/17.
 */

public class ParseJSONArrayObject extends AppCompatActivity {
    private final String EXTRA_JSON_OBJECT = "mobileObject";
    TextView greetingTextView;
    Yarsimaci yarsimaci;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        yarsimaci = (Yarsimaci) getIntent().getSerializableExtra("dataposition");
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        Picasso.with(this).load(yarsimaci.getYarismaciImageUrl()).into(imageView);

    }
}
