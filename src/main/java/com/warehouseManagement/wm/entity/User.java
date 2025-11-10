package com.warehouseManagement.wm.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "no")
    private String no;

    @Column(name = "name")
    private String name;

    @Column(name = "password_hash")
    private String password;

    @Column(name = "age")
    private int age;

    @Column(name = "sex")
    private int sex;

    @Column(name = "phone")
    private String phone;

    @Column(name = "role_id")
    private int roleId;

    @Column(name = "is_valid")
    private String isValid;
}
