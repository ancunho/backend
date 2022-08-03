package online.buza.blog.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class SysRoleMenuDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long menuId;
    private Long menuParentId;
    private String menuName;
    private String menuPath;
    private String menuComponent;
    private String menuOrderNum;
    private String menuStatus;

    private Long roleId;
    private String roleName;
    private String roleCode;
    private String roleRemark;
    private String roleStatus;

    private String isContain;


}
