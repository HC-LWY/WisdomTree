package com.qf.wisdomTree.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("t_test")
public class TUser {
    @TableId(type = IdType.AUTO)
    @Excel(name="学生Id")
    private Integer id;

    @Excel(name="学生姓名")
    private String name;

    @Excel(name="入学时间",exportFormat = "yyyy-MM-dd")
    private Date createTime;
}
