package com.wanyue.demo.view;

import android.widget.Toast;
import com.wanyue.demo.R;
import com.wanyue.demo.RxViewProxy;

public class ViewProxy3 extends RxViewProxy {
    @Override
    public int getLayoutId() {
        return R.layout.view_3;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if(isVisibleToUser){
            Toast.makeText(getActivity(),"ViewProxy3的setUserVisibleHint调用了",Toast.LENGTH_SHORT).show();
        }
        super.setUserVisibleHint(isVisibleToUser);
    }
}
