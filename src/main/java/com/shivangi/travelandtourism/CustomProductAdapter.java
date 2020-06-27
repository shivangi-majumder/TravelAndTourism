package com.shivangi.travelandtourism;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Abc on 7/23/2016.
 */
public class CustomProductAdapter extends ArrayAdapter<Product> {

    Activity context;
    ArrayList<Product> products;

    public CustomProductAdapter(Activity context, ArrayList<Product> objects) {
        super(context, R.layout.item_product, objects);
        //try {

        this.context = context;
        this.products = objects;
        //}
        /*catch (Exception exp)
        {
            Toast.makeText(context,exp.getMessage(),Toast.LENGTH_LONG).show();
        }*/
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
//try{

        LayoutInflater inflater = context.getLayoutInflater();
        View v = inflater.inflate(R.layout.item_product, null, true);
        //TextView pid = (TextView) v.findViewById(R.id.txt_pid);
        TextView pname = (TextView) v.findViewById(R.id.txt_pname);
        TextView pdesc = (TextView) v.findViewById(R.id.txt_pdesc);

        Product p = products.get(position);
        ImageView img = (ImageView) v.findViewById(R.id.img_product);
        //pid.setText(p.pid);
        pname.setText(p.pname);
        pdesc.setText(p.pdesc);
        img.setImageResource(p.pimage);
        return v;
//}
/*catch (Exception exp)
{
    Toast.makeText(context,exp.getMessage(),Toast.LENGTH_LONG).show();

}*/
        //return  null;
    }
}

