package com.qf.wisdomTree.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.qf.wisdomTree.dto.Equipment;

/**
* @author 昏晨
* @description 针对表【t_equipment】的数据库操作Service
* @createDate 2023-06-13 19:58:51
*/
public interface IEquipmentService extends IService<Equipment> {

    String getGreenhouseNameById(Integer greenhouseId);
}
