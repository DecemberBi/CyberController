package com.biykcode.cybercontroller;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import com.biykcode.cybercontroller.communication.BluetoothClient;
import com.huawei.hms.mlsdk.common.MLApplication;

public class CyberApplication extends Application {
    private static Context context;

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.context = this;
        MLApplication.getInstance().setApiKey("DAEDANu8lbSb28UrsyKcpgTWVJDDgVlWCAs9CpJBjzXQ4Z7br/2au/ykHta6JOu+Qml5kd3+GIOqfEILHDbxGbafNgpbz0h0IRBSdQ==");

        BluetoothClient.bindContext(this);

        ScreenStatusReceiver mScreenStatusReceiver = new ScreenStatusReceiver();

        IntentFilter intentFilter = new IntentFilter();

        intentFilter.addAction(Intent.ACTION_SCREEN_ON);

        intentFilter.addAction(Intent.ACTION_SCREEN_OFF);

        registerReceiver(mScreenStatusReceiver, intentFilter);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    private class ScreenStatusReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            if ( "android.intent.action.SCREEN_ON".equals(intent.getAction())) {

                BluetoothClient.getInstance().active();
            }
        }
    }
}
