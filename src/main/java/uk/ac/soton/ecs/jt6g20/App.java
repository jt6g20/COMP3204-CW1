package uk.ac.soton.ecs.jt6g20;

import org.openimaj.image.DisplayUtilities;
import org.openimaj.image.FImage;
import org.openimaj.image.ImageUtilities;
import org.openimaj.image.MBFImage;
import org.openimaj.image.colour.ColourSpace;
import org.openimaj.image.colour.RGBColour;
import org.openimaj.image.processing.convolution.FGaussianConvolve;
import org.openimaj.image.processing.edges.CannyEdgeDetector;
import org.openimaj.image.typography.hershey.HersheyFont;
import org.openimaj.video.Video;
import org.openimaj.video.VideoDisplay;
import org.openimaj.video.xuggle.XuggleVideo;
import uk.ac.soton.ecs.jt6g20.hybridimages.MyConvolution;
import uk.ac.soton.ecs.jt6g20.hybridimages.MyHybridImages;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * OpenIMAJ Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws IOException {
        MBFImage image1 = ImageUtilities.readMBF(new File("jodie.png"));
        MBFImage image2 = ImageUtilities.readMBF(new File("david.png"));

        MBFImage image = MyHybridImages.makeHybrid(image1, 3f, image2, 5f);

        DisplayUtilities.display(image);
    }
}
