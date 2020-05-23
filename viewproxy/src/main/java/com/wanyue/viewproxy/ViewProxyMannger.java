package com.wanyue.viewproxy;

import android.arch.lifecycle.LifecycleObserver;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresPermission;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;

import java.lang.ref.PhantomReference;
import java.lang.ref.WeakReference;

public class ViewProxyMannger extends BaseProxyMannger{
    protected BaseViewProxy mRequsetResultViewProxy;
    private boolean mShouldOnStartJudgeVisibiy;

    public ViewProxyMannger(AppCompatActivity activity) {
        super(activity);
        activity.getLifecycle().addObserver(new LifeObserver() {

        });
    }

    /*是否需要在onstart方法去判断是否调用 ViewProxy setUserVisibleHint方法*/
    public void setShouldOnStartJudgeVisibiy(boolean shouldOnStartJudgeVisibiy) {
        mShouldOnStartJudgeVisibiy = shouldOnStartJudgeVisibiy;
    }

    /*获取初始化inflater*/
    @Override
    public LayoutInflater getLayoutInflater() {
        if(mLayoutInflater==null){
           mLayoutInflater= LayoutInflater.from(mActivity);
        }
        return mLayoutInflater;
    }


    //*观察activity生命周期*//*
    @Override
    protected void watchActivityLife(int state) {
        super.watchActivityLife(state);
       switch (mCurrentActivityState){
           case LifeObserver.CREATE:
               onCreate();
               break;
           case LifeObserver.START:
              onStart();
               break;
           case LifeObserver.RESUME:
               onResume();
               break;
           case LifeObserver.PAUSE:
               onPause();
               break;
           case LifeObserver.STOP:
               onStop();
               break;
           case LifeObserver.DESTROY:
               onDestroy();
               break;
           default:
               break;
       }
    }

    @Override
    public void onStart() {
        super.onStart();
        if(mShouldOnStartJudgeVisibiy&&mUserVisibleViewProxy!=null){
           mUserVisibleViewProxy.setUserVisibleHint(true);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(mRequsetResultViewProxy!=null){
           mRequsetResultViewProxy.onActivityResult(requestCode,resultCode,data);
        }
           mRequsetResultViewProxy=null;
    }



    /*请求acitivy，并携带参数*/
     @Override
     protected  void startActivityForResult(@RequiresPermission Intent intent, int requestCode, BaseViewProxy baseViewProxy){
        mRequsetResultViewProxy=baseViewProxy;
        if(mActivity!=null){
          mActivity.startActivityForResult(intent,requestCode);
        }
    }

}
