package com.privatee.wjtbaseapp.Bean;

/**
 * @author wjt
 * @date 2019/8/15 8:31
 * @contact 983049539@qq.com
 */
public class RecyclerViewPartUpdateBean {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    String name;
    String age;

    @Override
    public boolean equals(Object object) {

        if (this == object) {
            return true;
        }
        if (object instanceof RecyclerViewPartUpdateBean) {
            RecyclerViewPartUpdateBean student = (RecyclerViewPartUpdateBean) object;
            return this.age.equals(student.age)
                    && this.name.equals(student.name);
        }
        return super.equals(object);
    }
}
