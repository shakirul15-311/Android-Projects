package com.wix.boss.daily;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by MNH on 5/12/2017.
 */

public class MyCustomAdapter extends ArrayAdapter {

    Calendar c = Calendar.getInstance();
    int y=c.get(Calendar.YEAR);
    private Context context;
    private ArrayList<Dates> u;

    public MyCustomAdapter(Context context, int textViewResourceId, ArrayList objects) {
        super(context,textViewResourceId, objects);

        this.context= context;
       u=objects;

    }

    private class ViewHolder
    {
        TextView name;
        TextView cost;
        TextView type;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder holder=null;
        if (convertView == null)
        {
            LayoutInflater vi = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.row, null);

            holder = new ViewHolder();
            holder.cost = (TextView) convertView.findViewById(R.id.cost);
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.type = (TextView) convertView.findViewById(R.id.type);

            convertView.setTag(holder);

        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        Dates us =u.get(position);
        holder.cost.setText(us.getCost());
        holder.name.setText(us.getName());
        holder.type.setText(us.getType());

        return convertView;


    }
}