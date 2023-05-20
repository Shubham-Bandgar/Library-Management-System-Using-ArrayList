
public class Admin {
String name;
String password;
public Admin(String name,String password) {
	this.name=name;
	this.password=password;
}
public boolean authenticate(String password) {
	return this.password.equals(password);
}
}
