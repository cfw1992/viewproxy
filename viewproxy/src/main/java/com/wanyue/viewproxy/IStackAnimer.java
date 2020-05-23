package com.wanyue.viewproxy;

import android.view.View;

public interface IStackAnimer {
    public void startBackOutAnim(View view);
    public void startBackInAnim(View view);
    public void startForwardOutAnim(View view);
    public void startForwardInAnim(View view);

}
