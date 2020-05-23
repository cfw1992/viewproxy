package com.wanyue.demo.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.wanyue.demo.R;

public class ResultActivity extends AppCompatActivity {
    public static final int MESSGAE=1;
    private EditText mTvContent;
    private Button mBtnCompelete;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        mTvContent = (EditText) findViewById(R.id.tv_content);
        mBtnCompelete = (Button) findViewById(R.id.btn_compelete);
    }

    public void compelete(View view) {
        Intent intent=getIntent().putExtra("message",mTvContent.getText().toString());
        setResult(RESULT_OK,intent);
        finish();
    }
}
