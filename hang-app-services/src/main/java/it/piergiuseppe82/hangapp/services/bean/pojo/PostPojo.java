package it.piergiuseppe82.hangapp.services.bean.pojo;

public class PostPojo {
		
		private Long id;		
		private String accountId;
	 	private String postName;
	    private String photoPath;
	    private String latitude;
	    private String longitude;
	    private Long postCreationTime;
	    
	    public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getAccountId() {
			return accountId;
		}
		public void setAccountId(String accountId) {
			this.accountId = accountId;
		}
		public String getPostName() {
			return postName;
		}
		public void setPostName(String postName) {
			this.postName = postName;
		}
		public String getPhotoPath() {
			return photoPath;
		}
		public void setPhotoPath(String photoPath) {
			this.photoPath = photoPath;
		}
		public String getLatitude() {
			return latitude;
		}
		public void setLatitude(String latitude) {
			this.latitude = latitude;
		}
		public String getLongitude() {
			return longitude;
		}
		public void setLongitude(String longitude) {
			this.longitude = longitude;
		}
		public Long getPostCreationTime() {
			return postCreationTime;
		}
		public void setPostCreationTime(Long postCreationTime) {
			this.postCreationTime = postCreationTime;
		}
}
