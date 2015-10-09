package com.example.zomato.foodtruckmerchant;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.location.Location;
import android.util.Log;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MerchantLocationService extends IntentService implements FusedLocationService.LocationListener{
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_FOO = "com.example.zomato.foodtruckmerchant.action.FOO";
    private static final String ACTION_BAZ = "com.example.zomato.foodtruckmerchant.action.BAZ";

    // TODO: Rename parameters
    private static final String EXTRA_PARAM1 = "com.example.zomato.foodtruckmerchant.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "com.example.zomato.foodtruckmerchant.extra.PARAM2";

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionFoo(Context context, String param1, String param2) {
        Intent intent = new Intent(context, MerchantLocationService.class);
        intent.setAction(ACTION_FOO);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionBaz(Context context, String param1, String param2) {
        Intent intent = new Intent(context, MerchantLocationService.class);
        intent.setAction(ACTION_BAZ);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    public MerchantLocationService() {
        super("MerchantLocationService");
    }



    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionFoo(String param1, String param2) {
        // TODO: Handle action Foo
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionBaz(String param1, String param2) {
        // TODO: Handle action Baz
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private static final String STATUS="status";
    Location mOldLocation=null;
    Location mNewLocation=null;

    @Override
    protected void onHandleIntent(Intent intent) {

        while(true) {

            new FusedLocationService(getApplicationContext(), this);

            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    protected boolean isFoodTruckMoving(String oldLocation,String newLocation){
        boolean isMoving=false;
        int countToCheckPos=10000;

        while(countToCheckPos!=0) {
            if (oldLocation.equals(newLocation) && isMoving) {

            } else {
                isMoving = true;
            }
            countToCheckPos--;
        }
        return isMoving;
    }

    boolean isMoving=true;
    int count=0;
    @Override
    public void onReceiveLocation(Location location) {
        mOldLocation=mNewLocation;
        Log.i("uuuuuu","Old location : "+mOldLocation.getLatitude());
        mNewLocation=location;
        Log.i("uuuuuu","New location : "+mNewLocation.getLatitude());
        if(mOldLocation==mNewLocation){
            isMoving=false;
            count++;
        }else{
            isMoving=true;
            count=0;
        }
        if(count==10){
            Intent i = new Intent();
            i.setAction(ACTION_FOO);
            i.putExtra(STATUS, "whetherCatering");
            sendBroadcast(i);
        }

    }

    @Override
    public void onLocationDisabled(String msg) {

    }

    @Override
    public void onConnectionFailed(String msg) {

    }
}
