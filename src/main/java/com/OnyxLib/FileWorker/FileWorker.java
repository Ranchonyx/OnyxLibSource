package com.OnyxLib.FileWorker;
import com.sun.istack.internal.NotNull;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileWorker {

	public FileWorker() {}
	
	public String[] stringArrayFromFile(@NotNull File f) throws IOException, FileNotFoundException {
		String path = f.getAbsolutePath();
		List<String> arrayList = new ArrayList<String>();
		String ln = "";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			while(ln != null) {
				
				ln = reader.readLine();
				if(ln == null) {
					reader.close();
					break;
				}
				arrayList.add(ln);
			}
		} catch(IOException fnex) {
			fnex.printStackTrace();
		}

		String[] out = new String[arrayList.size()];
		for(int i = 0; i < out.length; i++) {
			out[i] = arrayList.get(i);
		}
		return out;
	}
	
	public void writeStringArraytoFile(String[] array, File target) throws FileNotFoundException, IOException {
		try {
		FileWriter writer = new FileWriter(target.getAbsolutePath());
			for (String s : array) {
				writer.write(s + System.lineSeparator());
			}
		writer.close();
		
		} catch(IOException ioex) {
			ioex.printStackTrace();
		}
	}


	

}
