package com.lxj.xpopup.core;

import android.app.Dialog;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class BaseScreenDialog extends Dialog {

    public BaseScreenDialog(@NonNull Context context) {
        super(context);
    }

    public BaseScreenDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    public BaseScreenDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    public void reset(){

    }

}
