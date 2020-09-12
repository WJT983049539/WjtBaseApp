package com.privatee.wjtbaseapp.A_V.activity;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.privatee.mylibrary.Base.BaseActivity;
import com.privatee.wjtbaseapp.BaseAppaction;
import com.privatee.wjtbaseapp.R;
import com.qw.soul.permission.SoulPermission;
import com.qw.soul.permission.bean.Permission;
import com.qw.soul.permission.bean.Permissions;
import com.qw.soul.permission.callbcak.CheckRequestPermissionListener;
import com.qw.soul.permission.callbcak.CheckRequestPermissionsListener;
import com.qw.soul.permission.callbcak.GoAppDetailCallBack;

/**
 * 权限获取练习
 * @auther wjt
 * @date 2019/6/13
 */
public class PermissionTestActivity extends BaseActivity {
    Button button_singe;
    Button button_multiple;
    Button button7;
    Button tzpremission_button;
    @Override
    public String setNowActivityName() {
        return null;
    }

    @Override
    public int setLayout() {
        return R.layout.activity_permission;
    }

    @Override
    public void inintView() {
        button_singe=fvbi(R.id.button_singe);
        button_singe.setOnClickListener(this);
        button_multiple=fvbi(R.id.button_multiple);
        button_multiple.setOnClickListener(this);
        button7=fvbi(R.id.button7);
        button7.setOnClickListener(this);
        tzpremission_button=fvbi(R.id.tzpremission_button);
        tzpremission_button.setOnClickListener(this);
    }

    @Override
    public void inintData() {

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            //请求单个权限
            case R.id.button_singe:
                getPremission();
                break;
               //请求多个权限
            case R.id.button_multiple:

                SoulPermission.getInstance().checkAndRequestPermissions(
                            Permissions.build(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE),
                        //if you want do noting or no need all the callbacks you may use SimplePermissionsAdapter instead
                        new CheckRequestPermissionsListener() {
                            @Override
                            public void onAllPermissionOk(Permission[] allPermissions) {
                                Toast.makeText(PermissionTestActivity.this, allPermissions.length + "权限获取成功", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onPermissionDenied(Permission[] refusedPermissions) {
                                Toast.makeText(PermissionTestActivity.this, refusedPermissions[0].toString() +
                                        " 权限获取失败", Toast.LENGTH_SHORT).show();
                            }                       });
                getPremission2();
                break;
            case R.id.button7:

                SoulPermission.getInstance().checkAndRequestPermission(Manifest.permission.READ_CONTACTS,
                        new CheckRequestPermissionListener() {
                            @Override
                            public void onPermissionOk(Permission permission) {
                                Toast.makeText(PermissionTestActivity.this, permission.toString() +
                                        "\n is ok , you can do your operations", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onPermissionDenied(Permission permission) {
                                // see CheckPermissionWithRationaleAdapter
                                if (permission.shouldRationale()) {
                                    Toast.makeText(PermissionTestActivity.this, permission.toString() +
                                            " \n you should show a explain for user then retry ", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(PermissionTestActivity.this, permission.toString() +
                                            " \n is refused you can not do next things", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                break;
            case R.id.tzpremission_button:
                SoulPermission.getInstance().goApplicationSettings(new GoAppDetailCallBack() {
                    @Override
                    public void onBackFromAppDetail(Intent data) {
                        //if you need to know when back from app detail
//                        Utils.showMessage(view, "back from go appDetail");
                        Log.i("test","这里是在设置也手动获取到权限以后返回，回调");
                    }
                });
                break;

        }

    }
    public void getPremission(){

        //单个权限获取
        SoulPermission.getInstance().checkAndRequestPermission(Manifest.permission.ACCESS_FINE_LOCATION,
                //if you want do noting or no need all the callbacks you may use SimplePermissionAdapter instead
                new CheckRequestPermissionListener() {
                    @Override
                    public void onPermissionOk(Permission permission) {
                        Toast.makeText(PermissionTestActivity.this, permission.toString() +
                                "权限获取成功", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onPermissionDenied(Permission permission) {
                        Toast.makeText(PermissionTestActivity.this, permission.toString() +
                                "权限获取失败", Toast.LENGTH_SHORT).show();
                        //如果第一次权限获取失败,此时需要提示用户为什么需要获取这个权限
                        //用户第一次拒绝了权限,且点击了不在提醒的情况下这个值为false ,否则为true
                        if (permission.shouldRationale()) {
                            new AlertDialog.Builder(PermissionTestActivity.this).setTitle("提示").setMessage("如果你拒绝了权限,应用中的一些功能将不糊能正常使用")
                                    .setPositiveButton("授予权限", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            //用户点击以后
                                            getPremission();
                                        }
                                    }).create().show();
                        }else{
                            new AlertDialog.Builder(PermissionTestActivity.this).setTitle("提示").setMessage("权限获取失败,请您从设置页面设置允许权限！")
                                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.cancel();
                                        }
                                    })
                                    .setPositiveButton("授予权限", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            SoulPermission.getInstance().goApplicationSettings(new GoAppDetailCallBack() {
                                    @Override
                                    public void onBackFromAppDetail(Intent data) {
                                    Log.i("test","这里是在设置也手动获取到权限以后返回，回调");
                                }
                            });
                              }
                               }).create().show();
                        }
                    }
                });
    }

    public void getPremission2(){
        SoulPermission.getInstance().checkAndRequestPermissions(
                Permissions.build(Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.INTERNET,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.CAMERA
             ),
                //if you want do noting or no need all the callbacks you may use SimplePermissionsAdapter instead
                new CheckRequestPermissionsListener() {
                    @Override
                    public void onAllPermissionOk(Permission[] allPermissions) {
                        Toast.makeText(PermissionTestActivity.this, allPermissions.length + "权限获取成功", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onPermissionDenied(final Permission[] refusedPermissions) {
                        Toast.makeText(PermissionTestActivity.this, refusedPermissions[0].toString() +
                                " 权限获取失败", Toast.LENGTH_SHORT).show();

                        new AlertDialog.Builder(PermissionTestActivity.this).setTitle("提示").setMessage("如果你拒绝了权限,应用中的一些功能将不糊能正常使用")
                                .setPositiveButton("授予权限", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        //用户点击以后

                                        boolean ff=PanduanIsProhibitedPermissionDenied(refusedPermissions);
                                        if(!ff){
                                            SoulPermission.getInstance().goApplicationSettings(new GoAppDetailCallBack() {
                                                @Override
                                                public void onBackFromAppDetail(Intent data) {
                                                    Log.i("test","这里是在设置也手动获取到权限以后返回，回调");
                                                }
                                            });
                                        }else{
                                            getPremission2();
                                        }
                                    }
                                }).create().show();
                    }
                });
    }

    private Boolean PanduanIsProhibitedPermissionDenied(Permission[] refusedPermissions) {
        boolean flag=true;
        for(int i=0;i<refusedPermissions.length;i++){
            if(!refusedPermissions[i].shouldRationale()){
                flag=false;
                return flag;
            }
        }
        return flag;

    }
}
