package online.buza.blog.dao;

import online.buza.blog.entity.TbSkuAttribute;

public interface TbSkuAttributeMapper {
    int deleteByPrimaryKey(Integer skuAttrId);

    int insert(TbSkuAttribute record);

    int insertSelective(TbSkuAttribute record);

    TbSkuAttribute selectByPrimaryKey(Integer skuAttrId);

    int updateByPrimaryKeySelective(TbSkuAttribute record);

    int updateByPrimaryKey(TbSkuAttribute record);
}