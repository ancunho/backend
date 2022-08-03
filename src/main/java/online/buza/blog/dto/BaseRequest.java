package online.buza.blog.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Getter
@Setter
@Slf4j
@ToString
public class BaseRequest implements Serializable {

    private Long rn;
    private int page;
    private int limit;
    private int rows;
    private String startDate;
    private String endDate;
    private String startTime;
    private String endTime;
    private String sessionId;
    private String ipAddr;
    private String userAgent;
    private String referer;
    private String statusName;

    public int getPage() {
        if (this.page == 0 || "".equals(String.valueOf(this.page))) {
            return 1;
        }
        return page;
    }

    public int getLimit() {
        if (this.limit == 0 || "".equals(String.valueOf(this.limit))) {
            return 15;
        }
        return limit;
    }

    public int getRows() {
        if (this.rows == 0 || "".equals(String.valueOf(this.rows))) {
            return 15;
        }
        return rows;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
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
}
