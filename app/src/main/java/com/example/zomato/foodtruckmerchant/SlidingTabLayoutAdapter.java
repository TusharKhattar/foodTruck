package com.example.zomato.foodtruckmerchant;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by zomato on 09/10/15.
 */
public class SlidingTabLayoutAdapter extends FragmentPagerAdapter {
    public SlidingTabLayoutAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new ScheduleTaskFragment();
    }

    @Override
    public int getCount() {
        return 7;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return " MONDAY";
            case 1:
                return " TUESDAY";
            case 2:
                return "WEDNESDAY";
            case 3:
                return "THURSDAY";
            case 4:
                return "FRIDAY";
            case 5:
                return "SATURDAY";
            case 6:
                return "SUNDAY";
        }
        return null;

    }


}
