package com.tlias.pojo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 学员表
 * @TableName student
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    /**
     * ID,主键
     */
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 学号
     */
    private String no;

    /**
     * 性别, 1: 男, 2: 女
     */
    private Integer gender;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 是否来自于院校, 1:是, 0:否
     */
    private Integer isCollege;

    /**
     * 联系地址
     */
    private String address;

    /**
     * 最高学历, 1:初中, 2:高中, 3:大专, 4:本科, 5:硕士, 6:博士
     */
    private Integer degree;

    /**
     * 毕业时间
     */
    private LocalDate graduationDate;

    /**
     * 班级ID, 关联班级表ID
     */
    private Integer clazzId;

    /**
     * 违纪次数
     */
    private Short violationCount;

    /**
     * 违纪扣分
     */
    private Short violationScore;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    //封装班级名称
    private String clazzName;
}
