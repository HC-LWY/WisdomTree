package com.qf.wisdomTree.controller;

import com.ken.mybatis.utils.KenPages;
import com.qf.wisdomTree.dto.TUser;
import com.qf.wisdomTree.sevice.ITUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import wisdomTree.R;


import java.util.List;
import java.util.Map;



@RestController
@RequestMapping("/test")
@RefreshScope
public class TestController {


    @Autowired
    private ITUserService itUserService;



    @GetMapping("/list/{pageSize}/{pageNum}")
    public R getList(@PathVariable Integer pageSize,@PathVariable Integer pageNum){
        KenPages.setPage(pageNum, pageSize);
        List list= itUserService.list();
        return R.ok().put("data",list);

    }

    @PostMapping("/add")
    public R addObject(TUser tUser){
        itUserService.save(tUser);
        return R.ok().put("id",tUser.getId()).put("msg","添加成功");
    }


    @PutMapping("/update")
    public R updateObject(TUser tUser){
        itUserService.updateById(tUser);
        return R.ok().put("msg","修改成功");
    }

    @DeleteMapping("/del")
    public R delObject(Integer id){
        itUserService.removeById(id);
        return R.ok().put("id",id).put("msg","删除成功");
    }

}
