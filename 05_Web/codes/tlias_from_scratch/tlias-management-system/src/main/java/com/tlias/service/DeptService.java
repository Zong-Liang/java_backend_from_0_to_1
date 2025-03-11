package com.tlias.service;

import com.tlias.pojo.Dept;

import java.util.List;


public interface DeptService{
    List<Dept> listAll();

    void deleteById(Integer id);

    void add(Dept dept);

    Dept getById(Integer id);

    void updateById(Dept dept);
}
