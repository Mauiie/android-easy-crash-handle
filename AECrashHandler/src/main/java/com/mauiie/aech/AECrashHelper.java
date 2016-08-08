package com.mauiie.aech;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;

import com.mauiie.aech.utils.LogUtil;

/**
 * Created by TaiJL on 2016/8/2.
 */
public class AECrashHelper {

    public static void initCrashHandler(Application app) {
        LogUtil.d("initCrashHandler");
        Context appContext = app.getApplicationContext();

        int pid = android.os.Process.myPid();
        ActivityManager mActivityManager = (ActivityManager) appContext.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcess : mActivityManager.getRunningAppProcesses()) {
            if (appProcess.pid == pid) {
                if (appProcess.processName.equalsIgnoreCase(appContext.getPackageName())) {
                    Thread.setDefaultUncaughtExceptionHandler(AECrashHandler.getInstance(appContext, new AECHConfiguration.Builder().build()));
                    LogUtil.d("setDefaultUncaughtExceptionHandler");
                }
            }
        }
    }

    public static void initCrashHandler(Application app,AECHConfiguration config) {
        LogUtil.d("initCrashHandler");
        Context appContext = app.getApplicationContext();

        int pid = android.os.Process.myPid();
        ActivityManager mActivityManager = (ActivityManager) appContext.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcess : mActivityManager.getRunningAppProcesses()) {
            if (appProcess.pid == pid) {
                if (appProcess.processName.equalsIgnoreCase(appContext.getPackageName())) {
                    Thread.setDefaultUncaughtExceptionHandler(AECrashHandler.getInstance(appContext,config));
                    LogUtil.d("setDefaultUncaughtExceptionHandler");
                }
            }
        }
    }

}
