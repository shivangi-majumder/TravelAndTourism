package com.shivangi.travelandtourism;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_register, btn_login;
    EditText txt_id, txt_password;
    CheckBox cb_rm;
    private SharedPreferences loginPreferences;
    private SharedPreferences.Editor loginPrefsEditor;
    private Boolean saveLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_id = (EditText) findViewById(R.id.txt_id);
        txt_password = (EditText) findViewById(R.id.txt_password);
        cb_rm = (CheckBox) findViewById(R.id.cb_rm);


        btn_register = (Button) findViewById(R.id.btn_register);
        btn_register.setOnClickListener(click_register);

        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(click_login);
        //btn_login.setEnabled(false);
        loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        loginPrefsEditor = loginPreferences.edit();

        saveLogin = loginPreferences.getBoolean("saveLogin", false);
        if (saveLogin == true) {
            txt_id.setText(loginPreferences.getString("username", ""));
            txt_password.setText(loginPreferences.getString("password", ""));
            cb_rm.setChecked(true);
        }
    }

    View.OnClickListener click_register = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "Please Register Yourself", Toast.LENGTH_SHORT).show();
            Intent intent_start_activity = new Intent(getApplicationContext(), Registration.class);
            startActivity(intent_start_activity);
            intent_start_activity = new Intent(getApplicationContext(), Registration.class);
        }
    };
    View.OnClickListener click_login = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (txt_password.getText().toString().equals("")) {
                txt_password.setError("Enter Password");
            } else if (txt_id.getText().toString().equals("")) {
                txt_id.setError("Enter the User Id");
            } else {
                txt_id.setError(null);
                txt_password.setError(null);

            }
            if (v.getId() == R.id.btn_login) {
                MyDb db = new MyDb(getApplicationContext());
                if (db.GetOrder(txt_id.getText().toString(), txt_password.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Valid User", Toast.LENGTH_SHORT).show();
                    String uid=txt_id.getText().toString();
                    String password=txt_password.getText().toString();
                        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(txt_id.getWindowToken(), 0);

                        if (cb_rm.isChecked()) {
                            loginPrefsEditor.putBoolean("saveLogin", true);
                            loginPrefsEditor.putString("username", uid);
                            loginPrefsEditor.putString("password", password);
                            loginPrefsEditor.commit();
                        } else {
                            loginPrefsEditor.clear();
                            loginPrefsEditor.commit();
                        }
                    /*if (cb_rm.isChecked())
                    {
                        txt_id.setText(uid);
                        txt_password.setText(password);
                    }*/
                    //Toast.makeText(getApplicationContext(), "WELCOME..!!", Toast.LENGTH_SHORT).show();
                    Intent intent_start_activity = new Intent(getApplicationContext(), Nav.class);
                    intent_start_activity.putExtra("userid",uid);
                    startActivity(intent_start_activity);

                } else {
                    Toast.makeText(getApplicationContext(), "Invalid User", Toast.LENGTH_SHORT).show();
                }

            }
            }
        };

    TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (!txt_id.getText().toString().equals("")) {
                txt_id.setError(null);
            } else {
                txt_id.setError("Enter User Id");
            } if (!txt_password.getText().toString().equals("")) {
                txt_password.setError(null);
            } else {
                txt_password.setError("Enter Password");
            }
        }
    };
}
