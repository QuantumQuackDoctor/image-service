package com.database.ormlibrary;

import javax.persistence.Embeddable;

@Embeddable
public class CoordinatesEmbeddable {
    private Double latitude;
    private Double longitude;

    public Double getLatitude() {
        return latitude;
    }

    public CoordinatesEmbeddable setLatitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public Double getLongitude() {
        return longitude;
    }

    public CoordinatesEmbeddable setLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }
}
