package com.spring.boot.springbootswagger.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author yy
 * @ProjectName spring-boot-swagger
 * @Description: TODO 实体
 * @date 2018/12/10 11:51
 */

@ApiModel( description = "实体")
public class Entity {

        @ApiModelProperty(value = "主键id")
        private String id;
        @ApiModelProperty(value = "名称", required = true)
        private String name;
        @ApiModelProperty(value = "时间", required = true)
        private Date date;
}
