package com.rick.testdemo;

import android.app.Application;

import com.jeremyliao.liveeventbus.LiveEventBus;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;
import com.rick.testdemo.network.RetrofitUtility;
import com.rick.testdemo.utlis.BlueToothUtils;
import com.rick.testdemo.utlis.DataBaseUtils;
import com.rick.testdemo.utlis.MMKVUtils;

/**
 * package: MyApplication
 * author: Rick
 * date: 2020-04-03 11:10
 * desc:
 */


public class MyApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        initialize();
    }

    private void initialize() {
        RetrofitUtility.getInstance().init();
        MMKVUtils.init(getApplicationContext());
        LiveEventBus.config();
        //CrashHandler.getInstance().init(getApplicationContext());
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)
                .methodCount(0)
                .methodOffset(7)
                .tag(Constant.TAG)
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));
        DataBaseUtils.getInstance().init(getApplicationContext());
        BlueToothUtils.getInstance().init(getApplicationContext());
    }
}
