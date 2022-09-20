package online.buza.blog.service.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import online.buza.blog.dao.WechatMapper;
import online.buza.blog.service.WechatMiniappService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Getter
@Setter
@AllArgsConstructor
@Service
public class WechatMiniappServiceImpl implements WechatMiniappService {

    @Resource
    private WechatMapper wechatMapper;



}
