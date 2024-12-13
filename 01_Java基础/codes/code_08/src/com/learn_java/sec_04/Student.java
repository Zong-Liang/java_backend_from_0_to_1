package com.learn_java.sec_04;

public class Student {
    int id;

    public void register1(int id) {
        if (id > 0) {
            this.id = id;
        } else {
//            System.out.println("输入的id非法");
            //手动抛出异常类的对象
//            throw new RuntimeException("输入的id非法1");
            throw new BelowZeroException1();

        }
    }

    public void register2(int id) throws Exception {
        if (id > 0) {
            this.id = id;
        } else {
//            System.out.println("输入的id非法");
            //手动抛出异常类的对象
//            throw new RuntimeException("输入的id非法");
//            throw new Exception("输入的id非法2");
//            System.out.println("此语句不能被执行");
            throw new BelowZeroException2();
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
