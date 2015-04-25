package it.piergiuseppe82.hangapp.services.bean.pojo;


public class PersonPojo {
	
	private Long id;
	private String fullName;
    private String accountId;
    private String password;
    private String email;
	private Long accountCreationTime;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getAccountCreationTime() {
		return accountCreationTime;
	}
	public void setAccountCreationTime(Long accountCreationTime) {
		this.accountCreationTime = accountCreationTime;
	}
	@Override
	public String toString() {
		return "PersonPojo [id=" + id + ", fullName=" + fullName
				+ ", accountId=" + accountId + ", password=" + password
				+ ", email=" + email + ", accountCreationTime="
				+ accountCreationTime + "]";
	}
	
	
    
    
}
