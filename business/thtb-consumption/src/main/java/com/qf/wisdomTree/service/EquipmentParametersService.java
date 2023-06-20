package com.qf.wisdomTree.service;

import com.qf.wisdomTree.dto.Equipment;
import com.qf.wisdomTree.dto.EquipmentParameters;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qf.wisdomTree.dto.GreenhouseConfig;

/**
* @author 昏晨
* @description 针对表【t_equipment_parameters】的数据库操作Service
* @createDate 2023-06-16 14:26:50
*/
public interface EquipmentParametersService extends IService<EquipmentParameters> {

    Integer getGreenhouseIdByEquipmentId(Integer equipmentId);

    GreenhouseConfig getGreenhouseConfigById(Integer greenhouseId);

    Equipment getEquipmentNameById(Integer equipmentId);
}
