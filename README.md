# android-easy-crash-handle
This is An Easy Android Crash Handle Lib.
you can use this in your project to collect crash , you can easily store cresh to your phone
or send to you server.

# AECrashHandler简介
Android 应用崩溃异常抓取处理工具。实现了在应用崩溃的时候抓取崩溃的异常原因，默认存贮在本地，
使用者可以任意配置本地异常日志文件存储的路径，也可按照当前项目的风格上传到自己的服务器上。

## 为什么要使用AECrashHandler？
* 集成简单，配置简单。
* 可以按照当前项目的风格来自定义存储路径和定制化上传到自己服务器。
* 便于Android 开发的小伙伴来定位自己的错误，机型适配等。

# AECrashHandler使用方法

## 下载AECrashHandler
通过Gradle抓取:

```gradle
compile 'com.mauiie.aech:AECrashHandler:0.0.1'
```


## 具体使用
1、通过gradle把AECrashHandler添加到你的项目里

2、在你的Application中添加配置AECrashHandler

```java
        //简单的配置，采用这种方式配置时，崩溃日志只会存在本地，默认存在 'sdcard'/Android/data/'youPackageName'/files/crash/ ,
        //当SD卡不存在或者状态异常时存贮在                          /data/data/'youPackageName'/crash/
        //AECrashHelper.initCrashHandler(this); 
        
        AECrashHelper.initCrashHandler(this,
                new AECHConfiguration.Builder()
                .setLocalFolderPath(FileAccessor.getFilePathName().getAbsolutePath()) //配置日志信息存储的路径
                .setReportToServer(true)                                              //开启报告服务器功能   
                .setSaveToLocal(true)                                                 //开启存储在本地功能 
                .setReporter(new AECHConfiguration.IAECHReporter() {                  //向服务器发送报告由你自己根据项目的环境定制实现
                    @Override
                    public void report(Throwable ex) {
                        com.mauiie.aech.utils.LogUtil.d("向服务器发送报告由你自己根据项目的环境定制实现");
                    }
                }).build());
```

# 权限
```xml
    <uses-permission android:name="android.permission.INTERNET"/>
    <uses-permission android:name="android.permission.MOUNT_UNMOUNT_FILESYSTEMS"/>
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
    <uses-permission android:name="android.permission.READ_PHONE_STATE"/>
```

# 混淆配置   
```properties
-keep class com.mauiie.aech.*{*;}
```

# 关于作者
* **QQ:**1203407263
* **Email:**<taijinglei@163.com>

License
=======

    Copyright 2013 Square, Inc.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
