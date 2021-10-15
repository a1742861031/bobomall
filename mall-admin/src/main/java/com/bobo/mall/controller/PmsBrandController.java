package com.bobo.mall.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bobo.mall.entity.Product.PmsBrand;
import com.bobo.mall.entity.R;
import com.bobo.mall.service.PmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 品牌表 前端控制器
 * </p>
 *
 * @author bobo
 * @since 2021-10-15
 */
@RestController
@Api(value = "品牌controller", tags = {"品牌控制器"})
@RequestMapping("/mall/product/brand")
public class PmsBrandController {
    @Autowired
    private PmsBrandService pmsBrandService;

    //分页查询所有的品牌
    @GetMapping(value = {"/query/{current}/{limit}", "/query/{current}/{limit}/{brandName}"})
    @ApiModelProperty("分页查询品牌")
    public R queryBrand(@PathVariable long current, @PathVariable long limit, @PathVariable(required = false) String brandName) {
        Page<PmsBrand> brandPage = new Page<>(current, limit);
        pmsBrandService.getBrands(brandPage, brandName);
        return R.ok().data("data",brandPage);
    }
}

