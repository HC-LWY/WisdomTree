package com.qf.wisdomTree.controller;


import com.ken.mybatis.utils.KenPages;
import com.qf.wisdomTree.annotation.OutLog;
import com.qf.wisdomTree.dto.GreenhouseConfig;

import com.qf.wisdomTree.service.IGreenhouseConfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wisdomTree.R;

import java.util.List;

@RestController
@RequestMapping("/greenhouseConfig")
public class GreenhouseConfigController {


    @Autowired
    private IGreenhouseConfService greenhouseConfService;

    @GetMapping("/list/{pageSize}/{pageNum}")
    public R pageList(@PathVariable Integer pageNum,@PathVariable Integer pageSize){
        KenPages.setPage(pageNum, pageSize);
        List<GreenhouseConfig> list = greenhouseConfService.list();
        if((list==null)||list.size()<=0){
            return R.error().put("msg","没有大棚信息");
        }
        return R.ok().put("data",list).put("total",KenPages.getPage().getCount());
    }


    @PostMapping("/addGreenhouseConfig")
    @OutLog(resources = "大棚配置",operation = OutLog.Operation_Add)
    public R addGreenhouseConfig(GreenhouseConfig greenhouse){

        String greenhouseName=greenhouseConfService.getGreenhouseNameById(greenhouse.getGreenhouseId());

        greenhouse.setGreenhouseName(greenhouseName);

        boolean save = greenhouseConfService.save(greenhouse);

        if (!save){
            return R.error().put("msg","大棚信息插入失败");
        }
        return R.ok().put("msg","大棚信息添加成功");
    }

    @PutMapping("/updateGreenhouseConfig")
    @OutLog(resources = "大棚配置",operation = OutLog.Operation_Put)
    public R updateGreenhouseConfig(GreenhouseConfig greenhouse){
        boolean b = greenhouseConfService.updateById(greenhouse);

        if (!b){
            return R.error().put("msg","大棚信息修改失败");
        }

        return R.ok().put("msg","大棚信息修改成功");
    }

    @DeleteMapping("/delGreenhouseConfig")
    @OutLog(resources = "大棚配置",operation = OutLog.Operation_Del)
    public R delGreenhouseConfig(Integer id){
        boolean b = greenhouseConfService.removeById(id);
        if(!b){
            return R.error().put("msg","大棚信息移除失败");
        }
        return R.ok().put("msg","大棚信息移除成功");
    }

}
