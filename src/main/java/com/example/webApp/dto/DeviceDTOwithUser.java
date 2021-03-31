package com.example.webApp.dto;

public class DeviceDTOwithUser {

    private Long deviceId;
    private boolean isEnable;
    private String description;
    private UserDTONotLazy userDTONotLazy;

    public DeviceDTOwithUser() {
        isEnable = true;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserDTONotLazy getUserDTONotLazy() {
        return userDTONotLazy;
    }

    public void setUserDTONotLazy(UserDTONotLazy userDTONotLazy) {
        this.userDTONotLazy = userDTONotLazy;
    }
}
