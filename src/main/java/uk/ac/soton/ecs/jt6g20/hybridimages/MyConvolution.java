package uk.ac.soton.ecs.jt6g20.hybridimages;

import org.openimaj.image.FImage;
import org.openimaj.image.processor.SinglebandImageProcessor;

public class MyConvolution implements SinglebandImageProcessor<Float, FImage> {
    private float[][] kernel;

    public MyConvolution(float[][] kernel) {
        this.kernel = kernel;
    }

    @Override
    public void processImage(FImage image) {

        FImage result = image;

        for (int cy=0; cy<image.getHeight(); cy++) {
            for(int cx=0; cx<image.getWidth(); cx++) {

                float newPixel = 0;

                int kernelHeight = kernel.length;
                int kernelWidth = kernel[0].length;

                int image_kernel_start_y = cy - kernelHeight/2;
                int image_kernel_start_x = cx - kernelWidth/2;

                for (int ky = 0; ky < kernelHeight; ky++) {
                    for (int kx = 0; kx < kernelWidth; kx++) {
                        int y = image_kernel_start_y + ky;
                        int x = image_kernel_start_x + kx;

                        if (y < 0 || x < 0 || y > image.getHeight()-1 || x > image.getWidth()-1) {
                            newPixel += 0;
                        } else {
                            newPixel += image.pixels[y][x] * kernel[ky][kx];
                        }
                    }
                }

                result.pixels[cy][cx] = newPixel;
            }
        }

        image.internalAssign(result);
    }
}