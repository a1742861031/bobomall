package com.bobo.mall.mapper;

import com.bobo.mall.entity.Product.PmsBrand;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 * 品牌表 Mapper 接口
 * </p>
 *
 * @author bobo
 * @since 2021-10-15
 */
@Mapper
public interface PmsBrandMapper extends BaseMapper<PmsBrand> {
    @Update("update pms_brand set show_status = #{status} where id = #{id}")
    int updateShowStatus(Long id,Integer status);
}
