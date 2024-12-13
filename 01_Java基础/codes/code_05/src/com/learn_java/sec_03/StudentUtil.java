package com.learn_java.sec_03;

public class StudentUtil {
    //打印指定年级学生的信息
    public void printInfoWithGrade(Student[] students, int grade) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].grade == 3) {
                System.out.println(students[i].printInfo());
            }
        }
    }

    //遍历数组
    public void iterateStudent(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].printInfo());
        }
    }

    //使用冒泡排序进行学生成绩排序
    public void sortStudent(Student[] students) {
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = 0; j < students.length - 1 - i; j++) {
                //注意不能只交换学生成绩
                if (students[j].score > students[j + 1].score) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
    }
}
