package com.example.alx.fastandroid_4a;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Alx on 16.03.2017.
 */

public class UserAdapter extends ArrayAdapter<User> {
    public UserAdapter(Context context, ArrayList<User> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        User u = getItem(position);

        if(convertView == null){
            // Позиция элемента, , Наш элемент
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.castom, parent, false);
        }

        TextView tv1 = (TextView)convertView.findViewById(R.id.textView);
        TextView tv2 = (TextView)convertView.findViewById(R.id.textView2);

        tv1.setText(u.name);
        tv2.setText(u.fname);

        return convertView;
        //return super.getView(position, convertView, parent);
    }
}
