package com.example.a1walta34.mapping;

import android.preference.PreferenceActivity;
import android.os.Bundle;

public class MyPrefsActivity extends PreferenceActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}