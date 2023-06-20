package com.qf.wisdomTree.dto;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.qf.wisdomTree.data.BaseData;
import lombok.Data;

@TableName("t_greenhouse_type")
@Data
public class GreenhouseType extends BaseData {

    @TableId(type = IdType.AUTO)
    private Integer greenhouseTypeId;

    private String greenhouseTypeName;
}
