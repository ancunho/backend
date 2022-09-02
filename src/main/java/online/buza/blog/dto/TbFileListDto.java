package online.buza.blog.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class TbFileListDto extends BaseRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer fileId;
    private String fileType;
    private String filePurpose;
    private String fileOriginName;
    private String fileName;
    private String filePath;
    private String fileBucketName;
    private String fileBucketObject;
    private String fileSize;
    private String status;
    private String fileExtention;
    private String fileUrl;
    private Integer fileSort;
    private String fileIsMain;
    private String fileRemark;
    private String option01;
    private String option02;
    private String option03;
    private String option04;
    private String option05;
    private String createTime;
    private String updateTime;

}
