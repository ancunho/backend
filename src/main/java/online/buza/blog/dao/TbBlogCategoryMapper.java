package online.buza.blog.dao;

import online.buza.blog.entity.TbBlogCategory;

public interface TbBlogCategoryMapper {
    int deleteByPrimaryKey(Integer categoryId);

    int insert(TbBlogCategory record);

    int insertSelective(TbBlogCategory record);

    TbBlogCategory selectByPrimaryKey(Integer categoryId);

    int updateByPrimaryKeySelective(TbBlogCategory record);

    int updateByPrimaryKey(TbBlogCategory record);
}