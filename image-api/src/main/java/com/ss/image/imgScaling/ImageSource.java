package com.ss.image.imgScaling;

import java.io.File;
import java.io.IOException;

public interface ImageSource {
    File asFile() throws IOException;
}
