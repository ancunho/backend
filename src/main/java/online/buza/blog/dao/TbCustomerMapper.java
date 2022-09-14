package online.buza.blog.dao;

import online.buza.blog.entity.TbCustomer;

public interface TbCustomerMapper {
    int deleteByPrimaryKey(Integer customerId);

    int insert(TbCustomer record);

    int insertSelective(TbCustomer record);

    TbCustomer selectByPrimaryKey(Integer customerId);

    int updateByPrimaryKeySelective(TbCustomer record);

    int updateByPrimaryKey(TbCustomer record);
}