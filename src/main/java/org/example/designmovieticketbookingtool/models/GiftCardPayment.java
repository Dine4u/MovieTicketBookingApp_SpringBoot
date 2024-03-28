package org.example.designmovieticketbookingtool.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name="giftcard_payments")
public class GiftCardPayment extends BaseModel{
    private int giftCardID;
    @ManyToOne
    private Payment payment;
}
