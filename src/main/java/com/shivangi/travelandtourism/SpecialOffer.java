package com.shivangi.travelandtourism;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SpecialOffer extends AppCompatActivity {

    Button btn_kolkata, btn_delhi, btn_mumbai,btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_offer);
        btn_kolkata=(Button)findViewById(R.id.btn_kolkata);
        btn_delhi=(Button)findViewById(R.id.btn_delhi);
        btn_mumbai=(Button)findViewById(R.id.btn_mumbai);
        btn_back=(Button)findViewById(R.id.btn_back);

        btn_kolkata.setOnClickListener(click_kolkata);
        btn_mumbai.setOnClickListener(click_mumbai);
        btn_delhi.setOnClickListener(click_delhi);
        btn_back.setOnClickListener(click_back);
    }

    View.OnClickListener click_kolkata= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent_start_activity = new Intent(getApplicationContext(), Payment.class);
            intent_start_activity.putExtra("value",20000);
            startActivity(intent_start_activity);
        }
    };
    View.OnClickListener click_mumbai= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent_start_activity = new Intent(getApplicationContext(), Payment.class);
            intent_start_activity.putExtra("value",20000);
            startActivity(intent_start_activity);
        }
    };

    View.OnClickListener click_delhi= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent_start_activity = new Intent(getApplicationContext(), Payment.class);
            intent_start_activity.putExtra("value",30000);
            startActivity(intent_start_activity);
        }
    };
    View.OnClickListener click_back= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent_start_activity = new Intent(getApplicationContext(), Menu.class);
            startActivity(intent_start_activity);
        }
    };

}
