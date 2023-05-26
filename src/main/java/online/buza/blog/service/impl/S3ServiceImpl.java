package online.buza.blog.service.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import online.buza.blog.service.S3Service;
import online.buza.blog.util.DateUtil;
import online.buza.blog.util.PropertiesUtils;
import online.buza.blog.util.ValueUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

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
    private static final String AWS_ACCESS_KEY = PropertiesUtils.getAwsAccessKey();
    private static final String AWS_SECRET_KEY = PropertiesUtils.getAwsSecretKey();

    private static final String AWS_S3_ENDPOINT_URL = PropertiesUtils.getAwsS3EndpointUrl();

//    private final AmazonS3 amazonS3Client;

    private final S3Client s3Client;


    public S3ServiceImpl() {
        AwsBasicCredentials credentials = AwsBasicCredentials.create(AWS_ACCESS_KEY, AWS_SECRET_KEY);
        this.s3Client = S3Client.builder()
                .region(Region.AP_NORTHEAST_2)
                .credentialsProvider(StaticCredentialsProvider.create(credentials))
                .build();
    }

//    public void uploadFileToS3(String bucketName, String key, File file) {
//        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, file);
//        amazonS3Client.putObject(putObjectRequest);
//    }

//    public String updateFileToS3ReturnETag(String bucketName, String key, File file) {
//        PutObjectRequest objectRequest = new PutObjectRequest(AWS_S3_BUCKET_NAME, key, file);
//        PutObjectResult result = amazonS3Client.putObject(objectRequest);
//        return result.getETag();
//    }



    public String updateFileToS3ReturnETag(MultipartFile file) {
        try {
//            String fileName = file.getOriginalFilename();
            String fileName = file.getOriginalFilename();
            String fileExtensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
            String uploadFileName = DateUtil.getTime() + "_" + ValueUtil.generateUid(10) + "." + fileExtensionName;

            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH) + 1;
            int date = calendar.get(Calendar.DATE);

            String keyName = year + "/" + month + "/" + date + "/" + uploadFileName;

            PutObjectRequest request = PutObjectRequest.builder()
                    .bucket(AWS_S3_BUCKET_NAME)
                    .key(keyName)
                    .build();

            s3Client.putObject(request, RequestBody.fromInputStream(file.getInputStream(), file.getSize())); // 이미지 파일 업로드

            System.out.println("이미지 업로드 완료. 파일 이름: " + keyName);

            // 완전한 이미지 URL 생성
            String imageURL = generateImageURL(keyName);
            System.out.println(imageURL);
            return imageURL;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String generateImageURL(String keyName) {
//        String baseURL = "https://buzaio.s3.ap-northeast-2.amazonaws.com";
//        String baseURL = "https://s3.ap-northeast-2.amazonaws.com";
        String imagePath = "/" + keyName; // 이미지 경로/키 이름
        return AWS_S3_ENDPOINT_URL + imagePath;
    }

//    public InputStream getFileFromS3(String bucketName, String key) throws IOException {
//        S3Object object = amazonS3Client.getObject(bucketName, key);
//        return object.getObjectContent();
//    }

//    public List<String> listObjectsInBucket(String bucketName) {
//        List<String> objectKeys = new ArrayList<>();
//        ListObjectsV2Request listObjectsV2Request = new ListObjectsV2Request().withBucketName(bucketName);
//        ListObjectsV2Result result = amazonS3Client.listObjectsV2(listObjectsV2Request);
//        for (S3ObjectSummary objectSummary : result.getObjectSummaries()) {
//            objectKeys.add(objectSummary.getKey());
//        }
//        return objectKeys;
//    }






}
