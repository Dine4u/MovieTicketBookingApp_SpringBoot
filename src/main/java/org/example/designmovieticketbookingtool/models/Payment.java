package org.example.designmovieticketbookingtool.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data       //Generates Getters and Setters
@Entity(name="payments")
public abstract class Payment extends BaseModel {
    private double amount;
    @Enumerated
    private PaymentStatus paymentStatus;
    private Date paymentDate;

    @OneToMany(mappedBy = "payment")
    private List<RazorpayPayment> razorpayPayments;

    @OneToMany(mappedBy = "payment")
    private List<GiftCardPayment> giftCardPayments;
}
