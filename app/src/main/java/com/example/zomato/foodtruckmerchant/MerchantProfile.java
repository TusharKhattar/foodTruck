package com.example.zomato.foodtruckmerchant;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

public class MerchantProfile extends AppCompatActivity implements View.OnClickListener, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener,LocationListener {

    protected GoogleApiClient mGoogleApiClient;

    public static final long UPDATE_INTERVAL_IN_MILLISECONDS = 10000;

    public static final long FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS = UPDATE_INTERVAL_IN_MILLISECONDS / 2;

    protected LocationRequest mLocationRequest;

    protected Location mCurrentLocation;

    protected Location mPreviousLocation;

    protected LocationChangedListener mLocationChangedListener;

    public interface LocationChangedListener{
        void sendLocations(String oldLocation,String newLocation);
    }

    public void setLocationChangedListener(LocationChangedListener mLocationChangedListener) {
        this.mLocationChangedListener = mLocationChangedListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button shareLocation_button= (Button) findViewById(R.id.shareLocation);
        shareLocation_button.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent i=new Intent(this,LocationActivity2.class);
        startActivity(i);
    }

    protected synchronized void buildGoogleApiClient(){
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        createLocationRequest();
    }


    @Override
    public void onConnected(Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    protected void createLocationRequest() {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(UPDATE_INTERVAL_IN_MILLISECONDS);
        mLocationRequest.setFastestInterval(FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    }

    protected void startLocationUpdates() {
        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
    }

    @Override
    public void onLocationChanged(Location location) {
        mPreviousLocation=mCurrentLocation;
        mCurrentLocation = location;
        String prevLatLng="{Lat:"+mPreviousLocation.getLatitude()+",Lng:"+mCurrentLocation.getLongitude()+"}";
        String currentLatLng="{Lat:"+mPreviousLocation.getLatitude()+",Lng:"+mCurrentLocation.getLongitude()+"}";
        mLocationChangedListener.sendLocations(prevLatLng,currentLatLng);

    }

}
