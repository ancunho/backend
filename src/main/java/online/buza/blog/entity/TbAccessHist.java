package online.buza.blog.entity;

import java.util.Date;

public class TbAccessHist {
    private Integer accessSeq;

    private Integer customerSeq;

    private String requestUrl;

    private String requestUri;

    private String headerInfo;

    private String useYn;

    private String memo;

    private String errCd;

    private String errMsg;

    private String sessionId;

    private String ipAddr;

    private String userAgent;

    private String referer;

    private String cuser;

    private String euser;

    private Date createTime;

    private Date updateTime;

    private String parameters;

    public Integer getAccessSeq() {
        return accessSeq;
    }

    public void setAccessSeq(Integer accessSeq) {
        this.accessSeq = accessSeq;
    }

    public Integer getCustomerSeq() {
        return customerSeq;
    }

    public void setCustomerSeq(Integer customerSeq) {
        this.customerSeq = customerSeq;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getRequestUri() {
        return requestUri;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    public String getHeaderInfo() {
        return headerInfo;
    }

    public void setHeaderInfo(String headerInfo) {
        this.headerInfo = headerInfo;
    }

    public String getUseYn() {
        return useYn;
    }

    public void setUseYn(String useYn) {
        this.useYn = useYn;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getErrCd() {
        return errCd;
    }

    public void setErrCd(String errCd) {
        this.errCd = errCd;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getReferer() {
        return referer;
    }

    public void setReferer(String referer) {
        this.referer = referer;
    }

    public String getCuser() {
        return cuser;
    }

    public void setCuser(String cuser) {
        this.cuser = cuser;
    }

    public String getEuser() {
        return euser;
    }

    public void setEuser(String euser) {
        this.euser = euser;
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

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", accessSeq=").append(accessSeq);
        sb.append(", customerSeq=").append(customerSeq);
        sb.append(", requestUrl=").append(requestUrl);
        sb.append(", requestUri=").append(requestUri);
        sb.append(", headerInfo=").append(headerInfo);
        sb.append(", useYn=").append(useYn);
        sb.append(", memo=").append(memo);
        sb.append(", errCd=").append(errCd);
        sb.append(", errMsg=").append(errMsg);
        sb.append(", sessionId=").append(sessionId);
        sb.append(", ipAddr=").append(ipAddr);
        sb.append(", userAgent=").append(userAgent);
        sb.append(", referer=").append(referer);
        sb.append(", cuser=").append(cuser);
        sb.append(", euser=").append(euser);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", parameters=").append(parameters);
        sb.append("]");
        return sb.toString();
    }
}