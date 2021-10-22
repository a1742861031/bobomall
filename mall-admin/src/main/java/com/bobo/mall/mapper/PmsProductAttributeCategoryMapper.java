package com.bobo.mall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bobo.mall.dto.PmsProductAttributeCategoryItem;
import com.bobo.mall.entity.Product.PmsProductAttributeCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 产品属性分类表 Mapper 接口
 * </p>
 *
 * @author bobo
 * @since 2021-10-19
 */
@Mapper
public interface PmsProductAttributeCategoryMapper extends BaseMapper<PmsProductAttributeCategory> {

    List<PmsProductAttributeCategoryItem >getAttributeType();
}
