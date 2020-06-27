package com.shivangi.travelandtourism;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

;

public class CityDetails extends Activity {

    ListView lv_kol;
    ImageView iv_kol1,iv_kol2,iv_kol3,iv_kol4;
    TextView txt_cd;

    ArrayList<Product> products= new ArrayList<Product>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_details);
        lv_kol = (ListView) findViewById(R.id.lv_kol);
        iv_kol1 = (ImageView) findViewById(R.id.iv_kol1);
        iv_kol2 = (ImageView) findViewById(R.id.iv_kol2);
        iv_kol3 = (ImageView) findViewById(R.id.iv_kol3);
        iv_kol4 = (ImageView) findViewById(R.id.iv_kol4);
        txt_cd=(TextView) findViewById(R.id.txt_cd);
        Intent intent = getIntent();


        if (intent.getStringExtra("city").equals("KOLKATA")) {
            txt_cd.setText("Kolkata");
            iv_kol1.setBackgroundResource(R.drawable.kol1);
            iv_kol2.setBackgroundResource(R.drawable.kol2);
            iv_kol3.setBackgroundResource(R.drawable.kol3);
            iv_kol4.setBackgroundResource(R.drawable.kol9);


            Product p11 = new Product();
            Product p22 = new Product();
            Product p33 = new Product();

            p11.pid = "pk";
            p11.pname = "1) ITC SONAR";
            p11.pdesc = "ITC Sonar , Kolkata is the first hotel in East India to have been awarded Platinum rating under LEED® EB (Existing Building) program." +
                    " Platinum rating is the highest category of certification preceded by Gold, Silver and Certified. Rating:4.5/5";
            p11.pimage = R.drawable.kol4;

            p22.pid = "pc";
            p22.pname = "2) THE OBEROI GRAND ";
            p22.pdesc = "Housed in a palatial villa dating from the 1880’s, this elegant hotel is an 11-minute walk from the Hooghly River and 2.6 km from the Victoria Memorial.\n" +
                    "\n" +
                    "Featuring colonial-style prints and wood furniture, the posh rooms offer flat-screen TVs, minibars, and tea and coffeemaking equipment. Upgraded rooms add balconies. The suites include living areas, and some have 4-poster beds, writing desks and garden views. Room service is available.\n" +
                    "\n" +
                    "Breakfast and parking are free. There’s a chic French-style bistro, a Thai restaurant and a bar, as well as a spa, a fitness centre and an outdoor pool fringed by palm trees." +
                    "Rating:4.5/5 ";
            p22.pimage = R.drawable.kol5;

            p33.pid = "pp";
            p33.pname = "3) TAJ BENGAL";
            p33.pdesc = "This upmarket hotel, in the downtown area, is a 3-minute walk from the nearest bus stop, and 0.5 km from India's oldest zoo, Alipore Zoological Gardens.\n" +
                    "\n" +
                    "The luxurious rooms offer free Wi-Fi, tea and coffee making facilities and minibars, along with safes and yoga mats. Club rooms add butler service and access to the club lounge which serves breakfast and drinks (no charge). Suites add separate living areas, and upgraded suites add original artworks, terraces and/or rooms.\n" +
                    "\n" +
                    "Breakfast and parking are free. There are 8 restaurants; dining options include Mediterranean, Indian and Chinese cuisine. There's also a bar, plus a spa and an outdoor pool.Rating:4.5/5";
            p33.pimage = R.drawable.kol6;


            products.add(p11);
            products.add(p22);
            products.add(p33);
            /*Intent intent_start_activity = new Intent(getApplicationContext(), Selection.class);
            startActivity(intent_start_activity);*/
            lv_kol.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent=new Intent(getApplicationContext(),Selection.class);
                    startActivity(intent);
                }
            });

        } else if (intent.getStringExtra("city").equals("DELHI")) {
            txt_cd.setText("Delhi");
            iv_kol1.setBackgroundResource(R.drawable.del1);
            iv_kol2.setBackgroundResource(R.drawable.del2);
            iv_kol3.setBackgroundResource(R.drawable.del3);
            iv_kol4.setBackgroundResource(R.drawable.del4);
            Product p31 = new Product();
            Product p42 = new Product();
            Product p53 = new Product();

            p31.pid = "pk";
            p31.pname = "1) HYATT Regency";
            p31.pdesc = "The Hyatt Regency Delhi is a luxury hotel in New Delhi, India, built in 1983. The five-star hotel has 507 rooms and 52 suites equipped with modern amenities and high-speed Internet access. Rating:4.7/5";
            p31.pimage = R.drawable.del5;

            p42.pid = "pc";
            p42.pname = "2) J W MARRIOT ";
            p42.pdesc = "This sophisticated hotel is an 8-minute walk from Delhi Aerocity metro station and 2.5 km from Indira Gandhi International Airport's terminals.\n" +
                    "\n" +
                    "Sleek, contemporary rooms offer flat-screen TVs, WiFi (fee), minifridges, and tea and coffeemaking facilities. Some add balconies; club rooms include access to a lounge with free drinks. Suites feature integrated or separate living areas.\n" +
                    "\n" +
                    "There's a breakfast buffet (fee) and a pair of restaurants for international cuisine, plus a cafe/bakery, and a lounge bar with live entertainment. Amenities include a heated outdoor pool, a fitness centre and a subdued spa, plus 8 function rooms. Rating:4.3/5";
            p42.pimage = R.drawable.del6;

            p53.pid = "pp";
            p53.pname = "3) THE OBEROI";
            p53.pdesc = "Set 1.6 km from Humayun's Tomb, this luxury hotel is also 2.3 km from India Gate and 9 km from the Red Fort.\n" +
                    "\n" +
                    "The modern rooms have flat-screen TVs, DVD players, minibars and paid Wi-Fi. Suites add living/dining rooms and/or kitchenettes. Room service is available.\n" +
                    "\n" +
                    "Amenities include 3 chic restaurants featuring international fare, and a breakfast buffet is available (fee). There's also a bar, a gym and an outdoor pool, as well as a full-service spa.  Rating:4.5/5";
            p53.pimage = R.drawable.del7;


            products.add(p31);
            products.add(p42);
            products.add(p53);

            lv_kol.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent=new Intent(getApplicationContext(),Selection.class);
                    startActivity(intent);
                }
            });

        } else if (intent.getStringExtra("city").equals("MUMBAI")) {
            txt_cd.setText("Mumbai");
            iv_kol1.setBackgroundResource(R.drawable.mum1);
            iv_kol2.setBackgroundResource(R.drawable.mum2);
            iv_kol3.setBackgroundResource(R.drawable.mum3);
            iv_kol4.setBackgroundResource(R.drawable.mum4);

            Product p44 = new Product();
            Product p55 = new Product();
            Product p66 = new Product();

            p44.pid = "pk";
            p44.pname = "1) THE OBEROI";
            p44.pdesc = "On the shores of Back Bay, this luxe hotel in the Nariman Point business district is 1.4 km from Wankhede Stadium and 1.9 km from the Gateway of India arch.\n" +
                    "\n" +
                    "Mixing modern and classic decor, the sophisticated rooms offer iPod/iPhone docks, flat-screen TVs and Wi-Fi (fee), plus minibars, and marble bathrooms with tubs and massage showers. Upgraded rooms add sea views and/or sitting areas. Suites feature living rooms; 1 has a grand piano. There's 24-hour room service.\n" +
                    "\n" +
                    "There are 3 sleek restaurants for casual and fine dining, plus 2 bars, a 24-hour spa, a gym, and an outdoor pool with bar service. Event space and a business centre are available. Rating:4.5/5";
            p44.pimage = R.drawable.mum5;

            p55.pid = "pc";
            p55.pname = "2) THE TAJ MAHAL PALACE ";
            p55.pdesc = "Opposite the Arabian Sea, this luxury hotel is a 6-minute walk from the Gateway of India and 3.4 km from the bustling Marine Drive.\n" +
                    "\n" +
                    "The refined rooms come with free Wi-Fi, flat-screens and turndown service. Club-level rooms add butler service, marble bathrooms and access to a private lounge serving drinks and appetizers. Suites add living rooms, and the presidential suite provides a spa and a fitness room.\n" +
                    "\n" +
                    "Freebies include a breakfast buffet, parking and airport pickup (for club-level and suites’ guests) . There are 11 upscale restaurants and bars. A spa, a beauty salon, an outdoor pool, a fitness room and a luxe shopping zone are also on-site. Rating:4.6/5";
            p55.pimage = R.drawable.mum6;

            p66.pid = "pp";
            p66.pname = "3) Hotel Sofitel Mumbai BKC";
            p66.pdesc = "Set in the Bandra Kurla Complex financial district, this luxe hotel is 7.2 km from Chhatrapati Shivaji International Airport.\n" +
                    "\n" +
                    "The opulent rooms feature plush fabrics and vivid colors, and come with flat-screen TVs, free WiFi, iPod docks, minibars, and tea and coffeemaking facilities. Suites add extra living space or separate lounges, while some have glass-walled bathrooms with soaking tubs. Club rooms and suites include free airport transfers, plus breakfast and evening cocktails in the club lounge.\n" +
                    "\n" +
                    "There are 4 dining options, including a vegetarian restaurant. Other amenities include a rooftop pool with a bar, an Ayurvedic spa and a gym. Rating:4.4/5";
            p66.pimage = R.drawable.mum7;


            products.add(p44);
            products.add(p55);
            products.add(p66);
           /* Intent intent_start_activity = new Intent(getApplicationContext(), Selection.class);
            intent_start_activity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent_start_activity);*/
            lv_kol.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent=new Intent(getApplicationContext(),Selection.class);
                    startActivity(intent);
                }
            });
        } else if (intent.getStringExtra("city").equals("CHENNAI")) {
            txt_cd.setText("Chennai");
            iv_kol1.setBackgroundResource(R.drawable.che1);
            iv_kol2.setBackgroundResource(R.drawable.che2);
            iv_kol3.setBackgroundResource(R.drawable.che3);
            iv_kol4.setBackgroundResource(R.drawable.che4);

            Product p77 = new Product();
            Product p88 = new Product();
            Product p99 = new Product();

            p77.pid = "pk";
            p77.pname = "1) HOTEL COMFORT";
            p77.pdesc = "This understated hotel is 2.1 km from Marina Beach, 2.5 km from Chennai Central train station and 2.7 km from the multidisciplinary Government Museum.\n" +
                    "\n" +
                    "Straightforward rooms and suites come with TVs; upgraded quarters add air-conditioning.\n" +
                    "\n" +
                    "An unpretentious restaurant offers dining on a city-view, rooftop terrace. There’s also a subdued bar with a fireplace. Rating:3/5";
            p77.pimage = R.drawable.che5;

            p88.pid = "pc";
            p88.pname = "2) TAJ CLUB HOUSE ";
            p88.pdesc = "Set 3.1 km from Chennai Central railway station, this upscale hotel in a building with a glass facade is 6 km from 17th-century Fort St. George.\n" +
                    "\n" +
                    "The refined rooms offer Wi-Fi (limited free), flat-screen TVs and minibars, plus tea and coffeemaking facilities. Upgraded rooms and suites have club lounge access, with breakfast, and drinks served throughout the day. Suites add connecting rooms. An upgraded suite has 2 bedrooms, a whirlpool tub, gym and butler.\n" +
                    "\n" +
                    "The hotel offers free parking and breakfast. Other amenities include 3 polished restaurants, 2 bars and a deli. There's a rooftop pool with sunloungers, plus a spa and a fitness room. Rating:4.5/5";
            p88.pimage = R.drawable.che6;

            p99.pid = "pp";
            p99.pname = "3) THE RAIN TREE";
            p99.pdesc = "This modern business hotel is 2.7 km from Mambalam railway station, 3.1 km from Kapaleeshwarar Temple and 6 km from Marina Beach.\n" +
                    "\n" +
                    "The warmly decorated rooms offer Wi-Fi (fee) and flat-screen TVs, plus desks, tea and coffeemaking equipment and minibars. Upgraded rooms come with free Wi-Fi and access to a private lounge. Studios add sitting areas and kitchenettes, while suites have separate living spaces. Room service is available 24/7.\n" +
                    "\n" +
                    "A breakfast buffet and parking are free. There are 3 contemporary restaurants and 2 bars. Other amenities include a rooftop pool, a fitness room and a spa. The hotel also has a business centre and meeting space.Rating:4.2/5";
            p99.pimage = R.drawable.che7;


            products.add(p77);
            products.add(p88);
            products.add(p99);
            lv_kol.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent=new Intent(getApplicationContext(),Selection.class);
                    startActivity(intent);
                }
            });
           /* Intent intent_start_activity = new Intent(getApplicationContext(), Selection.class);
            startActivity(intent_start_activity);*/

        }
        else if (intent.getStringExtra("city").equals("PUNE")) {
            txt_cd.setText("Pune");
            iv_kol1.setBackgroundResource(R.drawable.pune1);
            iv_kol2.setBackgroundResource(R.drawable.pune2);
            iv_kol3.setBackgroundResource(R.drawable.pune3);
            iv_kol4.setBackgroundResource(R.drawable.pune4);

            Product p45 = new Product();
            Product p46= new Product();
            Product p47 = new Product();

            p45.pid = "pk";
            p45.pname = "1) HYATT REGENCT";
            p45.pdesc = "This upscale hotel is a 4-minute walk from the nearest bus stop, 1.5 km from Aga Khan Palace and 8 km from the fortress of Shaniwar Wada.\n" +
                    "\n" +
                    "The contemporary rooms and suites feature flat-screen TVs, iPod docks, minibars, and tea and coffeemaking facilities; some also include free Wi-Fi. Suites add balconies with panoramic city views, as well as sitting areas, dining tables and private lounge access. There's 24-hour room service.\n" +
                    "\n" +
                    "Amenities include an Italian restaurant, a trendy cafe, a bakery and a bar/lounge, as well as a spa, an indoor pool, a fitness room and cooking classes. Parking is included. Rating:4.2/5";
            p45.pimage = R.drawable.pune5;

            p46.pid = "pc";
            p46.pname = "2) HOTEL SAPNA PUNE ";
            p46.pdesc = "This relaxed budget hotel is a 13-minute walk from the 8th-century Pataleshwar Cave Temple, 1.6 km from Shaniwar Wada Fort and 13 km from Pune Airport.\n" +
                    "\n" +
                    "The streamlined rooms with wood floors and contemporary decor offer complimentary Wi-Fi, flat-screen TVs, and tea and coffeemaking equipment. Upgraded rooms feature garden views, while suites add living and dining areas. Room service is available 24/7.\n" +
                    "\n" +
                    "A breakfast buffet and parking are complimentary. There's a laid-back vegetarian restaurant and an open-air cafe. Bike rental is available.Rating:4.1/5";
            p46.pimage = R.drawable.pune6;

            p47.pid = "pp";
            p47.pname = "3) THE O HOTEL";
            p47.pdesc = "Set in a contemporary building, this fashionable hotel is 4.2 km from the 19th-century Aga Khan Palace and 11 km from the temple on Parvati Hill.\n" +
                    "\n" +
                    "Warmly decorated suites with wood floors have high-speed Internet access, flat-screen TVs, minibars and electronic safes. Club suites add private lounge access, in-room check-in and high tea service. Upgraded quarters add kitchens and sitting/dining areas.\n" +
                    "\n" +
                    "Breakfast and parking are complimentary. There are also 3 restaurants and 2 bars, plus a cafe, a rooftop pool, a gym and a spa. Rating:4.0/5";
            p47.pimage = R.drawable.pune7;


            products.add(p45);
            products.add(p46);
            products.add(p47);

           /*Intent intent_start_activity = new Intent(getApplicationContext(), Selection.class);
            startActivity(intent_start_activity);*/
            lv_kol.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent=new Intent(CityDetails.this,Selection.class);
                    startActivity(intent);
                }
            });

        }


        CustomProductAdapter2 adapter = new CustomProductAdapter2(CityDetails.this, products);
        lv_kol.setAdapter(adapter);
      /*  lv_kol.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent nextActivity = new Intent(CityDetails.this,Selection.class);
                startActivity(nextActivity);
            }
        });*/




    }


}