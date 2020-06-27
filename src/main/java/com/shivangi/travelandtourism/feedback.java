package com.shivangi.travelandtourism;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class feedback extends AppCompatActivity {
    Button btn_sub;
    EditText edt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        btn_sub = (Button) findViewById(R.id.btn_sub);
        edt = (EditText) findViewById(R.id.edt);
        btn_sub.setOnClickListener(click);

    }

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
                if(edt.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Your feedback please", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Thank You for your feedback", Toast.LENGTH_SHORT).show();
                    Intent intent_start_activity = new Intent(getApplicationContext(), Menu.class);
                    startActivity(intent_start_activity);
                    intent_start_activity = new Intent(getApplicationContext(), Menu.class);

                }


        }


    };
}
