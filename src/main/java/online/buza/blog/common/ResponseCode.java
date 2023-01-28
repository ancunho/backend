package online.buza.blog.common;

/**
 * @author : Cunho
 * @date : 2020/3/22
 */
public enum ResponseCode {

    SUCCESS(200,"Server Response Success"),
    CODE(0,"code return success"),
    CODE_ERROR(999,"code fail"),
    ERROR(400,"ERROR"),
    UNAUTHORIZED(401,"无权限"),
    ILLEGAL_ARGUMENT(402,"参数错误"),
    NEED_LOGIN(403,"需要登录"),

    INSERT_SUCCESS(1000, "新增成功"),
    INSERT_ERROR(1999, "新增失败"),
    SAVE_SUCCESS(2000, "保存成功"),
    SAVE_ERROR(2999, "保存失败"),
    DELETE_SUCCESS(3000, "删除成功"),
    DELETE_ERROR(3999, "删除失败"),

    LOGIN_EXPIRED(9999, "Session超时"),

    ;



    private final int code;
    private final String desc;

    ResponseCode(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode(){
        return code;
    }
    public String getDesc(){
        return desc;
    }

}
