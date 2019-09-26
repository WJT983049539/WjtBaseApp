package com.privatee.wjtbaseapp.A_V.activity;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import com.privatee.wjtbaseapp.R;

/**
 * 底部弹出框
 * 默认是在底部隐藏着，只显示一小部分，可以通过手势操作将其完全展开，或者完全隐藏，或者部分隐藏
 * @author wjt
 * @date 2019/8/13 16:45
 * @contact 983049539@qq.com
 */
public class BottomSheetActivity extends AppCompatActivity  {
    private Button SheetClick;
    BottomSheetBehavior mBehavior;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottomsheet);
        inintView();
    }
    //按钮改变现实隐藏
    public void SheetClick(View view) {

        /**
         * STATE_HIDDEN: 隐藏状态。默认是false，可通过app:behavior_hideable属性设置。
         * STATE_COLLAPSED: 折叠关闭状态。可通过app:behavior_peekHeight来设置显示的高度,peekHeight默认是0。
         * STATE_DRAGGING: 被拖拽状态
         * STATE_SETTLING: 拖拽松开之后到达终点位置（collapsed or expanded）前的状态。
         * STATE_EXPANDED: 完全展开的状态。
         */
        if (mBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            mBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        } else {
            mBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        }
    }

    /**
     * sheetFragment
     * @param view
     */
    public void Sheetfragment(View view){

    }

    public void SheetDialog(View view){
        BottomSheetDialog dialog=new BottomSheetDialog(this);
        View v = getLayoutInflater().inflate(R.layout.bottom_sheet_dialog, null);
        dialog.setContentView(v);
        resetLp(v);
        dialog.show();
    }

    public void inintView() {
        View bottomSheet = findViewById(R.id.bootom_sheet);
        //得到悬浮窗 bottomSheet的窗口，然后 得到BottomSheet 的Behavior;
        mBehavior = BottomSheetBehavior.from(bottomSheet);
        mBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                //bottomsheet状态改变
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                //bottomsheet滑动拖拽改变slideoffest做动画
            }
        });
    }

    /**
     * 问题，bottomsheetdialog默认显示高度256dp,不完全显示，如果想要完全显示，处理的办法
     * 1.通过bottomsheetdialog中contentview得到parentView，通过parentview得到bottomsheetbehavior
     * 2.测量bottomsheetdialog布局中的content的高度，设置peekhight
     * 3.设置bottomsheetdialog的contentview对应的父布局coordinatorlayout的grivity为gravity top  gravity horizontal
     */
    public void resetLp(View v) {
        View parent = (View) v.getParent();
        BottomSheetBehavior behavior = BottomSheetBehavior.from(parent);
        v.measure(0, 0);
        behavior.setPeekHeight(v.getMeasuredHeight());
        CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) parent.getLayoutParams();
        lp.gravity = Gravity.TOP | Gravity.CENTER_HORIZONTAL;
        parent.setLayoutParams(lp);

    }
}
