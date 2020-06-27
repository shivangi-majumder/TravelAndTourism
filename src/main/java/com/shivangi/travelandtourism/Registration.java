package com.shivangi.travelandtourism;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    EditText txt_fname, txt_lname, txt_id, txt_password, txt_ph;
    Button btn_set, btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        txt_fname= (EditText)findViewById(R.id.txt_fname);
        txt_lname= (EditText)findViewById(R.id.txt_lname);
        txt_id= (EditText)findViewById(R.id.txt_id);
        txt_password= (EditText)findViewById(R.id.txt_password);
        txt_ph= (EditText)findViewById(R.id.txt_ph);

        btn_set=(Button)findViewById(R.id.btn_set);
        btn_set.setOnClickListener(click);

        btn_back=(Button)findViewById(R.id.btn_back);
        btn_back.setOnClickListener(click_back);
    }

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (txt_fname.getText().toString().equals("")) {
                txt_fname.setError("Enter First Name");
            } else if (txt_lname.getText().toString().equals("")) {
                txt_lname.setError("Enter Last Name");
            } else if (txt_password.getText().toString().equals("")) {
                txt_password.setError("Enter Password");
            } else if(txt_id.getText().toString().equals(""))
            {
                txt_id.setError("Enter the User Id");
            }else if(txt_ph.getText().toString().equals(""))
            {
                txt_ph.setError("Enter the Phone Number");
            }
            else {
                txt_fname.setError(null);
                txt_lname.setError(null);
                txt_id.setError(null);
                txt_password.setError(null);
                txt_ph.setError(null);
                MyDb db = new MyDb(getApplicationContext());
                Toast.makeText(getApplicationContext(), "Database Created",
                        Toast.LENGTH_SHORT).show();

                db= new MyDb(getApplicationContext());
                Customer customer = new Customer();
                customer.UserId = txt_id.getText().toString();
                customer.Password = txt_password.getText().toString();
                long rowid= db.AddOrder(customer);
                Toast.makeText(getApplicationContext(), "Added " + rowid, Toast.LENGTH_SHORT).show();

                Intent intent_start_activity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent_start_activity);
               // intent_start_activity = new Intent(getApplicationContext(), MainActivity.class);
            }
        }
    };
    TextWatcher watcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (!txt_fname.getText().toString().equals("")) {
                txt_fname.setError(null);
            } else {
                txt_fname.setError("Enter First Name");
            }if (!txt_lname.getText().toString().equals("")) {
                txt_lname.setError(null);
            } else{
                txt_lname.setError("Enter Last Name");
            }if (!txt_password.getText().toString().equals("")) {
                txt_password.setError(null);
            } else {
                txt_password.setError("Enter Password");
            }if(!txt_id.getText().toString().equals("")) {
                txt_id.setError(null);
            } else {
                txt_id.setError("Enter User Id");
            }if(!txt_ph.getText().toString().equals("")) {
                txt_ph.setError(null);
            } else {
                txt_ph.setError("Enter User Id");
            }
        }
    };
    View.OnClickListener click_back= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent_start_activity = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent_start_activity);
            //intent_start_activity = new Intent(getApplicationContext(), MainActivity.class);
        }
    };
}
