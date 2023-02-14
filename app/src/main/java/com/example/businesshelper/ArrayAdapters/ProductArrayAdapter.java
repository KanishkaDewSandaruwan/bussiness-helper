package com.example.businesshelper.ArrayAdapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.businesshelper.Modal.Product;
import com.example.businesshelper.R;

import java.util.List;

public class ProductArrayAdapter extends ArrayAdapter<Product> {

    Context context;
    int resource;
    List<Product> productList;

    public ProductArrayAdapter(@NonNull Context context, int resource, List<Product> productList) {
        super(context, resource, productList);
        this.context = context;
        this.resource = resource;
        this.productList = productList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);


        TextView p_id = row.findViewById(R.id.p_id);
        TextView p_name = row.findViewById(R.id.p_name);
        TextView p_price = row.findViewById(R.id.p_price);
        TextView p_status = row.findViewById(R.id.p_status);

        Product product = productList.get(position);

        p_id.setText(product.getPid());
        p_name.setText(product.getProduct_name());
        p_name.setText(String.valueOf(product.getProduct_price()));
        p_name.setText(String.valueOf(product.getProduct_status()));

        return row;
    }
}