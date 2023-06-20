package com.qf.wisdomTree.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.wisdomTree.dto.EquipmentParameters;
import com.qf.wisdomTree.service.TEquipmentParametersService;
import com.qf.wisdomTree.mapper.TEquipmentParametersMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 昏晨
* @description 针对表【t_equipment_parameters】的数据库操作Service实现
* @createDate 2023-06-16 16:30:47
*/
@Service
public class TEquipmentParametersServiceImpl extends ServiceImpl<TEquipmentParametersMapper, EquipmentParameters>
    implements TEquipmentParametersService{

    @Override
    public List<EquipmentParameters> list() {
        QueryWrapper qw=new QueryWrapper();
        qw.orderByDesc("create_time");
        List list = baseMapper.selectList(qw);

        return list;
    }
}




