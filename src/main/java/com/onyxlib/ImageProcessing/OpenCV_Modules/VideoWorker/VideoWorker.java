package com.onyxlib.ImageProcessing.OpenCV_Modules.VideoWorker;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import com.onyxlib.ImageProcessing.ImageProcessing;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;


public class VideoWorker {

    public VideoWorker() {}
static {System.loadLibrary(Core.NATIVE_LIBRARY_NAME);}

    private Mat[] frames;

    public void extractFrames(File pInput) {
        String inputPath = pInput.getAbsolutePath();
        VideoCapture vcap = new VideoCapture();
        vcap.open(inputPath);

        int vidlen = (int) vcap.get(Videoio.CAP_PROP_FRAME_COUNT);
        int fps = (int) vcap.get(Videoio.CAP_PROP_FPS);
        int fn = (int) vcap.get(Videoio.CAP_PROP_POS_FRAMES);
        frames = new Mat[vidlen];
        if(vcap.isOpened()) {
            Mat currentFrame = new Mat();
            int frameNumber = 0;
            while (vcap.read(currentFrame)) {
                frames[frameNumber] = currentFrame;
                currentFrame = new Mat();
                System.out.println("Frame Number: " + frameNumber + " , Frame Value " + frames[frameNumber]);
                frameNumber++;

            }
            vcap.release();
        }


    }
    public void writeFrames(String dir, String generalName) throws IOException {
        ImageProcessing imgp = new ImageProcessing();
        BufferedImage[] imageFrames = new BufferedImage[frames.length-1];
        for(int i = 0; i < frames.length-1; i++) {
            if(frames[i] == null) {
                break;
            }
            imageFrames[i] = imgp.bufferedImageFromMat(frames[i]);
        }



        System.out.println("Writing files to disk...");
        imgp.writeImagesToDirectory(imageFrames, dir,".png",generalName);
    }
    public Mat[] getFrames() {
        return this.frames;
    }

}
