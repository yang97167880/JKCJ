package com.jkcj.VO;

import java.util.Date;

/**
 * @Auther:Xhy
 * @Date:2020/2/17 20:21
 * @Description:用户视觉模型
 **/
public class UserVO {

    private Integer uid;

    private String username;

    private String title;

    private Integer status;

    private Date createdAt;

    private String tel;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getTel() { return tel; }

    public void setTel(String tel) { this.tel = tel; }

}
