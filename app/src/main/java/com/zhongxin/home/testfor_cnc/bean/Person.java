package com.zhongxin.home.testfor_cnc.bean;

/**
 * Created by Walter on 2015/7/25.
 * 使用了builder 来创建 对象，便于以后的维护和修改
 *
 */
public class Person {
    private int id;
    private String name;
    private int age;
    private String address;

   public Person(Builder builder){
       this.id = builder.id;
       this.name = builder.name;
       this.age = builder.age;
       this.address = builder.address;
   }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
    @Override
    public String toString() {
        return "{[id:"+id+"  name:"+name+"  age:"+age+"  address:"+address+"]}";
    }

    public static class Builder{
        public int getId() {
            return id;
        }

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public String getName() {
            return name;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public int getAge() {
            return age;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public String getAddress() {
            return address;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Person build(){
            return new Person(this);
        }

        private int id;
        private String name;
        private int age;
        private String address;
    }
}
