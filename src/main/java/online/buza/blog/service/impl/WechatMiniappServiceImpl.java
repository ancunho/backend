package online.buza.blog.service.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import online.buza.blog.dao.TbCollectMapper;
import online.buza.blog.dao.WechatMapper;
import online.buza.blog.dto.TbCollectDto;
import online.buza.blog.dto.TbPostDto;
import online.buza.blog.entity.TbCollect;
import online.buza.blog.service.WechatMiniappService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Getter
@Setter
@AllArgsConstructor
@Service
public class WechatMiniappServiceImpl implements WechatMiniappService {

    @Resource
    private WechatMapper wechatMapper;

    @Resource
    private TbCollectMapper tbCollectMapper;

    public List<TbPostDto> getPostListByCodeName(TbPostDto tbPostDto) {
        return wechatMapper.getPostListByCodeName(tbPostDto);
    }

    @Transactional
    public Boolean insertCollectType(TbCollect tbCollect) {
        int insertCount = tbCollectMapper.insertSelective(tbCollect);
        if (insertCount > 0) {
            return true;
        }
        return false;
    }

    @Transactional
    public Boolean deleteCollectTypeByCollectId(Integer collectId) {
        int deleteCount = tbCollectMapper.deleteByPrimaryKey(collectId);
        if (deleteCount > 0) {
            return true;
        }
        return false;
    }

    @Transactional
    public Boolean deleteCollectTypeByPostIdAndCustomerId(TbCollectDto tbCollectDto) {
        int deleteCount = tbCollectMapper.deleteCollectTypeByPostIdAndCustomerId(tbCollectDto);
        if (deleteCount > 0) {
            return true;
        }
        return false;
    }


}
