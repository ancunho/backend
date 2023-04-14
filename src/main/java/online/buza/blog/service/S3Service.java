package online.buza.blog.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface S3Service {

    public void uploadFileToS3(String bucketName, String key, File file);

    public String updateFileToS3ReturnETag(String bucketName, String key, File file);

    public String updateFileToS3ReturnETag(File file);

    public InputStream getFileFromS3(String bucketName, String key) throws IOException;

    public List<String> listObjectsInBucket(String bucketName);

}
