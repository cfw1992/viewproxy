package com.wanyue.viewproxy;

import android.support.annotation.Nullable;
import java.util.LinkedList;

public class ViewProxyStack  {
    private LinkedList<BaseViewProxy> mProxyLinkedList;
    private IStackAnimer mStackAnimHelper;
    public ViewProxyStack() {

    }

    public boolean isContain(BaseViewProxy baseViewProxy){
        return mProxyLinkedList!=null&&mProxyLinkedList.contains(baseViewProxy);
    }


    public int popStack(@Nullable BaseViewProxy baseViewProxy){
        if(mProxyLinkedList==null){
           return 0;
        }
        if(mStackAnimHelper==null){
            mStackAnimHelper =new StackAnimHelper();
        }

      if(!isContain(baseViewProxy)){
          return mProxyLinkedList.size();
      }

      mStackAnimHelper.startBackOutAnim(baseViewProxy.getContentView());
      mProxyLinkedList.remove(baseViewProxy);
      int size=mProxyLinkedList.size();
      if(size==0){
         return size;
      }
        BaseViewProxy mProxyLinkedListLast=mProxyLinkedList.getLast();
        if(mProxyLinkedListLast!=null){
           mStackAnimHelper.startBackInAnim(mProxyLinkedListLast.getContentView());
           mProxyLinkedListLast.onAddAtParent();
        }
        return mProxyLinkedList.size();
    }

    public void addStack(@Nullable BaseViewProxy viewProxy){
        if(mProxyLinkedList==null){
           mProxyLinkedList= new LinkedList<BaseViewProxy>();
        }
        if(mStackAnimHelper==null){
          mStackAnimHelper =new StackAnimHelper();
        }

        if(mProxyLinkedList.size()>0){
          BaseViewProxy lastViewProxy=mProxyLinkedList.getLast();
           if(lastViewProxy==viewProxy){
               return;
           }
           mStackAnimHelper.startForwardOutAnim(lastViewProxy.getContentView());
           lastViewProxy.onRemoveAtParent();
          }
            mStackAnimHelper.startForwardInAnim(viewProxy.getContentView());
           mProxyLinkedList.add(viewProxy);
    }

    public void setStackAnimHelper(IStackAnimer stackAnimHelper) {

        mStackAnimHelper = stackAnimHelper;
    }


}
