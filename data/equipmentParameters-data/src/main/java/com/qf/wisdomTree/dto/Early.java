package com.qf.wisdomTree.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName t_early
 */
@Data
@TableName("t_early")
public class Early implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;


    private String equipmentName;

    private String greenhouseName;


    private String earlyContent;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss" ,timezone = "GMT+8")
    private Date createTime;


    private Integer status;




}