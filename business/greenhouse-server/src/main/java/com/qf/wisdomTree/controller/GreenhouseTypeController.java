package com.qf.wisdomTree.controller;


import com.ken.mybatis.utils.KenPages;
import com.qf.wisdomTree.annotation.OutLog;
import com.qf.wisdomTree.dto.GreenhouseType;
import com.qf.wisdomTree.service.IGreenhouseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wisdomTree.R;

import java.util.List;

@RestController
@RequestMapping("/greenhouseType")
public class GreenhouseTypeController {


    @Autowired
    private IGreenhouseTypeService greenhouseTypeService;

    @GetMapping("/list/{pageSize}/{pageNum}")
    public R pageList(@PathVariable Integer pageNum,@PathVariable Integer pageSize){
        KenPages.setPage(pageNum, pageSize);
        List<GreenhouseType> list = greenhouseTypeService.list();
        if((list==null)||list.size()<=0){
            return R.error().put("msg","没有大棚分类信息");
        }
        return R.ok().put("data",list).put("total",KenPages.getPage().getCount());
    }

    @GetMapping("/list")
    public R list(){

        List<GreenhouseType> list = greenhouseTypeService.list();
        if((list==null)||list.size()<=0){
            return R.error().put("msg","没有大棚分类信息");
        }
        return R.ok().put("data",list);
    }


    @PostMapping("/addGreenhouseType")
    @OutLog(resources = "大棚类型",operation = OutLog.Operation_Add)
    public R addGreenhouse(GreenhouseType greenhouseType){
        boolean save = greenhouseTypeService.save(greenhouseType);

        if (!save){
            return R.error().put("msg","大棚类型插入失败");
        }
        return R.ok().put("msg","大棚类型添加成功");
    }

    @PutMapping("/updateGreenhouseType")
    @OutLog(resources = "大棚类型",operation = OutLog.Operation_Put)
    public R updateGreenhouse(GreenhouseType greenhouseType){
        boolean b = greenhouseTypeService.updateById(greenhouseType);

        if (!b){
            return R.error().put("msg","大棚类型修改失败");
        }

        return R.ok().put("msg","大棚类型修改成功");
    }

    @DeleteMapping("/delGreenhouseType")
    @OutLog(resources = "大棚类型",operation = OutLog.Operation_Del)
    public R delGreenhouse(Integer id){
        boolean b = greenhouseTypeService.removeById(id);
        if(!b){
            return R.error().put("msg","大棚类型移除失败");
        }
        return R.ok().put("msg","大棚类型移除成功");
    }
}
