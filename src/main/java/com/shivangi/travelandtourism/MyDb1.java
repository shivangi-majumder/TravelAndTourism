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
public class MyDb1 extends SQLiteOpenHelper {


    public MyDb1(Context context) {

        super(context, "AndroidOrderDB1", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String tablecode = "Create table Bookings(NoP varchar(20) primary key," + "Amount varchar(20))";
        db.execSQL(tablecode);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public ArrayList<Book> GetOrders() {
        //showing everything without any where clause//
        ArrayList<Book> Bookings = new ArrayList<Book>();

        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {"NoP", "Amount"};

        Cursor rows =
                db.query("Bookings", columns, null, null, null, null, "NoP DESC");

        if (rows != null) {
            while (rows.moveToNext()) {
                Book ord = new Book();
                ord.NoP = rows.getString(0);
                ord.Amount = rows.getString(0);
                Bookings.add(ord);

            }
        }

        db.close();
        return Bookings;
    }



    public ArrayList<Book> GetOrders(String NoP) {
        //showing orders based on custname
        //this function will return more than one value
        //hence ArrayList<Order> is written
        ArrayList<Book> Bookings = new ArrayList<Book>();

        SQLiteDatabase db = getReadableDatabase();

        String[] columns = {"NoP", "Amount"};
        String[] para = {NoP};

        Cursor rows =
                db.query("Bookings", columns, "NoP=?", para, null, null, "NoP DESC");

        if (rows != null) {
            while (rows.moveToNext()) {
                Book ord = new Book();
                ord.NoP = rows.getString(0);
                ord.Amount = rows.getString(0);
            }
        }
        db.close();
        return Bookings;
    }




    public Book GetOrder(String Amount) {
        ArrayList<Book> orders = new ArrayList<Book>();

        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {"NoP", "Amount"};
        String[] para1={Amount};

        Cursor rows =
                db.query("Bookings", columns, Amount, para1, null, null, "NoP DESC");

        if (rows != null) {
            while (rows.moveToNext()) {
                Book ord = new Book();
                ord.NoP = rows.getString(0);
                ord.Amount = rows.getString(0);
                orders.add(ord);

            }
        }
        return null;
    }

    public long AddOrder(Book ord)
    {

        ContentValues values= new ContentValues();
        values.put("NoP",ord.NoP);
        values.put("Amount",ord.Amount);

        SQLiteDatabase db= getWritableDatabase();
        long rowid=db.insert("Bookings",null,values);

        db.close();
        return rowid;

    }

}
