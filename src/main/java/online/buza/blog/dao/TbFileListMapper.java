package online.buza.blog.dao;

import online.buza.blog.dto.TbFileListDto;
import online.buza.blog.entity.TbFileList;

import java.util.List;

public interface TbFileListMapper {
    int deleteByPrimaryKey(Integer fileId);

    int insert(TbFileList record);

    int insertSelective(TbFileList record);

    TbFileList selectByPrimaryKey(Integer fileId);

    int updateByPrimaryKeySelective(TbFileList record);

    int updateByPrimaryKey(TbFileList record);

    List<TbFileListDto> getAllTbFileList(TbFileListDto tbFileListDto);

    TbFileListDto getTbFileListInfoByFileId(Integer fileId);
}