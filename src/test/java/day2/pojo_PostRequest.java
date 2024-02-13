package day2;

public class pojo_PostRequest {
	String Name;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String[] getCourses() {
		return Courses;
	}
	public void setCourses(String[] courses) {
		Courses = courses;
	}
	
	String Location;
	String Phone;
	String Courses[];

}
