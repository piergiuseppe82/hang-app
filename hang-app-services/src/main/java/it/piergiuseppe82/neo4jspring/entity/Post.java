package it.piergiuseppe82.neo4jspring.entity;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@NodeEntity
public class Post {

    @GraphId Long id;
    private String postName;
    private String photoPath;
    private String latitude;
    private String longitude;
    private Long postCreationTime;
    
   
	public Long getPostCreationTime() {
		return postCreationTime;
	}

	public void setPostCreationTime(Long postCreationTime) {
		this.postCreationTime = postCreationTime;
	}
	@RelatedTo(type="POSTED", direction=Direction.INCOMING)
    public @Fetch Person person;
    
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Post(String postName, String photoPath, String latitude,
			String longitude) {
		super();
		this.postName = postName;
		this.photoPath = photoPath;
		this.latitude = latitude;
		this.longitude = longitude;
		this.postCreationTime = System.currentTimeMillis();
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
	
	public Long getId() {
		return id;
	}

	public Post() {
		super();
		this.postCreationTime = System.currentTimeMillis();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		String ret = "\nNode["+id+"] Post "+postName+":";
    	ret = ret +"\n\taccountCreationTime "+postCreationTime;
    	ret = ret +"\n\tcreated by Person["+person.id+"] "+person.getAccountId();
		return ret;
	}

	
}