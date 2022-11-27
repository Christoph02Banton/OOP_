// Author/Name: Aneska Bryan
// ID Number: 2102374
// Module: Object Oriented Programming
// Date: November 7, 2022
// Description: System accepts general programme details
package models;

public class Programme {

	private String programmeCode;
	private String programmeName;
	private int maxNumofCourses;
	private String award;
	private String accreditation;
	public Course course;

	// Default Constructor
	public Programme() {
		programmeCode = "No Code";
		programmeName = "No Programme Name";
		maxNumofCourses = 0;
		award = "No Award";
		accreditation = "No Accreditation";
		course = new Course();
	}

	// Primary Constructor

	public Programme(String programmeCode, String programmeName, int maxNumCourse, String award, String accreditation,
			String courseName, String courseCode,
			String description,
			int numCredits,
			String preRequisite,
			float costPerCredit,
			float courseCost) {
		this.programmeCode = programmeCode;
		this.programmeName = programmeName;
		this.maxNumofCourses = maxNumCourse;
		this.award = award;
		this.accreditation = accreditation;
		this.course = new Course(courseCode,courseName,description,numCredits,preRequisite,costPerCredit,courseCost,programmeCode);
	}

	// Copy Constructor //
	public Programme(Programme programme) {
		this.programmeCode = programme.programmeCode;
		this.programmeName = programme.programmeName;
		this.maxNumofCourses = programme.maxNumofCourses;
		this.award = programme.award;
		this.accreditation = programme.accreditation;
		this.course = programme.course;
	}

	// Getters and setters

	// Display of all the attributes set in the Programme class by the View
	// Programme Details method
	public void viewProgrammeDetails() {
		System.out.println("Programme Code: " + programmeCode);
		System.out.println("Programme Name: " + programmeName);
		System.out.println("Maximum Number of Courses: " + maxNumofCourses);
		System.out.println("Award: " + award);
		System.out.println("Accreditation: " + accreditation);
		System.out.println("Course: " + course.getName());
	}

	// Get Course Class
	public Course getCourse() {
		return course;
	}

	// Setting Course Class
	public void setCourse(Course course) {
		this.course = course;
	}

	// Getting the Programme Code by returning it to the attribute
	public String getProgrammeCode() {
		return programmeCode;
	}

	// Setting the Programme Code
	public void setProgrammeCode(String programmeCode) {
		this.programmeCode = programmeCode;
	}

	// Getting the Programme Name by returning it to the attribute
	public String getProgrammeName() {
		return programmeName;
	}

	// Setting the Programme Name
	public void setProgrammeName(String programmeName) {
		this.programmeName = programmeName;
	}

	// Getting the Max Number of Courses in the Programme by returning it to the attribute
	public int getMaxNumofCourses() {
		return maxNumofCourses;
	}

	// Setting the Max number of courses in the programme
	public void setMaxNumofCourses(int maxNumofCourses) {
		this.maxNumofCourses = maxNumofCourses;
	}

	// Getting programme award by returning it to the attribute
	public String getAward() {
		return award;
	}

	// Setting Programme Award
	public void setAward(String award) {
		this.award = award;
	}

	// Getting the Programme accreditation by returning it to the attribute
	public String getAccreditation() {
		return accreditation;
	}

	// Setting the Programme accreditation
	public void setAccreditation(String accreditation) {
		this.accreditation = accreditation;
	}
}

