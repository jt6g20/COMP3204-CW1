package uk.ac.soton.ecs.jt6g20.hybridimages;

import junit.framework.TestCase;
import static org.junit.Assert.*;
import org.junit.Test;

public class MyHybridImagesTest extends TestCase {
    MyHybridImages myHybridImages;

    public void testMakeHybrid() {
    }

    public void testMakeGaussianKernel() {
        float[][] kernel1 = new float[][]{{6.96247819e-08f, 2.80886418e-05f, 2.07548550e-04f, 2.80886418e-05f, 6.96247819e-08f},
                {2.80886418e-05f, 1.13317669e-02f, 8.37310610e-02f, 1.13317669e-02f, 2.80886418e-05f},
                {2.07548550e-04f, 8.37310610e-02f, 6.18693507e-01f, 8.37310610e-02f, 2.07548550e-04f},
                {2.80886418e-05f, 1.13317669e-02f, 8.37310610e-02f, 1.13317669e-02f, 2.80886418e-05f},
                {6.96247819e-08f, 2.80886418e-05f, 2.07548550e-04f, 2.80886418e-05f, 6.96247819e-08f}};

        assertArrayEquals(kernel1, myHybridImages.makeGaussianKernel(0.5f));
    }
}