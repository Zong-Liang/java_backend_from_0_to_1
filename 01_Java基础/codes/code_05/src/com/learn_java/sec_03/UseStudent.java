package com.learn_java.sec_03;

public class UseStudent {
    public static void main(String[] args) {
        //创建Student[]
        Student[] students =new Student[20];
        //给数组元素赋值
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student();
            //给每一个学生属性赋值
            students[i].id = i + 1;
            students[i].grade = (int) (Math.random() * 6 + 1);
            students[i].score = (int) (Math.random() * 101);
        }
        //打印3年级的学生信息
        StudentUtil studentUtil = new StudentUtil();
        studentUtil.printInfoWithGrade(students, 3);
        //遍历数组并打印
        System.out.println("before sort: ");
        studentUtil.iterateStudent(students);
        //使用冒泡排序进行学生成绩排序
        studentUtil.sortStudent(students);
        System.out.println("after sort: ");
        studentUtil.iterateStudent(students);
    }
}
