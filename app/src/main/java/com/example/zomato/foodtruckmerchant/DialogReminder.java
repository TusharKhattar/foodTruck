package com.example.zomato.foodtruckmerchant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DialogReminder extends Activity implements View.OnClickListener {

    Button reminderPos;
    Button reminderNeg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_reminder);
        setFinishOnTouchOutside(false);

        reminderPos = (Button) findViewById(R.id.cater);
        reminderNeg = (Button) findViewById(R.id.notCater);

        reminderPos.setOnClickListener(this);
        reminderNeg.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v==reminderPos){
            PreferenceManager.setReminder(this,true);
        }else if(v==reminderNeg){
            PreferenceManager.setReminder(this,false);
        }
        finish();
    }
}
