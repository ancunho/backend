package online.buza.blog.dao;

import online.buza.blog.entity.TbCommonCode;

public interface TbCommonCodeMapper {
    int deleteByPrimaryKey(Integer codeSeq);

    int insert(TbCommonCode record);

    int insertSelective(TbCommonCode record);

    TbCommonCode selectByPrimaryKey(Integer codeSeq);

    int updateByPrimaryKeySelective(TbCommonCode record);

    int updateByPrimaryKey(TbCommonCode record);
}