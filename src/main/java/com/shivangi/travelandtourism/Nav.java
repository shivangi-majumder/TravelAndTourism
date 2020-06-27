package com.shivangi.travelandtourism;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Nav extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Button btn_back;
    ImageButton btn_cities,btn_feedback,btn_package,btn_bookings;
    TextView txt_uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        txt_uid=(TextView)findViewById(R.id.txt_uid);
        Intent intent = getIntent();
        if (null!=intent)
        {
            String uid = intent.getStringExtra("userid");
            txt_uid.setText("Welcome "+uid);
        }
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



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_Home) {
            Intent intent_start_activity = new Intent(getApplicationContext(), Nav.class);
            startActivity(intent_start_activity);
        } else if (id == R.id.nav_plan)
        {
            Intent intent_start_activity = new Intent(getApplicationContext(), Booking.class);
            startActivity(intent_start_activity);

        } else if (id == R.id.nav_about)
        {
            Intent intent_start_activity = new Intent(getApplicationContext(), About.class);
            startActivity(intent_start_activity);

        } else if (id == R.id.nav_logout)
        {
            Intent intent_start_activity = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent_start_activity);
        } else if (id == R.id.nav_share)
        {
            Intent sendIntent =new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.setType("text/plain");
            startActivity(sendIntent);
        } else if (id == R.id.nav_contact)
        {
            Intent intent_start_activity = new Intent(getApplicationContext(), Contact.class);
            startActivity(intent_start_activity);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
