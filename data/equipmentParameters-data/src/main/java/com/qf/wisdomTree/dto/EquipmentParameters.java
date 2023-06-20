package com.qf.wisdomTree.dto;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("t_equipment_parameters")
public class EquipmentParameters implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer equipmentId;

    private String equipmentName;


    private String equipmentType;


    private String greenhouseName;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss" ,timezone = "GMT+8")
    private Date createTime;


    private Integer temperature;


    private Integer humidity;
}
