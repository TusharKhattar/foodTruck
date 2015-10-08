package com.example.zomato.foodtruckmerchant;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class DialogCatering extends Activity implements View.OnClickListener {

    Button cateringPos;
    Button cateringNeg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_catering);

        cateringPos= (Button) findViewById(R.id.cater);
        cateringNeg= (Button) findViewById(R.id.notCater);

        cateringPos.setOnClickListener(this);
        cateringNeg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==cateringPos){
            StartUpdatingLocationAsyncTask startUpdatingLocationAsyncTask=new StartUpdatingLocationAsyncTask();
            //TODO get this data from the weekly schedule database.
            LocationUpdateDetails locationUpdateDetails=new LocationUpdateDetails("9:00","12:00","27.2234","34.323");
            startUpdatingLocationAsyncTask.execute(locationUpdateDetails);
            finish();
        }else if(v==cateringNeg){
            Intent i=new Intent(this,DialogReminder.class);
            startActivity(i);
            finish();
        }
    }
}
