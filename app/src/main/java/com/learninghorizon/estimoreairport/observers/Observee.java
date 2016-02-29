package com.learninghorizon.estimoreairport.observers;

import com.estimote.sdk.Beacon;

import java.util.List;

/**
 * Created by ramnivasindani on 2/28/16.
 */
public interface Observee {

    public void update(List<Beacon> beacons);
}
