package online.buza.blog.service.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import online.buza.blog.dao.CommonMapper;
import online.buza.blog.dao.TbAccessHistMapper;
import online.buza.blog.dto.TbCommonCodeDto;
import online.buza.blog.entity.TbAccessHist;
import online.buza.blog.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Getter
@Setter
@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private TbAccessHistMapper tbAccessHistMapper;

    @Autowired
    private CommonMapper commonMapper;

    public void insertTbAccessHist(TbAccessHist tbAccessHist) {
        tbAccessHistMapper.insertSelective(tbAccessHist);
    }

    public List<TbCommonCodeDto> getCommonCodeByCodeType(TbCommonCodeDto tbCommonCodeDto) {
        return commonMapper.getCommonCodeByCodeType(tbCommonCodeDto);
    }

}
