package online.buza.blog.util;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

public class AmazonS3Client {

    private static final String AWS_REGION = PropertiesUtils.getAwsRegion();
    private static final String AWS_S3_END_POINT_URL = PropertiesUtils.getAwsS3EndpointUrl();
    private static final String AWS_ACCESS_KEY = PropertiesUtils.getAwsAccessKey();
    private static final String AWS_SECRET_KEY = PropertiesUtils.getAwsSecretKey();

    private final com.amazonaws.services.s3.AmazonS3Client s3Client;

    public AmazonS3Client() {
//        String accessKey = "AKIAYHCBPVVDBVQ7WF5G";
//        String secretKey = "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";
//        String endpointUrl = "https://s3.ap-northeast-2.amazonaws.com"; // AWS S3 엔드포인트 URL
//        String region = "ap-northeast-2"; // AWS 리전

        BasicAWSCredentials credentials = new BasicAWSCredentials(AWS_ACCESS_KEY, AWS_SECRET_KEY);
        AwsClientBuilder.EndpointConfiguration endpointConfiguration = new AwsClientBuilder.EndpointConfiguration(AWS_S3_END_POINT_URL, AWS_REGION);
        AWSStaticCredentialsProvider credentialsProvider = new AWSStaticCredentialsProvider(credentials);

        this.s3Client = (com.amazonaws.services.s3.AmazonS3Client) AmazonS3ClientBuilder.standard()
                .withEndpointConfiguration(endpointConfiguration)
                .withCredentials(credentialsProvider)
                .build();
    }

    public com.amazonaws.services.s3.AmazonS3Client getS3Client() {
        return s3Client;
    }

}
