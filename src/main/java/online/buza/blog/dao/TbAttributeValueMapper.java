package online.buza.blog.dao;

import online.buza.blog.entity.TbAttributeValue;

public interface TbAttributeValueMapper {
    int deleteByPrimaryKey(Integer attrValueId);

    int insert(TbAttributeValue record);

    int insertSelective(TbAttributeValue record);

    TbAttributeValue selectByPrimaryKey(Integer attrValueId);

    int updateByPrimaryKeySelective(TbAttributeValue record);

    int updateByPrimaryKey(TbAttributeValue record);
}