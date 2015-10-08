package com.example.zomato.foodtruckmerchant;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class LocationActivityFinal extends AppCompatActivity {


    private static  final String TAG="pppppppp";

    public static final long UPDATE_TIME_IN_MILLISECONDS=10000;

    public static final long FASTEST_UPDATE_TIME_IN_MILLISECONDS=15000;

    protected static final String REQUESTING_LOCATION_UPDATE_KEY="";

    String LOCATION_key="";

    String LAST_UPDATED_TIME_STRING_KEY="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_activity_final);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        buildGoogleApiCLient();

    }

    public void buildGoogleApiCLient(){};

}
