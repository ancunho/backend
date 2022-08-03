package online.buza.blog.util;

import online.buza.blog.config.JwtProperties;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class JwtTokenUtil {

    @Resource
    private JwtProperties jwtProperties;
}
