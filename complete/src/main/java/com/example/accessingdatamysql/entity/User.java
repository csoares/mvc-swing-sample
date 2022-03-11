package com.example.accessingdatamysql.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Getter
@Setter

public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String username;
    @Column(nullable = false, unique=true)
    private String email;
    private String password;
}