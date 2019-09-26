package com.privatee.wjtbaseapp.A_V.activity;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.privatee.mylibrary.Base.BaseActivity;
import com.privatee.mylibrary.utils.TaoTools;
import com.privatee.wjtbaseapp.A_tools.TestBeanDao;
import com.privatee.wjtbaseapp.Bean.TestBean;
import com.privatee.wjtbaseapp.Bean.TestStudent;
import com.privatee.wjtbaseapp.Bean.TwoListBean;
import com.privatee.wjtbaseapp.Bean.User;
import com.privatee.wjtbaseapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther wjt
 * @date 2019/4/28
 */
public class GreenDaoTestActivity extends BaseActivity {
    Button button_add;
    Button button_delete;
    Button buttonup_date;
    Button button_quere;
    RecyclerView show_list;
    @Override
    public String setNowActivityName() {
        return "greenDao测试";
    }


    @Override
    public int setLayout() {
        return R.layout.layout_greendao;
    }

    @Override
    public void inintView() {
        button_add=fvbi(R.id.button_add);
        button_delete=fvbi(R.id.button_delete);
        buttonup_date=fvbi(R.id.buttonup_date);
        button_quere=fvbi(R.id.button_quere);
        button_delete.setOnClickListener(this);
        buttonup_date.setOnClickListener(this);
        button_quere.setOnClickListener(this);
        button_add.setOnClickListener(this);
        show_list=fvbi(R.id.show_list);
    }

    @Override
    public void inintData() {

    }

    @Override
    public void onClick(View v) {
    switch (v.getId()){

        case R.id.button_add:
            TwoListBean twoListBean=new TwoListBean();
            twoListBean.setLastname("最后的名字");
            twoListBean.setValue(1);
            List<TwoListBean> twoListBeans=new ArrayList<TwoListBean>();
            twoListBeans.add(twoListBean);


            TestStudent testStudent=new TestStudent();
            testStudent.setId("2");
            testStudent.setStudentName("倒数第二个名字");
            testStudent.setListBeans(twoListBeans);

            List<TestStudent> testStudents=new ArrayList<TestStudent>();
            testStudents.add(testStudent);

            User user=new User();
            user.setAge("24");
            user.setListbean(testStudents);

            TestBean testBean=new TestBean();
            testBean.setId(1);
            testBean.setName("王江涛");
            testBean.setUser(user);
            TestBeanDao.insertTestBean(testBean);
            break;
        case R.id.button_delete:

            break;
        case R.id.buttonup_date:

            TwoListBean twoListBean2=new TwoListBean();
            twoListBean2.setLastname("我爱你");
            twoListBean2.setValue(1);
            List<TwoListBean> twoListBeans2=new ArrayList<TwoListBean>();
            twoListBeans2.add(twoListBean2);


            TestStudent testStudent2=new TestStudent();
            testStudent2.setId("2");
            testStudent2.setStudentName("倒数第二个名字");
            testStudent2.setListBeans(twoListBeans2);

            List<TestStudent> testStudents2=new ArrayList<TestStudent>();
            testStudents2.add(testStudent2);

            User user2=new User();
            user2.setAge("24");
            user2.setListbean(testStudents2);

            TestBean testBean2=new TestBean();
            testBean2.setId(1);
            testBean2.setName("史晋凤");
            testBean2.setUser(user2);
            TestBeanDao.updateTestBean(testBean2);
            break;
        case R.id.button_quere:
            List<TestBean> list=TestBeanDao.queryAll();
            TaoTools.i("lsit=="+list);
            break;
    }
    }
}
