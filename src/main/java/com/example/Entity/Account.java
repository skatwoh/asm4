package com.example.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Table(name = "tai_khoan")
@Entity
@Getter
@Setter
public class Account implements Serializable {

    @Id
    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private String roles;
}
