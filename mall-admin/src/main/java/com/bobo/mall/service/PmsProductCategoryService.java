package com.bobo.mall.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bobo.mall.entity.Product.PmsBrand;
import com.bobo.mall.entity.Product.PmsProductCategory;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.lang.Nullable;

/**
 * <p>
 * 产品分类 服务类
 * </p>
 *
 * @author bobo
 * @since 2021-10-19
 */
public interface PmsProductCategoryService extends IService<PmsProductCategory> {
    //得到商品的一级分类
    void getCategoryLevelOne(Page<PmsProductCategory> pageParams);
    //得到商品的二级分类
    void getCategoryLevelTwo(Page<PmsProductCategory> pageParams,Long parentId);
}
