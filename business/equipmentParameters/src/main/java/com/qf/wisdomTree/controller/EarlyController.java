package com.qf.wisdomTree.controller;


import com.ken.mybatis.utils.KenPages;
import com.qf.wisdomTree.dto.Early;
import com.qf.wisdomTree.dto.EquipmentParameters;
import com.qf.wisdomTree.service.TEarlyService;
import com.qf.wisdomTree.service.TEquipmentParametersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wisdomTree.R;

import java.util.List;

@RestController
@RequestMapping("/early")
public class EarlyController {


    @Autowired
    private TEarlyService earlyService;

    @GetMapping("/list/{pageSize}/{pageNum}")
    public R pageList(@PathVariable Integer pageNum,@PathVariable Integer pageSize){
        KenPages.setPage(pageNum, pageSize);
        List<Early> list = earlyService.list();
        if((list==null)||list.size()<=0){
            return R.error().put("msg","没有设备信息");
        }
        return R.ok().put("data",list).put("total",KenPages.getPage().getCount());
    }

    @GetMapping("/list")
    public R list(){

        List<Early> list = earlyService.list();
        if((list==null)||list.size()<=0){
            return R.error().put("msg","没有设备信息");
        }
        return R.ok().put("data",list);
    }




}
