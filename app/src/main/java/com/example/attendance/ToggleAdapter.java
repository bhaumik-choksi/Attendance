package com.example.attendance;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.Toast;
import android.widget.ToggleButton;

/**
 * Created by Bhaumik on 5/31/2016.
 */
public class ToggleAdapter extends BaseAdapter {
    public String[] filesnames = {
            "Stu 1", "Stu 1", "Stu 1",
            "Stu 2", "Stu 1", "Stu 1",
            "Stu 3", "Stu 1", "Stu 1"

    };
    private Context mContext;

    // Gets the context so it can be used later
    public ToggleAdapter(Context c) {
        mContext = c;
    }

    // Total number of things contained within the adapter
    public int getCount() {
        return filesnames.length;
    }

    // Require for structure, not really used in my code.
    public Object getItem(int position) {
        return null;
    }

    // Require for structure, not really used in my code. Can
    // be used to get the id of an item in the adapter for
    // manual control.
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position,
                        View convertView, ViewGroup parent) {
        ToggleButton btn;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            btn = new ToggleButton(mContext);
            btn.setLayoutParams(new GridView.LayoutParams(100, 55));
            btn.setPadding(3, 3, 3, 3);
        } else {
            btn = (ToggleButton) convertView;
        }

        btn.setText(filesnames[position]);
        // filenames is an array of strings
        btn.setBackgroundResource(R.drawable.toggle_selector);
        btn.setId(position);
        btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    //TODO Student is present
                } else {
                    // The toggle is disabled
                    //TODO Student is absent
                }
            }
        });
        return btn;
    }

}