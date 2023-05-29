package online.buza.blog.dao;

import online.buza.blog.entity.TbPostCategory;

public interface TbPostCategoryMapper {
    int deleteByPrimaryKey(Integer postCategoryId);

    int insert(TbPostCategory record);

    int insertSelective(TbPostCategory record);

    TbPostCategory selectByPrimaryKey(Integer postCategoryId);

    int updateByPrimaryKeySelective(TbPostCategory record);

    int updateByPrimaryKey(TbPostCategory record);
}