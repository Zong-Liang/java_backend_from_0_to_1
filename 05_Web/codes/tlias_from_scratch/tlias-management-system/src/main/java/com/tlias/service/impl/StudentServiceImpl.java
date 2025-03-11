package com.tlias.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tlias.mapper.StudentMapper;
import com.tlias.pojo.PageResult;
import com.tlias.pojo.Student;
import com.tlias.pojo.StudentQueryParam;
import com.tlias.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentMapper studentMapper;

    //分页查询
    @Override
    public PageResult<Student> pageRead(StudentQueryParam studentQueryParam) {
        PageHelper.startPage(studentQueryParam.getPage(), studentQueryParam.getPageSize());

        List<Student> studentList = studentMapper.listByPage(studentQueryParam);

        Page<Student> studentPage = (Page<Student>) studentList;
        return new PageResult<>(studentPage.getTotal(), studentPage.getResult());
    }

    //新增学生信息
    @Override
    public void saveStudent(Student student) {
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.insertStudent(student);

    }

    //删除学生信息
    @Override
    public void deleteStudent(List<Integer> ids) {
        studentMapper.deleteStudent(ids);
    }

    //根据ID查询学生信息
    @Override
    public Student getStudentById(Integer id) {
        return studentMapper.getById(id);
    }

    //修改学生信息
    @Override
    public void updateStudent(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.updateStudent(student);

    }

    //违纪处理
    @Override
    public void violationHandle(Integer id, Integer score) {
        studentMapper.violationHandle(id, score);

    }
}
