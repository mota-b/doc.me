package com.example.zexes.docme_mobile_client;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Card extends Activity{

    /**
     * Attributes
     */
    ArrayList<String> choises;
    String id;

    String[] questions = new String[]{"avez vous Une fièvre intense (autour de 37~39°C) ?",
                                        "avez vous Une Fatigue intense ?",
                                        "avez vous des maux au tète ?",
                                        "avez vous des courbatures ?",
                                        "avez vous Des frissons ?",
                                        "avez vous  une toux?",
                                        "avez vous  Le nez qui coule ?",
                                        "avez vous Une incapacité à se concentrer ?",
                                        "avez vous soif intense ?",
                                        "avez vous perte de poids involontaire ?",
                                        "avez vous De la nervosité, de l’irritabilité ?",
                                        "avez vous Des étourdissements, de la somnolence. ?",
                                        "avez vous Une pression au niveau du visage ?",
                                        "avez vous  des maux de dents ?"};

    TextView t1;
    TextView t2;

    Button valid;
    Button deny;


    /**
     * Life cycle
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        init();
    }

    /**
     * Methodes
     */

    // Initialise components
    public void init(){
        t1 = (TextView)  findViewById(R.id.t1_q);
        t2 = (TextView)  findViewById(R.id.t2_q);

        valid = (Button) findViewById(R.id.yes);
        deny = (Button) findViewById(R.id.no);

        valid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((Button)findViewById(v.getId())==valid)
                    next(true);
            }
        });
        deny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((Button)findViewById(v.getId())==deny)
                    next(false);
            }
        });

        choises = new ArrayList<>(getIntent().getStringArrayListExtra("choises"));
        id = getIntent().getStringExtra("id");


        t1.setText("Q"+id);
        t2.setText(questions[Integer.valueOf(id)-1]+"");


    }

    // Start next activity
    public void next(boolean v){

        if (v)
            choises.add("true");
        else
            choises.add("false");

        if (Integer.valueOf(id)!=questions.length){
            Intent card = new Intent(Card.this, Card.class);

            card.putStringArrayListExtra("choises",choises);
            card.putExtra("id",(Integer.valueOf(id)+1)+"");

            startActivity(card);
            if (v)
                overridePendingTransition(R.anim.l_r_enter,
                        R.anim.l_r_exit);
            else
                overridePendingTransition(R.anim.r_l_enter,
                        R.anim.r_l_exit);
        }
        else{
            Intent display = new Intent(Card.this, Display.class);
            display.putStringArrayListExtra("choises",choises);

            startActivity(display);

        }


    }
}
