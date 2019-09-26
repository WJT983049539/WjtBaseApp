package com.privatee.wjtbaseapp.A_helper;

import android.graphics.Rect;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

/**
 * 类的作用：
 * 包名 com.privatee.wjtbaseapp.A_helper
 * 邮箱 983049539@qq.com
 * Created by WJT on  2018-09-25 17:59.
 * 修改历史:
 */
public class SpacesItemDecoration extends RecyclerView.ItemDecoration {

    private int space;

    public SpacesItemDecoration(int space) {
        this.space=space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left=space;
        outRect.right=space;
        outRect.bottom=space;
        if(parent.getChildAdapterPosition(view)==0){
            outRect.top=space;
        }
    }
}

