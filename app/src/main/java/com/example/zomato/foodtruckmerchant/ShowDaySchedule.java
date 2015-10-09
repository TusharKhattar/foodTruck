package com.example.zomato.foodtruckmerchant;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ShowDaySchedule extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_day_schedule);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng gurgaon = new LatLng(28.4700, 77.0300);
        LatLng noida=new LatLng(28.5700,77.3200);
        LatLng faridabad=new LatLng(28.4211,77.3078);
        LatLng indiaGate=new LatLng(28.6129,77.2293);
        mMap.addMarker(new MarkerOptions().position(gurgaon).title("Gurgaon").snippet("We will be here by 12 noon!! So wait for us!! "));
        mMap.addMarker(new MarkerOptions().position(noida).title("Noida").snippet("We will be here by 3 pm!! So wait for us!! "));
        mMap.addMarker(new MarkerOptions().position(faridabad).title("Faridabad").snippet("We will be here by 6 pm!! So wait for us!! "));
        mMap.addMarker(new MarkerOptions().position(indiaGate).title("India Gate").snippet("We will be here by 9 pm!! So wait for us!! "));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(indiaGate));
    }
}
