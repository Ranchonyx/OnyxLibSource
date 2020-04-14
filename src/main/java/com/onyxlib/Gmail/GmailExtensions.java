package com.onyxlib.Gmail;
import com.onyxlib.Gmail.ConfigWorker.ConfigWorker;


public class GmailExtensions {

	public GmailExtensions() {}
	
	public void sendEmailToRecipientList(ConfigWorker cfg, RecipientList list, String pSubject, String pText, boolean pHtml) {
		for(int i = 0; i < list.getRecipients().length; i++) {
			Gmail mail = new Gmail(cfg, list.getRecipients()[i], pSubject, pText, pHtml);
			mail.sendMail();
		} 
	}
	

}
