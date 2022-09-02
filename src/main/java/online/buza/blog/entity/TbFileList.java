package online.buza.blog.entity;

import java.util.Date;

public class TbFileList {
    private Integer fileId;

    private String fileType;

    private String filePurpose;

    private String fileOriginName;

    private String fileName;

    private String filePath;

    private String fileBucketName;

    private String fileBucketObject;

    private String fileSize;

    private String fileExtention;

    private String fileUrl;

    private Integer fileSort;

    private String fileIsMain;

    private String fileRemark;

    private String status;

    private String option01;

    private String option02;

    private String option03;

    private String option04;

    private String option05;

    private Date createTime;

    private Date updateTime;

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFilePurpose() {
        return filePurpose;
    }

    public void setFilePurpose(String filePurpose) {
        this.filePurpose = filePurpose;
    }

    public String getFileOriginName() {
        return fileOriginName;
    }

    public void setFileOriginName(String fileOriginName) {
        this.fileOriginName = fileOriginName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileBucketName() {
        return fileBucketName;
    }

    public void setFileBucketName(String fileBucketName) {
        this.fileBucketName = fileBucketName;
    }

    public String getFileBucketObject() {
        return fileBucketObject;
    }

    public void setFileBucketObject(String fileBucketObject) {
        this.fileBucketObject = fileBucketObject;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileExtention() {
        return fileExtention;
    }

    public void setFileExtention(String fileExtention) {
        this.fileExtention = fileExtention;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Integer getFileSort() {
        return fileSort;
    }

    public void setFileSort(Integer fileSort) {
        this.fileSort = fileSort;
    }

    public String getFileIsMain() {
        return fileIsMain;
    }

    public void setFileIsMain(String fileIsMain) {
        this.fileIsMain = fileIsMain;
    }

    public String getFileRemark() {
        return fileRemark;
    }

    public void setFileRemark(String fileRemark) {
        this.fileRemark = fileRemark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOption01() {
        return option01;
    }

    public void setOption01(String option01) {
        this.option01 = option01;
    }

    public String getOption02() {
        return option02;
    }

    public void setOption02(String option02) {
        this.option02 = option02;
    }

    public String getOption03() {
        return option03;
    }

    public void setOption03(String option03) {
        this.option03 = option03;
    }

    public String getOption04() {
        return option04;
    }

    public void setOption04(String option04) {
        this.option04 = option04;
    }

    public String getOption05() {
        return option05;
    }

    public void setOption05(String option05) {
        this.option05 = option05;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fileId=").append(fileId);
        sb.append(", fileType=").append(fileType);
        sb.append(", filePurpose=").append(filePurpose);
        sb.append(", fileOriginName=").append(fileOriginName);
        sb.append(", fileName=").append(fileName);
        sb.append(", filePath=").append(filePath);
        sb.append(", fileBucketName=").append(fileBucketName);
        sb.append(", fileBucketObject=").append(fileBucketObject);
        sb.append(", fileSize=").append(fileSize);
        sb.append(", fileExtention=").append(fileExtention);
        sb.append(", fileUrl=").append(fileUrl);
        sb.append(", fileSort=").append(fileSort);
        sb.append(", fileIsMain=").append(fileIsMain);
        sb.append(", fileRemark=").append(fileRemark);
        sb.append(", status=").append(status);
        sb.append(", option01=").append(option01);
        sb.append(", option02=").append(option02);
        sb.append(", option03=").append(option03);
        sb.append(", option04=").append(option04);
        sb.append(", option05=").append(option05);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}