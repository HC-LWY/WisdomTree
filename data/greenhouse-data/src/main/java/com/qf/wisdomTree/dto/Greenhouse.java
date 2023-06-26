package com.qf.wisdomTree.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.qf.wisdomTree.data.BaseData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("t_greenhouse")
@ApiModel
public class Greenhouse extends BaseData {


    @TableId(type = IdType.AUTO)
    private Integer  greenhouseId;

    @ApiModelProperty(value = "大棚名称")
    private String   greenhouseName;

    @ApiModelProperty(value = "大棚类型")
    private String   greenhouseType;

    @ApiModelProperty(value = "大棚状态",example = "1")
    private Integer  greenhouseStatus;

    @ApiModelProperty(value = "联系人")
    private String   contact;

    @ApiModelProperty(value = "联系人电话")
    private String   contactPhone;

    @ApiModelProperty(value = "大棚所属省")
    private String   province;

    @ApiModelProperty(value = "大棚所属市")
    private String   city;

    @ApiModelProperty(value = "大棚所属区")
    private String   county;

    @ApiModelProperty(value = "大棚占地面积",example = "134")
    private Double   area;

    @ApiModelProperty(value = "大棚简介")
    private String   remark;



}
