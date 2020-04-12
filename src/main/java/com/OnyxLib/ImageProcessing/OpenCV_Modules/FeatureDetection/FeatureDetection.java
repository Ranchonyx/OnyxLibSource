package com.OnyxLib.ImageProcessing.OpenCV_Modules.FeatureDetection;
import java.io.File;
import java.io.IOException;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
public class FeatureDetection {

    static{
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    private int detections;
    private String cascade;
    private String outputPath;
    private File loadedImageFile;
    private Mat imageMatrix;
    public FeatureDetection() {
    }
    public void loadCascade(String pCascade) {
        this.cascade = pCascade;
    }
    public void loadImage(File pFile) {
        this.loadedImageFile = pFile;
    }
    public void setOutputPath(String pOutputPath) {
        this.outputPath = pOutputPath;
    }
    public void detectFeatures() throws IOException {
        this.detections = 0;
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        CascadeClassifier faceDetector = new CascadeClassifier();
        faceDetector.load(cascade);
        this.imageMatrix = Imgcodecs.imread(this.loadedImageFile.getAbsolutePath());
        MatOfRect faceDetections = new MatOfRect();
        faceDetector.detectMultiScale(this.imageMatrix,faceDetections);

        for(Rect  rect : faceDetections.toArray()) {
            Imgproc.rectangle(this.imageMatrix, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height), new Scalar(0,0,255), 2);
            this.detections++;

        }

    }
    public void writeFilewithImage() {
        Imgcodecs.imwrite(outputPath, this.imageMatrix);
    }
    public int getDetections() {
        return this.detections;
    }
}