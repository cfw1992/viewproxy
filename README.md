# 基于普通的View开发替换Fragment的思考
## 简介


Fragment是google开发出的碎片化方案,可以将界面拆分成很多的模块进行组合开发，提高了代码复用率和程序的效率。但是使用中存在一些各种各样的问题,
基于这个前提下，学习Fragment的构建思路，可以制定下更轻量，更灵活的方案，还有很关键的一点是风险可控,避免程序出现一些无法解决的问题。


 ## 简单使用说明
 ### 1.配置
           根gradle: maven{url'https://www.jitpack.io'}
           app gradle：implementation 'com.github.cfw1992:viewproxy:1.0.0'
           
 ### 2.在activity抽象基类里面,加入ViewProxyMannger,自动完成生命周期调用       
             private ViewProxyMannger mViewProxyMannger;
             public ViewProxyMannger getViewProxyMannger() {
                if(mViewProxyMannger==null){
                mViewProxyMannger=new ViewProxyMannger(this);
            }
                return mViewProxyMannger;
    }
  ### 3.如何想拦截onBackPressed和onActivityResult方法需要在activity抽象基类再加上这几句代码：
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
    
  ### 4.添加到界面布局里面
                 SwitchViewProxy switchViewProxy=new SwitchViewProxy();
                 getViewProxyMannger().addViewProxy(mVpContainer,switchViewProxy,switchViewProxy.getDefaultTag());
                 
  ### 5.ViewPager里面使用
  
                 List<BaseViewProxy>list= Arrays.asList(viewProxy1,viewProxy2,viewProxy3);
                 ViewProxyPageAdapter adapter=new ViewProxyPageAdapter(getViewProxyMannger(),list);
                 adapter.attachViewPager(mViewPager,0);  /*必须attachViewPager因为需要进行一些处理.控制setUserVisibleHint方法才能精准*/
              
  ### 6.ViewProxy实现内部导航
  ####   A.直接添加    
  
                SwitchViewProxy switchViewProxy=new SwitchViewProxy();
                IStackAnimer stackAnimer=new StackAnimHelper(); //实现切换动画接口，StackAnimHelper是自带默认效果
                getViewProxyMannger().addStack(mVpContainer,switchViewProxy,switchViewProxy.getDefaultTag(),stackAnimer);
                
  ####   B.内部调用startViewProxy会自动切换到栈模式:                 
                ArrayMap<String,Object>arrayMap=new ArrayMap<>();
                arrayMap.put("index",mIndex+1);
                startViewProxy(arrayMap,SwitchViewProxy.class,null); //调用这句方法自动生成栈   
                
                
  
                 
    
    
