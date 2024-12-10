package com.learn_java;

public class UseKid_03 {
    public static void main(String[] args) {
        Kid_03 kid = new Kid_03();

        kid.setGender(1);
        kid.setSalary(30000.0);
        kid.setAge(25);

        kid.employed();
        kid.maleOrFemale();
        kid.getAge();

        //多态性
        Mankind_03 mankindKid = new Kid_03();
        //虚拟方法调用：编译看左边，运行看右边
        //无法调用kid里的特有的属性和方法
        mankindKid.employed();

        //向下转型
        Kid_03 kid1 = (Kid_03) mankindKid;
        kid1.getInfo();
    }
}
