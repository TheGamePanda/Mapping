package com.example.a1walta34.mapping;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.osmdroid.util.GeoPoint;

public class LocationChoice extends AppCompatActivity implements View.OnClickListener {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_choice);
        Button button = (Button) findViewById(R.id.butGo);
        button.setOnClickListener(this);
    }

    public void onClick(View v)
    {
            // Takes input from Latitude and Longitude EditTexts
            EditText LatEt = (EditText)findViewById(R.id.latIn);
            EditText LonEt = (EditText)findViewById(R.id.lonIn);

            String latString = LatEt.getText().toString();
            String lonString = LonEt.getText().toString();

            // Checks for value present in latEt and lonEt
            if (!lonString.equals("") && !latString.equals(""))
            {
            // Creates 'double' variables from
            double latCo = Double.parseDouble(LatEt.getText().toString());
            double lonCo = Double.parseDouble(LonEt.getText().toString());

            Intent intent = new Intent();
            Bundle bundle=new Bundle();
            bundle.putDouble("com.example.latCo", latCo);
            bundle.putDouble("com.example.lonCo", lonCo);
            intent.putExtras(bundle);
            setResult(RESULT_OK,intent);
            finish();
            }

            else
            {
            // Bundles default values, as no values were entered
            double latCo = Double.parseDouble("50.901321");
            double lonCo = Double.parseDouble("-1.405033");

            Intent intent = new Intent();
            Bundle bundle=new Bundle();
            bundle.putDouble("com.example.latCo", latCo);
            bundle.putDouble("com.example.lonCo", lonCo);
            intent.putExtras(bundle);
            setResult(RESULT_OK,intent);
            finish();
        }
    }
}
