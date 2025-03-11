package com.tlias.controller;

import com.tlias.pojo.*;
import com.tlias.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Slf4j
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    //分页查询
    @GetMapping
    public Result page(StudentQueryParam studentQueryParam) {
        log.info("分页查询: {}", studentQueryParam);
        PageResult<Student> pageResult = studentService.pageRead(studentQueryParam);
        return Result.success(pageResult);
    }

    //新增学生信息
    @PostMapping
    public Result save(@RequestBody Student student){
        log.info("新增学生信息: {}", student);
        studentService.saveStudent(student);
        return Result.success();
    }

    //删除学生信息
    @DeleteMapping("/{ids}")
    public Result delete(@RequestParam List<Integer> ids) {
        log.info("删除学生信息: {}", ids);
        studentService.deleteStudent(ids);
        return Result.success();
    }

    //根据ID查询学生信息
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
        log.info("根据ID查询学生信息: {}", id);
        Student student = studentService.getStudentById(id);
        return Result.success(student);
    }

    //修改学生信息
    @PutMapping
    public Result update(@RequestBody Student student) {
        log.info("修改学生信息: {}", student);
        studentService.updateStudent(student);
        return Result.success();
    }

    //违纪处理
    @PutMapping("/violation/{id}/{score}")
    public Result violationHandle(@PathVariable Integer id , @PathVariable Integer score){
        studentService.violationHandle(id, score);
        return Result.success();
    }
}
