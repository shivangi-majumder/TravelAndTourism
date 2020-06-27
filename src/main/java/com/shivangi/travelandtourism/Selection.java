package com.shivangi.travelandtourism;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Selection extends AppCompatActivity{


    Button  btn_sub,btn_b,btn_cal;
    EditText edit_people,edit_days,et_sum;
    int s1,s2,sum;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        btn_cal=(Button)findViewById(R.id.btn_cal);
        btn_b=(Button)findViewById(R.id.btn_b);
        btn_sub=(Button)findViewById(R.id.btn_sub);

        edit_days=(EditText)findViewById(R.id.edit_days);
        edit_people=(EditText)findViewById(R.id.edit_people);
        et_sum=(EditText)findViewById(R.id.et_sum);
        btn_cal.setOnClickListener(click_calc);
        btn_sub.setOnClickListener(click);
        btn_b.setOnClickListener(click_back);




    }

    View.OnClickListener click_calc=new View.OnClickListener() {
        @Override
        public void onClick(View v)
        {
            s1= Integer.parseInt(edit_days.getText().toString());
            s2=Integer.parseInt(edit_people.getText().toString());
           // Toast.makeText(getApplicationContext(),"Sudipta",Toast.LENGTH_LONG).show();
            sum=(s1*s2*1000);
          et_sum.setText(""+sum);

        }
    };
    View.OnClickListener click=new View.OnClickListener() {
        @Override
        public void onClick(View v)
        {
            s1=Integer.parseInt(edit_days.getText().toString());
            s2=Integer.parseInt(edit_people.getText().toString());
            sum=s1*s2*1000;

            Toast.makeText(getApplicationContext(), "Total:"+sum,
                    Toast.LENGTH_SHORT).show();

           MyDb1 db= new MyDb1(getApplicationContext());
            Book book = new Book();
            book.NoP = edit_people.getText().toString();
            book.Amount = et_sum.getText().toString();
            //Toast.makeText(getApplicationContext(), et_sum.getText().toString() , Toast.LENGTH_SHORT).show();
            long rowid= db.AddOrder(book);
            Toast.makeText(getApplicationContext(), "Added " + rowid, Toast.LENGTH_SHORT).show();

            Toast.makeText(getApplicationContext()," The number of people: "+s1+" Will stay for "+s2+" days"+" Total Amount= "+sum,Toast.LENGTH_LONG).show();
            Intent intent_start_activity = new Intent(getApplicationContext(), Payment.class);
            intent_start_activity.putExtra("value",sum);
            startActivity(intent_start_activity);



        }
    };
    View.OnClickListener click_back=new View.OnClickListener() {
        @Override
        public void onClick(View v)
        {
            Intent intent_start_activity = new Intent(getApplicationContext(), CityDetails.class);
            startActivity(intent_start_activity);

        }
    };


}
