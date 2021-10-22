package com.bobo.mall.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bobo.mall.dto.PmsProductAttributeCategoryItem;
import com.bobo.mall.entity.Product.PmsProductAttributeCategory;
import com.bobo.mall.entity.R;
import com.bobo.mall.service.PmsProductAttributeCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 产品属性分类表 前端控制器
 * </p>
 *
 * @author bobo
 * @since 2021-10-19
 */
@RestController
@RequestMapping("/mall/product/attribute-category")
@Api(value = "商品类型controller", tags = {"商品类型控制器"})
public class PmsProductAttributeCategoryController {
    @Autowired
    private PmsProductAttributeCategoryService productAttributeCategoryService;

    @GetMapping(value = {"/query/{current}/{limit}"})
    @ApiOperation("获取所有的商品类型")
    public R queryType(@PathVariable long current, @PathVariable long limit) {
        Page<PmsProductAttributeCategory> categoryPage = new Page<>(current, limit);
        productAttributeCategoryService.getProductTypeList(categoryPage);
        return R.ok().data("data", categoryPage);
    }

    @PutMapping()
    @ApiOperation("修改商品类型")
    public R updateProductType(String typeName, Long typeId) {
        boolean editProductType = productAttributeCategoryService.editProductType(typeName, typeId);
        if (editProductType) {
            return R.ok();
        }
        return R.error();
    }

    @PostMapping()
    @ApiOperation("新增商品类型")
    public R addProductType(String typeName) {
        boolean addProductType = productAttributeCategoryService.addProductType(typeName);
        if (addProductType) {
            return R.ok();
        }
        return R.error();
    }

    @GetMapping("{id}")
    @ApiOperation("根据id获取商品类型")
    public R getProductTypeById(@PathVariable Long id) {
        PmsProductAttributeCategory type = productAttributeCategoryService.getTypeById(id);
        return R.ok().data("item", type);
    }

    @DeleteMapping("{id}")
    @ApiOperation("根据id删除商品类型")
    public R deleteProductType(@PathVariable Long id) {
        boolean deleteProductType = productAttributeCategoryService.deleteProductType(id);
        if (deleteProductType) {
            return R.ok();
        }
        return R.error();
    }

    @GetMapping("/getAllTypeAttribute")
    @ApiOperation("获取商品类型以及其下级")
    public R getAllTypeAttribute() {
        List<PmsProductAttributeCategoryItem> allAttributeType = productAttributeCategoryService.getAllAttributeType();
        return R.ok().data("all", allAttributeType);
    }
}

