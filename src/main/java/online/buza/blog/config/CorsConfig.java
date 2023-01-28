package online.buza.blog.config;

import online.buza.blog.interceptor.BuzaInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.resource.GzipResourceResolver;

import java.util.concurrent.TimeUnit;

@Configuration
public class CorsConfig extends WebMvcConfigurerAdapter {

//    @Bean
//    public BuzaInterceptor buzaInterceptor() {
//        return new BuzaInterceptor();
//    }

    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
//        corsConfiguration.setAllowCredentials(true);
//        corsConfiguration.addAllowedOriginPattern("/**");
//        corsConfiguration.addExposedHeader("Authorization");
        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig());
        return new CorsFilter(source);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOriginPatterns("/**")
                .allowedOrigins("*")
//                .allowCredentials(true)
//                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .allowedMethods("POST", "GET")
                .allowedHeaders("*")
//                .exposedHeaders("Authorization")
                .maxAge(3600);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        WebMvcConfigurer.super.addInterceptors(registry);
        registry.addInterceptor(new BuzaInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/static/**")
                .excludePathPatterns("/css/**")
                .excludePathPatterns("/js/**")
                .excludePathPatterns("/images/**")
                .excludePathPatterns("/img/**")
                .excludePathPatterns("/backend/captcha")
                .excludePathPatterns("/login")
                .excludePathPatterns("/logout")
                .excludePathPatterns("/no_session")
                .excludePathPatterns("/manage")
                .excludePathPatterns("/backend/user/login")
                .excludePathPatterns("/admin/login.ahn")
        ;
//        WebMvcConfigurer.super.addInterceptors(registry);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**,/css/**").addResourceLocations("/static/,/css/")
                .setCacheControl(CacheControl.maxAge(10, TimeUnit.MINUTES).cachePrivate())
                .resourceChain(true)
                .addResolver(new GzipResourceResolver());
//        WebMvcConfigurer.super.addResourceHandlers(registry);

    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        super.addViewControllers(registry);
    }
}
