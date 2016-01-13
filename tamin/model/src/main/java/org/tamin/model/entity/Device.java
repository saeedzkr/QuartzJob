package org.tamin.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sector7 on 12/29/15.
 */

@Entity
@Table(name = "tbl_Device")
@NamedQueries({
        @NamedQuery(name = "Device.findAll", query = "SELECT t FROM Device t"),
        @NamedQuery(name = "Device.findByUserAndPass", query = "SELECT t FROM Device t WHERE t.username = :username AND t.password = :password ")

})
public class Device implements Serializable {


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


    public Device() {
    }


    public Device(String phoneNumber, String username, String firstname, String lastname, String password, String deviceName, String deviceIP, String deviceKey) {
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.deviceName = deviceName;
        this.deviceIP = deviceIP;
        this.deviceKey = deviceKey;
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


    @Override
    public String toString() {
        return "Device{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", password='" + password + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", deviceIP='" + deviceIP + '\'' +
                ", deviceKey='" + deviceKey + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
