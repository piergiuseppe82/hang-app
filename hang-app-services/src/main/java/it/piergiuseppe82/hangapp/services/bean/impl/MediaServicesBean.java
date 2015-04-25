package it.piergiuseppe82.hangapp.services.bean.impl;

import it.piergiuseppe82.hangapp.services.bean.MediaServices;
import it.piergiuseppe82.hangapp.services.supports.Utility;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.stereotype.Service;

@Service("MediaServices")
public class MediaServicesBean implements MediaServices{
	private static final String IMAGES_FOLDER_NAME = "imagesData";
	
	@Override
	public String saveImage(byte[] image, String accountId) {
		String destinationFileName = accountId+"_"+System.currentTimeMillis();
		String destinationFilePath = Utility.getDataPath()+IMAGES_FOLDER_NAME+File.separator;		
		checkPath(destinationFilePath);
		String fullPath = destinationFilePath+destinationFileName;
		OutputStream os = null;
		try {
			os = new FileOutputStream(fullPath);
			os.write(image);
			return destinationFileName;
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(os != null){
				try {
					os.close();
				} catch (IOException e) {}
			}
		}
		
		return null;
	}

	private void checkPath(String destinationFilePath) {
		File dir = new File(destinationFilePath);
		if(!dir.exists()){
			dir.mkdir();
		}
		
	}
	
}
