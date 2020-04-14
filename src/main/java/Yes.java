import com.onyxlib.ImageProcessing.OpenCV_Modules.FeatureDetection.FeatureDetection;

import java.io.File;
import java.io.IOException;

class Yes {
    public static void main(String[] args) throws IOException {

        FeatureDetection fd = new FeatureDetection();

        fd.setOutputPath("D:\\meh\\outImage.png");
        fd.loadCascade("D:\\meh\\haarcascade_frontalface_alt.xml");
        fd.loadImage(new File("D:\\meh\\downloadedImage.jpg"));
        fd.detectFeatures();
        fd.writeFilewithImage();

    }
}