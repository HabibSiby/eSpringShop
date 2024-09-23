package com.shop.espringshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;
    @Column(name="street_address")
    private String street_address;
    @Column(name="city")
    private String city;
    @Column(name="state")
    private String state;

    @Column(name="zip_code")
    private String zipCode;
    @Column(name="mobile")
    private String mobile;

    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonIgnore
    private User user;


}