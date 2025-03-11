package com.tlias.service;


import com.tlias.pojo.PageResult;
import com.tlias.pojo.Student;
import com.tlias.pojo.StudentQueryParam;

import java.util.List;

public interface StudentService {

    //分页查询
    PageResult<Student> pageRead(StudentQueryParam studentQueryParam);

    //新增学生信息
    void saveStudent(Student student);

    //删除学生信息
    void deleteStudent(List<Integer> ids);

    //根据ID查询学生信息
    Student getStudentById(Integer id);

    //修改学生信息
    void updateStudent(Student student);

    //违纪处理
    void violationHandle(Integer id, Integer score);
}
