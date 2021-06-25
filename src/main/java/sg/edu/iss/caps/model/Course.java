package sg.edu.iss.caps.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Range;

@Entity
public class Course {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NotBlank
	private String name;
	private String description;
	@Range(min=1, max=5)
	private int credit;
	private int maxSize;
	private long startDate;
	private long endDate;
	
	@OneToMany(mappedBy="course", 
			cascade = CascadeType.ALL,
	        orphanRemoval = true)
	private List<Student_Course> studentCourses;
	
	@ManyToMany(mappedBy="courses")
	private List<Lecturer> lecturers;
	

	public Course(@NotBlank String name, String description, @Range(min = 1, max = 5) int credit, int maxSize,
			long startDate, long endDate) {
		super();
		this.name = name;
		this.description = description;
		this.credit = credit;
		this.maxSize = maxSize;
		this.startDate = startDate;
		this.endDate = endDate;
	}


	public Course() {
		super();
	}
	
	public List<Student_Course> getStudentCourses() {
		return studentCourses;
	}


	public void setStudentCourses(List<Student_Course> studentCourses) {
		this.studentCourses = studentCourses;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	public long getStartDate() {
		return startDate;
	}

	public void setStartDate(long startDate) {
		this.startDate = startDate;
	}

	public long getEndDate() {
		return endDate;
	}

	public void setEndDate(long endDate) {
		this.endDate = endDate;
	}


	public List<Lecturer> getLecturers() {
		return lecturers;
	}

	public void setLecturers(List<Lecturer> lecturers) {
		this.lecturers = lecturers;
	}
	
	
}