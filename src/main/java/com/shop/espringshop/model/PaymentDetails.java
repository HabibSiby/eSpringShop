package com.shop.espringshop.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDetails {
    private String paymentMethod; //Class
    private String status; //Class PaymentStatus
    private String paymentId;
    private String razorpayPaymentLinkReferenceId;
    private String razorpayPaymentLinkStatus;
    private String razorpayPaymentId;
}
