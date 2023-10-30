package com.runner;

import java.io.IOException;

//import com.runner.ConfigurationReader;
import com.runner.FileReaderManager;

	public class FileReaderManager {
	private FileReaderManager() {
		
	}
	public static FileReaderManager getInstance() {
		FileReaderManager frm = new FileReaderManager();
		return frm;
		}

	public ConfigurationReader getCrInstance() throws IOException {
		ConfigurationReader cr = new ConfigurationReader();
		return cr;
		
	}
	}
