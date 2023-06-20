package com.qf.wisdomTree.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.wisdomTree.dto.Early;
import com.qf.wisdomTree.service.TEarlyService;
import com.qf.wisdomTree.mapper.TEarlyMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 昏晨
* @description 针对表【t_early】的数据库操作Service实现
* @createDate 2023-06-16 16:30:52
*/
@Service
public class TEarlyServiceImpl extends ServiceImpl<TEarlyMapper, Early>
    implements TEarlyService{

    @Override
    public List<Early> list() {
        QueryWrapper qw=new QueryWrapper();
        qw.orderByDesc("create_time");
        List list = baseMapper.selectList(qw);

        return list;
    }
}




