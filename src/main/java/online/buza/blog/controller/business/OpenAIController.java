package online.buza.blog.controller.business;

import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import online.buza.blog.annotation.BusinessPassLogin;
import online.buza.blog.common.BaseRequest;
import online.buza.blog.common.BaseResponse;
import online.buza.blog.dto.TbPostDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/openai")
public class OpenAIController {

    @BusinessPassLogin
    @ResponseBody
    @GetMapping(value = "/test.do")
    public BaseResponse openai_test() {
        RestTemplate restTemplate = new RestTemplate();
        String apiKey = "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";
        String endPointUrl = "https://api.openai.com/v1/engines/davinci-codex/completions";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + apiKey);

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("prompt", "Hello, my name is");
        requestBody.put("model", "text-davinci-003");
        requestBody.put("temperature", 0.5);
        requestBody.put("max_tokens", 1024);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody);

        ResponseEntity<String> response = restTemplate.postForEntity(endPointUrl, request, String.class);


        return BaseResponse.valueOfSuccess(response);
    }

}
