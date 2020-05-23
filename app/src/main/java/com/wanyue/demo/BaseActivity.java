package com.wanyue.demo;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.wanyue.viewproxy.ViewProxyMannger;

public class BaseActivity extends AppCompatActivity {
 private ViewProxyMannger mViewProxyMannger;

  public ViewProxyMannger getViewProxyMannger() {
        if(mViewProxyMannger==null){
           mViewProxyMannger=new ViewProxyMannger(this);
        }
        return mViewProxyMannger;
    }


    /*如果要在ViewProxy里面调用到onActivityResult可以在项目重点的基类Activity添加这句*/
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (mViewProxyMannger != null) {
            mViewProxyMannger.onActivityResult(requestCode, resultCode, data);
        }
    }


    /*如果要在ViewProxy里面想拦截onBackPressed方法需要添加这下面这句话*/
    @Override
    public void onBackPressed() {
        if (mViewProxyMannger != null && mViewProxyMannger.onBackPressed()) {
            return;
        }
        super.onBackPressed();
    }



}
