package com.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "registration")
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "mobile", nullable = false, unique = true, length = 10)
    private String mobile;


//    public Long getId() {
//        return id;
//    }
//
//    // Setter for id
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    // Getter for name
//
//    public String getName() {
//        return name;
//    }
//
//
//    // Setter for name
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    // Getter for email
//    public String getEmail() {
//        return email;
//    }
//
//    // Setter for email
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    // Getter for mobile
//    public String getMobile() {
//        return mobile;
//    }
//
//    // Setter for mobile
//    public void setMobile(String mobile) {
//        this.mobile = mobile;
//    }
}