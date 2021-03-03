package com.joker.fake.base;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;

import com.joker.fake.broadcast.ExitMainActivityReceiver;
import com.joker.fake.config.Joker;
import com.joker.fake.utils.Tips;
import com.permissionx.guolindev.PermissionX;

import androidx.annotation.Nullable;

/**
 * @author Joker
 * @since 2021/03/02
 */
public abstract class PermissionActivity extends DataBindingActivity {

    private final ExitMainActivityReceiver exitMainActivityReceiver = new ExitMainActivityReceiver();
    private static final String EXIT_MAIN_ACTIVITY_ACTION = "action.exit.MainActivity";
    private static final Handler HANDLER = Joker.getHandler();

    String[] permissions = new String[]{
//            Manifest.permission.WRITE_EXTERNAL_STORAGE,
//            Manifest.permission.READ_EXTERNAL_STORAGE
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //注册广播
        IntentFilter filter = new IntentFilter();
        filter.addAction(EXIT_MAIN_ACTIVITY_ACTION);
        registerReceiver(exitMainActivityReceiver, filter);
        requestPermission();
    }

    protected void requestPermission(){
        PermissionX.init(this)
                .permissions(permissions)
                .onExplainRequestReason((scope, deniedList, beforeRequest) -> {
                    String message = "需要您同意以下权限才能正常使用";
                    scope.showRequestReasonDialog(deniedList, message, "确定", "取消");
                })
                .onForwardToSettings((scope, deniedList) -> {
                    String message = "需要您同意以下权限才能正常使用";
                    scope.showForwardToSettingsDialog(deniedList, message, "确定");
                })
                .request((allGranted, grantedList, deniedList) -> {
                    if (!allGranted) {
                        Tips.showLong("您拒绝了所需权限\n程序即将退出");
                        //发送广播
                        HANDLER.postDelayed(()->{
                            Intent intentBroadcast = new Intent();
                            intentBroadcast.setAction(EXIT_MAIN_ACTIVITY_ACTION);
                            sendBroadcast(intentBroadcast);
                        }, 1000);
                    }
                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //注销广播
        unregisterReceiver(exitMainActivityReceiver);
    }
}
