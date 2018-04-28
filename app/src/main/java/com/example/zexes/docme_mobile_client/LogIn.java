package com.example.zexes.docme_mobile_client;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LogIn extends Activity {

    /**
     * Attributes
     */
    EditText userId_input;
    EditText password_input;
    Button login;

    OkHttpClient client ;

    public String postBody;
    public String url;


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
                try {
                    authentificate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
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
        //presentation.putExtra();
        startActivity(presentation);
        this.finish();
    }

    // Authentification
    private void authentificate() throws Exception {



        client = new OkHttpClient();
        url= "http://0e37153b.ngrok.io";


        JSONObject json = new JSONObject();
        json.put("id", userId_input.getText().toString() );
        json.put("password", password_input.getText().toString());

        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, json.toString());
        Request request = new Request.Builder()
                .header("X-Client-Type", "Android")
                .url(url)
                .post(body)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                call.cancel();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                final String myResponse = response.body().string();

                LogIn.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        JSONObject jSonres = null;
                        try {
                            jSonres = new JSONObject(myResponse);

                            //Toast.makeText(getApplicationContext(), jSonres.getString("user"), Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });

            }
        });
    }

}
