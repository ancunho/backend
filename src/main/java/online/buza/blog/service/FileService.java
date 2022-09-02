package online.buza.blog.service;

import online.buza.blog.dto.TbFileListDto;
import online.buza.blog.entity.TbFileList;

import java.util.List;

public interface FileService {

    public Boolean insertTbFileList(TbFileList tbFileList);
    public Boolean updateTbFileList(TbFileList tbFileList);
    public List<TbFileListDto> getAllTbFileList(TbFileListDto tbFileListDto);
    public TbFileListDto getTbFileListInfoByFileId(Integer fileId);
}
