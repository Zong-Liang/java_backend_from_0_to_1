package com.tlias.controller;

import com.tlias.anno.Log;
import com.tlias.pojo.Dept;
import com.tlias.pojo.Result;
import com.tlias.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/depts")
@Slf4j
public class DeptController {

    @Autowired
    private DeptService deptService;

    //查询所有部门数据
    @GetMapping
    public Result list() {
        log.info("查询全部部门数据");
        List<Dept> deptList = deptService.listAll();
        return Result.success(deptList);
    }


    //根据ID删除部门
    @Log
    @DeleteMapping
    public Result delete(@RequestParam(value = "id", required = false) Integer id) {
        log.info("根据ID删除部门: {}", id);
        deptService.deleteById(id);
        return Result.success();
    }

    //新增部门
    @Log
    @PostMapping
    public Result add(@RequestBody Dept dept) {
        log.info("新增部门:{}", dept);
        deptService.add(dept);
        return Result.success();
    }

    //根据ID查询部门
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable("id") Integer id) {
        log.info("根据ID查询部门 : {}", id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    //修改部门
    @Log
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        log.info("修改部门:{}", dept);
        deptService.updateById(dept);
        return Result.success();
    }
}
