package com.OnyxLib.ObjectDeserializer;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
	public class ObjectDeserializer<OBJ> {
        private String path;
        public ObjectDeserializer(String pPath) {
            this.path = pPath;
        }
		@SuppressWarnings("unchecked")
		public OBJ deserializeObject() throws IOException,java.io.InvalidClassException {
			OBJ out = null;
            try {
                FileInputStream fis = new FileInputStream(path);
                ObjectInputStream ois = new ObjectInputStream(fis);
                out = (OBJ) ois.readObject();
                ois.close();
                fis.close();
            } catch(ClassNotFoundException cnf) {
                cnf.printStackTrace();
                System.out.print("\t"+"CLASS NOT FOUND"+"\t");
                return null;
            } catch(IOException ioe) {
                ioe.printStackTrace();
                return null;
            }
            return out;
        }
	}