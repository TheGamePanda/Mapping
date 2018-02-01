package com.example.a1walta34.mapping;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;


import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    MapView mv;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));
        setContentView(R.layout.activity_main);
        mv = (MapView)findViewById(R.id.map1);
        mv.setBuiltInZoomControls(true);
        mv.getController().setZoom(16);
        mv.getController().setCenter(new GeoPoint(50.901321, -1.405033));
        Button button = (Button) findViewById(R.id.butGo);
        button.setOnClickListener(this);
    }

    public void onClick(View view) {
        EditText LatEt = (EditText)findViewById(R.id.latIn);
        EditText LonEt = (EditText)findViewById(R.id.lonIn);
        double latCo = Double.parseDouble(LatEt.getText().toString());
        double lonCo = Double.parseDouble(LonEt.getText().toString());
        mv.getController().setCenter(new GeoPoint(latCo, lonCo));
    }
}
