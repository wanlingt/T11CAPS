package sg.edu.iss.caps.service.interfaces;

import java.text.ParseException;
import java.util.List;

import java.util.Optional;

import sg.edu.iss.DTO.manageCourse.EditCourseDto;
import sg.edu.iss.caps.model.Course;
import sg.edu.iss.caps.model.User;

public interface ICourse {
	
	public List<Course> listAllCourses();
	
	public Optional<Course> findCourse(int id);
	public void AddCourse(EditCourseDto addcourseDto) throws ParseException;
	public void edit(EditCourseDto editCourseDto) throws ParseException;
	public void delete(Course course);
	public Course findCourseById(Integer id);
	
	public List<Course> findNewCoursesForStudents(int id);

	//search bar keyword
	public List<Course> listAll(String keyword);
	
	public List<Course> findCourseByLecturerId(Integer id);
	
	public void addLecturerToCourse(List<User> lecturers, Integer cid);
	public void deleteLecturerFromCourse(User lecturer, Integer cid);
	public void deleteCourse(Course course);
	public List<User> findLecturersByCourse(Integer cid);


}
