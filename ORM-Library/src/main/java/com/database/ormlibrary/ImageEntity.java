package com.database.ormlibrary;

import javax.persistence.*;

@Entity
public class ImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Lob
    private byte[] image; //ByteArrayInputStream

    public Long getId() {
        return id;
    }

    public ImageEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public byte[] getImage() {
        return image;
    }

    public ImageEntity setImage(byte[] image) {
        this.image = image;
        return this;
    }
}
