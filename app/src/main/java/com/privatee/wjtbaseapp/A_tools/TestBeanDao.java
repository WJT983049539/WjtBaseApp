package com.privatee.wjtbaseapp.A_tools;

import com.privatee.wjtbaseapp.BaseAppaction;
import com.privatee.wjtbaseapp.Bean.TestBean;

import java.util.List;

/**
 * @auther wjt
 * @date 2019/4/28
 */
public class TestBeanDao {
    /**
     * 添加bean
     */
    public static void insertTestBean(TestBean testBean){
        BaseAppaction.getDaoSessionInstance().getTestBeanDao().insert(testBean);
    }
    /**
     * 删除bean
     */
    public static void deleteTestBean(TestBean testBean){
        BaseAppaction.getDaoSessionInstance().getTestBeanDao().delete(testBean);
    }
    /**
     * 删除全部bean
     */
    public static void deleteAll(){
        BaseAppaction.getDaoSessionInstance().getTestBeanDao().deleteAll();
    }
    /**
     * 修改bean
     */
    public static void updateTestBean(TestBean testBean){
        BaseAppaction.getDaoSessionInstance().getTestBeanDao().update(testBean);
    }

    /**
     * 查询全部
     */
    public static List<TestBean> queryAll(){
       return BaseAppaction.getDaoSessionInstance().getTestBeanDao().loadAll();
    }
}
