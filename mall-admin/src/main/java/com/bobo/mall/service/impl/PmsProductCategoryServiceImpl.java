package com.bobo.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bobo.mall.entity.Product.PmsProductCategory;
import com.bobo.mall.mapper.PmsProductCategoryMapper;
import com.bobo.mall.service.PmsProductCategoryService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 产品分类 服务实现类
 * </p>
 *
 * @author bobo
 * @since 2021-10-19
 */
@Service
public class PmsProductCategoryServiceImpl extends ServiceImpl<PmsProductCategoryMapper, PmsProductCategory> implements PmsProductCategoryService {

    @Override
    public void getCategoryLevelOne(Page<PmsProductCategory> pageParams) {
        QueryWrapper<PmsProductCategory> wrapper = new QueryWrapper<>();
        wrapper.eq("level", 0);
        //按照sort字段进行排序
        wrapper.orderByDesc("sort");
        baseMapper.selectPage(pageParams, wrapper);
    }

    @Override
    public void getCategoryLevelTwo(Page<PmsProductCategory> pageParams, Long parentId) {
        QueryWrapper<PmsProductCategory> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id", parentId);
        wrapper.orderByDesc("sort");
        baseMapper.selectPage(pageParams, wrapper);
    }
}
