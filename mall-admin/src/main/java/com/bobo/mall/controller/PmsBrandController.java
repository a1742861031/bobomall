package com.bobo.mall.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bobo.mall.entity.Product.PmsBrand;
import com.bobo.mall.entity.R;
import com.bobo.mall.service.PmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @ApiOperation("分页查询品牌")
    public R queryBrand(@PathVariable long current, @PathVariable long limit, @PathVariable(required = false) String brandName) {
        Page<PmsBrand> brandPage = new Page<>(current, limit);
        pmsBrandService.getBrands(brandPage, brandName);
        return R.ok().data("data", brandPage);
    }

    //修改品牌
    @PutMapping()
    @ApiOperation("修改品牌")
    public R updateBrand(@RequestBody PmsBrand pmsBrand) {
        boolean update = pmsBrandService.updateById(pmsBrand);
        if (update) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    @PostMapping()
    @ApiOperation("新增品牌")
    public R addBrands(@RequestBody PmsBrand pmsBrand) {
        boolean add = pmsBrandService.addBrands(pmsBrand);
        if (add) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    @GetMapping("{brandId}")
    @ApiOperation("根据id查询品牌")
    public R selectedBrandById(@PathVariable Long brandId) {
        PmsBrand pmsBrand = pmsBrandService.selectedById(brandId);
        return R.ok().data("item", pmsBrand);
    }

    @DeleteMapping({"{brandId}"})
    @ApiOperation("根据id删除品牌")
    public R deleteBrand(@PathVariable Long brandId) {
        boolean delete = pmsBrandService.deleteById(brandId);
        if (delete) {
            return R.ok();
        } else {
            return R.error();
        }
    }
    @PostMapping("/editStatusByIds")
    @ApiOperation("批量修改status")
    public R editBrand(Long[] ids, int showStatus){
        boolean updateStatus = pmsBrandService.editStatusByIds(ids, showStatus);
        if (updateStatus) {
            return R.ok();
        } else {
            return R.error();
        }
    }
}

