package online.buza.blog.controller.business;

import lombok.extern.slf4j.Slf4j;
import okhttp3.Connection;
import online.buza.blog.annotation.BusinessPassLogin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Objects;

@Slf4j
@Controller
@RequestMapping("/openai")
public class OpenAIController {

    //通过spring 的resttemplate调用chatgpt api
    private static final RestTemplate restTemplate = new RestTemplate();
    //openai的api key，可以写死或从配置文件读取，这里读取的环境变量
    private static final String apiKey = "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";



}
