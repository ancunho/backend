package online.buza.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@SpringBootApplication
@ComponentScan("online.buza")
@ServletComponentScan
@MapperScan("online.buza.blog.dao")
public class BlogApplication {

    private static final Logger log = LoggerFactory.getLogger(BlogApplication.class);

    public static void main(String[] args) {
        log.info("BlogApplication starting .......");
        SpringApplication app = new SpringApplication(BlogApplication.class);
        Environment env = app.run(args).getEnvironment();
        log.info("BlogApplication started ....... SUCCESS!");
        log.info("BlogApplication 地址: \thttp://127.0.0.1:{}", env.getProperty("server.port"));
    }

}
