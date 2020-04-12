package com.OnyxLib.Gmail.Contact;
import java.awt.image.BufferedImage;


public class Contact {
	@SuppressWarnings("unused")
	private String extension = ".ocf";
	private String name;
	private String emailAddress;
	private BufferedImage contactPhoto = null;
	public Contact(String pName, String pEmailAddress) {
		this.name = pName;
		this.emailAddress = pEmailAddress;
	}
	
	public Contact(String pName, String pEmailAddress, BufferedImage pContactPhoto) {
		this.name = pName;
		this.emailAddress = pEmailAddress;
		this.contactPhoto = pContactPhoto;
	}
	
	public String getContactName() {
		return this.name;
	}
	public String getContactEmail() {
		return this.emailAddress;
	}
	public BufferedImage getContactPhoto() {
		return this.contactPhoto;
	}
	public void setContactName(String pName) {
		this.name = pName;
	}
	public void setContactEmail(String pEmail) {
		this.emailAddress = pEmail;
	}
	public void setContactPhoto(BufferedImage pImage) {
		this.contactPhoto = pImage;
	}
}