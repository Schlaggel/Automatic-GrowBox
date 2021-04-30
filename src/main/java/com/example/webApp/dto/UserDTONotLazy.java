package com.example.webApp.dto;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class UserDTONotLazy {

    private Long userId;
    private String username;
    private String password;
    private Set<RoleDTO> roles;
    private Set<DeviceDTOWithSensors> devices;


    public Set<DeviceDTOWithSensors> getDevices() {
        return devices;
    }

    public void setDevices(Set<DeviceDTOWithSensors> devices) {
        this.devices = devices;
    }

    public Set<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleDTO> roles) {
        this.roles = roles;
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    @Override
    public String toString() {
        return "UserDTONotLazy{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                ", devices=" + devices +
                '}';
    }
}
