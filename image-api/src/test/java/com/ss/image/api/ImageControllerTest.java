package com.ss.image.api;

import com.database.ormlibrary.ImageEntity;
import com.jayway.jsonpath.JsonPath;
import com.ss.image.repo.ImageRepo;
import com.ss.image.service.ImageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ImageControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ImageRepo imageRepo;

    @Autowired
    ImageService imageService;

    @Test
    @WithMockUser(authorities = "admin")
    public void shouldUploadResizeAndCompressJpgFileMaintain() throws Exception {
        Path sourceImagePath = Paths.get(ClassLoader.getSystemResource("image.jpg").toURI());
        MockMultipartFile imageFile = new MockMultipartFile(
                "image", "image.jpg", "image/jpeg",
                Files.readAllBytes(sourceImagePath));

        MvcResult result = mockMvc.perform(multipart("/image/upload/maintain")
                        .file(imageFile))
                .andExpect(status().isOk())
                .andReturn();
        Long id = Long.valueOf(JsonPath.read(result.getResponse().getContentAsString(), "id").toString());

        ImageEntity imageEntity = imageRepo.findById(id).orElseThrow(() -> new Exception("imageEntity does not exist"));

        BufferedImage originalImage = ImageIO.read(new FileInputStream(sourceImagePath.toFile()));
        BufferedImage compressedImage = ImageIO.read(new ByteArrayInputStream(imageEntity.getImage()));

        //aspect ratio is maintained
        assertEquals(originalImage.getWidth() / originalImage.getHeight(),
                compressedImage.getWidth() / compressedImage.getHeight());
        //image is resized
        assertTrue(originalImage.getWidth() > compressedImage.getWidth());
        assertTrue(originalImage.getHeight() > compressedImage.getHeight());
        //image is compressed
        assertTrue(Files.size(sourceImagePath) > imageEntity.getImage().length);
    }

    @Test
    @WithMockUser(authorities = "admin")
    public void shouldUploadResizeAndCompressJpgFileSquare() throws Exception {
        Path sourceImagePath = Paths.get(ClassLoader.getSystemResource("image.jpg").toURI());
        MockMultipartFile imageFile = new MockMultipartFile(
                "image", "image.jpg", "image/jpeg",
                Files.readAllBytes(sourceImagePath));

        MvcResult result = mockMvc.perform(multipart("/image/upload/square")
                        .file(imageFile))
                .andExpect(status().isOk())
                .andReturn();
        Long id = Long.valueOf(JsonPath.read(result.getResponse().getContentAsString(), "id").toString());

        ImageEntity imageEntity = imageRepo.findById(id).orElseThrow(() -> new Exception("imageEntity does not exist"));

        BufferedImage originalImage = ImageIO.read(new FileInputStream(sourceImagePath.toFile()));
        BufferedImage compressedImage = ImageIO.read(new ByteArrayInputStream(imageEntity.getImage()));

        //aspect ratio is square
        assertEquals(1, compressedImage.getWidth() / compressedImage.getHeight());
        //image is resized
        assertTrue(originalImage.getWidth() > compressedImage.getWidth());
        assertTrue(originalImage.getHeight() > compressedImage.getHeight());
        //image is compressed
        assertTrue(Files.size(sourceImagePath) > imageEntity.getImage().length);
    }

    @Test
    public void getImageWithNoImageReturnsNotFound() throws Exception {
        mockMvc.perform(get("/image/171823")).andExpect(status().isNotFound());
    }

    @Test
    @WithMockUser(authorities = "admin") //necessary to insert image
    public void getImageShouldReturnImage() throws Exception {
        //don't know how to insert an image otherwise
        Path sourceImagePath = Paths.get(ClassLoader.getSystemResource("image.jpg").toURI());
        MockMultipartFile originalImageFile = new MockMultipartFile(
                "image", "image.jpg", "image/jpeg",
                Files.readAllBytes(sourceImagePath));

        MvcResult uploadResult = mockMvc.perform(multipart("/image/upload/square")
                        .file(originalImageFile))
                .andExpect(status().isOk())
                .andReturn();
        Long id = Long.valueOf(JsonPath.read(uploadResult.getResponse().getContentAsString(), "id").toString());

        ImageEntity imageEntity = imageRepo.findById(id).orElseThrow(() -> new Exception("imageEntity does not exist"));

        MvcResult result = mockMvc.perform(get("/image/" + id))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.IMAGE_JPEG))
                .andReturn();

        BufferedImage imageReturn = ImageIO.read(new ByteArrayInputStream(result.getResponse().getContentAsByteArray()));
        BufferedImage storedImage = ImageIO.read(new ByteArrayInputStream(imageEntity.getImage()));

        //check image dimensions
        assertEquals(imageReturn.getWidth(), storedImage.getWidth());
        assertEquals(imageReturn.getHeight(), storedImage.getHeight());

        assertEquals(imageReturn.getType(), storedImage.getType());
    }
}