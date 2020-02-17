package com.jkcj.Error;

/**
 * @Auther:Xhy
 * @Date:2020/2/17 19:51
 * @Description:
 **/
public enum EmBusinessErr implements CommonError {

    //常规状态错误
    PARAMETER_INVALIDATION_ERROR(1001, "参数不合法"),
    UNKNOWN_ERROR(1002, "未知错误"),
    PERMISSION_DENIED(1003, "无权限"),
    NOT_LOGIN_USER(1004, "未登录"),

    //用户相关错误
    USER_LOGIN_ERROR(2001, "登录失败"),
    USER_NOT_EXISTS(2002, "用户不存在"),
    USER_PSD_MODIFY_ERROR(2003, "用户密码修改失败"),
    USER_FOCUS_ENTER_ERROR(2004, "用户关注问题类型录入失败"),
    USER_FOCUS_GET_ERROR(2005, "获取用户关注问题类型成功"),
    USER_LIST_GET_ERROR(2005, "用户列表获取失败");

    private int errCode;
    private String msg;

    EmBusinessErr(int errCode, String msg) {
        this.errCode = errCode;
        this.msg = msg;
    }

    @Override
    public int getErrCode() {
        return this.errCode;
    }

    @Override
    public String getErrMsg() {
        return this.msg;
    }

    @Override
    public void setErrMsg(String msg) {
        this.msg = msg;
    }
}
