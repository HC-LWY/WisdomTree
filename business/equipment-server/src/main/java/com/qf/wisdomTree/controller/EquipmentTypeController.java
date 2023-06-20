package com.qf.wisdomTree.controller;

import com.ken.mybatis.utils.KenPages;
import com.qf.wisdomTree.annotation.OutLog;
import com.qf.wisdomTree.dto.EquipmentType;
import com.qf.wisdomTree.service.IEquipmentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wisdomTree.R;

import java.util.List;

@RestController
@RequestMapping("/equipmentType")
public class EquipmentTypeController {


    @Autowired
    private IEquipmentTypeService equipmentTypeService;

    @GetMapping("/list/{pageSize}/{pageNum}")
    public R pageList(@PathVariable Integer pageNum,@PathVariable Integer pageSize){
        KenPages.setPage(pageNum, pageSize);
        List<EquipmentType> list = equipmentTypeService.list();
        if((list==null)||list.size()<=0){
            return R.error().put("msg","没有设备分类信息");
        }
        return R.ok().put("data",list).put("total",KenPages.getPage().getCount());
    }

    @GetMapping("/list")
    public R list(){

        List<EquipmentType> list = equipmentTypeService.list();
        if((list==null)||list.size()<=0){
            return R.error().put("msg","没有设备分类信息");
        }
        return R.ok().put("data",list);
    }


    @PostMapping("/addEquipmentType")
    @OutLog(resources = "设备类型",operation = OutLog.Operation_Add)
    public R addGreenhouse(EquipmentType greenhouseType){
        boolean save = equipmentTypeService.save(greenhouseType);

        if (!save){
            return R.error().put("msg","设备类型插入失败");
        }
        return R.ok().put("msg","设备类型添加成功");
    }

    @PutMapping("/updateEquipmentType")
    @OutLog(resources = "设备类型",operation = OutLog.Operation_Put)

    public R updateGreenhouse(EquipmentType greenhouseType){
        boolean b = equipmentTypeService.updateById(greenhouseType);

        if (!b){
            return R.error().put("msg","设备类型修改失败");
        }

        return R.ok().put("msg","设备类型修改成功");
    }

    @DeleteMapping("/delEquipmentType")
    @OutLog(resources = "设备类型",operation = OutLog.Operation_Del)

    public R delGreenhouse(Integer id){
        boolean b = equipmentTypeService.removeById(id);
        if(!b){
            return R.error().put("msg","设备类型移除失败");
        }
        return R.ok().put("msg","设备类型移除成功");
    }
}
