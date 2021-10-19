package com.bobo.mall.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bobo.mall.entity.Product.PmsBrand;
import org.springframework.lang.Nullable;

import java.util.List;

/**
 * <p>
 * 品牌表 服务类
 * </p>
 *
 * @author bobo
 * @since 2021-10-15
 */
public interface PmsBrandService extends IService<PmsBrand> {
    //分页查询所有的品牌
    void getBrands(Page<PmsBrand> pageParams,@Nullable String brandName);
    //修改商品信息
    boolean updateById(PmsBrand pmsBrand);
    //增加品牌
    boolean addBrands(PmsBrand pmsBrand);
    //删除品牌
    boolean deleteById(Long brandId);
    //根据id查询
    PmsBrand selectedById(Long brandId);
    //批量更改显示状态
    boolean editStatusByIds(Long[] ids,Integer status);
}
