package org.example.designmovieticketbookingtool.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name="razorpay_payments")
public class RazorpayPayment extends BaseModel{
    private int txnId;
    @Enumerated(value = EnumType.STRING)
    private PaymentMode paymentMode;
    @ManyToOne
    private Payment payment;
}
