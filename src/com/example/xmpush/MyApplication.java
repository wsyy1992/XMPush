package com.example.xmpush;

import java.util.List;

import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.mipush.sdk.Logger;
import com.xiaomi.mipush.sdk.MiPushClient;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.util.Log;

public class MyApplication extends Application {
	private static final String APP_ID = "2882303761517494400";
	private static final String APP_KEY = "5311749482400";
	private static final String TAG = "com.example.xmpush";

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		// 初始化push推送服务
		if (shouldInit()) {
			MiPushClient.registerPush(this, APP_ID, APP_KEY);
		}
		// 打开日志
		LoggerInterface newLogger = new LoggerInterface() {
			@Override
			public void setTag(String tag) {
				// ignore
			}

			@Override
			public void log(String content, Throwable t) {
				Log.d(TAG, content, t);
			}

			@Override
			public void log(String content) {
				Log.d(TAG, content);
			}
		};
		Logger.setLogger(this, newLogger);

		// Logger.disablePushFileLog(this);//关闭日志
	}

	private boolean shouldInit() {
		ActivityManager am = ((ActivityManager) getSystemService(Context.ACTIVITY_SERVICE));
		List<RunningAppProcessInfo> processInfos = am.getRunningAppProcesses();
		String mainProcessName = getPackageName();
		int myPid = Process.myPid();

		for (RunningAppProcessInfo info : processInfos) {
			if (info.pid == myPid && mainProcessName.equals(info.processName)) {
				return true;
			}
		}
		return false;
	}

}
