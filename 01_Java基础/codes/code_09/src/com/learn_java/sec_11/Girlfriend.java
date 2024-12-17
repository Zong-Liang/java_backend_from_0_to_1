package com.learn_java.sec_11;

//懒汉式：延迟加载(类的唯一实例在需要使用的时候进行创建)，节省内存空间
public class Girlfriend {
    //私有化构造器
    private Girlfriend() {
    }

    //创建类的唯一实例
    //加一个volatile可以避免指令重排
    private static volatile Girlfriend instance = null;

    //使用getInstance()方法获取当前类的实例，如果未创建，则在方法内部进行创建
//    public static synchronized GirlFriend getInstance() { //同步监视器是当前类本身
//        if (instance == null) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//
//            instance = new GirlFriend();
//        }
//        return instance;
//    }

//    public static GirlFriend getInstance() { //同步监视器是当前类本身
//        synchronized (GirlFriend.class) {
//            if (instance == null) {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//
//                instance = new GirlFriend();
//            }
////            return instance; //也可放在这
//        }
//        return instance;
//    }

    public static Girlfriend getInstance() { //同步监视器是当前类本身
        // 提高效率
        if (instance == null) {
            synchronized (Girlfriend.class) {
                if (instance == null) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    instance = new Girlfriend();
                }
            }
        }
        return instance;
    }


}
