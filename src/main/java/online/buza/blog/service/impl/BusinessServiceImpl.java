package online.buza.blog.service.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import online.buza.blog.dao.TbCustomerMapper;
import online.buza.blog.dto.TbCustomerDto;
import online.buza.blog.entity.SysUser;
import online.buza.blog.entity.TbCustomer;
import online.buza.blog.service.BusinessService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Slf4j
@Getter
@Setter
@AllArgsConstructor
@Service
public class BusinessServiceImpl implements BusinessService {

    @Resource
    private TbCustomerMapper tbCustomerMapper;

    public TbCustomerDto selectTbCustomerByLogin(TbCustomerDto tbCustomerDto) {
        return tbCustomerMapper.getTbCustomerByUsernameAndPassword(tbCustomerDto);
    }

    public Boolean existUserName(Map<String, Object> mapParams) {
        Integer existUserName = tbCustomerMapper.existUserName(mapParams);
        if (existUserName == null) {
            return false;
        }
        return true;
    }

    /**
     * 新增
     * @param tbCustomer
     * @return
     */
    public Boolean insertSysUser(TbCustomer tbCustomer) {
        int insertCount = tbCustomerMapper.insertSelective(tbCustomer);
        if (insertCount > 0) {
            return true;
        }
        return false;
    }

    /**
     * 更新用户信息
     * @param tbCustomer
     * @return
     */
    public Boolean updateSysUser(TbCustomer tbCustomer) {
        int updateCount = tbCustomerMapper.updateByPrimaryKeySelective(tbCustomer);
        if (updateCount > 0) {
            return true;
        }
        return false;
    }

    public TbCustomerDto selectTbCustomerDtoByCustomerUuid(Integer customerId) {
        return tbCustomerMapper.selectTbCustomerDtoByCustomerUuid(customerId);
    }

}
