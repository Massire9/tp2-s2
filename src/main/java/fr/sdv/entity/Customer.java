package fr.sdv.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "customer", schema = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DISCOUNT_CODE", nullable = false)
    private Discount discountCode;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ZIP", nullable = false)
    private MicroMarket zip;

    @Column(name = "NAME", length = 30)
    private String name;

    @Column(name = "ADDRESSLINE1", length = 30)
    private String addressline1;

    @Column(name = "ADDRESSLINE2", length = 30)
    private String addressline2;

    @Column(name = "CITY", length = 25)
    private String city;

    @Column(name = "STATE", length = 2)
    private String state;

    @Column(name = "PHONE", length = 12)
    private String phone;

    @Column(name = "FAX", length = 12)
    private String fax;

    @Column(name = "EMAIL", length = 40)
    private String email;

    @Column(name = "CREDIT_LIMIT")
    private Integer creditLimit;

    public Customer(String name, String addressline1, String addressline2, String city, String state, String phone, String fax, String email, Integer creditLimit) {
        this.name = name;
        this.addressline1 = addressline1;
        this.addressline2 = addressline2;
        this.city = city;
        this.state = state;
        this.phone = phone;
        this.fax = fax;
        this.email = email;
        this.creditLimit = creditLimit;
    }

    public Customer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Discount getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(Discount discountCode) {
        this.discountCode = discountCode;
    }

    public MicroMarket getZip() {
        return zip;
    }

    public void setZip(MicroMarket zip) {
        this.zip = zip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddressline1() {
        return addressline1;
    }

    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }

    public String getAddressline2() {
        return addressline2;
    }

    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Integer creditLimit) {
        this.creditLimit = creditLimit;
    }

}