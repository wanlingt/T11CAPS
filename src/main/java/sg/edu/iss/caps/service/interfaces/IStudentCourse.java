package sg.edu.iss.caps.service.interfaces;

import java.util.List;

import sg.edu.iss.caps.model.Course;
import sg.edu.iss.caps.model.User;

public interface IStudentCourse {
	public void addStudentToCourse(Course course, User user);
	public void removeStudentFromCourse(Course course, User user);
	public void addLecturerToCourse(Course course, User user);
	public void removeLecturerFromCourse(Course course, User user);
	public List<User> listStudentsInCourse (Course course);
}
