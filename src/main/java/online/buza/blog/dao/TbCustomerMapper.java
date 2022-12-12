package online.buza.blog.dao;

import online.buza.blog.dto.TbCustomerDto;
import online.buza.blog.entity.TbCustomer;

import java.util.Map;

public interface TbCustomerMapper {
    int deleteByPrimaryKey(Integer customerId);

    int insert(TbCustomer record);

    int insertSelective(TbCustomer record);

    TbCustomer selectByPrimaryKey(Integer customerId);

    int updateByPrimaryKeySelective(TbCustomer record);

    int updateByPrimaryKey(TbCustomer record);

    int existUserName(Map<String, Object> mapParams);

    TbCustomerDto getTbCustomerByUsernameAndPassword(TbCustomerDto tbCustomerDto);
    TbCustomerDto selectTbCustomerDtoByCustomerUuid(Integer customerId);
}
