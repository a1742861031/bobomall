package com.bobo.mall.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bobo.mall.dto.PmsProductAttributeCategoryItem;
import com.bobo.mall.entity.Product.PmsProductAttributeCategory;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;


/**
 * <p>
 * 产品属性分类表 服务类
 * </p>
 *
 * @author bobo
 * @since 2021-10-19
 */
public interface PmsProductAttributeCategoryService extends IService<PmsProductAttributeCategory> {
    //获取商品类型的列表
    void getProductTypeList(Page<PmsProductAttributeCategory> pageParams);
    //增加商品类型
    boolean addProductType(String typeName);
    //修改商品类型
    boolean editProductType(String typeName,long typeId);
    //删除商品的类型
    boolean deleteProductType(Long id);
    //根据id获取商品的类型
    PmsProductAttributeCategory getTypeById(Long id);
    //获取所有商品的类型，及其下属
    List<PmsProductAttributeCategoryItem> getAllAttributeType();
}
