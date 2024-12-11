package com.learn_java;
//Java种多态的体现：父类的引用指向子类的对象。
//多态适用性：只适用于方法，不适用于属性。
//缺点：在多态场景下，我们创建了子类对象，也加载了子类特有的属性和方法。但是由于声明为父类的引用，导致我们无法直接调用子类特有的属性和方法。
//开发中，使用父类方法做形参，是多态使用最多的场合。即使增加了新的子类，方法也无需改变，提高了扩展性，符合开闭原则。
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
