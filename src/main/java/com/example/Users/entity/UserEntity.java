package com.example.Users.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "USER_DATA")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="USER_ID")
    private long userid;

    @Column(name = "USER_NAME")
    private String username;
    @Column(name = "PASSWORD")
    private String password;


}