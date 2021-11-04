package com.ss.image.repo;

import com.database.ormlibrary.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepo extends JpaRepository<ImageEntity, Long> {
}
