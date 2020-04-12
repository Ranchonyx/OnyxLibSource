package com.OnyxLib.ObjectSerializer;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
    public class ObjectSerializer<OBJ> {
        private String path;
        private OBJ obj;
        public ObjectSerializer(String pPath, String pExtension,  OBJ pObj) {
            this.path = pPath+=pExtension;
            this.obj = pObj;
        }
        public void serializeObject() {
	            try {
	                FileOutputStream fos = new FileOutputStream(path);
	                ObjectOutputStream oos = new ObjectOutputStream(fos);
	                oos.writeObject(obj);
	                oos.close();
	                fos.close();
	            } catch(IOException ioe) {
	            	ioe.printStackTrace();
	            }
        	}  
    	}