package com.qf.wisdomTree.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.wisdomTree.dto.Equipment;
import com.qf.wisdomTree.dto.EquipmentParameters;
import com.qf.wisdomTree.dto.GreenhouseConfig;
import com.qf.wisdomTree.service.EquipmentParametersService;
import com.qf.wisdomTree.mapper.EquipmentParametersMapper;
import org.springframework.stereotype.Service;

/**
* @author 昏晨
* @description 针对表【t_equipment_parameters】的数据库操作Service实现
* @createDate 2023-06-16 14:26:50
*/
@Service
public class EquipmentParametersServiceImpl extends ServiceImpl<EquipmentParametersMapper, EquipmentParameters>
    implements EquipmentParametersService{

    @Override
    public Integer getGreenhouseIdByEquipmentId(Integer equipmentId) {



        return baseMapper.selectGreenhouseIdByEquipmentId(equipmentId);
    }

    @Override
    public GreenhouseConfig getGreenhouseConfigById(Integer greenhouseId) {
        return baseMapper.getGreenhouseConfigById(greenhouseId);
    }

    @Override
    public Equipment getEquipmentNameById(Integer equipmentId) {
        return baseMapper.selectEquipmentNameById(equipmentId);
    }
}




