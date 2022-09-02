package online.buza.blog.dao;

import online.buza.blog.entity.TbSpu;

public interface TbSpuMapper {
    int deleteByPrimaryKey(Integer spuId);

    int insert(TbSpu record);

    int insertSelective(TbSpu record);

    TbSpu selectByPrimaryKey(Integer spuId);

    int updateByPrimaryKeySelective(TbSpu record);

    int updateByPrimaryKey(TbSpu record);
}