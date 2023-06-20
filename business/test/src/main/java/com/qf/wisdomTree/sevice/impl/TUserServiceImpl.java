package com.qf.wisdomTree.sevice.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.wisdomTree.dto.TUser;
import com.qf.wisdomTree.mapper.TUserMapper;
import com.qf.wisdomTree.sevice.ITUserService;
import org.springframework.stereotype.Service;

@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper,TUser> implements ITUserService {



}
