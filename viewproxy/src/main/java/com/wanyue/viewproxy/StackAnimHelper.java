package com.wanyue.viewproxy;

import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;

public class StackAnimHelper implements IStackAnimer {
    private static int mDurcation=300;
    private Animation mBackOutAnim;
    private Animation mBackInAnim;
    private Animation mForwardOutAnim;
    private Animation mForwardInAnim;
    private Interpolator mInterpolator;

    @Override
    public void startBackOutAnim(View view){
        if(view==null){
            return;
        }
        if(mInterpolator==null){
           mInterpolator= new AccelerateDecelerateInterpolator();
        }

        if(mBackOutAnim==null){
            mBackOutAnim = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                    Animation.RELATIVE_TO_SELF, 1.0f,
                    Animation.RELATIVE_TO_SELF, 0.0f,
                    Animation.RELATIVE_TO_SELF, 0.0f);
            mBackOutAnim.setInterpolator(mInterpolator);
            mBackOutAnim.setDuration(mDurcation);
        }
        view.startAnimation(mBackOutAnim);
    }

    @Override
    public void startBackInAnim(View view){
        if(view==null){
            return;
        }
        if(mInterpolator==null){
           mInterpolator= new AccelerateDecelerateInterpolator();
        }

        if(mBackInAnim==null){
            mBackInAnim = new TranslateAnimation(Animation.RELATIVE_TO_SELF, -1.0f,
                    Animation.RELATIVE_TO_SELF, 0.0f,
                    Animation.RELATIVE_TO_SELF, 0.0f,
                    Animation.RELATIVE_TO_SELF, 0.0f);
            mBackInAnim.setInterpolator(mInterpolator);
            mBackInAnim.setDuration(mDurcation);
        }
        view.startAnimation(mBackInAnim);
    }

    @Override
    public void startForwardOutAnim(View view){
        if(view==null){
            return;
        }
        if(mInterpolator==null){
           mInterpolator= new AccelerateDecelerateInterpolator();
        }

        if(mForwardOutAnim==null){
            mForwardOutAnim = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                    Animation.RELATIVE_TO_SELF, -1.0f,
                    Animation.RELATIVE_TO_SELF, 0.0f,
                    Animation.RELATIVE_TO_SELF, 0.0f);
            mForwardOutAnim.setDuration(mDurcation);
            mForwardOutAnim.setInterpolator(mInterpolator);
        }
        view.startAnimation(mForwardOutAnim);
    }

    @Override
    public void startForwardInAnim(View view){
        if(view==null){
            return;
        }
        if(mInterpolator==null){
           mInterpolator= new AccelerateDecelerateInterpolator();
        }
        if(mForwardInAnim==null){
            mForwardInAnim = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 1.0f,
                    Animation.RELATIVE_TO_SELF, 0.0f,
                    Animation.RELATIVE_TO_SELF, 0.0f,
                    Animation.RELATIVE_TO_SELF, 0.0f);
            mForwardInAnim.setDuration(mDurcation);
            mForwardInAnim.setInterpolator(mInterpolator);
        }
        view.startAnimation(mForwardInAnim);
    }



    public void setForwardOutAnim(Animation forwardOutAnim) {
        mForwardOutAnim = forwardOutAnim;
    }

    public void setForwardInAnim(Animation forwardInAnim) {
        mForwardInAnim = forwardInAnim;
    }
}
