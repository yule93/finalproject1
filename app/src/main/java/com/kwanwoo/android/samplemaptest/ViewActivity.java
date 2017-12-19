package com.kwanwoo.android.samplemaptest;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by HOME on 2017-12-19.
 */

public class ViewActivity extends AppCompatActivity {
    private int img;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        Intent intent = getIntent();

        ImageView profile = (ImageView)findViewById(R.id.viewimage);
        TextView name = (TextView)findViewById(R.id.viewname);
        TextView place = (TextView)findViewById(R.id.viewplace);
        TextView number = (TextView)findViewById(R.id.viewnumber);

        img = Integer.parseInt(intent.getStringExtra("image"));
        profile.setImageResource(img);
        name.setText(intent.getStringExtra("name"));
        place.setText(intent.getStringExtra("place"));
        number.setText(intent.getStringExtra("phoneNumber"));
    }
}
