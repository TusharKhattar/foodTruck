package com.example.zomato.foodtruckmerchant;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zomato.foodtruckmerchant.com.example.zomato.tabs.SlidingTabLayout;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

public class Weekly_Schedule_Slider_TabLayout extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SlidingTabLayoutAdapter slidingTabLayoutAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly__schedule__slider__tab_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        slidingTabLayoutAdapter = new SlidingTabLayoutAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(slidingTabLayoutAdapter);

//        PagerSlidingTabStrip tabStrip= (PagerSlidingTabStrip) findViewById(R.id.tabs);
//        tabStrip.setViewPager(mViewPager);

//        TabLayout tabLayout= (TabLayout) findViewById(R.id.slidingTabs);
//        tabLayout.setupWithViewPager(mViewPager);

//        SlidingTabLayout tabs;
//        tabs= (SlidingTabLayout) findViewById(R.id.tabs);
//        tabs.setViewPager(mViewPager);

        SmartTabLayout viewPagerTab = (SmartTabLayout) findViewById(R.id.viewpagertab);
        viewPagerTab.setViewPager(mViewPager);




//        tabStrip.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });

    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_weekly__schedule__slider__tab_layout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
//    public class SectionsPagerAdapter extends FragmentPagerAdapter {
//
//        public SectionsPagerAdapter(FragmentManager fm) {
//            super(fm);
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            // getItem is called to instantiate the fragment for the given page.
//            // Return a PlaceholderFragment (defined as a static inner class below).
//            return PlaceholderFragment.newInstance(position + 1);
//        }
//
//        @Override
//        public int getCount() {
//            // Show 3 total pages.
//            return 7;
//        }
//
//        @Override
//        public CharSequence getPageTitle(int position) {
//            switch (position) {
//                case 0:
//                    return " MONDAY";
//                case 1:
//                    return " TUESDAY";
//                case 2:
//                    return "WEDNESDAY";
//                case 3:
//                    return "THURSDAY";
//                case 4:
//                    return "FRIDAY";
//                case 5:
//                    return "SATURDAY";
//                case 6:
//                    return "SUNDAY";
//            }
//            return null;
//        }
//    }
//
//    /**
//     * A placeholder fragment containing a simple view.
//     */
//    public static class PlaceholderFragment extends Fragment implements View.OnClickListener {
//        /**
//         * The fragment argument representing the section number for this
//         * fragment.
//         */
//        private static final String ARG_SECTION_NUMBER = "section_number";
//
//        /**
//         * Returns a new instance of this fragment for the given section
//         * number.
//         */
//        public static PlaceholderFragment newInstance(int sectionNumber) {
//            PlaceholderFragment fragment = new PlaceholderFragment();
//            Bundle args = new Bundle();
//            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
//            fragment.setArguments(args);
//            return fragment;
//        }
//
//        public PlaceholderFragment() {
//        }
//
//        EditText checkPoint1;
//        EditText checkPoint2;
//        EditText checkPoint3;
//        EditText checkPoint4;
//        EditText checkPoint5;
//        Button addCheckPoint;
//        int countCheckPoints=2;
//
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                                 Bundle savedInstanceState) {
//            View rootView = inflater.inflate(R.layout.fragment_weekly__schedule__slider__tab_layout, container, false);
//
//            checkPoint1= (EditText) rootView.findViewById(R.id.checkpoint1);
//            checkPoint2= (EditText) rootView.findViewById(R.id.checkpoint2);
//            checkPoint3= (EditText) rootView.findViewById(R.id.checkpoint3);
//            checkPoint4= (EditText) rootView.findViewById(R.id.checkpoint4);
//            checkPoint5= (EditText) rootView.findViewById(R.id.checkpoint5);
//
//            addCheckPoint= (Button) rootView.findViewById(R.id.addCheckPoint);
//            addCheckPoint.setOnClickListener(this);
//
//            return rootView;
//        }
//
//        @Override
//        public void onClick(View v) {
//            countCheckPoints++;
//            if(countCheckPoints<6){
//                Toast.makeText(getContext(), "No more checkboxes can be added", Toast.LENGTH_LONG).show();
//                if(countCheckPoints==3){
//                    Log.i("qqqqqq", "" + countCheckPoints);
//                    checkPoint3.setVisibility(View.VISIBLE);
//                }
//                else if(countCheckPoints==4){
//
//                    Log.i("qqqqqq",""+countCheckPoints);
//                    checkPoint4.setVisibility(View.VISIBLE);
//                }
//
//                else if(countCheckPoints==5){
//
//                    Log.i("qqqqqq",""+countCheckPoints);
//                    checkPoint5.setVisibility(View.VISIBLE);
//                }
//
//                else{
//                    Toast.makeText(getContext(),"No more checkboxes can be added",Toast.LENGTH_LONG).show();
//                }
//
//
//            }
//        }
//    }

}
