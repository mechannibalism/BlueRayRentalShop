package com.mechannibalism.bluerayrentalshop.persistence.entity;

import java.time.LocalDate;

public class RentalTransaction {

    private String transactionId;
    private LocalDate rentalDate;
    private LocalDate returnDate;
    private BluRayDisc disc;
    private Customer customer;

    // Конструктор
    public RentalTransaction(String transactionId, LocalDate rentalDate, LocalDate returnDate,
        BluRayDisc disc, Customer customer) {
        this.transactionId = transactionId;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.disc = disc;
        this.customer = customer;
    }

    // Геттери та сеттери
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDate rentalDate) {
        this.rentalDate = rentalDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public BluRayDisc getDisc() {
        return disc;
    }

    public void setDisc(BluRayDisc disc) {
        this.disc = disc;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    // Інші методи та функції, які можуть знадобитися...
}
