package com.privatee.wjtbaseapp.A_V.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.privatee.wjtbaseapp.R;

/**
 * 自定义组件：购买数量，带减少增加按钮
 * @auther wjt
 * @date 2019/5/19
 */
public class AmountView extends LinearLayout implements View.OnClickListener {

    private static final String TAG = "AmountView";
    private String amount = "0"; //购买数量
    private float goods_storage = 50; //商品库存
    float vva=0;
    private float num= (float) 0.5;
    private OnAmountChangeListener mListener;

    private TextView etAmount;
    private Button btnDecrease;
    private Button btnIncrease;

    public AmountView(Context context) {
        this(context, null);
    }

    public AmountView(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.view_amount, this);
        etAmount = (TextView) findViewById(R.id.etAmount);
        btnDecrease = (Button) findViewById(R.id.btnDecrease);
        btnIncrease = (Button) findViewById(R.id.btnIncrease);
        btnDecrease.setOnClickListener(this);
        btnIncrease.setOnClickListener(this);

        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.AmountView);
        int btnWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AmountView_btnWidth, LayoutParams.WRAP_CONTENT);
        int tvWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AmountView_tvWidth, 80);
        int tvTextSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AmountView_tvTextSize, 0);
        int btnTextSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AmountView_btnTextSize, 0);
        obtainStyledAttributes.recycle();

        LayoutParams btnParams = new LayoutParams(btnWidth, LayoutParams.MATCH_PARENT);
        btnDecrease.setLayoutParams(btnParams);
        btnIncrease.setLayoutParams(btnParams);
        if (btnTextSize != 0) {
            btnDecrease.setTextSize(TypedValue.COMPLEX_UNIT_PX, btnTextSize);
            btnIncrease.setTextSize(TypedValue.COMPLEX_UNIT_PX, btnTextSize);
        }

        LayoutParams textParams = new LayoutParams(tvWidth, LayoutParams.MATCH_PARENT);
        etAmount.setLayoutParams(textParams);
        if (tvTextSize != 0) {
            etAmount.setTextSize(tvTextSize);
        }
    }

    public void setOnAmountChangeListener(OnAmountChangeListener onAmountChangeListener) {
        this.mListener = onAmountChangeListener;
    }

    public void setGoods_storage(int goods_storage) {
        this.goods_storage = goods_storage;
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.btnDecrease) {
            if(isNumeric0(amount)){
                vva=Float.valueOf(amount);
                if (vva > 0&&vva%0.5==0) {
                    vva=vva-num;
                    etAmount.setText(vva + " ℃");
                    amount=String.valueOf(vva);
                }else{
                    amount="0";
                    etAmount.setText("0"+" ℃");
                }
            }else{
                amount="off";
                etAmount.setText("off"+" ℃");
            }

        } else if (i == R.id.btnIncrease) {
            if (isNumeric0(amount)) {
                vva=Float.valueOf(amount);
                if (vva < goods_storage&&vva%0.5==0) {
                    vva=vva+num;
                    etAmount.setText(vva + " ℃");
                    amount=String.valueOf(vva);
                }else {
                    etAmount.setText(goods_storage + " ℃");
                    amount=String.valueOf(goods_storage);
                }
            }else{
                amount="off";
                etAmount.setText(amount+" ℃");
            }
        }
        etAmount.clearFocus();
        if (mListener != null) {
            mListener.onAmountChange(this, amount);
        }
    }




    public interface OnAmountChangeListener {
        void onAmountChange(View view, String amount);
    }

    public void setValue(String value){
        if(isNumeric0(value)){
            float value2=Float.valueOf(value);
            if (value2 > goods_storage) {
                amount=String.valueOf(goods_storage);
                etAmount.setText(goods_storage + " ℃");
                return;
            }else if(value2 %0.5==0){
                amount=value;
                etAmount.setText(value + " ℃");
            }
        }else{
            if(value.equals("off")){
                etAmount.setText(value);
            }
        }

        if (mListener != null) {
            mListener.onAmountChange(this, amount);
        }
    }


    //判断是否位数字
    public static boolean isNumeric0(String str){
        String reg = "^[0-9]+(.[0-9]+)?$";
        return str.matches(reg);
    }
}