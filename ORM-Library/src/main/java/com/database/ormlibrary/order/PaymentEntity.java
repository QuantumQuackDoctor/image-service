package com.database.ormlibrary.order;

import javax.persistence.Embeddable;

@Embeddable
public class PaymentEntity {
    private String confirmationCode;
    private String status;
    private Integer type;

    public String getConfirmationCode() {
        return confirmationCode;
    }

    public PaymentEntity setConfirmationCode(String confirmationCode) {
        this.confirmationCode = confirmationCode;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public PaymentEntity setStatus(String status) {
        this.status = status;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public PaymentEntity setType(Integer type) {
        this.type = type;
        return this;
    }
}
