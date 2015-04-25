package it.piergiuseppe82.hangapp.services.bean;

public interface MediaServices {
	public String saveImage(byte[] image, String accountId);
	
	public byte[] getImage(String imageId, String accountId);
}
