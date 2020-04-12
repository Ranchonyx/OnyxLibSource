package com.OnyxLib.Gmail.ConfigWorker;
import com.OnyxLib.ObjectSerializer.*;
import com.OnyxLib.ObjectDeserializer.*;
import java.io.IOException;
import java.io.Serializable;

public class ConfigWorker implements Serializable{
	
	private static final long serialVersionUID = 3297152306835470358L;
	private String user, host, password, path;
	 private int port;
	 private boolean isConfigLoaded = false;
	 public ConfigWorker(String pUser, String pHost, String pPassword, String pPath, int pPort) {
		 this.port = pPort;
		 this.user = pUser;
		 this.host = pHost;
		 this.password = pPassword;
		 this.path = pPath;
	 }
	 public ConfigWorker() {}
	 public void createConfig() throws IOException {
		 ObjectSerializer<ConfigWorker> configSerializer = new ObjectSerializer<ConfigWorker>(this.path, ".cfg", new ConfigWorker(this.user, this.host, this.password, this.path, this.port));
		 configSerializer.serializeObject();
	 }
	 public void loadConfig(String path) throws IOException{
		 if(this.isConfigLoaded == true) {
			 System.out.println("[!] Config already loaded.");
			 return;
		 } else {
			 if(path != null) {
				 ObjectDeserializer<ConfigWorker> configDeserializer = new ObjectDeserializer<ConfigWorker>(path);
				 Object tmp  = configDeserializer.deserializeObject();
				 this.host = ((ConfigWorker) tmp).getConfigHost();
				 this.password = ((ConfigWorker) tmp).getConfigPassword();
				 this.user = ((ConfigWorker) tmp).getConfigUser();
				 this.path = ((ConfigWorker) tmp).getConfigPath();
				 this.port = ((ConfigWorker) tmp).getConfigPort();
				 this.isConfigLoaded = true;
			 } else {
				 ObjectDeserializer<ConfigWorker> configDeserializer = new ObjectDeserializer<ConfigWorker>(this.path);
				 Object tmp  = configDeserializer.deserializeObject();
				 this.host = ((ConfigWorker) tmp).getConfigHost();
				 this.password = ((ConfigWorker) tmp).getConfigPassword();
				 this.user = ((ConfigWorker) tmp).getConfigUser();
				 this.path = ((ConfigWorker) tmp).getConfigPath();
				 this.port = ((ConfigWorker) tmp).getConfigPort();
				 this.isConfigLoaded = true;
			 }
			 
			 
		 }
	 }
	 @SuppressWarnings("null")
	public void unloadConfig() {
		 this.port = (Integer)null;
		 this.host = null;
		 this.password = null;
		 this.path = null;
		 this.user = null;
		 this.isConfigLoaded = false;
	 }
	 public int getConfigPort() {
		 return this.port;		 
	 }
	 public String getConfigUser() {
		 return this.user;
	 }
	 public String getConfigPassword() {
		 return this.password;
	 }
	 public String getConfigHost() {
		 return this.host;
	 }
	 public String getConfigPath() {
		 return this.path;
	 }
}