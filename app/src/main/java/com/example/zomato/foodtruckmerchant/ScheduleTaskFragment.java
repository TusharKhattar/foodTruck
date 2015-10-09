package com.example.zomato.foodtruckmerchant;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;



public class ScheduleTaskFragment extends Fragment  {

    EditText checkPoint1;
    EditText checkPoint2;
    EditText checkPoint3;
    EditText checkPoint4;
    EditText checkPoint5;
    LinearLayout ll1;
    LinearLayout ll2;
    LinearLayout ll3;
    LinearLayout ll4;
    LinearLayout ll5;
    Button addCheckPoint;
    int countCheckPoints=2;

    public ScheduleTaskFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v=inflater.inflate(R.layout.fragment_weekly__schedule__slider__tab_layout,container,false);
        checkPoint1= (EditText) v.findViewById(R.id.checkpoint1);
        checkPoint2= (EditText) v.findViewById(R.id.checkpoint2);
        checkPoint3= (EditText) v.findViewById(R.id.checkpoint3);
        checkPoint4= (EditText) v.findViewById(R.id.checkpoint4);
        checkPoint5= (EditText) v.findViewById(R.id.checkpoint5);

        ll1= (LinearLayout) v.findViewById(R.id.ll1);
        ll2= (LinearLayout) v.findViewById(R.id.ll2);
        ll3= (LinearLayout) v.findViewById(R.id.ll3);
        ll4= (LinearLayout) v.findViewById(R.id.ll4);
        ll5= (LinearLayout) v.findViewById(R.id.ll5);

        addCheckPoint= (Button) v.findViewById(R.id.addCheckPoint);
        addCheckPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countCheckPoints++;
                Toast.makeText(getContext(),"You can add upto only 5 checkpoints",Toast.LENGTH_LONG).show();
                if(countCheckPoints<6){
                    if(countCheckPoints==3){
                        Log.i("qqqqqq", "" + countCheckPoints);
                        ll3.setVisibility(View.VISIBLE);
                    }
                    else if(countCheckPoints==4){

                        Log.i("qqqqqq",""+countCheckPoints);
                        ll4.setVisibility(View.VISIBLE);
                    }

                    else if(countCheckPoints==5){

                        Log.i("qqqqqq",""+countCheckPoints);
                        ll5.setVisibility(View.VISIBLE);
                    }

                    else{
                        Toast.makeText(getContext(),"No more checkboxes can be added",Toast.LENGTH_LONG).show();
                    }


                }
            }
        });

        Button seeMap= (Button) v.findViewById(R.id.seeMap);
        seeMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getContext(),ShowDaySchedule.class);
                startActivity(i);
            }
        });
        return v;
    }


}
