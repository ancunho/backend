package online.buza.blog.dao;

import online.buza.blog.dto.TbPostCategoryDto;
import online.buza.blog.entity.TbPostCategory;

import java.util.List;
import java.util.Map;

public interface TbPostCategoryMapper {
    int deleteByPrimaryKey(Integer postCategoryId);

    int insert(TbPostCategory record);

    int insertSelective(TbPostCategory record);

    TbPostCategory selectByPrimaryKey(Integer postCategoryId);

    int updateByPrimaryKeySelective(TbPostCategory record);

    int updateByPrimaryKey(TbPostCategory record);

    List<TbPostCategoryDto> getPostCategoryList(TbPostCategoryDto tbPostCategoryDto);

    TbPostCategoryDto getPostCategoryDetailById(Map<String, Object> mapParams);
}
