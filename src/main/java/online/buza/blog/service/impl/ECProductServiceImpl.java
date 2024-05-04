package online.buza.blog.service.impl;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import online.buza.blog.dao.EcStoreProductMapper;
import online.buza.blog.entity.EcStoreProduct;
import online.buza.blog.service.ECProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Slf4j
@Getter
@Setter
@Service
public class ECProductServiceImpl implements ECProductService {

    @Resource
    private EcStoreProductMapper ecStoreProductMapper;

    @Transactional
    public Boolean insertECStoreProduct(EcStoreProduct ecStoreProduct) {
        int insertCount = ecStoreProductMapper.insertSelective(ecStoreProduct);
        if (insertCount > 0) {
            return true;
        }
        return false;
    }

    @Transactional
    public Boolean updateECStoreProduct(EcStoreProduct ecStoreProduct) {
        int updateCount = ecStoreProductMapper.updateByPrimaryKeySelective(ecStoreProduct);
        if (updateCount > 0) {
            return true;
        }
        return false;
    }

}
