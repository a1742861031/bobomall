package com.bobo.mall.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bobo.mall.entity.Product.PmsProductCategory;
import com.bobo.mall.entity.R;
import com.bobo.mall.service.PmsProductCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 产品分类 前端控制器
 * </p>
 *
 * @author bobo
 * @since 2021-10-19
 */
@RestController
@RequestMapping("/mall/product/category")
@Api(value = "商品分类controller", tags = {"商品分类控制器"})
public class PmsProductCategoryController {
    @Autowired
    private PmsProductCategoryService productCategoryService;

    @GetMapping(value = {"/query/{current}/{limit}"})
    @ApiOperation("商品一级分类")
    public R queryBrandOneLevel(@PathVariable long current, @PathVariable long limit) {
        Page<PmsProductCategory> categoryPage = new Page<>(current, limit);
        productCategoryService.getCategoryLevelOne(categoryPage);
        return R.ok().data("data", categoryPage);
    }

    @GetMapping(value = {"/query/{parentId}/{current}/{limit}"})
    @ApiOperation("得到指定商品的二级分类")
    public R queryBrandTwoLevel(@PathVariable long parentId, @PathVariable long current, @PathVariable long limit) {
        Page<PmsProductCategory> categoryPage = new Page<>(current, limit);
        productCategoryService.getCategoryLevelTwo(categoryPage, parentId);
        return R.ok().data("data", categoryPage);
    }
}

