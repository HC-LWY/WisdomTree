package com.qf.wisdomTree.mapper;

import com.qf.wisdomTree.dto.Equipment;
import com.qf.wisdomTree.dto.EquipmentParameters;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.wisdomTree.dto.GreenhouseConfig;

/**
* @author 昏晨
* @description 针对表【t_equipment_parameters】的数据库操作Mapper
* @createDate 2023-06-16 14:26:50
* @Entity com.qf.wisdomTree.dto.EquipmentParameters
*/
public interface EquipmentParametersMapper extends BaseMapper<EquipmentParameters> {

    Integer selectGreenhouseIdByEquipmentId(Integer equipmentId);

    GreenhouseConfig getGreenhouseConfigById(Integer greenhouseId);

    Equipment selectEquipmentNameById(Integer equipmentId);
}




