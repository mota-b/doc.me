package com.example.zexes.docme_mobile_client;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class Display extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        ArrayList<String> choises = getIntent().getStringArrayListExtra("choises");

    }

    public void next(View v){
        Intent detail = new Intent(Display.this, Detail.class);
        startActivity(detail);
    }
}
