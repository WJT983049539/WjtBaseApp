package com.privatee.wjtbaseapp.A_V.activity;

import android.view.View;

import com.privatee.mylibrary.Base.BaseActivity;
import com.privatee.wjtbaseapp.Bean.User;
import com.privatee.wjtbaseapp.Bean.UserTest;
import com.privatee.wjtbaseapp.Factory_design.Factory;
import com.privatee.wjtbaseapp.Factory_design.FactoryA;
import com.privatee.wjtbaseapp.Factory_design.FactoryB;
import com.privatee.wjtbaseapp.Factory_design.product;
import com.privatee.wjtbaseapp.R;
import com.privatee.wjtbaseapp.obsever_design.Boy;
import com.privatee.wjtbaseapp.obsever_design.Girl;
import com.privatee.wjtbaseapp.obsever_design.Observable;
import com.privatee.wjtbaseapp.obsever_design.Obsever;
import com.privatee.wjtbaseapp.obsever_design.Postman;

/**
 * 构建者模式练习和观察者模式
 * @author wjt
 * @date 2019/8/23 18:33
 * @contact 983049539@qq.com
 */
public class BuilderModelExerciseActivity extends BaseActivity {
    @Override
    public String setNowActivityName() {
        return "构建者模式练习";
    }

    @Override
    public int setLayout() {
        return R.layout.layout_activity_builder;
    }

    @Override
    public void inintView() {

    }

    @Override
    public void inintData() {
      UserTest userTest=new UserTest.UserBuilder("zhangsan","zhaowu").age(20).phone("353").address("335").builder();

      test();
    }

    private void test() {
        Observable postman=new Postman();
        Obsever boy=new Boy("路飞");
        Obsever girl=new Girl("娜美");
        postman.add(boy);
        postman.add(girl);
        postman.notify("快递到了");


        /**
         * 测试工程模式
         *
         */
            Factory factory=new FactoryA();//具体工厂类
            product product=factory.create();//得到具体产品
            product.show();
    }

    @Override
    public void onClick(View v) {

    }
}
