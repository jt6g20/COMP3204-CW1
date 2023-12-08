package uk.ac.soton.ecs.jt6g20.hybridimages;

import org.openimaj.image.MBFImage;

public class MyHybridImages {
    /**
     * Compute a hybrid image combining low-pass and high-pass filtered images
     *
     * @param lowImage
     * the image to which apply the low pass filter
     * @param lowSigma
     * the standard deviation of the low-pass filter
     * @param highImage
     * the image to which apply the high pass filter
     * @param highSigma
     * the standard deviation of the low-pass component of computing the
     * high-pass filtered image
     * @return the computed hybrid image
     */
    public static MBFImage makeHybrid(MBFImage lowImage, float lowSigma, MBFImage highImage, float highSigma) {

        MyConvolution lowConvolution = new MyConvolution(makeGaussianKernel(lowSigma));
        MyConvolution highConvolution = new MyConvolution(makeGaussianKernel(highSigma));

        lowImage = lowImage.process(lowConvolution);
        highImage = highImage.subtract(highImage.process(highConvolution));

        return lowImage.add(highImage);
    }

    public static float[][] makeGaussianKernel(float sigma) {

        int size = (int) (8.0f * sigma + 1.0f); // (this implies the window is +/- 4 sigmas from the centre of the Gaussian)
        if (size % 2 == 0) size++; // size must be odd

        float[][] kernel = new float[size][size];
        int centre = size/2;

        float sum = 0;

        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++) {
                double normalisation = 1 / (2 * Math.PI * Math.pow(sigma, 2));
                float newValue = (float) (normalisation * Math.exp((-(Math.pow(i-centre,2)+Math.pow(j-centre,2))) / (2 * Math.pow(sigma, 2))));
                kernel[j][i] = newValue;
                sum += newValue;
            }
        }

        // Normalisation
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++) {
                kernel[j][i] = kernel[j][i] / sum;
            }
        }

        return kernel;
    }
}
