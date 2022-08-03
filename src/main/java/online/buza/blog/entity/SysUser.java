package online.buza.blog.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class SysUser implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer userSeq;
    private String openid;
    private String unionid;
    private String username;
    private String password;
    private String roleNo;
    private String role;
    private String status;
    private String userType;
    private String realname;
    private String company;
    private String companyType;
    private String mobileNo;
    private String email;
    private String sex;
    private String birthday;
    private String wechat;
    private String provinceCode;
    private String cityCode;
    private String districtCode;
    private String address;
    private String question;
    private String answer;
    private String imagePhoto;
    private String option01;
    private String option02;
    private String option03;
    private String option04;
    private String option05;
    private Date createtime;
    private Date updatetime;
    private Integer useYn;
    private String roles;
    private String permissions;

    public SysUser() {
    }

    public SysUser(String username, String password, String roles, String permissions) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.permissions = permissions;
        this.useYn = 1;
    }

    public List<String> getRolesList() {
        if (this.roles.length() > 0) {
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }

    public List<String> getPermissionList() {
        if (this.permissions.length() > 0) {
            return Arrays.asList(this.permissions.split(","));
        }
        return new ArrayList<>();
    }

}