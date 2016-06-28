package com.example.attendance;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AttendanceActivity extends AppCompatActivity {
    public static int PRESENT = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance); //init
        GridView gridview = (GridView) findViewById(R.id.gridView);
        gridview.setAdapter(new CustomAdapter(this));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mark_attendance, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.mark_attendance_button) {
            //Toast.makeText(this,"Present : "+Integer.toString(PRESENT),Toast.LENGTH_SHORT).show();
            //Toast.makeText(this, loadJSONFromAsset(), Toast.LENGTH_SHORT).show();
            backgroundReceiveData brd = new backgroundReceiveData();
            brd.execute();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {

            InputStream is = getAssets().open("demolist.json");
            //TODO Get file from server instead
            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
            Toast.makeText(this, "File not found", Toast.LENGTH_SHORT).show();
            return null;
        }
        return json;

    }


    class backgroundReceiveData extends AsyncTask<Void, Void, String> {
        String json_url;
        String json_string;

        @Override
        protected String doInBackground(Void... params) {
            try {
                URL url = new URL(json_url);
                HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpUrlConnection.getInputStream();
                BufferedReader bufferReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line;
                while ((line = bufferReader.readLine()) != null) {
                    result += line;
                }
                bufferReader.close();
                inputStream.close();
                httpUrlConnection.disconnect();
                return result;
            } catch (IOException u) {
                return " url";
            } catch (NullPointerException npe) {
                return "nullpointer";
            }
            //return " this is bug";
        }

        @Override
        protected void onPreExecute() {
            json_url = "http://absattendance.esy.es/json.php";

        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {
            TextView dataToDisplay = (TextView) findViewById(R.id.demoTextView);
            dataToDisplay.setText(result);
            json_string = result;
        }
    }

}
