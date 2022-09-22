package online.buza.blog.dao;

import online.buza.blog.entity.TbCollect;

public interface TbCollectMapper {
    int deleteByPrimaryKey(Integer collectId);

    int insert(TbCollect record);

    int insertSelective(TbCollect record);

    TbCollect selectByPrimaryKey(Integer collectId);

    int updateByPrimaryKeySelective(TbCollect record);

    int updateByPrimaryKey(TbCollect record);
}