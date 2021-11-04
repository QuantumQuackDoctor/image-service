package com.ss.image.imgScaling;

import java.io.IOException;

public interface ImageCompression {
    byte[] compress(ImageSource imageSource, Aspect aspect) throws IOException;
}
