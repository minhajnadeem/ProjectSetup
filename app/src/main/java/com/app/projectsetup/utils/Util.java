package com.app.projectsetup.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

import com.app.projectsetup.MainActivity;

/**
 * Created by minhaj nadeem on 22/07/2018.
 */
public class Util {

    /**
     * start HomeActivity. if activity instance exists in task then bring that task on foreground and handle intent in onNewIntent
     */
    public static void startHomeActivity(Activity activity, Bundle extras){
        Intent intent = new Intent(activity, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtras(extras);
        activity.startActivity(intent);
    }

    /**
     *
     * show any view
     */
    public static void showView(View view){
        view.setVisibility(View.VISIBLE);
    }
    /**
     *
     * hide any view
     */
    public static void hideView(View view){
        view.setVisibility(View.GONE);
    }

    /**
     *
     * hide system UI(nav bar and status bar) to enable full screen
     */
    public static void hideSystemUI(Activity context) {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = context.getWindow().getDecorView();
        int uiOptions =
                View.SYSTEM_UI_FLAG_IMMERSIVE |
                // Set the content to appear under the system bars so that the
                // content doesn't resize when the system bars hide and show.
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                        // Hide the nav bar and status bar
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_FULLSCREEN;

        decorView.setSystemUiVisibility(uiOptions);

    }

    /**
     *
     * show back system UI(nav bar and status bar)
     */
    // Shows the system bars by removing all the flags
    // except for the ones that make the content appear under the system bars.
    public static void showSystemUI(Activity context) {
        View decorView = context.getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }

    /**
     * device width
     */
    public static int getDeviceWidth(Activity context){
        DisplayMetrics displayMetrics = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    /**
     * device height
     */
    public static int getDeviceHeight(Activity activity){
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    /**
     * enable or disable view
     */
    public static void setEnabled(View view,boolean enabled){
        if (enabled){
            view.setEnabled(enabled);
            view.setAlpha(1f);
        }else {
            view.setEnabled(enabled);
            view.setAlpha(0.5f);
        }
    }
}
