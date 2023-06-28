package com.boris.stuff_members.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;


@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
public class Worker {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String firstName;
    String lastName;
    String middleName;
    String email;
    String phone;
    String PersonalId;
    String role;
    Date startingDate;
    Date endingDate;
    String gender;
    String education;
    String familyStatus;
    Integer kids;
    Double salary;

    public Worker() {
    }
}
