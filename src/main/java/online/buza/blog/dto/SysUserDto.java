package online.buza.blog.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
public class SysUserDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long rn;
    private Integer userSeq;
    private String openid;
    private String unionid;
    private String username;
    private String password;
    private String roleNo;
    private String role;
    private String status;
    private String statusName;
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
    private String createtime;
    private String updatetime;
    private Integer useYn;
    private String roles;
    private String permissions;
    private SysRoleDto roleDto;
    private List<SysMenuDto> menuList;

    private Integer roleId;
    private String roleName;
    private String roleCode;
    private String roleRemark;
    private String isContain;

}
