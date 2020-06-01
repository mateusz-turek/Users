package com.mat.users.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "AGE")
    private int age;

}

