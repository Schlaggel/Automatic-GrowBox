package com.example.webApp.util;

import javax.persistence.*;
import java.util.Collections;
import java.util.Set;

@Entity
@Table(name="user")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    private String password;

    private String username;

    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.MERGE)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))
    private Set<Role> roles;


    @OneToMany (mappedBy = "deviceUser", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Set<Device> devices = Collections.emptySet();

    public User() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Device> getDevices() {
        return devices;
    }

     public void setDevices(Set<Device> devices) {
        this.devices = devices;
    }
}
