package com.shivangi.travelandtourism;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Payment extends AppCompatActivity {


    Button btn_back,btn_submit;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        btn_submit=(Button)findViewById(R.id.btn_submit);
        btn_back=(Button)findViewById(R.id.btn_back);
        tv1=(TextView)findViewById(R.id.tv1);
        Intent intent = getIntent();


        btn_submit.setOnClickListener(click);
        btn_back.setOnClickListener(click_bck);
        if(null!=intent)
        {
            int sum =getIntent().getIntExtra("value",0);
            tv1.setText("Amount Payable:"+sum);
        }
        //String s=intent.getStringExtra("amount");
       // tv1.setText("Amount Payable"+sum);
        //btn_back.setOnClickListener(click_back);


    }

    View.OnClickListener click=new View.OnClickListener() {
        @Override
        public void onClick(View v)
        {
            Toast.makeText(getApplicationContext(),"THANKS FOR THE PAYMENT",Toast.LENGTH_SHORT).show();
            Intent intent_start_activity = new Intent(getApplicationContext(), thanks.class);
            startActivity(intent_start_activity);


        }
    };

    View.OnClickListener click_bck=new View.OnClickListener() {
        @Override
        public void onClick(View v)
        {
            Intent intent_start_activity = new Intent(getApplicationContext(), Selection.class);
            startActivity(intent_start_activity);


        }
    };


    /*View.OnClickListener click_back=new View.OnClickListener() {
        @Override
        public void onClick(View v)
        {
            Intent intent_start_activity = new Intent(getApplicationContext(), CityDetails.class);
            startActivity(intent_start_activity);
        }
    };*/
}
