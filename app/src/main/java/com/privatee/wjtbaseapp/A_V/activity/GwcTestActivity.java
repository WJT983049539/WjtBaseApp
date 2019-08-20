package com.privatee.wjtbaseapp.A_V.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.privatee.mylibrary.Base.BaseActivity;
import com.privatee.mylibrary.DiskLruTools.ACache;
import com.privatee.mylibrary.utils.CustomProgressDialog;
import com.privatee.mylibrary.utils.TaoTools;
import com.privatee.wjtbaseapp.A_V.customview.AmountView;
import com.privatee.wjtbaseapp.Bean.TwoListBean;
import com.privatee.wjtbaseapp.R;

import java.io.FileNotFoundException;

/**
 * @auther wjt
 * @date 2019/4/18
 */
public class GwcTestActivity extends BaseActivity {
    private AmountView  mAmountView;
    private EditText editText3;
    CustomProgressDialog progressDialog;
    @Override
    public String setNowActivityName() {
        return null;
    }

    @Override
    public int setLayout() {
        return R.layout.layout_guc;
    }

    @Override
    public void inintView() {
//        TdialogUtils.getInstances().showDialog();
    }

    @Override
    public void inintData() {
        editText3=findViewById(R.id.editText3);
        final ACache aCache=ACache.get(this);
        aCache.put("123","测试一下");
        aCache.put("123","2");
        TwoListBean twoListBean=new TwoListBean();
        mAmountView = (AmountView) findViewById(R.id.amount_view);
        mAmountView.setGoods_storage(50);
        createProgress(this);
        progressDialog.setPropress(50);
        mAmountView.setOnAmountChangeListener(new AmountView.OnAmountChangeListener() {
            @Override
            public void onAmountChange(View view, String amount) {
                TaoTools.i(amount);
//                GlobalToast.show("显示"+amount,Toast.LENGTH_LONG);
                try {
                   String va= aCache.getAsString("123");
                    TwoListBean twoListBean= (TwoListBean) aCache.getAsObject("test");
                    TaoTools.i(va);
                    Editable asdasd=editText3.getText();
                    TaoTools.i(asdasd+"");
                    int a=5;
                    a=a+1;
                    progressDialog.setProgress(a);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }

    @Override
    public void onClick(View v) {

    }
    private void createProgress(Context context) {
        progressDialog= new CustomProgressDialog(context);
        progressDialog.setMax(100);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("正在下载...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                progressDialog.dismiss();
                System.exit(0);
            }
        });
        progressDialog.show();

    }
}
