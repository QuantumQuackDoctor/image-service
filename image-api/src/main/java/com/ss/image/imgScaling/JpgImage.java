package com.ss.image.imgScaling;

import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class JpgImage {
    public static final String EXTENSION = "jpg";

    private final BufferedImage source;
    private final ImageFormat format;

    public JpgImage(File imageFile, Aspect aspect) throws IOException {
        source = ImageIO.read(imageFile);
        switch (aspect) {
            case square:
                this.format = new SquareCompressed(Math.min(Math.min(source.getWidth(), source.getHeight()), 1080 ));
                break;
            case maintain:
            default:
                this.format = new AspectCompressed(
                        (float) source.getWidth() / (float) source.getHeight(),
                        Math.max(source.getWidth(), 1920));
        }
    }

    public byte[] compress() throws IOException {
        BufferedImage resizedImage = resize(source);

        ByteArrayOutputStream baos = new ByteArrayOutputStream(); //doesn't need to be closed
        ImageIO.write(resizedImage, EXTENSION, baos);

        return baos.toByteArray();
    }

    private BufferedImage resize(BufferedImage source) throws IOException {
        return Scalr.resize(source, Scalr.Mode.FIT_EXACT, format.width(), format.height());
    }
}
