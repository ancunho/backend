package online.buza.blog.dao;

import online.buza.blog.dto.LabelDto;
import online.buza.blog.dto.TbCommonCodeDto;
import online.buza.blog.entity.TbCommonCode;

import java.util.List;

public interface TbCommonCodeMapper {
    int deleteByPrimaryKey(Integer codeId);

    int insert(TbCommonCode record);

    int insertSelective(TbCommonCode record);

    TbCommonCode selectByPrimaryKey(Integer codeId);

    int updateByPrimaryKeySelective(TbCommonCode record);

    int updateByPrimaryKey(TbCommonCode record);

    List<TbCommonCodeDto> getAllTbCommonCodeList(TbCommonCodeDto tbCommonCodeDto);

    TbCommonCodeDto getTbCommonCodeInfoByCodeId(Integer codeId);

    List<TbCommonCodeDto> lstTbCommonCodeByCodeType(String codeType);

    int deleteTbCommonCodeByCodeId(TbCommonCodeDto tbCommonCodeDto);

    List<TbCommonCodeDto> getCommonCodeList(TbCommonCodeDto tbCommonCodeDto);

    List<TbCommonCodeDto> getAllGroupTypeCommonCode(TbCommonCodeDto tbCommonCodeDto);


}
