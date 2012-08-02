package com.googlecode.pythonforandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.InputStreamReader;
import android.util.Log;
import java.util.Enumeration;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.Vector;
import com.googlecode.android_scripting.IoUtils;
import com.googlecode.android_scripting.FileUtils;

public class CreateFilesFolderService extends Activity {
	  private final static String TAG = "CreateFilesFolderService";
	  private static String python_destPath = "", extras_desPath = "";
	  private static final int BUFFER_SIZE = 4096;

	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
		
		python_destPath = "/data/data/" + getPackageName() + "/files/";
		createFilesFolder(python_destPath);
		extras_desPath = "/sdcard/" + getPackageName() + "/extras/";
		createFilesFolder(extras_desPath);
		//unZip("/sdcard/python.zip");
		try{
			unzip("/sdcard/download/python.zip", python_destPath);
			FileUtils.chmod(new File(python_destPath + "python"), 0755);
			unzip("/sdcard/download/python_extras_r14.zip", extras_desPath);
		}catch(Exception e){e.printStackTrace();}
		this.finish();
	  }

	  private void createFilesFolder(String to){
		File file = null;
		FileOutputStream fos = null;
		try {
			file = new File(to);
			if (!file.exists()) {
				file.mkdirs();
				FileUtils.chmod(new File(to), 0755);
			}
			//fos = new FileOutputStream(file);
			//fos.write(new String("python libs").getBytes());
			//fos.close();
		} /*catch (FileNotFoundException e){
			e.printStackTrace();
		} */catch (Exception e2) {
			e2.printStackTrace();
		}
	  }

	private long unzip(String from, String to) throws Exception {
		long extractedSize = 0l;
    		Enumeration<? extends ZipEntry> entries;
    		ZipFile zip = new ZipFile(from);
    		long uncompressedSize = getOriginalSize(zip);

    		entries = zip.entries();

    		try {
      			while (entries.hasMoreElements()) {
        			ZipEntry entry = entries.nextElement();
        			if (entry.isDirectory()) {
          				Log.d(TAG, "*destination folder:" + to + entry.getName());
	  				new File(to + entry.getName()).mkdirs();
	  				FileUtils.chmod(new File(to + entry.getName()), 0755);
          				continue;
        			}
        			File destination = new File(to, entry.getName());
        			if (!destination.getParentFile().exists()) {
          				destination.getParentFile().mkdirs();
	  				FileUtils.chmod(destination.getParentFile(), 0755);
	  				if(destination.toString().indexOf("python2.6")!=-1)
						Log.d(TAG, "destination folder:" + destination.getParentFile());
        			}
				if(destination.toString().indexOf("python2.6")!=-1)
					Log.d(TAG, "destination:" + destination);
	
          			ProgressReportingOutputStream outStream = new ProgressReportingOutputStream(destination);
        			extractedSize += IoUtils.copy(zip.getInputStream(entry), outStream);
        			outStream.close();
				FileUtils.chmod(destination, 0755);
      			}
    		} finally {
      			try {
        			zip.close();
      			} catch (Exception e) {
        			// swallow this exception, we are only interested in the original one
      			}
    		}
    		Log.d(TAG, "Extraction is complete.");
    		return extractedSize;
  	}

	private final class ProgressReportingOutputStream extends FileOutputStream {
    		private ProgressReportingOutputStream(File f) throws FileNotFoundException {
      			super(f);
   	 	}

    		@Override
    		public void write(byte[] buffer, int offset, int count) throws IOException {
      			super.write(buffer, offset, count);
    		}
  	}

	private long getOriginalSize(ZipFile file) {
    		Enumeration<? extends ZipEntry> entries = file.entries();
    		long originalSize = 0l;
    		while (entries.hasMoreElements()) {
      			ZipEntry entry = entries.nextElement();
      			if (entry.getSize() >= 0) {
        			originalSize += entry.getSize();
      			}
    		}
    		return originalSize;
  	}
}
