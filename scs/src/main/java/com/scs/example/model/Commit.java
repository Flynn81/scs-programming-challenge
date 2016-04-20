package com.scs.example.model;

/**
 * Created by cuixun on 4/20/16.
 */
public class Commit {

    public String userName;
    public String sha;
    public String msg;

    public Commit(String userName, String sha, String msg) {
        this.userName = userName;
        this.sha = sha;
        this.msg = msg;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
