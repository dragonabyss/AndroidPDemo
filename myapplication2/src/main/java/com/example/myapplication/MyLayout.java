package com.example.myapplication;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.WindowInsets;
import android.widget.LinearLayout;

/**
 * Created by kaggle on 18-3-24.
 */

public class MyLayout extends LinearLayout {
    private static final String TAG = "MyLayout";

    public MyLayout(Context context) {
        super(context);
    }

    public MyLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @RequiresApi(api = 28)
    @Override
    public WindowInsets onApplyWindowInsets(WindowInsets insets) {
        DisplayCutout displayCutout = insets.getDisplayCutout();
        int bottom = displayCutout.getSafeInsetBottom();
        int top = displayCutout.getSafeInsetTop();
        int left = displayCutout.getSafeInsetLeft();
        int right = displayCutout.getSafeInsetRight();
        Log.d(TAG, "onApplyWindowInsets: bottom: " + bottom + " top: " + top + " left: " + left + " right: " + right);
        return super.onApplyWindowInsets(insets);
    }
}
