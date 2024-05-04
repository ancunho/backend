package online.buza.blog.dao;

import online.buza.blog.entity.EcStoreProduct;

public interface EcStoreProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EcStoreProduct record);

    int insertSelective(EcStoreProduct record);

    EcStoreProduct selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EcStoreProduct record);

    int updateByPrimaryKey(EcStoreProduct record);
}