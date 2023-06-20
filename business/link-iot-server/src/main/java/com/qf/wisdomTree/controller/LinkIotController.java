package com.qf.wisdomTree.controller;


import com.qf.wisdomTree.dto.EquipmentParameters;
import com.qf.wisdomTree.openFeign.ThTBFeign;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wisdomTree.R;

import java.util.Map;

@RestController
@RequestMapping("/linkIot")
public class LinkIotController {

    @Autowired
    private ThTBFeign thTBFeign;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @GetMapping("/byId")
    public R byId(Integer id){

        R r = thTBFeign.byId(id);
        Map th = (Map) r.get("th");
        EquipmentParameters ep=new EquipmentParameters();
        ep.setHumidity((Integer) th.get("h"));
        ep.setTemperature((Integer) th.get("t"));
        ep.setEquipmentId(id);

        System.out.println(r);
        amqpTemplate.convertAndSend("THTBQueue",ep);

        return R.ok().put("温度",th.get("t")).put("湿度",th.get("h"));


    }
}
