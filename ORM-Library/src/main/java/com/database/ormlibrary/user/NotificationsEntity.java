package com.database.ormlibrary.user;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class NotificationsEntity {

    private Boolean emailOption;
    private Boolean emailOrder;
    private Boolean emailDelivery;
    private Boolean phoneOption;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotificationsEntity that = (NotificationsEntity) o;
        return Objects.equals(emailOption, that.emailOption) && Objects.equals(emailOrder, that.emailOrder) && Objects.equals(emailDelivery, that.emailDelivery) && Objects.equals(phoneOption, that.phoneOption);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailOption, emailOrder, emailDelivery, phoneOption);
    }

    public Boolean getEmailOrder() {
        return emailOrder;
    }

    public NotificationsEntity setEmailOrder(Boolean emailOrder) {
        this.emailOrder = emailOrder;
        return this;
    }

    public Boolean getEmailDelivery() {
        return emailDelivery;
    }

    public NotificationsEntity setEmailDelivery(Boolean emailDelivery) {
        this.emailDelivery = emailDelivery;
        return this;
    }

    public Boolean getEmail() {
        return emailOption;
    }

    public NotificationsEntity setEmail(Boolean emailOption) {
        this.emailOption = emailOption;
        return this;
    }

    public Boolean getPhoneOption() {
        return phoneOption;
    }

    public NotificationsEntity setPhoneOption(Boolean phoneOption) {
        this.phoneOption = phoneOption;
        return this;
    }
}
