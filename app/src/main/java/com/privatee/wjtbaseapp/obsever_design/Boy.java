package com.privatee.wjtbaseapp.obsever_design;

import android.util.Log;
import android.widget.Toast;

import com.privatee.wjtbaseapp.A_tools.GlobalToast;

/**
 * 定义具体观察者
 */
public class Boy implements Obsever{
    private String name;
    public Boy(String name){this.name=name;}

    @Override
    public void uptade(String message) {
        GlobalToast.show("男孩收到快递，屁颠屁颠的去取快递", Toast.LENGTH_LONG);
        Log.d("test","男孩收到快递，屁颠屁颠的去取快递");
    }
}
