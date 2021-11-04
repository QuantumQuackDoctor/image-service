package com.ss.image.api;

import com.ss.image.errors.ImageNotFoundException;
import com.ss.image.imgScaling.Aspect;
import com.ss.image.models.UploadReturn;
import com.ss.image.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(value = "/image")
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageService;

    @GetMapping(value = "/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<Resource> getImage(@PathVariable("id") Long id) throws ImageNotFoundException {
        return ResponseEntity.ok(imageService.getImage(id));
    }

    @PostMapping(value = "/upload/{aspect}")
    public ResponseEntity<UploadReturn> uploadImage(@RequestPart("image") MultipartFile file,
                                                    @PathVariable Aspect aspect) throws IOException {
        UploadReturn uploadReturn = new UploadReturn();
        uploadReturn.setId(imageService.storeImage(file, aspect));
        return ResponseEntity.ok().body(uploadReturn);
    }
}
