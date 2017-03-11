public class Account {

	private String name;
	private int aga;
	private String username;
	private char Gender;
	private String Email;
	private String Password;
	private boolean type;
	//student true
	//teacher false
	
	Account(String a,String b,String c,boolean t)
	{
		username=a;
		Password=b;
		Email=c;
		type=t;
	}
	Account()
	{}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAga() {
		return this.aga;
	}

	public void setAga(int aga) {
		this.aga = aga;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public char getGender() {
		return this.Gender;
	}

	public void setGender(char Gender) {
		this.Gender = Gender;
	}

	public String getEmail() {
		return this.Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}

	public String getPassword() {
		return this.Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}

	public boolean isType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Account [name=" + name + ", aga=" + aga + ", username=" + username + ", Gender=" + Gender + ", Email="
				+ Email + ", Password=" + Password + ", type=" + type + "]";
	}

}