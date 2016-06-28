package com.example.attendance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.attendance.R;

/**
 * Created by Bhaumik on 6/29/2016.
 */
public class StudentListAdapter extends ArrayAdapter<String> {
    int[] images;
    String[] names;
    String[] rollNumbers = {"1411008", "1411009", "1411010"};//Dummy array
    Context c;
    LayoutInflater layoutInflater;

    public StudentListAdapter(Context context, String[] rollNumbers) {
        super(context, R.layout.single_row_student_list, R.id.rollNumberInStudentList, rollNumbers);
        this.c = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.single_row_student_list, parent, false);

        ImageView studentImage = (ImageView) row.findViewById(R.id.imageInStudentList);
        TextView studentRollNumber = (TextView) row.findViewById(R.id.rollNumberInStudentList);
        TextView studentName = (TextView) row.findViewById(R.id.nameInStudentList);

        studentImage.setImageResource(images[position]);
        studentRollNumber.setText(rollNumbers[position]);
        studentName.setText(names[position]);
        //TODO Set the Image and the texts
        return row;
    }
}
