package com.bobo.mall.dto;

import lombok.Data;

/**
 * @Description 带有属性的商品属性分类
 * @Date 2021/10/19 19:23
 * @Created by bobo
 */
@Data
public class PmsProductAttributeCategoryItem {
    private Long id;
    private String name;
    private Long attrId;
    private String attrName;
}



