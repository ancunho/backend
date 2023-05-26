package online.buza.blog.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface S3Service {

//    public void uploadFileToS3(String bucketName, String key, File file);

    /**
     * 파라미터 다름 1
     * @param bucketName
     * @param key
     * @param file
     * @return
     */
//    public String updateFileToS3ReturnETag(String bucketName, String key, File file);


    /**
     * MultipartFile 파라미터
     * @param file
     * @return
     */
    public String updateFileToS3ReturnETag(MultipartFile file);

//    public InputStream getFileFromS3(String bucketName, String key) throws IOException;

//    public List<String> listObjectsInBucket(String bucketName);

}
