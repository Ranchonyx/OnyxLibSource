package com.onyxlib.SpecializedInformation;
import java.io.IOException;

public class SpecializedInformation {
	public SpecializedInformation() {}
	public long getFreeMem() {
		return Runtime.getRuntime().freeMemory();
	}
	public long getTotalMem() {
		return Runtime.getRuntime().totalMemory();
	}
	public int getTotalProcessors() {
		return Runtime.getRuntime().availableProcessors();
	}
	public Process startProcess(String cmd) throws IOException {
		return Runtime.getRuntime().exec(cmd);
	}

}
