package online.buza.blog.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;

@Slf4j
@Component
public class PropertiesUtils {

    private static Properties properties;

    private static String PROGRAM_NAME;
    private static String ADMIN_LOGIN_URL;
    private static String FILE_PATH;
    private static String ALIYUN_OSS_FILE_BUCKET_NAME;
    private static String ALIYUN_OSS_FILE_ENDPOINT;
    private static String ALIYUN_OSS_FILE_BUCKET_ENDPOINT;
    private static String ALIYUN_OSS_FILE_ACCESS_KEY_ID;
    private static String ALIYUN_OSS_FILE_ACCESS_KEY_SECRET;

    private static String BUZA_MINIAPP_ID;
    private static String BUZA_MCH_ID;
    private static String BUZA_MINIAPP_SECRET;
    private static String JS_CODE_TO_SESSION_URL;
    private static String GET_ACCESS_TOKEN_URL;

    static {
        properties = new Properties();
        InputStream inStream = PropertiesUtils.class.getClassLoader().getResourceAsStream("config.properties");
        try {
            Reader reader = new InputStreamReader(inStream, "UTF-8");
            properties.load(reader);
            PROGRAM_NAME = properties.getProperty("PROGRAM_NAME");
            ADMIN_LOGIN_URL = properties.getProperty("ADMIN_LOGIN_URL");
            FILE_PATH = properties.getProperty("FILE_PATH");
            ALIYUN_OSS_FILE_BUCKET_NAME = properties.getProperty("ALIYUN_OSS_FILE_BUCKET_NAME");
            ALIYUN_OSS_FILE_ENDPOINT = properties.getProperty("ALIYUN_OSS_FILE_ENDPOINT");
            ALIYUN_OSS_FILE_BUCKET_ENDPOINT = properties.getProperty("ALIYUN_OSS_FILE_BUCKET_ENDPOINT");
            ALIYUN_OSS_FILE_ACCESS_KEY_ID = properties.getProperty("ALIYUN_OSS_FILE_ACCESS_KEY_ID");
            ALIYUN_OSS_FILE_ACCESS_KEY_SECRET = properties.getProperty("ALIYUN_OSS_FILE_ACCESS_KEY_SECRET");
            BUZA_MINIAPP_ID = properties.getProperty("BUZA_MINIAPP_ID");
            BUZA_MCH_ID = properties.getProperty("BUZA_MCH_ID");
            BUZA_MINIAPP_SECRET = properties.getProperty("BUZA_MINIAPP_SECRET");
            JS_CODE_TO_SESSION_URL = properties.getProperty("JS_CODE_TO_SESSION_URL");
            GET_ACCESS_TOKEN_URL = properties.getProperty("GET_ACCESS_TOKEN_URL");

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try { inStream.close(); } catch (Exception e1) {}
        }
    }

    public static String getProperty(String key){
        String value = properties.getProperty(key.trim());
        if(StringUtils.isBlank(value)){
            return null;
        }
        return value.trim();
    }

    public static String getProperty(String key,String defaultValue){

        String value = properties.getProperty(key.trim());
        if(StringUtils.isBlank(value)){
            value = defaultValue;
        }
        return value.trim();
    }

    public static String getProgramName() {
        return PROGRAM_NAME;
    }

    public static void setProgramName(String programName) {
        PROGRAM_NAME = programName;
    }
    
    public static String getAdminLoginUrl() {
        return ADMIN_LOGIN_URL;
    }

    public static void setAdminLoginUrl(String adminLoginUrl) {
        ADMIN_LOGIN_URL = adminLoginUrl;
    }

    public static String getFilePath() {
        return FILE_PATH;
    }

    public static void setFilePath(String filePath) {
        FILE_PATH = filePath;
    }

    public static String getAliyunOssFileBucketName() {
        return ALIYUN_OSS_FILE_BUCKET_NAME;
    }

    public static void setAliyunOssFileBucketName(String aliyunOssFileBucketName) {
        ALIYUN_OSS_FILE_BUCKET_NAME = aliyunOssFileBucketName;
    }

    public static String getAliyunOssFileEndpoint() {
        return ALIYUN_OSS_FILE_ENDPOINT;
    }

    public static void setAliyunOssFileEndpoint(String aliyunOssFileEndpoint) {
        ALIYUN_OSS_FILE_ENDPOINT = aliyunOssFileEndpoint;
    }

    public static String getAliyunOssFileBucketEndpoint() {
        return ALIYUN_OSS_FILE_BUCKET_ENDPOINT;
    }

    public static void setAliyunOssFileBucketEndpoint(String aliyunOssFileBucketEndpoint) {
        ALIYUN_OSS_FILE_BUCKET_ENDPOINT = aliyunOssFileBucketEndpoint;
    }

    public static String getAliyunOssFileAccessKeyId() {
        return ALIYUN_OSS_FILE_ACCESS_KEY_ID;
    }

    public static void setAliyunOssFileAccessKeyId(String aliyunOssFileAccessKeyId) {
        ALIYUN_OSS_FILE_ACCESS_KEY_ID = aliyunOssFileAccessKeyId;
    }

    public static String getAliyunOssFileAccessKeySecret() {
        return ALIYUN_OSS_FILE_ACCESS_KEY_SECRET;
    }

    public static void setAliyunOssFileAccessKeySecret(String aliyunOssFileAccessKeySecret) {
        ALIYUN_OSS_FILE_ACCESS_KEY_SECRET = aliyunOssFileAccessKeySecret;
    }

    public static String getBuzaMiniappId() {
        return BUZA_MINIAPP_ID;
    }

    public static void setBuzaMiniappId(String buzaMiniappId) {
        BUZA_MINIAPP_ID = buzaMiniappId;
    }

    public static String getBuzaMchId() {
        return BUZA_MCH_ID;
    }

    public static void setBuzaMchId(String buzaMchId) {
        BUZA_MCH_ID = buzaMchId;
    }

    public static String getBuzaMiniappSecret() {
        return BUZA_MINIAPP_SECRET;
    }

    public static void setBuzaMiniappSecret(String buzaMiniappSecret) {
        BUZA_MINIAPP_SECRET = buzaMiniappSecret;
    }

    public static String getJsCodeToSessionUrl() {
        return JS_CODE_TO_SESSION_URL;
    }

    public static void setJsCodeToSessionUrl(String jsCodeToSessionUrl) {
        JS_CODE_TO_SESSION_URL = jsCodeToSessionUrl;
    }

    public static String getGetAccessTokenUrl() {
        return GET_ACCESS_TOKEN_URL;
    }

    public static void setGetAccessTokenUrl(String getAccessTokenUrl) {
        GET_ACCESS_TOKEN_URL = getAccessTokenUrl;
    }
}
