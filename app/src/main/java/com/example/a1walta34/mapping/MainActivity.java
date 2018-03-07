package com.example.a1walta34.mapping;

import android.content.SharedPreferences;
import android.location.Location;
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
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import android.content.Intent;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;

public class MainActivity extends AppCompatActivity{

    MapView mv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));
        setContentView(R.layout.activity_main);
        mv = (MapView) findViewById(R.id.map1);
        mv.setBuiltInZoomControls(true);
        mv.getController().setZoom(16);
        mv.getController().setCenter(new GeoPoint(50.901321, -1.405033));
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId() == R.id.choosemap)
        {
            Intent intent = new Intent(this,MapChooseActivity.class);
            startActivityForResult(intent, 0);
            // react to the menu item being selected...
            return true;
        }
        if(item.getItemId() == R.id.locationchoice)
        {
            Intent intent = new Intent(this,LocationChoice.class);
            startActivityForResult(intent, 1);
            // react to the menu item being selected...
            return true;
        }
        if(item.getItemId() == R.id.preferences){
            Intent intent = new Intent(this,PrefsActivity.class);
            startActivityForResult(intent, 2);
            // react to the menu item being selected...
            return true;
        }
        return false;
    }
    protected void onActivityResult(int requestCode,int resultCode,Intent intent)
    {
        if(requestCode==0)
        {

            if (resultCode==RESULT_OK)
            {
                Bundle extras=intent.getExtras();
                boolean hikebikemap = extras.getBoolean("com.example.hikebikemap");
                if(hikebikemap==true)
                {
                    mv.setTileSource(TileSourceFactory.HIKEBIKEMAP);
                }
                else
                {
                    mv.setTileSource(TileSourceFactory.MAPNIK);
                }
            }
        }
        if(requestCode==1)
        {

            if (resultCode==RESULT_OK) {
                Bundle extras = intent.getExtras();
                double latCo = extras.getDouble("com.example.latCo");
                double lonCo = extras.getDouble("com.example.lonCo");
                mv.getController().setCenter(new GeoPoint(latCo, lonCo));
            }
        }
        if(requestCode==2)
        {
            if (resultCode==RESULT_OK) {
                Bundle extras = intent.getExtras();
            }
        }
    }
    public void onStart(){
        super.onStart();
        SharedPreferences prefs =PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        double lat = Double.parseDouble(prefs.getString("lat","50.9"));
    }
}