package com.qf.wisdomTree.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.wisdomTree.service.LogService;
import com.qf.wisdomTree.mapper.LogMapper;
import com.qf.wisdomTree.vo.Log;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 昏晨
* @description 针对表【t_log】的数据库操作Service实现
* @createDate 2023-06-14 18:59:27
*/
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log>
    implements LogService{


    @Override
    public List<Log> list() {
        QueryWrapper qw=new QueryWrapper();
        qw.orderByDesc("create_time");
        List list = baseMapper.selectList(qw);

        return list;
    }
}




