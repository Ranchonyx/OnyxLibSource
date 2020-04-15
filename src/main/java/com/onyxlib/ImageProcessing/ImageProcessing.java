package com.onyxlib.ImageProcessing;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Path;

import com.onyxlib.ImageProcessing.ImageFilters.*;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;

import javax.imageio.ImageIO;

public class ImageProcessing {
	
	public ImageProcessing() {}

	static {System.loadLibrary(Core.NATIVE_LIBRARY_NAME);}

	public ImageFilters imgfil = new ImageFilters();
	public BufferedImage applyFilter(BufferedImage img, Filters filter, int value, boolean reverse) {
		BufferedImage tmp = img;
		switch(filter) {
		case ALPHA:
			for(int x = 0; x < tmp.getWidth(); x++) {
				for(int y = 0; y < tmp.getHeight(); y++) {
					int oldRgb = tmp.getRGB(x, y);
					int newRgb = imgfil.alphaFilter(oldRgb, value, reverse);
					tmp.setRGB(x, y, newRgb);
				}
			}
			break;
		case RED:
			for(int x = 0; x < tmp.getWidth(); x++) {
				for(int y = 0; y < tmp.getHeight(); y++) {
					int oldRgb = tmp.getRGB(x, y);
					int newRgb = imgfil.redFilter(oldRgb, value, reverse);
					tmp.setRGB(x, y, newRgb);
				}
			}
			break;
		case GREEN:
			for(int x = 0; x < tmp.getWidth(); x++) {
				for(int y = 0; y < tmp.getHeight(); y++) {
					int oldRgb = tmp.getRGB(x, y);
					int newRgb = imgfil.greenFilter(oldRgb, value, reverse);
					tmp.setRGB(x, y, newRgb);
				}
			}
			break;
		case BLUE:
			for(int x = 0; x < tmp.getWidth(); x++) {
				for(int y = 0; y < tmp.getHeight(); y++) {
					int oldRgb = tmp.getRGB(x, y);
					int newRgb = imgfil.blueFilter(oldRgb, value, reverse);
					tmp.setRGB(x, y, newRgb);
				}
			}
			break;
		default:
			
		}
		return tmp;
	}

	public boolean writeFile(BufferedImage pImg, String pFormat, File pFile) throws IOException {
		try {
			ImageIO.write(pImg, pFormat, pFile);
		} catch(IOException ioex) {
			return false;
		}
		return true;
	}

	public boolean writeFile(BufferedImage pImg, String pFormat, String filePath) throws IOException {
		try {
			ImageIO.write(pImg, pFormat, new File(filePath));
		} catch(IOException ioex) {
			return false;
		}
		return true;
	}
	public boolean writeFile(Image pImg, String pFormat, File pFile) throws IOException {
		try {
			BufferedImage tmp = new BufferedImage(pImg.getWidth(null), pImg.getHeight(null),BufferedImage.TYPE_INT_ARGB);
			Graphics tmpGraphics = tmp.getGraphics();
			tmpGraphics.drawImage(pImg, 0,0,null);
			ImageIO.write(tmp, pFormat, pFile);
		} catch(IOException ioex) {
			ioex.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean writeFile(Image pImg, String pFormat, String filePath) throws IOException {
		try {
			BufferedImage tmp = new BufferedImage(pImg.getWidth(null), pImg.getHeight(null),BufferedImage.TYPE_INT_ARGB);
			Graphics tmpGraphics = tmp.getGraphics();
			tmpGraphics.drawImage(pImg, 0,0,null);
			ImageIO.write(tmp, pFormat, new File(filePath));
		} catch(IOException ioex) {
			ioex.printStackTrace();
			return false;
		}
		return true;
	}

	public void writeImagesToDirectory(BufferedImage[] images, String directory, String format, String generalName) throws IOException {
		String discriminator = null;
		int i = 0;
		for (BufferedImage x : images) {
			String path = directory +
					generalName +
					"_" +
					i +
					format;
				if(x == null) {
					break;
				}
			ImageIO.write(x,"png",new File(path));

			i++;

		}
	}

	// FIXME: 12.04.2020 THIS IS STACKOVERFLOW CODE  MAKE YOUR OWN SOLUTION
	public BufferedImage bufferedImageFromMat(Mat in) throws IOException {
		System.out.println("Converted Matrix to Image");
		MatOfByte mob=new MatOfByte();
		Imgcodecs.imencode(".png", in, mob);
		return ImageIO.read(new ByteArrayInputStream(mob.toArray()));
	}
	
}
