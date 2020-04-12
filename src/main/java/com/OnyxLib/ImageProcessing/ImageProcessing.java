package com.OnyxLib.ImageProcessing;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import com.OnyxLib.ImageProcessing.ImageFilters.*;
import com.sun.javaws.exceptions.InvalidArgumentException;
import org.opencv.core.Core;
import org.opencv.core.Mat;

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

	public void writeImagesToDirectory(BufferedImage[] images, String directory, String format, String generalName, String discriminator) throws IOException, InvalidArgumentException {
		for (BufferedImage x : images) {
			if(x == null) {
				System.exit(1);
				ImageIO.write(x, format, new File(directory+=generalName+=discriminator));
			}
			System.out.println("ImageData: "+x);

		}
	}

	// FIXME: 12.04.2020 THIS IS STACKOVERFLOW CODE  MAKE YOUR OWN SOLUTION
	public BufferedImage bufferedImageFromMat(Mat in, int x, int y) {
		BufferedImage out;
		byte[] data = new byte[x * y * (int)in.elemSize()];
		int type;
		in.get(0, 0, data);

		if(in.channels() == 1)
			type = BufferedImage.TYPE_BYTE_GRAY;
		else
			type = BufferedImage.TYPE_3BYTE_BGR;

		out = new BufferedImage(320, 240, type);

		out.getRaster().setDataElements(0, 0, 320, 240, data);
		return out;
	}
	
}
