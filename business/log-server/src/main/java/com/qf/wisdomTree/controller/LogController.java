package com.qf.wisdomTree.controller;

import com.ken.mybatis.utils.KenPages;
import com.qf.wisdomTree.service.LogService;
import com.qf.wisdomTree.vo.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wisdomTree.R;

import java.util.List;

@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    private LogService logService;


    @GetMapping("/list/{pageSize}/{pageNum}")
    public R pageList(@PathVariable Integer pageNum, @PathVariable Integer pageSize){
        KenPages.setPage(pageNum, pageSize);
        List<Log> list = logService.list();
        if((list==null)||list.size()<=0){
            return R.error().put("msg","没有日志信息");
        }
        return R.ok().put("data",list).put("total",KenPages.getPage().getCount());
    }

}
