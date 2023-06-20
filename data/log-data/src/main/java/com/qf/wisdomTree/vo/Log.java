package com.qf.wisdomTree.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


@Data
@TableName("t_log")
public class Log implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer logId;

    private String logContent;

    private String logType;

    private String username;

    private String operation;

    private String resources;

    private String remarks;

    private String object;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss" ,timezone = "GMT+8")
    private Date createTime;

}
