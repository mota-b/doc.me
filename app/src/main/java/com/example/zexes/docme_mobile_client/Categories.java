package com.example.zexes.docme_mobile_client;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class Categories extends Activity implements View.OnClickListener{

    /**
     * Attributes
     */
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;
    Button b7;
    Button urgence;


    /**
     * Life cycle
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        init();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    /**
     * Methodes
     */

    // Initialise components
    public void init(){
        b1 =(Button) findViewById(R.id.b1);
        b2 =(Button) findViewById(R.id.b2);
        b3 =(Button) findViewById(R.id.b3);
        b4 =(Button) findViewById(R.id.b4);
        b5 =(Button) findViewById(R.id.b5);
        b6 =(Button) findViewById(R.id.b6);
        b7 =(Button) findViewById(R.id.b7);
        urgence =(Button) findViewById(R.id.urg);


        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        urgence.setOnClickListener(this);




    }

    // Start next activity
    public void next(View v){
        Intent card = new Intent(Categories.this, Card.class);
        card.putExtra("cat",v.getId());
        card.putStringArrayListExtra("choises",new ArrayList<String>());
        card.putExtra("id",1+"");

        startActivity(card);
    }


    @Override
    public void onClick(View v) {
        //Toast.makeText(getApplicationContext(), ((Button) findViewById(v.getId())).getText(), Toast.LENGTH_SHORT).show();
        next(v);
    }
}
