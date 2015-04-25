package it.piergiuseppe82.hangapp.services.repositories.model;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@NodeEntity
public class Person {

    


	@GraphId Long id;
    public Long getId() {
		return id;
	}


	private String fullName;
    

    @Indexed(unique=true, failOnDuplicate=true)
    private String accountId;
    
    private String password;
    
    @Indexed(failOnDuplicate=true)
    private String email;
    
    public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	private Long accountCreationTime;
    
    
    
    public Long getAccountCreationTime() {
		return accountCreationTime;
	}


	public void setAccountCreationTime(Long accountCreationTime) {
		this.accountCreationTime = accountCreationTime;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getAccountId() {
		return accountId;
	}


	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}


	public Set<Person> getHangouts() {
		return hangouts;
	}


	public void setHangouts(Set<Person> hangouts) {
		this.hangouts = hangouts;
	}


	public Set<Post> getPosts() {
		return posts;
	}


	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}


	public Person() {super();this.accountCreationTime = System.currentTimeMillis();}
   

    public Person(String fullName, String accountId) {
		super();
		this.fullName = fullName;
		this.accountId = accountId;
		this.accountCreationTime = System.currentTimeMillis();
	}
    
    public Person(String accountId) {
		super();
		this.accountId = accountId;
		this.accountCreationTime = System.currentTimeMillis();
	}


	@RelatedTo(type="HANG", direction=Direction.OUTGOING)
	private @Fetch Set<Person> hangouts;

    public void hang(Person person) {
        if (hangouts == null) {
            hangouts = new HashSet<Person>();
        }
        hangouts.add(person);
    }
    
    @RelatedTo(type="HANG", direction=Direction.INCOMING)
	private @Fetch Set<Person> hangouted;

   
    
    public Set<Person> getHangouted() {
		return hangouted;
	}


	public void setHangouted(Set<Person> hangouted) {
		this.hangouted = hangouted;
	}


	@RelatedTo(type="POSTED", direction=Direction.OUTGOING)
    private @Fetch Set<Post> posts;

    public void post(Post post) {
        if (posts == null) {
        	posts = new HashSet<Post>();
        }
        posts.add(post);
    }


	@Override
	public String toString() {
		return "Person [id=" + id + ", fullName=" + fullName + ", accountId="
				+ accountId + ", password=" + password + ", email=" + email
				+ ", accountCreationTime=" + accountCreationTime
				+ ", hangouts=" + hangouts + ", hangouted=" + hangouted
				+ ", posts=" + posts + "]";
	}


    
    


   

}