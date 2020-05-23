package com.wanyue.demo.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.wanyue.demo.R;
import com.wanyue.demo.RxViewProxy;
import com.wanyue.demo.SwitchViewProxyActivity;

public class ViewProxy1 extends RxViewProxy {
    @Override
    public int getLayoutId() {
        return R.layout.view_1;
    }

    @Override
    protected void initView(ViewGroup contentView) {
        super.initView(contentView);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              startActivity(SwitchViewProxyActivity.class);
            }
        });
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if(isVisibleToUser){
           Toast.makeText(getActivity(),"ViewProxy1的setUserVisibleHint调用了",Toast.LENGTH_SHORT).show();
        }
        super.setUserVisibleHint(isVisibleToUser);
    }
}
