package com.onyxlib.Gmail;
import com.onyxlib.FileWorker.FileWorker;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class RecipientList {

	private File recipientFile = null;
	private String path = null;
	private String[] recipients;
	
	public RecipientList(File pRecipientFile) throws IOException {
		FileWorker fw = new FileWorker();
		
		this.recipientFile = pRecipientFile;
	    path = recipientFile.getAbsolutePath();
	    recipients = fw.stringArrayFromFile(recipientFile);
	}
	
	public String[] getRecipients() {
		return this.recipients;
	}
	public String getPath() {
		return this.path;
	}
	
}
