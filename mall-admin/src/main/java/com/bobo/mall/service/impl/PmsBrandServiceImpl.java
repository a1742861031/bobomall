package com.bobo.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bobo.mall.entity.Product.PmsBrand;
import com.bobo.mall.mapper.PmsBrandMapper;
import com.bobo.mall.service.PmsBrandService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 品牌表 服务实现类
 * </p>
 *
 * @author bobo
 * @since 2021-10-15
 */
@Service
public class PmsBrandServiceImpl extends ServiceImpl<PmsBrandMapper, PmsBrand> implements PmsBrandService {


    @Override
    public void getBrands(Page<PmsBrand> pageParams, String brandName) {
        QueryWrapper<PmsBrand> wrapper = new QueryWrapper<>();
        //按照sort字段进行排序
        wrapper.orderByDesc("sort");
        if (StringUtils.isNotEmpty(brandName)) {
            wrapper.like("name", brandName);
        }
        baseMapper.selectPage(pageParams, wrapper);
    }
}
