package fr.sdv.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "discount", schema = "customer")
public class Discount {
    @Id
    @Column(name = "CODE", nullable = false)
    private Character id;

    @Column(name = "RATE", precision = 4, scale = 2)
    private BigDecimal rate;

    public Character getId() {
        return id;
    }

    public void setId(Character id) {
        this.id = id;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

}