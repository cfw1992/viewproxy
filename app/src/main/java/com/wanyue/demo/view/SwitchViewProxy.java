package com.wanyue.demo.view;

import android.util.ArrayMap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.wanyue.demo.R;
import com.wanyue.demo.RxViewProxy;

//实现类似activity跳转逻辑
public class SwitchViewProxy extends RxViewProxy  implements View.OnClickListener {
    private Button mBack;
    private TextView mTvTitle;
    private Button mGoTo;

    private int mIndex;

    @Override
    protected void initView(ViewGroup contentView) {
        super.initView(contentView);
        mBack = (Button) findViewById(R.id.back);
        mGoTo = (Button) findViewById(R.id.goTo);
        mTvTitle = (TextView) findViewById(R.id.tv_title);

        mBack.setOnClickListener(this);
        mGoTo.setOnClickListener(this);
        Object object= getArgMap().get("index");
        if(object!=null){
            mIndex= (int) object;
        }
        mTvTitle.setText((mIndex+1)+"SwitchViewProxy");

    }

    @Override
    public int getLayoutId() {
        return R.layout.view_switch_view;
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        int id=v.getId();
        if(id==R.id.back){
            back();
        }else if(id==R.id.goTo){
            goTo();
        }
    }

    /*跳转*/
    private void goTo() {
        ArrayMap<String,Object>arrayMap=new ArrayMap<>();
        arrayMap.put("index",mIndex+1);
        startViewProxy(arrayMap,SwitchViewProxy.class,null); //调用这句方法自动生成栈
    }

    /*返回*/
    private void back() {
        popStack();
    }
}
