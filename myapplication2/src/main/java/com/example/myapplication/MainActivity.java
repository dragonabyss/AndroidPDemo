package com.example.myapplication;

import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;

import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.w(TAG, "onCreate: test");

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        Window window = getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_ALWAYS;
        window.setAttributes(params);

        View view = findViewById(R.id.main_content);
        view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
            @RequiresApi(api = 28)
            @Override
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                DisplayCutout displayCutout = windowInsets.getDisplayCutout();
                int top = displayCutout.getSafeInsetTop();
                int bottom = displayCutout.getSafeInsetBottom();
                int left = displayCutout.getSafeInsetLeft();
                int right = displayCutout.getSafeInsetRight();
                Log.w(TAG, "onApplyWindowInsetsk: top: " + top + ", bottom: " + bottom + ", left: " + left + ", right: " + right);
                Region region = displayCutout.getBounds();
                Rect rect = region.getBounds();
                Log.w(TAG, "cutout size: top: " + rect.top + ", bottom: " + rect.bottom + ", left: " + rect.left + ", right: " + rect.right);

                return windowInsets;
            }
        });
    }
}
