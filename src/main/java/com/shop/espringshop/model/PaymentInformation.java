package com.shop.espringshop.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Embeddable
@Getter
@Setter
public class PaymentInformation {

    @Column(name="cardholder_name")
    private String CardholderName;

    @Column(name="card_number")
    private String card_number;
    @Column(name="expiration_date")
    private LocalDateTime expiration_date;
    @Column(name="cvv")
    private String cvv;
}
