package com.qf.wisdomTree.listener;


import com.qf.wisdomTree.dto.*;
import com.qf.wisdomTree.service.EarlyService;
import com.qf.wisdomTree.service.EquipmentParametersService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
public class THTBListener {

    @Autowired
    private EquipmentParametersService epService;

    @Autowired
    private EarlyService earlyService;

    @RabbitListener(queues = "THTBQueue")
    public void consumption(EquipmentParameters equipmentParameters){

        Early early=new Early();


        if(equipmentParameters==null){

            System.out.println("接口异常");
        }else {
            Integer greenhouseId=epService.getGreenhouseIdByEquipmentId(equipmentParameters.getEquipmentId());
            GreenhouseConfig greenhouseConfig=epService.getGreenhouseConfigById(greenhouseId);
            Equipment equipment=epService.getEquipmentNameById(equipmentParameters.getEquipmentId());


            early.setGreenhouseName(greenhouseConfig.getGreenhouseName());
            early.setEquipmentName(equipment.getEquipmentName());
            early.setCreateTime(new Date());

            equipmentParameters.setEquipmentName(equipment.getEquipmentName());
            equipmentParameters.setGreenhouseName(greenhouseConfig.getGreenhouseName());
            equipmentParameters.setCreateTime(new Date());
            equipmentParameters.setEquipmentType(equipment.getEquipmentType());
            if(greenhouseConfig==null){
               early.setEarlyContent("配置信息出错");
               earlyService.save(early);
            }else {

                temperature(equipmentParameters,early,greenhouseConfig);
                humidity(equipmentParameters,early,greenhouseConfig);

            }
            epService.save(equipmentParameters);
        }

    }

    public void temperature(EquipmentParameters equipmentParameters,Early early,GreenhouseConfig greenhouseConfig){
        Integer temperature = equipmentParameters.getTemperature();

        Double temperatureMax = greenhouseConfig.getTemperatureMax();

        Double temperatureMin = greenhouseConfig.getTemperatureMin();

        if(temperature<temperatureMin){
            early.setEarlyContent("温度过低");
            earlyService.save(early);
        }else if(temperature>temperatureMax){
            early.setEarlyContent("温度过高");
            earlyService.save(early);
        }


    }


    public void humidity(EquipmentParameters equipmentParameters,Early early,GreenhouseConfig greenhouseConfig){
        Integer humidity = equipmentParameters.getHumidity();

        Double humidityMax = greenhouseConfig.getHumidityMax();

        Double humidityMin = greenhouseConfig.getHumidityMin();

        if(humidity<humidityMin){
            early.setEarlyContent("湿度过低");
            earlyService.save(early);
        }else if(humidity>humidityMax){
            early.setEarlyContent("湿度过高");
            earlyService.save(early);
        }


    }

}
