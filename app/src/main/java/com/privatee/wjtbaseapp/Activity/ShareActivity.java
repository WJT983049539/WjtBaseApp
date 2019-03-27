package com.privatee.wjtbaseapp.Activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.privatee.mylibrary.Base.CompatibilityBaseActivity;
import com.privatee.wjtbaseapp.R;

/**
 * 类的作用：
 * Created by WJT on  2018/4/17 17:41.
 */

public class ShareActivity extends CompatibilityBaseActivity{
    private Button share_button;
    @Override
    public String setNowActivityName() {
        return "分享测试";
    }

    @Override
    public int setLayout() {
        return R.layout.activity_richtext;
    }

    @Override
    public void inintView() {
        share_button=fvbi(R.id.share_button);
        share_button.setOnClickListener(this);
    }

    @Override
    public void inintData() {

//        setTitle("设置");
//setTitleViewBg(R.drawable.ic_launcher);
    }

    @Override
    public void onClick(View view) {

        if(view.getId()==R.id.share_button){
//            showShare();

            Intent intent=new Intent(this,TwoActivity.class);
            startActivity(intent);
        }
//    }
//    private void showShare() {
//        OnekeyShare oks = new OnekeyShare();
//        //关闭sso授权
//        oks.disableSSOWhenAuthorize();
//
//        // title标题，微信、QQ和QQ空间等平台使用
//        oks.setTitle("分享");
//        // titleUrl QQ和QQ空间跳转链接
//        oks.setTitleUrl("http://sharesdk.cn");
//        // text是分享文本，所有平台都需要这个字段
//        oks.setText("我是分享文本");
//        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
//        oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
//        // url在微信、微博，Facebook等平台中使用
//        oks.setUrl("http://sharesdk.cn");
//        // comment是我对这条分享的评论，仅在人人网使用
//        oks.setComment("我是测试评论文本");
//        // 启动分享GUI
//        oks.show(this);
    }
}
