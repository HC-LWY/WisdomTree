package com.qf.wisdomTree.controller;


import com.ken.mybatis.utils.KenPages;
import com.qf.wisdomTree.annotation.OutLog;
import com.qf.wisdomTree.dto.Greenhouse;
import com.qf.wisdomTree.service.IGreenhouseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wisdomTree.R;
import java.util.List;

@RestController
@RequestMapping("/greenhouse")
@Api(tags = "大棚信息接口",description = "大棚详情信息")
public class GreenhouseController {


    @Autowired
    private IGreenhouseService greenhouseService;

    @GetMapping("/list/{pageSize}/{pageNum}")
    @ApiOperation(value = "大棚展示信息接口")
//    @Operation(summary = "body")
    public R pageList(@PathVariable
                      @ApiParam(name = "pageNum",value = "当前页")
                                  Integer pageNum,
                      @PathVariable
                      @ApiParam(name = "pageSize",value = "每页条目数")
                              Integer pageSize){
        KenPages.setPage(pageNum, pageSize);
        List<Greenhouse> list = greenhouseService.list();
        if((list==null)||list.size()<=0){
            return R.error().put("msg","没有大棚信息");
        }
        return R.ok().put("data",list).put("total",KenPages.getPage().getCount());
    }

    @GetMapping("/list")
    public R list(){

        List<Greenhouse> list = greenhouseService.list();
        if((list==null)||list.size()<=0){
            return R.error().put("msg","没有大棚信息");
        }
        return R.ok().put("data",list);
    }


    @PostMapping("/addGreenhouse")
    @OutLog(resources = "大棚",operation = OutLog.Operation_Add)
    public R addGreenhouse(Greenhouse greenhouse){
        boolean save = greenhouseService.save(greenhouse);

        if (!save){
            return R.error().put("msg","大棚信息插入失败");
        }
        return R.ok().put("msg","大棚信息添加成功");
    }

    @PutMapping("/updateGreenhouse")
    @OutLog(resources = "大棚",operation = OutLog.Operation_Put)
    public R updateGreenhouse(Greenhouse greenhouse){
        boolean b = greenhouseService.updateById(greenhouse);

        if (!b){
            return R.error().put("msg","大棚信息修改失败");
        }

        return R.ok().put("msg","大棚信息修改成功");
    }

    @DeleteMapping("/delGreenhouse")
    @OutLog(resources = "大棚",operation = OutLog.Operation_Del)
    public R delGreenhouse(Integer id){
        boolean b = greenhouseService.removeById(id);
        if(!b){
            return R.error().put("msg","大棚信息移除失败");
        }
        return R.ok().put("msg","大棚信息移除成功");
    }

}
