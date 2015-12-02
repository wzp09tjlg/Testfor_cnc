package com.zhongxin.home.testfor_cnc.utils;

import com.zhongxin.home.testfor_cnc.bean.Person;

import java.util.Comparator;

/**
 * Created by Walter on 2015/7/25.
 */
public class Compare<T> implements Comparator<T> {

    @Override
    public int compare(T t1, T t2) {
        Person person1 = (Person)t1;
        Person person2 = (Person)t2;

        if(person1.getAge()>person2.getAge())
        {return 1;}
        else if(person1.getAge()==person2.getAge())
        {
            return 0;
        }else {
            return -1;
        }
    }
}
