package com.learn_java.sec_05;

class Data {
    int m;
    int n;
}
public class SwapValue {
    public void swap(int m, int n) {
        int temp = m;
        m = n;
        n = temp;
    }

    public void swap1(Data data) {
        int temp = data.m;
        data.m = data.n;
        data.n = temp;
    }
    public static void main(String[] args) {
        int m = 10;
        int n = 20;
        System.out.println("before swap: " + "m=" + m + " n=" + n);  //m=10 n=20

        //交换m和n的值
        int temp = m;
        m = n;
        n = temp;
        System.out.println("after swap: " + "m=" + m + " n=" + n);  //m=20 n=10

        //调用方法
        int i = 10;
        int j = 20;
        System.out.println("before swap: " + "i=" + i + " j=" + j);  //i=10 j=20

        SwapValue swapValue = new SwapValue();
        swapValue.swap(i, j);
        System.out.println("after swap: " + "i=" + i + " j=" + j);  //i=10 j=20

        Data data = new Data();
        data.m = 10;
        data.n = 20;
        System.out.println("before swap: " + "m=" + data.m + " n=" + data.n);  //m=10 n=20
        swapValue.swap1(data);
        System.out.println("after swap: " + "m=" + data.m + " n=" + data.n);  //m=20 n=10
    }
}
