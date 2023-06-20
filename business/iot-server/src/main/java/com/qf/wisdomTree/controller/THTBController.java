package com.qf.wisdomTree.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wisdomTree.R;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/thtb")
public class THTBController {


    @GetMapping("/byId")
    public R byId(Integer id){
        Map th = getTh();
        return R.ok().put("th",th);
    }

    public Map getTh(){
        int t = new Random().nextInt(20)+10;
        int h = new Random().nextInt(20)+40;
        HashMap map = new HashMap();
        map.put("t",t);
        map.put("h",h);
        return map;
    }

}
