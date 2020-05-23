package com.wanyue.demo;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import com.wanyue.demo.view.ViewProxy1;
import com.wanyue.demo.view.ViewProxy2;
import com.wanyue.demo.view.ViewProxy3;
import com.wanyue.viewproxy.BaseViewProxy;
import com.wanyue.viewproxy.ViewProxyPageAdapter;
import java.util.Arrays;
import java.util.List;

/*实现类似FragmentAdapter效果，但是生命周期调用方法更精确*/
public class MainActivity extends BaseActivity {
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = findViewById(R.id.viewPager);

        setTitle("ViewPager可滑动");
        BaseViewProxy viewProxy1=new ViewProxy1();
        BaseViewProxy viewProxy2=new ViewProxy2();
        BaseViewProxy viewProxy3=new ViewProxy3();


        List<BaseViewProxy>list= Arrays.asList(viewProxy1,viewProxy2,viewProxy3);
        ViewProxyPageAdapter adapter=new ViewProxyPageAdapter(getViewProxyMannger(),list);
        adapter.attachViewPager(mViewPager,0);  /*必须attachViewPager因为需要进行一些处理.控制setUserVisibleHint方法能精准的执行*/
        
    }
}
