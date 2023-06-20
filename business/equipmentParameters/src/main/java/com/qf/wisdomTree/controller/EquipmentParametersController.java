package com.qf.wisdomTree.controller;


import com.ken.mybatis.utils.KenPages;
import com.qf.wisdomTree.dto.EquipmentParameters;
import com.qf.wisdomTree.service.TEquipmentParametersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wisdomTree.R;

import java.util.List;

@RestController
@RequestMapping("/equipmentParameters")
public class EquipmentParametersController {


    @Autowired
    private TEquipmentParametersService equipmentParametersService;

    @GetMapping("/list/{pageSize}/{pageNum}")
    public R pageList(@PathVariable Integer pageNum,@PathVariable Integer pageSize){
        KenPages.setPage(pageNum, pageSize);
        List<EquipmentParameters> list = equipmentParametersService.list();
        if((list==null)||list.size()<=0){
            return R.error().put("msg","没有设备信息");
        }
        return R.ok().put("data",list).put("total",KenPages.getPage().getCount());
    }

    @GetMapping("/list")
    public R list(){

        List<EquipmentParameters> list = equipmentParametersService.list();
        if((list==null)||list.size()<=0){
            return R.error().put("msg","没有设备信息");
        }
        return R.ok().put("data",list);
    }




}
