package com.database.ormlibrary.user;

import javax.persistence.Embeddable;

@Embeddable
public class ThemesEntity {

    private Boolean dark;

    public Boolean getDark() {
        return dark;
    }

    public ThemesEntity setDark(Boolean dark) {
        this.dark = dark;
        return this;
    }
}
