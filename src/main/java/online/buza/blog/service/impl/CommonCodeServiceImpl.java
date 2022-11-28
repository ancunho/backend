package online.buza.blog.service.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import online.buza.blog.dao.TbCommonCodeMapper;
import online.buza.blog.dto.TbCommonCodeDto;
import online.buza.blog.entity.TbCommonCode;
import online.buza.blog.service.CommonCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Getter
@Setter
@AllArgsConstructor
@Service
public class CommonCodeServiceImpl implements CommonCodeService {

    @Autowired
    private TbCommonCodeMapper tbCommonCodeMapper;

    @Transactional
    public Boolean insertTbCommonCode(TbCommonCode tbCommonCode) {
        int insertCount = tbCommonCodeMapper.insertSelective(tbCommonCode);
        if (insertCount > 0) {
            return true;
        }
        return false;
    }

    @Transactional
    public Boolean updateTbCommonCode(TbCommonCode tbCommonCode) {
        int updateCount = tbCommonCodeMapper.updateByPrimaryKeySelective(tbCommonCode);
        if (updateCount > 0) {
            return true;
        }
        return false;
    }

    @Transactional
    public Boolean deleteTbCommonCode(Integer codeId) {
        int deleteCount = tbCommonCodeMapper.deleteByPrimaryKey(codeId);
        if (deleteCount > 0) {
            return true;
        }
        return false;
    }

    @Transactional
    public Boolean deleteTbCommonCode(TbCommonCodeDto tbCommonCodeDto) {
        int deleteCount = tbCommonCodeMapper.deleteTbCommonCodeByCodeId(tbCommonCodeDto);
        if (deleteCount > 0) {
            return true;
        }
        return false;
    }

    public List<TbCommonCodeDto> getAllTbCommonCodeList(TbCommonCodeDto tbCommonCodeDto) {
        return tbCommonCodeMapper.getAllTbCommonCodeList(tbCommonCodeDto);
    }

    public TbCommonCodeDto getTbCommonCodeInfoByCodeId(Integer codeId) {
        return tbCommonCodeMapper.getTbCommonCodeInfoByCodeId(codeId);
    }

    public List<TbCommonCodeDto> lstTbCommonCodeByCodeType(String codeType) {
        return tbCommonCodeMapper.lstTbCommonCodeByCodeType(codeType);
    }



}
