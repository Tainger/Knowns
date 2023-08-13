package com.bonbon.knowns.model.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author rocky
 * @since 2023-08-13
 */
public class KnownsUser implements Serializable {


    private Long id;

    private String username;

    private String password;

    private String phone;

    private String mail;

    private Integer status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "KnownsUser{" +
            "id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", phone=" + phone +
            ", mail=" + mail +
            ", status=" + status +
        "}";
    }
}
