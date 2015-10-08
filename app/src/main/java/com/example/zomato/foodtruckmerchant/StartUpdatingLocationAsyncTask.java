package com.example.zomato.foodtruckmerchant;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by zomato on 08/10/15.
 */
public class StartUpdatingLocationAsyncTask extends AsyncTask<LocationUpdateDetails,Void,Boolean> {


    @Override
    protected Boolean doInBackground(LocationUpdateDetails... params) {

        LocationUpdateDetails inputLocationUpdateDetails=params[0];

        URL url=null;
        try{
            url=new URL("http://......");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        HttpURLConnection httpURLConnection=null;

        try {
            httpURLConnection= (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(httpURLConnection==null){
            return false;
        }

        try {
            httpURLConnection.setRequestMethod("POST");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }

        httpURLConnection.setRequestProperty("Content-Type","application/json");

        JSONObject locationUpdateDetails=new JSONObject();

        JSONObject top=new JSONObject();

        try {
            locationUpdateDetails.put("startTime", inputLocationUpdateDetails.getStartTime());
            locationUpdateDetails.put("endTime", inputLocationUpdateDetails.getEndTime());
            locationUpdateDetails.put("location",inputLocationUpdateDetails.getAddress());
            top.put("locationUpdateDetail",locationUpdateDetails);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            httpURLConnection.connect();
            httpURLConnection.getOutputStream().write(top.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        InputStream inputStream=null;

        try {
            inputStream=httpURLConnection.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(inputStream==null){
            return false;
        }

        StringBuffer stringBuffer=new StringBuffer();
        String temp="";
        Scanner s=new Scanner(inputStream);
        while(s.hasNext()){
            stringBuffer.append(s.nextLine());
        }


        Log.i("json", stringBuffer.toString());
        return true;
    }
}
