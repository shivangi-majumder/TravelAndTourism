package com.shivangi.travelandtourism;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Booking extends AppCompatActivity {

    Button btn_back,btn_show;
    TextView txt_bb,txt_b1;
    String bb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        btn_back=(Button)findViewById(R.id.btn_back);
        btn_show=(Button)findViewById(R.id.btn_show);
        btn_back.setOnClickListener(click_back);
        btn_show.setOnClickListener(click_show);
        txt_bb=(TextView)findViewById(R.id.txt_bb);
    }

    View.OnClickListener click_back= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent_start_activity = new Intent(getApplicationContext(), Menu.class);
            startActivity(intent_start_activity);
        }
    };
    View.OnClickListener click_show= new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            try {
                Toast.makeText(getApplicationContext(), "Analysing", Toast.LENGTH_SHORT).show();
                MyDb1 db = new MyDb1(getApplicationContext());


                ArrayList<Book> data = db.GetOrders();
               // Toast.makeText(getApplicationContext(), "hello", Toast.LENGTH_SHORT).show();

                for (int i = 0; i < data.size(); i++) {
                    Book o = data.get(i);
                    int c=i+1;
                    Toast.makeText(getApplicationContext(),c+")You have booked  "+o.NoP+ " Rooms. " , Toast.LENGTH_SHORT).show();
                }


            } catch (Exception e) {
                Toast.makeText(getApplication(), e.getMessage(), Toast.LENGTH_LONG).show();
            }

        }
    };

}
