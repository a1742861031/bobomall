package com.bobo.mall.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bobo.mall.dto.PmsProductAttributeCategoryItem;
import com.bobo.mall.entity.Product.PmsProductAttributeCategory;
import com.bobo.mall.mapper.PmsProductAttributeCategoryMapper;
import com.bobo.mall.service.PmsProductAttributeCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 产品属性分类表 服务实现类
 * </p>
 *
 * @author bobo
 * @since 2021-10-19
 */
@Service
public class PmsProductAttributeCategoryServiceImpl extends ServiceImpl<PmsProductAttributeCategoryMapper, PmsProductAttributeCategory> implements PmsProductAttributeCategoryService {
    @Autowired
    private PmsProductAttributeCategoryMapper pmsProductAttributeCategoryMapper;
    @Override
    public void getProductTypeList(Page<PmsProductAttributeCategory> pageParams) {
        baseMapper.selectPage(pageParams, null);
    }

    @Override
    public boolean addProductType(String typeName) {
        PmsProductAttributeCategory type = new PmsProductAttributeCategory();
        type.setName(typeName);
        type.setAttributeCount(0);
        type.setParamCount(0);
        int insert = baseMapper.insert(type);
        return insert > 0;
    }

    @Override
    public boolean editProductType(String typeName, long typeId) {
        PmsProductAttributeCategory editType = new PmsProductAttributeCategory();
        editType.setId(typeId);
        editType.setName(typeName);
        int update = baseMapper.updateById(editType);
        return update > 0;
    }

    @Override
    public boolean deleteProductType(Long id) {
        int delete = baseMapper.deleteById(id);
        return delete > 0;
    }

    @Override
    public PmsProductAttributeCategory getTypeById(Long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public List<PmsProductAttributeCategoryItem> getAllAttributeType() {
        return pmsProductAttributeCategoryMapper.getAttributeType();
    }

}
