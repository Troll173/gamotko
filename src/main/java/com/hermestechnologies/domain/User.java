package com.hermestechnologies.domain;

import javax.persistence.*;

@Entity
@Table(name = "users")

public class User implements java.io.Serializable{

    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    private String password;
    private String name;
//    private Integer role_id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="role_id",referencedColumnName="id")
    private Role role;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", role=" + role +
                '}';
    }
}
