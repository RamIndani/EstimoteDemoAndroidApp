package com.learninghorizon.estimoreairport;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.estimote.sdk.Beacon;
import com.estimote.sdk.SystemRequirementsChecker;
import com.learninghorizon.estimoreairport.observers.Observee;
import com.learninghorizon.estimoreairport.observers.Observer;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Observee{
    TextView beacons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        beacons = (TextView) findViewById(R.id.beacons);
        ((Observer)getApplication()).register(this);
    }



    @Override
    protected void onResume() {
        super.onResume();

        SystemRequirementsChecker.checkWithDefaultDialogs(this);
    }

    @Override
    public void update(List<Beacon> beaconsList) {
        if(null != this.beacons && null != beaconsList) {
            StringBuilder beaconData = new StringBuilder();
            for(Beacon beacon : beaconsList) {
                beaconData
                        .append("UUID : ")
                        .append(beacon.getProximityUUID())
                        .append("\n")
                        .append("Major : ")
                        .append(beacon.getMajor())
                        .append("\n")
                        .append("Minor : ")
                        .append(beacon.getMinor())
                        .append("\n");
            }
            beacons.setText(beaconData);
        }
    }
}
