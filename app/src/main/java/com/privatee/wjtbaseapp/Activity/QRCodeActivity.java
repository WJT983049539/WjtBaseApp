package com.privatee.wjtbaseapp.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.privatee.mylibrary.Base.BaseActivity;
import com.privatee.mylibrary.XingRQ.activity.CaptureActivity;
import com.privatee.mylibrary.XingRQ.encoding.EncodingUtils;
import com.privatee.wjtbaseapp.R;

/**
 * 类的作用：二维码
 * Created by WJT on  2018/4/23 15:49.
 */

public class QRCodeActivity extends BaseActivity{
    private TextView resultTextView;
    private EditText qrStrEditText;
    private ImageView qrImgImageView;
    private CheckBox mCheckBox;
    private Button scanBarCodeButton;
    @Override
    public String setNowActivityName() {
        return "二维码";
    }

    @Override
    public int setLayout() {
        return R.layout.layout_activity_qrcode;
    }

    @Override
    public void inintView() {
        resultTextView = fvbi(R.id.tv_scan_result);
        qrStrEditText = fvbi(R.id.et_qr_string);
        qrImgImageView = fvbi(R.id.iv_qr_image);
        mCheckBox = fvbi(R.id.logo);
        scanBarCodeButton = fvbi(R.id.btn_scan_barcode);
    }

    @Override
    public void inintData() {
        scanBarCodeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //打开扫描界面扫描条形码或二维码
                Intent openCameraIntent = new Intent(QRCodeActivity.this, CaptureActivity.class);
                startActivityForResult(openCameraIntent, 0);
            }
        });
        Button generateQRCodeButton = (Button) this.findViewById(R.id.btn_add_qrcode);
        generateQRCodeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String contentString = qrStrEditText.getText().toString();
                if (!contentString.equals("")) {
                    //根据字符串生成二维码图片并显示在界面上，第二个参数为图片的大小（350*350）
                    Bitmap qrCodeBitmap = EncodingUtils.createQRCode(contentString, 350, 350,
                            mCheckBox.isChecked() ?
                                    BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher) :
                                    null);
                    qrImgImageView.setImageBitmap(qrCodeBitmap);
                } else {
                    Toast.makeText(QRCodeActivity.this, "Text can not be empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            String scanResult = bundle.getString("result");
            resultTextView.setText(scanResult);
        }
    }
}
