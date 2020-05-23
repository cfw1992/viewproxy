package com.wanyue.demo;

import android.support.annotation.CallSuper;
import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.util.Log;

import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.RxLifecycle;
import com.trello.rxlifecycle2.android.FragmentEvent;
import com.trello.rxlifecycle2.android.RxLifecycleAndroid;
import com.wanyue.viewproxy.BaseViewProxy;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

public  abstract class RxViewProxy extends BaseViewProxy implements LifecycleProvider<FragmentEvent> {
    private String TAG="RxViewProxy";

    private final BehaviorSubject<FragmentEvent> lifecycleSubject = BehaviorSubject.create();

    @Override
    @NonNull
    @CheckResult
    public final Observable<FragmentEvent> lifecycle() {
        return lifecycleSubject.hide();
    }

    @Override
    @NonNull
    @CheckResult
    public final <T> LifecycleTransformer<T> bindUntilEvent(@NonNull FragmentEvent event) {
        return RxLifecycle.bindUntilEvent(lifecycleSubject, event);
    }

    @Override
    @NonNull
    @CheckResult
    public final <T> LifecycleTransformer<T> bindToLifecycle() {
        return RxLifecycleAndroid.bindFragment(lifecycleSubject);
    }

    @Override
    @CallSuper
    public void onAttach(android.app.Activity activity) {
        super.onAttach(activity);
        lifecycleSubject.onNext(FragmentEvent.ATTACH);
    }

    @Override
    @CallSuper
    public void onCreate() {
        super.onCreate();
        lifecycleSubject.onNext(FragmentEvent.CREATE);
    }



    @Override
    @CallSuper
    public void onStart() {
        super.onStart();
        lifecycleSubject.onNext(FragmentEvent.START);
    }

    public String getString(int stringId){
        return getResources().getString(stringId);
    }

    public String getString(int stringId, Object...objectArg){
        return getResources().getString(stringId);
    }

    @Override
    @CallSuper
    public void onResume() {
        super.onResume();
        lifecycleSubject.onNext(FragmentEvent.RESUME);
    }

    @Override
    @CallSuper
    public void onPause() {
        lifecycleSubject.onNext(FragmentEvent.PAUSE);
        super.onPause();
    }

    @Override
    @CallSuper
    public void onStop() {
        lifecycleSubject.onNext(FragmentEvent.STOP);
        super.onStop();
        Log.d(TAG,this.getClass().getSimpleName()+"-->onStop()");
    }


    /*绑定生命周期在销毁的时候,以下两种都可以用，效果是一样的*/
    public <T> Observable<T> bindClycleInOnDestory(Observable<T>observable) {
        return observable.compose(this.<T>bindUntilEvent(FragmentEvent.DESTROY));
    }

    /*绑定生命周期在销毁的时候,*/
    public final <T> LifecycleTransformer<T> bindUntilOnDestoryEvent() {
        return bindUntilEvent(FragmentEvent.DESTROY);
    }


    @Override
    @CallSuper
    public void onDestroy() {
        lifecycleSubject.onNext(FragmentEvent.DESTROY);
        super.onDestroy();
    }
}
