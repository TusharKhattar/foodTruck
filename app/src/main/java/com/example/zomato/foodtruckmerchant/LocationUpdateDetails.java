package com.example.zomato.foodtruckmerchant;

/**
 * Created by zomato on 08/10/15.
 */
public class LocationUpdateDetails {

    private String mStartTime;
    private String mEndTime;
    private String mLatitude;
    private String mLongitude;
    private String address;

    public LocationUpdateDetails(String startTime,String endTime,String latitude,String longitude){
        mStartTime=startTime;
        mEndTime=endTime;
        mLatitude=latitude;
        mLongitude=longitude;

        convertLatLongIntoAddress(latitude,longitude);
    }

    public void convertLatLongIntoAddress(String latitude,String longitude){
        address="";
    }

    public String getAddress() {
        return address;
    }

    public String getEndTime() {
        return mEndTime;
    }

    public String getStartTime() {
        return mStartTime;
    }

    public String getLatitude() {
        return mLatitude;
    }

    public String getLongitude() {
        return mLongitude;
    }
}
