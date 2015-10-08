package com.example.zomato.foodtruckmerchant;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by zomato on 08/10/15.
 */
public class PreferenceManager {

    public static final String PREF_FILE_NAME="preferences";
    public static final String IS_REMINDER_SET="isReminderSet";

    public static void setReminder(Context context, boolean isReminder){
        SharedPreferences sp=context.getSharedPreferences(PREF_FILE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putBoolean(IS_REMINDER_SET,isReminder);
        editor.commit();
    }

    public static boolean isReminderSet(Context context){
        SharedPreferences sp=context.getSharedPreferences(PREF_FILE_NAME,Context.MODE_PRIVATE);
        return sp.getBoolean(IS_REMINDER_SET,true);
    }


}
