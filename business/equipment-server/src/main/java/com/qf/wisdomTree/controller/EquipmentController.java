package com.qf.wisdomTree.controller;


import com.ken.mybatis.utils.KenPages;

import com.qf.wisdomTree.annotation.OutLog;
import com.qf.wisdomTree.dto.Equipment;
import com.qf.wisdomTree.service.IEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wisdomTree.R;
import java.util.List;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {


    @Autowired
    private IEquipmentService equipmentService;

    @GetMapping("/list/{pageSize}/{pageNum}")
    public R pageList(@PathVariable Integer pageNum,@PathVariable Integer pageSize){
        KenPages.setPage(pageNum, pageSize);
        List<Equipment> list = equipmentService.list();
        if((list==null)||list.size()<=0){
            return R.error().put("msg","没有设备信息");
        }
        return R.ok().put("data",list).put("total",KenPages.getPage().getCount());
    }

    @GetMapping("/list")
    public R list(){

        List<Equipment> list = equipmentService.list();
        if((list==null)||list.size()<=0){
            return R.error().put("msg","没有设备信息");
        }
        return R.ok().put("data",list);
    }


    @PostMapping("/addEquipment")
    @OutLog(operation =OutLog.Operation_Add,resources = "设备")
    public R addGreenhouse(Equipment equipment){
        String greenhouseName=equipmentService.getGreenhouseNameById(equipment.getGreenhouseId());

        equipment.setGreenhouseName(greenhouseName);
        boolean save = equipmentService.save(equipment);

        if (!save){
            return R.error().put("msg","设备信息插入失败");
        }
        return R.ok().put("msg","设备信息添加成功");
    }


    @PutMapping("/updateEquipment")
    @OutLog(operation =OutLog.Operation_Put,resources = "设备")
    public R updateGreenhouse(Equipment equipment){
        boolean b = equipmentService.updateById(equipment);

        if (!b){
            return R.error().put("msg","设备信息修改失败");
        }

        return R.ok().put("msg","设备信息修改成功");
    }

    @DeleteMapping("/delEquipment")
    @OutLog(operation =OutLog.Operation_Del,resources = "设备")
    public R delGreenhouse(Integer id){
        boolean b = equipmentService.removeById(id);
        if(!b){
            return R.error().put("msg","设备信息移除失败");
        }
        return R.ok().put("msg","设备信息移除成功");
    }

}
