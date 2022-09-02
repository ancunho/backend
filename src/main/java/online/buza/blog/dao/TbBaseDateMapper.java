package online.buza.blog.dao;

import online.buza.blog.entity.TbBaseDate;

public interface TbBaseDateMapper {
    int deleteByPrimaryKey(String baseYmd);

    int insert(TbBaseDate record);

    int insertSelective(TbBaseDate record);

    TbBaseDate selectByPrimaryKey(String baseYmd);

    int updateByPrimaryKeySelective(TbBaseDate record);

    int updateByPrimaryKey(TbBaseDate record);
}