package com.googlecode.pythonforandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class CreateFilesFolderService extends Activity {

	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
		//System.out.println("TEST!!!!!!");
		File file = null;
		FileOutputStream fos = null;
		try {
			file = new File("/data/data/" + getPackageName()
				+ "/files/");
			if (!file.exists()) {
				file.mkdirs();
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
}
