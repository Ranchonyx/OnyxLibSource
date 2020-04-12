package com.OnyxLib.ImageProcessing.ARGB;

import java.awt.Color;

public class ARGB {
	
	public ARGB() {}
	
	public int create(int a, int r, int g, int b) {
		return  (a<<24) | (r<<16) | (g<<8) | b;
	}
	
	public int toInt(Color color) {
		int a,r,g,b;
		a = color.getAlpha();
		r = color.getRed();
		g = color.getGreen();
		b = color.getBlue();
		return  (a<<24) | (r<<16) | (g<<8) | b;
	}
	
	public Color toColor(int argb) {
		return new Color(argb);
	}
	
}
