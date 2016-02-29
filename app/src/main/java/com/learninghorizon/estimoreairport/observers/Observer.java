package com.learninghorizon.estimoreairport.observers;

/**
 * Created by ramnivasindani on 2/28/16.
 */
public interface Observer {

    public void register(Observee observee);
    public void notifyObservee();
}
