package com.blu.personservice.cif.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PERSON")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "FIRST_NAME", nullable=false, length = 25)
    @NonNull
    private String firstName;

    @Column(name = "LAST_NAME", nullable=false, length = 40)
    @NonNull
    private String lastName;

    @Column(name = "NATIONAL_CODE", nullable=false, unique = true, length = 10)
    @NonNull
    private String nationalCode;

    @Column(name = "HOME_ADDRESS", nullable=false, length = 255)
    @NonNull
    private String homeAddress;

    @Column(name = "PHONE_NUMBER", nullable=false, length = 11)
    @NonNull
    private String phoneNumber;

}
