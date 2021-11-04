package com.ss.image.service;

import com.database.ormlibrary.ImageEntity;
import com.ss.image.errors.ImageNotFoundException;
import com.ss.image.imgScaling.Aspect;
import com.ss.image.imgScaling.ImageMultipart;
import com.ss.image.imgScaling.JpgImageCompression;
import com.ss.image.repo.ImageRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final JpgImageCompression jpgCompression;
    private final ImageRepo imageRepo;

    public long storeImage(MultipartFile file, Aspect aspect) throws IOException {
        byte[] imageBytes = jpgCompression.compress(new ImageMultipart(file), aspect);
        ImageEntity image = new ImageEntity();
        image.setImage(imageBytes);
        image = imageRepo.save(image);
        return image.getId();
    }

    public Resource getImage(Long id) throws ImageNotFoundException {
        ImageEntity image = imageRepo.findById(id).orElseThrow(ImageNotFoundException::new);
        return new ByteArrayResource(image.getImage());
    }
}
