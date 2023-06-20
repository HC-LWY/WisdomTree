package com.qf.wisdomTree.mapper;

import com.qf.wisdomTree.dto.GreenhouseConfig;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author 昏晨
* @description 针对表【t_greenhouse_conf】的数据库操作Mapper
* @createDate 2023-06-13 17:10:47
* @Entity com.qf.wisdomTree.dto.TGreenhouseConf
*/
public interface TGreenhouseConfMapper extends BaseMapper<GreenhouseConfig> {

    String selectGreenhouseNameById(Integer greenhouseId);
}




