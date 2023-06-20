package com.qf.wisdomTree.openFeign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wisdomTree.R;

@FeignClient("iot-server")
@RequestMapping("/thtb")
public interface ThTBFeign {

    @GetMapping("/byId")
    public R byId(@RequestParam("id") Integer id);



}
