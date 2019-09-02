package com.tyzn.pojo;


/**
 * @author Unclue_liu
 * @organization tyzn
 * @date 2019/8/30 0030 17:28
 * @desc TODO
 */
public class SystemUser {
    private int id;
    private String userName;
    private String account;
    private String psd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPsd() {
        return psd;
    }

    public void setPsd(String psd) {
        this.psd = psd;
    }

    @Override
    public String toString() {
        return "SystemUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", account='" + account + '\'' +
                ", psd='" + psd + '\'' +
                '}';
    }
}
