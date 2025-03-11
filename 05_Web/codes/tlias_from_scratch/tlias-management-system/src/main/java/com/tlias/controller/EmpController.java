package com.tlias.controller;

import com.tlias.pojo.Emp;
import com.tlias.pojo.EmpQueryParam;
import com.tlias.pojo.PageResult;
import com.tlias.pojo.Result;
import com.tlias.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emps")
@Slf4j
public class EmpController {

    @Autowired
    private EmpService empService;

    //分页查询
    @GetMapping
    public Result page(EmpQueryParam empQueryParam) {
        log.info("分页查询: {}", empQueryParam);
        PageResult<Emp> pageResult = empService.pageRead(empQueryParam);
        return Result.success(pageResult);
    }


    //新增员工
    @PostMapping
    public Result save(@RequestBody Emp emp) throws Exception {
        log.info("新增员工: {}", emp);
        empService.saveEmp(emp);
        return Result.success();
    }


    //删除员工
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids) {
        log.info("删除员工: {}", ids);
        empService.deleteEmp(ids);
        return Result.success();
    }


    //根据ID查询员工
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
        log.info("根据ID查询员工: {}", id);
        Emp emp = empService.getEmpById(id);
        return Result.success(emp);
    }


    //修改员工
    @PutMapping
    public Result update(@RequestBody Emp emp) {
        log.info("修改员工: {}", emp);
        empService.updateEmp(emp);
        return Result.success();
    }


    //查询所有员工
    @GetMapping("/list")
    public Result list() {
        log.info("查询所有员工数据");
        List<Emp> empList = empService.listAll();
        return Result.success(empList);
    }
}
