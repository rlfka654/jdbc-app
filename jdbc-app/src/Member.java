
public class Member {
	
	private String id;
	private String pw;
	private String level;
	private String name;
	private String email;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		System.out.println(id + "<-- id Member.java");
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		System.out.println(pw + "<-- pw Member.java");
		this.pw = pw;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		System.out.println(level + "<-- level Member.java");
		this.level = level;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println(name + "<-- name Member.java");
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		System.out.println(email + "<-- email Member.java");
		this.email = email;
	}
}
