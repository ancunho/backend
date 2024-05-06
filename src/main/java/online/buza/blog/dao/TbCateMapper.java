package online.buza.blog.dao;

import online.buza.blog.entity.TbCate;

public interface TbCateMapper {
    int deleteByPrimaryKey(Integer categoryId);

    int insert(TbCate record);

    int insertSelective(TbCate record);

    TbCate selectByPrimaryKey(Integer categoryId);

    int updateByPrimaryKeySelective(TbCate record);

    int updateByPrimaryKey(TbCate record);
}