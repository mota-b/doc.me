package com.example.zexes.docme_mobile_client;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LogIn extends Activity {

    /**
     * Attributes
     */
    EditText userId_input;
    EditText password_input;
    Button login;


    /**
     * Life cycle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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
        userId_input = (EditText) findViewById(R.id.userId_input);
        password_input = (EditText) findViewById(R.id.password_input);
        login = (Button) findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: autentificate && return user Object
                if(true)
                    next();
                else
                    {}//TODO: notify error
            }
        });
    }

    // Start next activity
    public void next(){
        Intent presentation = new Intent(this, Presentation.class);
        //TODO: pass the User object throught the intent
        startActivity(presentation);
        this.finish();
    }
}
