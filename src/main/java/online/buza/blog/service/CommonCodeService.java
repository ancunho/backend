package online.buza.blog.service;

import online.buza.blog.dto.LabelDto;
import online.buza.blog.dto.TbCommonCodeDto;
import online.buza.blog.entity.TbCommonCode;

import java.util.List;

public interface CommonCodeService {

    public Boolean insertTbCommonCode(TbCommonCode tbCommonCode);
    public Boolean updateTbCommonCode(TbCommonCode tbCommonCode);
    public Boolean deleteTbCommonCode(Integer codeId);

    public Boolean deleteTbCommonCode(TbCommonCodeDto tbCommonCodeDto);
    public List<TbCommonCodeDto> getAllTbCommonCodeList(TbCommonCodeDto tbCommonCodeDto);
    public TbCommonCodeDto getTbCommonCodeInfoByCodeId(Integer codeId);
    public List<TbCommonCodeDto> lstTbCommonCodeByCodeType(String codeType);

    public List<TbCommonCodeDto> getCommonCodeList(TbCommonCodeDto tbCommonCodeDto);
    public List<TbCommonCodeDto> getAllGroupTypeCommonCode(TbCommonCodeDto tbCommonCodeDto);



}
