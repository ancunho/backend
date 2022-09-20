package online.buza.blog.service;

import online.buza.blog.dto.TbCommonCodeDto;
import online.buza.blog.entity.TbAccessHist;

import java.util.List;

public interface CommonService {

    public void insertTbAccessHist(TbAccessHist tbAccessHist);

    public List<TbCommonCodeDto> getCommonCodeByCodeType(TbCommonCodeDto tbCommonCodeDto);


}
