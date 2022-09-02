package online.buza.blog.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface AliyunService {

    public String uploadFileReturnURL(MultipartFile file) throws Exception;
    public Map<String, Object> uploadImageReturnURL(MultipartFile file) throws Exception;
    public void deleteImage(Map<String, Object> mapParams);

}
