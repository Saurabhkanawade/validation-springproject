package com.example.validation.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "person")
public class PersonEntity {
    @Id
    @SequenceGenerator(name = "seq_person_id",initialValue = 1,sequenceName = "seq_person_id",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_person_id")
    private Long id;

    @Column(name= "name")
    private String Name;

    @Column(name= "email")
    private String Email;

    @Column(name="mobileno")
    private String mobileNumber;

    @Column(name= "gender")
    private String gender;

    @Column(name= "age")
    private Byte age;

    @Column(name= "nationality")
    private String nationality;
}