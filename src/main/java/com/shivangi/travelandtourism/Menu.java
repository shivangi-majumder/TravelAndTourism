package com.shivangi.travelandtourism;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Menu extends AppCompatActivity {
    Button btn_back;
    ImageButton btn_cities,btn_feedback,btn_package,btn_bookings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btn_cities=(ImageButton)findViewById(R.id.btn_c1);
        btn_bookings=(ImageButton)findViewById(R.id.btn_bookings);
        btn_package=(ImageButton)findViewById(R.id.btn_package);
        btn_feedback=(ImageButton)findViewById(R.id.btn_feedback);
        btn_back= (Button)findViewById(R.id.btn_back);
        btn_back.setOnClickListener(click);
        btn_cities.setOnClickListener(click_cities);
        btn_bookings.setOnClickListener(click_book);
        btn_feedback.setOnClickListener(click_feed);
        btn_package.setOnClickListener(click_pack);
    }
   View.OnClickListener click_cities=new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           Intent intent_start_activity = new Intent(getApplicationContext(), CityList.class);
           startActivity(intent_start_activity);
          // intent_start_activity = new Intent(getApplicationContext(), CityList.class);

       }
   };
    View.OnClickListener click_pack=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent_start_activity = new Intent(getApplicationContext(), SpecialOffer.class);
            startActivity(intent_start_activity);
            // intent_start_activity = new Intent(getApplicationContext(), CityList.class);

        }
    };
    View.OnClickListener click= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent_start_activity = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent_start_activity);
           // intent_start_activity = new Intent(getApplicationContext(), MainActivity.class);
        }
    };
    View.OnClickListener click_book=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent_start_activity = new Intent(getApplicationContext(), Booking.class);
            startActivity(intent_start_activity);

        }
    };
    View.OnClickListener click_feed=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent_start_activity = new Intent(getApplicationContext(), feedback.class);
            startActivity(intent_start_activity);
           // intent_start_activity = new Intent(getApplicationContext(), feedback.class);

        }
    };
}
