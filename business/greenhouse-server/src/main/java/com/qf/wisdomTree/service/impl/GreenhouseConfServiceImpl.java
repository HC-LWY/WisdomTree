package com.qf.wisdomTree.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.wisdomTree.dto.GreenhouseConfig;
import com.qf.wisdomTree.service.IGreenhouseConfService;
import com.qf.wisdomTree.mapper.TGreenhouseConfMapper;
import org.springframework.stereotype.Service;

/**
* @author 昏晨
* @description 针对表【t_greenhouse_conf】的数据库操作Service实现
* @createDate 2023-06-13 17:10:47
*/
@Service
public class GreenhouseConfServiceImpl extends ServiceImpl<TGreenhouseConfMapper, GreenhouseConfig>
    implements IGreenhouseConfService {

    @Override
    public String getGreenhouseNameById(Integer greenhouseId) {
        return baseMapper.selectGreenhouseNameById(greenhouseId);
    }
}




