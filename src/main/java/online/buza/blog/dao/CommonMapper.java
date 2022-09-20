package online.buza.blog.dao;

import online.buza.blog.dto.TbCommonCodeDto;

import java.util.List;

public interface CommonMapper {

    List<TbCommonCodeDto> getCommonCodeByCodeType(TbCommonCodeDto tbCommonCodeDto);

}
