package com.ss.image.imgScaling;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SquareCompressed implements ImageFormat {
    private final int size;
    @Override
    public int width() {
        return size;
    }

    @Override
    public int height() {
        return size;
    }

    @Override
    public float compression() {
        return 0.5f;
    }
}
