package online.buza.blog.dao;

import online.buza.blog.entity.TbAccessHist;

public interface TbAccessHistMapper {
    int deleteByPrimaryKey(Integer accessSeq);

    int insert(TbAccessHist record);

    int insertSelective(TbAccessHist record);

    TbAccessHist selectByPrimaryKey(Integer accessSeq);

    int updateByPrimaryKeySelective(TbAccessHist record);

    int updateByPrimaryKeyWithBLOBs(TbAccessHist record);

    int updateByPrimaryKey(TbAccessHist record);
}