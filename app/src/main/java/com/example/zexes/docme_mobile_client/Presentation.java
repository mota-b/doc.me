package com.example.zexes.docme_mobile_client;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class Presentation extends Activity {

    /**
     * Attributes
     */
    TextView t1;
    TextView t2;
    TextView t3;


    /**
     * Life cycle
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentation);

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
        t1 = (TextView) this.findViewById(R.id.t1);
        t2 = (TextView) this.findViewById(R.id.t2);
        t3 = (TextView) this.findViewById(R.id.t3);

        Animator.AnimatorListener a1= new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                t1.setVisibility(View.VISIBLE);
            }
        };
        Animator.AnimatorListener a2= new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                t1.setVisibility(View.VISIBLE);
            }
        };
        Animator.AnimatorListener a3= new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                t1.setVisibility(View.VISIBLE);
            }
        };

        t1.animate()
                .alpha(0f)
                .setDuration(1000)
                .setListener(a1);
        t2.animate()
                .alpha(0f)
                .setDuration(2000)
                .setListener(a2);
        t3.animate()
                .alpha(0f)
                .setDuration(3000)
                .setListener(a3);

        next();
        //TODO: add Animation to the splash screen

    }

    // Start next activity
    public void next(){
        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start next activity

                Intent i = new Intent(Presentation.this, Categories.class);

                startActivity(i);
                overridePendingTransition(R.anim.r_l_enter,
                        R.anim.r_l_exit);

                // close this activity
                finish();
            }
        }, 3000);
    }


}
