package com.example.attendance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class AttendanceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance); //init
        GridView gridview = (GridView) findViewById(R.id.gridView);
        gridview.setAdapter(new ToggleAdapter(this));

    }

    public void foo() {
        Toast.makeText(getApplicationContext(), "Hello", Toast.LENGTH_SHORT);
    }
}
