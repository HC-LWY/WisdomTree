package com.qf.wisdomTree.dto;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.qf.wisdomTree.data.BaseData;
import lombok.Data;

@Data
@TableName("t_greenhouse_conf")
public class GreenhouseConfig extends BaseData {

    @TableId(type = IdType.AUTO)
    private Integer  id;


    private Integer  greenhouseId;


    private String   greenhouseName;


    private Double   temperatureMax;

    private Double   temperatureMin;

    private Double   humidityMax;

    private Double   humidityMin;
}
