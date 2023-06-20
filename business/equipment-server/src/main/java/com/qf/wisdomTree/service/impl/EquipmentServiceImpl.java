package com.qf.wisdomTree.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.wisdomTree.dto.Equipment;
import com.qf.wisdomTree.service.IEquipmentService;
import com.qf.wisdomTree.mapper.TEquipmentMapper;
import org.springframework.stereotype.Service;

/**
* @author 昏晨
* @description 针对表【t_equipment】的数据库操作Service实现
* @createDate 2023-06-13 19:58:51
*/
@Service
public class EquipmentServiceImpl extends ServiceImpl<TEquipmentMapper, Equipment>
    implements IEquipmentService {

    @Override
    public String getGreenhouseNameById(Integer greenhouseId) {
        return baseMapper.selectGreenhouseNameById(greenhouseId);
    }
}




