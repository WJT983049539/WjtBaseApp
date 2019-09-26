package com.privatee.wjtbaseapp.A_V.activity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.privatee.wjtbaseapp.R;

/**
 * @author wjt
 * @date 2019/8/15 16:22
 * @contact 983049539@qq.com
 */
public class BottomSheetTestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_bottomsheettest);
        FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_lin,new BottomSheet(),"a");
        fragmentTransaction.commit();
    }
    @SuppressLint("ValidFragment")
    public static class BottomSheet extends BottomSheetDialogFragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View v = inflater.inflate(android.R.layout.simple_list_item_1, null);
            v.setBackgroundColor(Color.LTGRAY);
            v.setMinimumHeight(500);
            TextView text = (TextView) v.findViewById(android.R.id.text1);
            text.setText("zhang phil @ csdn");
            return v;
        }
    }
}
