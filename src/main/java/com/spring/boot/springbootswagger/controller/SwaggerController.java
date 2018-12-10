package com.spring.boot.springbootswagger.controller;


import com.spring.boot.springbootswagger.entity.Entity;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Map;

@RestController
@EnableSwagger2
@Api(value = "Swagger controller",description = "Swagger用法的controller",tags = "Swagger Controller Tag")
@RequestMapping("/api")
public class SwaggerController {

    @ApiOperation(value = "获取data",response = Object.class)
    @ApiImplicitParams({@ApiImplicitParam(name = "params",paramType = "query",dataType = "Map<String,Object>",required = true,value = "获取数据的条件参数",defaultValue = "null")})
    @RequestMapping(value = "/get",method = {RequestMethod.GET,RequestMethod.POST})
    public String get(@RequestParam("params") Map<String,Object> params){

        return params.toString();
    }


    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    // 方法说明
    @ApiOperation(value = "添加data", notes="传递复杂对象DTO",produces = "application/json")
    public int update(@RequestBody Entity entity){
        if(entity != null){
            return 1;
        }
        return 0;
    }


    @RequestMapping(value = "/del", method = {RequestMethod.POST, RequestMethod.GET})
    // 方法说明
    @ApiOperation(value = "删除data",response = int.class)
    // 定义返回值意义
    @ApiResponses({
            @ApiResponse(code = 500, message = "服务器内部异常",response = String.class),
            @ApiResponse(code = 400, message = "权限不足",response = String.class),
            @ApiResponse(code = 404,message = "找不到页面",response = String.class)
            })
    public int del(int id){
        if(id != 0 ){
        return 1;
        }
        return 0;
    }
}
