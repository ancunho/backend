package online.buza.blog.dao;

import online.buza.blog.entity.TbFileList;

public interface TbFileListMapper {
    int deleteByPrimaryKey(Integer fileId);

    int insert(TbFileList record);

    int insertSelective(TbFileList record);

    TbFileList selectByPrimaryKey(Integer fileId);

    int updateByPrimaryKeySelective(TbFileList record);

    int updateByPrimaryKey(TbFileList record);
}