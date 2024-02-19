package com.springtutorial.entity;


import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Transactional
@Data
@NoArgsConstructor
@Table(name = "Notes")
public class Notes{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "primary_id")
    private Long primary_id;

    @Column(length = 100, name = "note_title")
    private String note_titles;

    @Column(length = 500, name = "note_content")
    private String note_content;

    @Column(name = "note_status")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

}
