package com.qf.wisdomTree.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.qf.wisdomTree.data.BaseData;
import lombok.Data;

@Data
@TableName("t_greenhouse")
public class Greenhouse extends BaseData {


    @TableId(type = IdType.AUTO)
    private Integer  greenhouseId;

    private String   greenhouseName;

    private String   greenhouseType;

    private Integer  greenhouseStatus;

    private String   contact;

    private String   contactPhone;

    private String   province;

    private String   city;

    private String   county;

    private Double   area;

    private String   remark;



}
