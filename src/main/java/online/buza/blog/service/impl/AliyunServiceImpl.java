package online.buza.blog.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import online.buza.blog.service.AliyunService;
import online.buza.blog.util.DateUtil;
import online.buza.blog.util.PropertiesUtils;
import online.buza.blog.util.ValueUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Getter
@Setter
@AllArgsConstructor
@Service
public class AliyunServiceImpl implements AliyunService {

    private static final String ALIYUN_OSS_BUCKET_NAME = PropertiesUtils.getAliyunOssFileBucketName();
    private static final String ALIYUN_OSS_END_POINT = PropertiesUtils.getAliyunOssFileEndpoint();
    private static final String ALIYUN_OSS_ACCESS_KEY_ID = PropertiesUtils.getAliyunOssFileAccessKeyId();
    private static final String ALIYUN_OSS_ACCESS_KEY_SECRET = PropertiesUtils.getAliyunOssFileAccessKeySecret();

    public String uploadFileReturnURL(MultipartFile file) throws Exception {
        OSS ossClient = new OSSClientBuilder().build(ALIYUN_OSS_END_POINT, ALIYUN_OSS_ACCESS_KEY_ID, ALIYUN_OSS_ACCESS_KEY_SECRET);
        InputStream inputStream = file.getInputStream();

        //기존파일명
        String fileName = file.getOriginalFilename();
        //파일확장자
        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
        //새로운 파일명  UUID.randomUUID().toString()
        String uploadFileName = DateUtil.getTime() + "_" + ValueUtil.generateUid(10) + "." + fileExtensionName;

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int date = calendar.get(Calendar.DATE);

        String file_path_url = year + "/" + month + "/" + date + "/" + uploadFileName;
        ossClient.putObject(ALIYUN_OSS_BUCKET_NAME, file_path_url, inputStream);
        ossClient.shutdown();
        return "https://" + PropertiesUtils.getAliyunOssFileBucketEndpoint() + "/" + file_path_url;
    }

    public Map<String, Object> uploadImageReturnURL(MultipartFile file) throws Exception {
        OSS ossClient = new OSSClientBuilder().build(ALIYUN_OSS_END_POINT, ALIYUN_OSS_ACCESS_KEY_ID, ALIYUN_OSS_ACCESS_KEY_SECRET);
        InputStream inputStream = file.getInputStream();

        //기존파일명
        String fileName = file.getOriginalFilename();
        //파일확장자
        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
        //새로운 파일명  UUID.randomUUID().toString()
        String uploadFileName = DateUtil.getTime() + "_" + ValueUtil.generateUid(10) + "." + fileExtensionName;

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int date = calendar.get(Calendar.DATE);

        String file_path_url = year + "/" + month + "/" + date + "/" + uploadFileName;
        ossClient.putObject(ALIYUN_OSS_BUCKET_NAME, file_path_url, inputStream);
        ossClient.shutdown();

        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("imageUrl", "https://" + PropertiesUtils.getAliyunOssFileBucketEndpoint() + "/" + file_path_url);
        returnMap.put("imageOriginName", fileName);
        returnMap.put("imageName", uploadFileName);
        returnMap.put("imagePath", year + "/" + month + "/" + date);
        returnMap.put("imageExt", fileExtensionName);
        returnMap.put("imageObject", year + "/" + month + "/" + date + "/" + uploadFileName);
        returnMap.put("imageSize", file.getSize());
        returnMap.put("success", true);
        return returnMap;
    }

    public void deleteImage(Map<String, Object> mapParams) {
        OSS ossClient = new OSSClientBuilder().build(ALIYUN_OSS_END_POINT, ALIYUN_OSS_ACCESS_KEY_ID, ALIYUN_OSS_ACCESS_KEY_SECRET);
        ossClient.deleteObject(ALIYUN_OSS_BUCKET_NAME, String.valueOf(mapParams.get("imageUrl")));
        ossClient.shutdown();
    }


}
