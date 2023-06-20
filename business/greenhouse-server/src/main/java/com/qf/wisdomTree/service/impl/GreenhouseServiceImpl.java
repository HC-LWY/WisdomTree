package com.qf.wisdomTree.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.qf.wisdomTree.dto.Greenhouse;
import com.qf.wisdomTree.service.IGreenhouseService;
import com.qf.wisdomTree.mapper.TGreenhouseMapper;
import org.springframework.stereotype.Service;

/**
* @author 昏晨
* @description 针对表【t_greenhouse】的数据库操作Service实现
* @createDate 2023-06-12 18:12:32
*/
@Service
public class GreenhouseServiceImpl extends ServiceImpl<TGreenhouseMapper, Greenhouse>
implements IGreenhouseService {

}
