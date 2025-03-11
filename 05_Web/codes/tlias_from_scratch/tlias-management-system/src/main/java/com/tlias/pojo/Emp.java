package com.tlias.pojo;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

/**
 * 员工表
 * @TableName emp
 */
@Data
public class Emp {
    /**
     * ID,主键
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别, 1:男, 2:女
     */
    private Integer gender;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 职位, 1 班主任, 2 讲师 , 3 学工主管, 4 教研主管, 5 咨询师
     */
    private Integer job;

    /**
     * 薪资
     */
    private Integer salary;

    /**
     * 头像
     */
    private String image;

    /**
     * 入职日期
     */
    private LocalDate entryDate;

    /**
     * 部门ID
     */
    private Integer deptId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    //封装部门名称
    private String deptName;
    //封装工作经历信息
    private List<EmpExpr> exprList;
}
