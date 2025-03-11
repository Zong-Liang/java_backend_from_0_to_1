package com.tlias.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class ClazzQueryParam {
    private Integer page = 1; //页码
    private Integer pageSize = 10; //每页展示记录数
    private String name; //姓名
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin; //时间-开始
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end; //时间-结束
}
