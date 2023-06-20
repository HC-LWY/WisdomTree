package com.qf.wisdomTree.dto;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.qf.wisdomTree.data.BaseData;
import lombok.Data;

@TableName("t_equipment_type")
@Data
public class EquipmentType extends BaseData {

    @TableId(type = IdType.AUTO)
    private Integer equipmentTypeId;

    private String equipmentTypeName;
}
