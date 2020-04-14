package com.onyxlib.ImageProcessing.ImageFilters;
import java.awt.Color;

import com.onyxlib.ImageProcessing.ARGB.ARGB;

public class ImageFilters {

	public ARGB converter = new ARGB();
	
public int redFilter(int rgba, int offset, boolean reverse) {
		
		int filteredColor = 0;
		int r,g,b,a;
		
		if(reverse) {
			Color color = converter.toColor(rgba);
			a = color.getAlpha();
			r = color.getRed();
			r -= offset;
			g = color.getGreen();
			b = color.getBlue();
			filteredColor = converter.create(a,r,g,b);
			
		} else {
			
			Color color = converter.toColor(rgba);
			a = color.getAlpha();
			r = color.getRed();
			r += offset;
			g = color.getGreen();
			b = color.getBlue();
			filteredColor = converter.create(a,r,g,b);
			
		}
		return filteredColor;
	}
	
public int greenFilter(int rgba, int offset, boolean reverse) {
		
		int filteredColor = 0;
		int r,g,b,a;
		
		if(reverse) {
			Color color = converter.toColor(rgba);
			a = color.getAlpha();
			r = color.getRed();
			g = color.getGreen();
			g -= offset;
			b = color.getBlue();
			filteredColor = converter.create(a,r,g,b);
			
		} else {
			
			Color color = converter.toColor(rgba);
			a = color.getAlpha();
			r = color.getRed();
			g = color.getGreen();
			g += offset;
			b = color.getBlue();
			filteredColor = converter.create(a,r,g,b);
			
		}
		return filteredColor;
	}

public int blueFilter(int rgba, int offset, boolean reverse) {
	
	int filteredColor = 0;
	int r,g,b,a;
	
	if(reverse) {
		Color color = converter.toColor(rgba);
		a = color.getAlpha();
		r = color.getRed();
		g = color.getGreen();
		b = color.getBlue();
		b -= offset;
		filteredColor = converter.create(a,r,g,b);
		
	} else {
		
		Color color = converter.toColor(rgba);
		a = color.getAlpha();
		r = color.getRed();
		g = color.getGreen();
		b = color.getBlue();
		b += offset;
		filteredColor = converter.create(a,r,g,b);
		
	}
	return filteredColor;
}


public int alphaFilter(int rgba, int offset, boolean reverse) {
	
	int filteredColor = 0;
	int r,g,b,a;
	
	if(reverse) {
		Color color = converter.toColor(rgba);
		a = color.getAlpha();
		a -= offset;
		r = color.getRed();
		g = color.getGreen();
		b = color.getBlue();
		filteredColor = converter.create(a,r,g,b);
		
	} else {
		
		Color color = converter.toColor(rgba);
		a = color.getAlpha();
		a += offset;
		r = color.getRed();
		g = color.getGreen();
		b = color.getBlue();
		filteredColor = converter.create(a,r,g,b);
		
	}
	return filteredColor;
}}