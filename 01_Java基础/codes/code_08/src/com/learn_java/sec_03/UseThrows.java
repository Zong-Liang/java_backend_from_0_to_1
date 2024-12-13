package com.learn_java.sec_03;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UseThrows {
    public static void method1() throws FileNotFoundException, IOException {
        File file = new File("hello.txt");

        FileInputStream fis = new FileInputStream(file); //java.io.FileNotFoundException

        int data = fis.read(); //java.io.IOException
        while (data != -1) {
            System.out.println((char) data);
            data = fis.read(); //java.io.IOException
        }
        fis.close(); //java.io.IOException
    }

    public static void method2() throws IOException {
        method1();
    }

    public static void method3() {
        try {
            method2();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        method3();
//        method2();
    }
}
