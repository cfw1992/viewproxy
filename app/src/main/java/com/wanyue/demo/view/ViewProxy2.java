package com.wanyue.demo.view;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.wanyue.demo.R;
import com.wanyue.demo.RxViewProxy;

import static android.app.Activity.RESULT_OK;

public class ViewProxy2 extends RxViewProxy {
    private TextView mTvContent;


    @Override
    public int getLayoutId() {
        return R.layout.view_2;
    }

    @Override
    protected void initView(ViewGroup contentView) {
        super.initView(contentView);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),ResultActivity.class);
                startActivityForResult(intent,ResultActivity.MESSGAE);
            }
        });
        mTvContent = (TextView) findViewById(R.id.tv_content);
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if(isVisibleToUser){
            Toast.makeText(getActivity(),"ViewProxy2的setUserVisibleHint调用了",Toast.LENGTH_SHORT).show();
        }
        super.setUserVisibleHint(isVisibleToUser);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==ResultActivity.MESSGAE&&resultCode==RESULT_OK){
           String message= data.getStringExtra("message");
            mTvContent.setText(message);
        }
    }
}
