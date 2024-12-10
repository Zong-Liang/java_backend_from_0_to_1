package com.learn_java;

public class UseStudent_03 {
    public static void main(String[] args) {
        //创建Student[]
        Student_03[] students =new Student_03[20];
        //给数组元素赋值
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student_03();
            //给每一个学生属性赋值
            students[i].id = i + 1;
            students[i].grade = (int) (Math.random() * 6 + 1);
            students[i].score = (int) (Math.random() * 101);
        }
        //打印3年级的学生信息
        StudentUtil_03 studentUtil = new StudentUtil_03();
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
