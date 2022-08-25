package online.buza.blog.dao;

import online.buza.blog.dto.TbCommonCodeDto;
import online.buza.blog.entity.TbCommonCode;

import java.util.List;

public interface TbCommonCodeMapper {
    int deleteByPrimaryKey(Integer codeSeq);

    int insert(TbCommonCode record);

    int insertSelective(TbCommonCode record);

    TbCommonCode selectByPrimaryKey(Integer codeSeq);

    int updateByPrimaryKeySelective(TbCommonCode record);

    int updateByPrimaryKey(TbCommonCode record);

    List<TbCommonCodeDto> getAllTbCommonCodeList();

    TbCommonCodeDto getTbCommonCodeInfoByCodeId(Integer codeId);

    List<TbCommonCodeDto> lstTbCommonCodeByCodeType(String codeType);
}