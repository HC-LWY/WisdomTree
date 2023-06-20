package com.qf.wisdomTree.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.wisdomTree.dto.TUser;
import com.qf.wisdomTree.mapper.TUserMapper;
import com.qf.wisdomTree.service.TestService;
import org.springframework.stereotype.Service;

/**
* @author 昏晨
* @description 针对表【t_test】的数据库操作Service实现
* @createDate 2023-06-15 17:25:26
*/
@Service
public class TestServiceImpl extends ServiceImpl<TUserMapper, TUser>
    implements TestService{

}




