package com.shivangi.travelandtourism;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class CityList extends Registration {

    ListView lv_products;
    ArrayList <Product> products= new ArrayList<Product>();
    Button btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_list);

        btn_back = (Button) findViewById(R.id.btn_back);
        //btn_back.setOnClickListener(click_bk);


        lv_products = (ListView) findViewById(R.id.lv_products);

        Product p1 = new Product();
        Product p2 = new Product();
        Product p3 = new Product();
        Product p4 = new Product();
        Product p5 = new Product();

        p1.pid = "pk";
        p1.pname = "Kolkata";
        p1.pdesc = "Kolkata is located on the east bank of the Hooghly River," +
                " the principal commercial, cultural, and educational" +
                " centre of East India";
        p1.pimage = R.drawable.kolkata;

        p2.pid = "pc";
        p2.pname = "Chennai";
        p2.pdesc = "Chennai is located on the Coromandel Coast off the Bay of Bengal," +
                " the biggest cultural, economic and educational centre in South India";
        p2.pimage = R.drawable.chennai;

        p3.pid = "pp";
        p3.pname = "Pune";
        p3.pdesc = "Pune has had a traditional old-economic base. Most of the old industries continue to grow here.";
        p3.pimage = R.drawable.pune;

        p4.pid = "pm";
        p4.pname = "Mumbai";
        p4.pdesc = "The seven islands that came to constitute Mumbai were home to communities of fishing colonies.";
        p4.pimage = R.drawable.mumbai;

        p5.pid = "pm";
        p5.pname = "Delhi";
        p5.pdesc = "Delhi and its urban region have been given the special status of NCR" +
                " under the Constitution of India's 69th Amendment Act of 1991.";
        p5.pimage = R.drawable.delhi;
        //p5=(ListView)findViewById(R.drawable.


        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5);


        CustomProductAdapter adapter = new CustomProductAdapter(CityList.this, products);
        lv_products.setAdapter(adapter);

       // lv_products.setOnItemClickListener(click);
        lv_products.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                               @Override
                                               public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                   switch (position) {
                                                       case 0:
                                                           Intent nextActivity = new Intent(CityList.this,CityDetails.class);
                                                           nextActivity.putExtra("city","KOLKATA");
                                                           startActivity(nextActivity);
                                                           break;
                                                       case 1:
                                                           Intent nextActivity1 = new Intent(CityList.this, CityDetails.class);
                                                           nextActivity1.putExtra("city","CHENNAI");
                                                           startActivity(nextActivity1);
                                                           break;
                                                       case 2:
                                                           Intent nextActivity2 = new Intent(CityList.this, CityDetails.class);
                                                           nextActivity2.putExtra("city","PUNE");
                                                           startActivity(nextActivity2);
                                                           break;
                                                       case 3:
                                                           Intent nextActivity3 = new Intent(getApplicationContext(), CityDetails.class);
                                                           nextActivity3.putExtra("city","MUMBAI");
                                                           startActivity(nextActivity3);
                                                           break;
                                                       case 4:
                                                           Intent nextActivity4 = new Intent(getApplicationContext(), CityDetails.class);
                                                           nextActivity4.putExtra("city","DELHI");
                                                           startActivity(nextActivity4);
                                                           break;

                                                   }
                                               }
                                           });

            //AdapterView.OnItemClickListener click=new AdapterView.OnItemClickListener() {
            //  @Override
            //public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //  Product p=products.get(position);
            //Intent i=new Intent(getApplicationContext(), Kolkata.class);
            //startActivity(i);

        }
    };












   /* Button btn_city, btn_so;
    ListView lv_cities;
    ArrayList<String> cities= new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_list);

        cities.add("Kolkata");
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Pune");
        cities.add("Chennai");

        btn_city=(Button)findViewById(R.id.btn_city);
        btn_city.setOnClickListener(click);

        lv_cities=(ListView)findViewById(R.id.lv_cities);
        btn_so=(Button)findViewById(R.id.btn_so);
        //btn_so.setOnClickListener(click_so);
    }
    AdapterView.OnItemClickListener btn_click=new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
            String city=cities.get(i);
            Toast.makeText(getApplicationContext(),city,Toast.LENGTH_SHORT).show();
        }
    };
    ArrayAdapter<String> adapter;

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
         //   if (view.getId() == R.id.btn_city) {
          try {
              adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.activity_item_city, cities);
              lv_cities.setAdapter(adapter);
          }
          catch (Exception exp)
          {
              Log.i("Error",exp.getMessage());
          }
           // }

        }


    };*/
