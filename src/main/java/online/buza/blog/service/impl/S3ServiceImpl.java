package online.buza.blog.service.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import online.buza.blog.service.S3Service;
import online.buza.blog.util.DateUtil;
import online.buza.blog.util.PropertiesUtils;
import online.buza.blog.util.S3Client;
import online.buza.blog.util.ValueUtil;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Slf4j
@Getter
@Setter
@AllArgsConstructor
@Service
public class S3ServiceImpl implements S3Service {

    private static final String AWS_S3_BUCKET_NAME = PropertiesUtils.getAwsS3BucketName();

    private final AmazonS3 s3Client;

    public S3ServiceImpl() {
        this.s3Client = new S3Client().getS3Client();
    }

    public void uploadFileToS3(String bucketName, String key, File file) {
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, file);
        s3Client.putObject(putObjectRequest);
    }

    public String updateFileToS3ReturnETag(String bucketName, String key, File file) {
        PutObjectRequest objectRequest = new PutObjectRequest(AWS_S3_BUCKET_NAME, key, file);
        PutObjectResult result = s3Client.putObject(objectRequest);
        return result.getETag();
    }

    public String updateFileToS3ReturnETag(File file) {
        String fileName = file.getName();
        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
        String uploadFileName = DateUtil.getTime() + "_" + ValueUtil.generateUid(10) + "." + fileExtensionName;

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int date = calendar.get(Calendar.DATE);

        String objectKey = year + "/" + month + "/" + date + "/" + uploadFileName;;

        PutObjectRequest objectRequest = new PutObjectRequest(AWS_S3_BUCKET_NAME, objectKey, file)
                .withCannedAcl(CannedAccessControlList.PublicRead);
        PutObjectResult result = s3Client.putObject(objectRequest);

        return result.getETag();
    }

    public InputStream getFileFromS3(String bucketName, String key) throws IOException {
        S3Object object = s3Client.getObject(bucketName, key);
        return object.getObjectContent();
    }

    public List<String> listObjectsInBucket(String bucketName) {
        List<String> objectKeys = new ArrayList<>();
        ListObjectsV2Request listObjectsV2Request = new ListObjectsV2Request().withBucketName(bucketName);
        ListObjectsV2Result result = s3Client.listObjectsV2(listObjectsV2Request);
        for (S3ObjectSummary objectSummary : result.getObjectSummaries()) {
            objectKeys.add(objectSummary.getKey());
        }
        return objectKeys;
    }






}
