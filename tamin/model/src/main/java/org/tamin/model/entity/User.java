package org.tamin.model.entity;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by s.zakipour on 12/27/2015.
 */
@Entity
@Table(name = "tbl_user")
@NamedQueries({
        @NamedQuery(name = "User.findAll", query = "SELECT t FROM User t"),
        @NamedQuery(name = "User.findByUserAndPass", query = "SELECT t FROM User t WHERE t.username = :username AND t.password = :password ")

})
public class User implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USERID", nullable = false)
    private Long userid;
    @Column(name = "USERNAME", length = 50)
    private String username;
    @Column(name = "FIRSTNAME", length = 50)
    private String firstname;
    @Column(name = "LASTNAME", length = 50)
    private String lastname;
    @Column(name = "PASSWORD", length = 150)
    private String password;

    @Column(name = "DEVICE_NAME", length = 150)
    private String deviceName;
    @Column(name = "DEVICE_IP", length = 150)
    private String deviceIP;
    @Column(name = "DEVICE_KEY", length = 500)
    private String deviceKey;
    @Column(name = "DEVICE_PHONE_NUMBER", length = 20)
    private String phoneNumber;



    public User() {
    }

    public User(String username, String firstname, String lastname, String password) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceIP() {
        return deviceIP;
    }

    public void setDeviceIP(String deviceIP) {
        this.deviceIP = deviceIP;
    }

    public String getDeviceKey() {
        return deviceKey;
    }

    public void setDeviceKey(String deviceKey) {
        this.deviceKey = deviceKey;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
