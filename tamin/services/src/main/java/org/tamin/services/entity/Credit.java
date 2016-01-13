package org.tamin.services.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by s.zakipour on 10/21/2015.
 */
//@XmlRootElement

public class Credit {


    private String username;
    private String password;
    private long accountID;


    public Credit() {
    }

    public Credit(String username, String password, long accountID) {
        this.username = username;
        this.password = password;
        this.accountID = accountID;
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
//todo ok
    public long getAccountID() {
        return accountID;
    }

    public void setAccountID(long accountID) {
        this.accountID = accountID;
    }

    @Override
    public String toString() {
        return "Credit{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", accountID=" + accountID +
                '}';
    }
}
