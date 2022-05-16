package com.biykcode.cybercontroller.utils;

import android.app.Activity;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;

public class PermissionUtil {
    public static void checkAndRequestPermissions(Activity activity, String[] PERMISSIONS){
        for(String permission:PERMISSIONS){
            if (!(ActivityCompat.checkSelfPermission(
                    activity, permission)
                    == PackageManager.PERMISSION_GRANTED)) {
                ActivityCompat.requestPermissions(
                        activity, PERMISSIONS, 10);
                return;
            }
        }


    }

}
