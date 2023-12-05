package fr.sdv.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "micro_market", schema = "customer")
public class MicroMarket {
    @Id
    @Column(name = "ZIP_CODE", nullable = false, length = 10)
    private String zipCode;

    @Column(name = "RADIUS")
    private Double radius;

    @Column(name = "AREA_LENGTH")
    private Double areaLength;

    @Column(name = "AREA_WIDTH")
    private Double areaWidth;

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public Double getAreaLength() {
        return areaLength;
    }

    public void setAreaLength(Double areaLength) {
        this.areaLength = areaLength;
    }

    public Double getAreaWidth() {
        return areaWidth;
    }

    public void setAreaWidth(Double areaWidth) {
        this.areaWidth = areaWidth;
    }

}