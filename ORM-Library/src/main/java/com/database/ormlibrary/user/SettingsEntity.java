package com.database.ormlibrary.user;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.util.Objects;

@Embeddable
public class SettingsEntity {

    @Embedded
    private ThemesEntity themes;
    @Embedded
    private NotificationsEntity notifications;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SettingsEntity entity = (SettingsEntity) o;
        return Objects.equals(themes, entity.themes) && Objects.equals(notifications, entity.notifications);
    }

    @Override
    public int hashCode() {
        return Objects.hash(themes, notifications);
    }

    public ThemesEntity getThemes() {
        return themes;
    }

    public SettingsEntity setThemes(ThemesEntity themes) {
        this.themes = themes;
        return this;
    }

    public NotificationsEntity getNotifications() {
        return notifications;
    }

    public SettingsEntity setNotifications(NotificationsEntity notifications) {
        this.notifications = notifications;
        return this;
    }
}
