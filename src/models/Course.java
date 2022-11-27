// Author/Name: Aneska Bryan
// ID Number: 2102374
// Module: Object Oriented Programming
// Date: November 7, 2022
// Description: System accepts general course details
package models;


public class Course {

	  private String courseCode;
	  private String name;
	  private String description;
	  private int numCredits;
	  private String preRequisite;
	  private float costPerCredit;
	  private float courseCost;
	  private String programmeCode;


	  // Default Constructor
	 public Course() {
	    courseCode = "No Code Assigned";
	    name = "Null";
	    description = "Null";
	    numCredits = 0;
	    preRequisite = "No Pre-Requisite Assigned";
	    costPerCredit = 0;
	    courseCost = 0;
	    programmeCode = "No Code";
	  }
	// Primary Constructor
	public Course(
	    String courseCode,
	    String name,
	    String description,
	    int numCredits,
	    String preRequisite,
	    float costPerCredit,
	    float courseCost,
	    String programmeCode
	  ) {
	    this.courseCode = courseCode;
	    this.name = name;
	    this.description = description;
	    this.numCredits = numCredits;
	    this.preRequisite = preRequisite;
	    this.costPerCredit = costPerCredit;
		courseCost=costPerCredit*numCredits;
	    this.courseCost = courseCost;
	    this.programmeCode = programmeCode;
	  }
	// Copy Constructor
	  public Course(Course course) {
	    this.courseCode = course.courseCode;
	    this.name = course.name;
	    this.description = course.description;
	    this.numCredits = course.numCredits;
	    this.preRequisite = course.preRequisite;
	    this.costPerCredit = course.costPerCredit;
	    this.courseCost = course.courseCost;
	    this.programmeCode = course.programmeCode;
	  }
	// Setting the Course Cost by multipling the course cost and the number of credits within each programme
	  public void setCourseCost(int numCrdt, float crdtCost,float courseCost) {
        courseCost=crdtCost * numCrdt;
	    this.courseCost = courseCost;
	  }
	// Getting the Course Code after calculation by returning it to the attribute
	  public float getCourseCost() {
	    return courseCost;
	  }
	// Setting the Course name 
	  public void setName(String name) {
	    this.name = name;
	  }
	//Getting the Course name by returning it to the attribute
	  public String getName() {
	    return name;
	  }
	// Setting the Course Description
	  public void setDescription(String description) {
	    this.description = description;
	  }
	//Getting the Course Description by returning it to the attribute
	  public String getDescription() {
	    return description;
	  }
	// Setting the number of credits within a particular course
	  public void setNumCredits(int numCredits) {
	    this.numCredits = numCredits;
	  }
	//Getting the number of credits per course by returning it to the attribute
	  public int getNumCredits() {
	    return numCredits;
	  }
	// Setting the Pre- Requisite for each course
	  public void setPreRequisite(String preRequisite) {
	    this.preRequisite = preRequisite;
	  }
	//Getting the Course Pre-Requisite by returning it to the attribute
	  public String getPreRequisite() {
	    return preRequisite;
	  }
	//Setting the cost per credit by returning it to the attribute
	  public void setCostPerCredit(float costPerCredit) {
	    this.costPerCredit = costPerCredit;
	  }
	//Getting the cost per credit for each course by returning it to the attribute
	  public float getCostPerCredit() {
	    return costPerCredit;
	  }
	//Getting the Course Code by returning it to the attribute
	public String getCourseCode() {
		return courseCode;
	}
	// Setting the Course Code
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	// Setting the Course Cost
	public void setCourseCost(float courseCost) {
		this.courseCost = courseCost;
	}
	//Getting the Programme Code (called from Programme Class)by returning it to the attribute
	public String getProgrammeCode() {
		return programmeCode;
	}
	// Setting the Programme Code  (Called from Programme class)
	public void setProgrammeCode(String programmeCode) {
		this.programmeCode = programmeCode;
	}
	  
	}
