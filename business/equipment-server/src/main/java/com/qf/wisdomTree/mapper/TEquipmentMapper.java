package com.qf.wisdomTree.mapper;

import com.qf.wisdomTree.dto.Equipment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author 昏晨
* @description 针对表【t_equipment】的数据库操作Mapper
* @createDate 2023-06-13 19:58:51
* @Entity com.qf.wisdomTree.dto.TEquipment
*/
public interface TEquipmentMapper extends BaseMapper<Equipment>{


    String selectGreenhouseNameById(Integer greenhouseId);
}

