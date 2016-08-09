package com.mauiie.open.app;

import android.app.Application;

import com.mauiie.aech.AECHConfiguration;
import com.mauiie.aech.AECrashHelper;
import com.mauiie.aech.utils.LogUtil;

/**
 * Created by TaiJL on 2016/8/8.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//      AECrashHelper.initCrashHandler(this);

        AECrashHelper.initCrashHandler(this, new AECHConfiguration.Builder()
                .setSaveToLocal(true)
                .setReportToServer(true)
                .setReporter(new AECHConfiguration.IAECHReporter() {
                    @Override
                    public void report(Throwable ex) {
                        LogUtil.d("向服务器发送报告由你自己根据项目的环境定制实现");
                    }
                })
//              .setLocalFolderPath()//设置本地异常日志文件存储路径
                .build());
    }
}
