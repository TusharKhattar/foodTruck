package com.example.zomato.foodtruckmerchant;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by zomato on 08/10/15.
 */
public class MerchantLocationReciever extends BroadcastReceiver {

    private static final String STATUS="status";

    @Override
    public void onReceive(Context context, Intent intent) {
        String choice=intent.getStringExtra(STATUS);
        if(choice.equals("whetherCatering")){
            Intent i=new Intent();
            i.setClass(context,DialogCatering.class);
            context.startActivity(i);
        }
    }
}
