package com.wanyue.viewproxy;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Log;

public class LifeObserver implements LifecycleObserver {
    private static final String TAG="LifeObserver";
    public static final int CREATE=1;
    public static final int START=2;
    public static final int RESUME=3;
    public static final int PAUSE=4;
    public static final int STOP=5;
    public static final int DESTROY=6;
    protected int mState;


    public LifeObserver(){

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreated(){
        Log.d(TAG, "onCreated: ");
        mState=CREATE;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart(){
        Log.d(TAG, "onStart: ");
        mState=START;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume(){
        Log.d(TAG, "onResume: ");
        mState=RESUME;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause(){
        Log.d(TAG, "onPause: ");
        mState=CREATE;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop(){
        Log.d(TAG, "onStop: ");
        mState=CREATE;
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestory(){//此方法可以有参数，但类型必须如两者之一(LifecycleOwner owner,Lifecycle.Event event)
        Log.d(TAG, "ONDESTROY: ");
        mState=DESTROY;
    }
}