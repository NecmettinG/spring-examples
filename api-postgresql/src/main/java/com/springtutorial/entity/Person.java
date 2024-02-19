package com.springtutorial.entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Transactional
@Data
@NoArgsConstructor
@Table(name = "Persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "primary_id")
    private Long primary_id;

    @Column(length = 100, name = "username")
    private String username;

    @Column(length = 100, name = "password")
    private String password;

    @Column(length = 100, name = "person_status")
    private Boolean status;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_primary_id", referencedColumnName = "primary_id")
    private List<Notes> notes;
}
