package com.ss.image.imgScaling;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class JpgImageCompression implements ImageCompression {
    @Override
    public byte[] compress(ImageSource imageSource, Aspect aspect) throws IOException {
        File imageSourceFile = imageSource.asFile();

        return new JpgImage(imageSourceFile, aspect).compress();
    }
}
