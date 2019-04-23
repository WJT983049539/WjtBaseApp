package com.privatee.wjtbaseapp.A_V.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.privatee.mylibrary.Base.BaseActivity;
import com.privatee.mylibrary.utils.TaoTools;
import com.privatee.mylibrary.utils.ToastManager;
import com.privatee.wjtbaseapp.CustomView.CustonDialog;
import com.privatee.wjtbaseapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 自定义dialog
 *
 * @auther wjt
 * @date 2019/4/22
 */
public class CustomDialogActivity extends BaseActivity {
    Button button2;

    @Override
    public String setNowActivityName() {
        return null;
    }

    @Override
    public int setLayout() {
        return R.layout.layout_custom_dialogview;
    }

    @Override
    public void inintView() {
        button2=fvbi(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustonDialog custonDialog=new CustonDialog(CustomDialogActivity.this);
                custonDialog.setMessage("這是中間顯示的信息");
                custonDialog.setTitle("提示");
                custonDialog.setYesOnclickListener("確定", new CustonDialog.onYesOnclickListener() {
                    @Override
                    public void onYesOnclick() {
                        ToastManager.getInstnce().showToast(CustomDialogActivity.this,"點擊了確定按鈕");
                    }
                });
                custonDialog.setNoOnclickListener("取消", new CustonDialog.onNoOnclickListener() {
                    @Override
                    public void onNoClick() {
                        ToastManager.getInstnce().showToast(CustomDialogActivity.this,"點擊了取消按鈕");
                    }
                });
                custonDialog.show();
            }
        });
    }

    @Override
    public void inintData() {

    }

    @Override
    public void onClick(View v) {

    }



}
