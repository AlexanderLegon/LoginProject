package com.sparta.alegon.JSFDemo.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Users", schema = "users")

public class UsersEntity {
    private Integer id;
    private String name;
    private String password;
    private Byte adminStatus;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "adminStatus")
    public Byte getAdminStatus() {
        return adminStatus;
    }

    public void setAdminStatus(Byte adminStatus) {
        this.adminStatus = adminStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEntity that = (UsersEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(password, that.password) && Objects.equals(adminStatus, that.adminStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, password, adminStatus);
    }
}
