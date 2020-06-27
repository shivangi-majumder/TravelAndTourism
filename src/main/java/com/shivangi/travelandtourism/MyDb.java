package com.shivangi.travelandtourism;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by sudipta on 27-Jul-16.
 */
public class MyDb extends SQLiteOpenHelper {


    public MyDb(Context context) {

        super(context, "AndroidOrderDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {

        String tablecode = "Create table Customers(UserId varchar(20) primary key," + "Password varchar(20))";
        db.execSQL(tablecode);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public ArrayList<Customer> GetOrders() {
        //showing everything without any where clause//
        ArrayList<Customer> Customers = new ArrayList<Customer>();

        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {"UserId", "Password"};

        Cursor rows =
                db.query("Customers", columns, null, null, null, null, "UserId DESC");

        if (rows != null) {
            while (rows.moveToNext()) {
                Customer ord = new Customer();
                ord.UserId = rows.getString(0);
                ord.Password = rows.getString(0);
                Customers.add(ord);

            }
        }

        db.close();
        return Customers;
    }



    public ArrayList<Customer> GetOrderss(String UserId) {
        //showing orders based on custname
        //this function will return more than one value
        //hence ArrayList<Order> is written
        ArrayList<Customer> Customers = new ArrayList<Customer>();

        SQLiteDatabase db = getReadableDatabase();

        String[] columns = {"UserId", "Password"};
        String[] para = {UserId};

        Cursor rows =
                db.query("Customers", columns, "UserId=?", para, null, null, "UserId DESC");

        if (rows != null) {
            while (rows.moveToNext()) {
                Customer ord = new Customer();
                ord.UserId = rows.getString(0);
                ord.Password = rows.getString(0);
            }
        }
        db.close();
        return Customers;
    }

    public ArrayList<Customer> GetOrders(String UserId) {
        //showing orders based on custname
        //this function will return more than one value
        //hence ArrayList<Order> is written
        ArrayList<Customer> Customers = new ArrayList<Customer>();

        SQLiteDatabase db = getReadableDatabase();

        String[] columns = {"UserId", "Password"};
        String[] para = {UserId};

        Cursor rows =
                db.query("Customers", columns, "UserId=?", para, null, null, "UserId DESC");

        if (rows != null) {
            while (rows.moveToNext()) {
                Customer ord = new Customer();
                ord.UserId = rows.getString(0);
                ord.Password = rows.getString(0);
            }
        }
        db.close();
        return Customers;
    }




    public boolean GetOrder(String UserID ,String Password) {
        //showing orders based on orderid
        //here only Order and not ArrayList<Order>
        //because this function will return only one value
        //since it is a primary key
        String[] columns = {"UserId", "Password"};
        String[] para2 = {UserID,Password};

        SQLiteDatabase db = getReadableDatabase();

        Cursor rows =
                db.query("Customers", columns, "UserId = ? and Password = ?", para2, null, null, "UserId DESC");

        if (rows != null) {
            if (rows.moveToNext()) {
                return  true;
            }

        }
        return false;
    }

    public long AddOrder(Customer ord)
    {

        ContentValues values= new ContentValues();
        values.put("UserId",ord.UserId);
        values.put("Password",ord.Password);

        SQLiteDatabase db= getWritableDatabase();
        long rowid=db.insert("Customers",null,values);

        db.close();
        return rowid;

    }

}
