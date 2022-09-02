package online.buza.blog.dao;

import online.buza.blog.entity.TbAttribute;

public interface TbAttributeMapper {
    int deleteByPrimaryKey(Integer attrId);

    int insert(TbAttribute record);

    int insertSelective(TbAttribute record);

    TbAttribute selectByPrimaryKey(Integer attrId);

    int updateByPrimaryKeySelective(TbAttribute record);

    int updateByPrimaryKey(TbAttribute record);
}