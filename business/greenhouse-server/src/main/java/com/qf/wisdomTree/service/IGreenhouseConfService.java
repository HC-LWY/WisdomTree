package com.qf.wisdomTree.service;

import com.qf.wisdomTree.dto.GreenhouseConfig;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 昏晨
* @description 针对表【t_greenhouse_conf】的数据库操作Service
* @createDate 2023-06-13 17:10:47
*/
public interface IGreenhouseConfService extends IService<GreenhouseConfig> {

    String getGreenhouseNameById(Integer greenhouseId);
}
