package online.buza.blog.dao;

import online.buza.blog.entity.TbPostClassification;

public interface TbPostClassificationMapper {
    int deleteByPrimaryKey(Integer postClassificationId);

    int insert(TbPostClassification record);

    int insertSelective(TbPostClassification record);

    TbPostClassification selectByPrimaryKey(Integer postClassificationId);

    int updateByPrimaryKeySelective(TbPostClassification record);

    int updateByPrimaryKey(TbPostClassification record);
}