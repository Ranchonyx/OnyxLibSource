package com.OnyxLib.SoundWorker;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;
import java.net.MalformedURLException;
import java.applet.Applet;
import java.applet.AudioClip;

public class SoundWorker {
	
	TargetDataLine line = null;;


	public SoundWorker() {}
	
	public void playSound(File f) throws MalformedURLException {
		@SuppressWarnings("deprecation")
		AudioClip a = Applet.newAudioClip(f.toURL());
		a.play();
	}
	
	AudioFormat getAudioFormat(float sampleRate, int channels) {
		 int sampleSizeInBits = 16;
		 boolean signed = true;
		 boolean bigEndian = true;
		 return new AudioFormat(sampleRate, sampleSizeInBits, channels, signed, bigEndian);
	}
	
	public void stop(TargetDataLine ln, AudioInputStream ais) {
		try {
			ais.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ln.stop();
		ln.close();
	}
	
//	@Deprecated
//	public void n(File f,AudioFileFormat.Type auf, long duration) throws LineUnavailableException, IOException, InterruptedException  {
//
//		AudioFileFormat.Type fileType = auf;
//		AudioFormat format = getAudioFormat(44000, 2);
//		DataLine.Info lineInfo = new DataLine.Info(TargetDataLine.class, format);
//		if(!AudioSystem.isLineSupported(lineInfo)) {
//			System.out.println("Line not Supported!\nTry another line");
//			System.exit(1);
//		}
//		line = (TargetDataLine) AudioSystem.getLine(lineInfo);
//		line.open(format);
//		line.start();
//		AudioInputStream ais = new AudioInputStream(line);
//		AudioSystem.write(ais, fileType, f);
//		stop(line,ais);
//	}
//	
	
	public void getSound(long duration, AudioInputStream ais) {
		 @SuppressWarnings("unused")
		Thread stopper = new Thread(new Runnable() {
	            public void run() {
	                try {
	                    Thread.sleep(duration);
	                } catch (InterruptedException ex) {
	                    ex.printStackTrace();
	                }
	                stop(line,ais);
	            }
	        });
		
	}
}
