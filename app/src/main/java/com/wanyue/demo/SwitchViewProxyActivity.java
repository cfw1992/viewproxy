package com.wanyue.demo;

import android.animation.LayoutTransition;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.wanyue.demo.view.SwitchViewProxy;


/*实现类似fragment的内部导航切换，返回等功能*/
public class SwitchViewProxyActivity extends BaseActivity {
    private FrameLayout mVpContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_view_proxy);
        init();
    }

    private void init() {
      mVpContainer = (FrameLayout) findViewById(R.id.vp_container);
      LayoutTransition transition = new LayoutTransition();

      mVpContainer.setLayoutTransition(transition);
      SwitchViewProxy switchViewProxy=new SwitchViewProxy();
      getViewProxyMannger().addViewProxy(mVpContainer,switchViewProxy,switchViewProxy.getDefaultTag());
    }



    public void back(View view){
        finish();
    }
}
