package online.buza.blog.service;

import online.buza.blog.dto.TbCustomerDto;
import online.buza.blog.entity.TbCustomer;

import java.util.Map;

public interface BusinessService {

    public TbCustomerDto selectTbCustomerByLogin(TbCustomerDto tbCustomerDto);

    public Boolean existUserName(Map<String, Object> mapParams);

    public Boolean insertSysUser(TbCustomer tbCustomer);

    public Boolean updateSysUser(TbCustomer tbCustomer);

    public TbCustomerDto selectTbCustomerDtoByCustomerUuid(Integer customerId);



}
