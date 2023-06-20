package com.qf.wisdomTree.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.qf.wisdomTree.data.BaseData;
import lombok.Data;

import java.util.Date;

@TableName("t_equipment")
@Data
public class Equipment extends BaseData {

    @TableId(type = IdType.AUTO)
    private Integer equipmentId;


    private String  equipmentName;


    private Integer equipmentStatus;


    private String  equipmentType;

    private String  remark;

    private Integer greenhouseId;

    private String greenhouseName;

}
