package com.ss.image.imgScaling;

import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@RequiredArgsConstructor
public class ImageMultipart implements ImageSource{

    private final MultipartFile multipartFile;

    @Override
    public File asFile() throws IOException {
        File imageFile = Files.createTempFile("image_upload_", ".tmp").toFile();
        multipartFile.transferTo(imageFile);

        return imageFile;
    }
}
