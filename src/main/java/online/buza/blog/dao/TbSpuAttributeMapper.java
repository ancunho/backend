package online.buza.blog.dao;

import online.buza.blog.entity.TbSpuAttribute;

public interface TbSpuAttributeMapper {
    int deleteByPrimaryKey(Integer spuAttrId);

    int insert(TbSpuAttribute record);

    int insertSelective(TbSpuAttribute record);

    TbSpuAttribute selectByPrimaryKey(Integer spuAttrId);

    int updateByPrimaryKeySelective(TbSpuAttribute record);

    int updateByPrimaryKey(TbSpuAttribute record);
}