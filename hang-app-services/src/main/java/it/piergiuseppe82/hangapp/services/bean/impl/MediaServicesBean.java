package it.piergiuseppe82.hangapp.services.bean.impl;

import it.piergiuseppe82.hangapp.services.bean.MediaServices;
import it.piergiuseppe82.hangapp.services.supports.Utility;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

@Service("MediaServices")
public class MediaServicesBean implements MediaServices{
	private static final String IMAGES_FOLDER_NAME = "imagesData";
	private static final Log log = LogFactory.getLog(MediaServices.class);
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

	@Override
	public byte[] getImage(String imageId, String accountId) {
		byte[] imagebytes = null;
		String imagesPath = Utility.getDataPath() + IMAGES_FOLDER_NAME
				+ File.separator;
		checkPath(imagesPath);
		String fullPath = imagesPath + imageId;
		FileInputStream fis = null;
		ByteArrayOutputStream bos = null;
		try {
			File file = new File(fullPath);
			fis = new FileInputStream(file);
			bos = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			for (int readNum; (readNum = fis.read(buf)) != -1;) {
				bos.write(buf, 0, readNum);
			}
			imagebytes = bos.toByteArray();
		} catch (Throwable ex) {
			log.error("Error during retrieve image " + fullPath);
		} finally {
			try {
				if (bos != null)
					bos.close();
			} catch (Throwable e) {
			}
			try {
				if (fis != null)
					fis.close();
			} catch (Throwable e) {
			}
		}
		return imagebytes;
	}
	
}
