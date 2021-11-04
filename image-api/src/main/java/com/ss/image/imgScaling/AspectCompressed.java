package com.ss.image.imgScaling;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AspectCompressed implements ImageFormat{
    private final float ratio;
    private final int width;

    @Override
    public int width() {
        return width;
    }

    @Override
    public int height() {
        return (int) (width / ratio);
    }

    @Override
    public float compression() {
        return 0.5f;
    }
}
