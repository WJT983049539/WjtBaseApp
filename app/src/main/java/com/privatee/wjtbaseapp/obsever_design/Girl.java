package com.privatee.wjtbaseapp.obsever_design;

import android.util.Log;
import android.widget.Toast;

import com.privatee.wjtbaseapp.A_tools.GlobalToast;

public class Girl implements Obsever{
    private String name;
    public Girl(String name){this.name=name;}
    @Override
    public void uptade(String message) {
        GlobalToast.show("女孩收到快递，让男朋友去取快递", Toast.LENGTH_LONG);
        Log.d("test","女孩收到快递，让男朋友去取快递");
    }
}
