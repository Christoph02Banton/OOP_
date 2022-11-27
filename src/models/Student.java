// Author/Name: Chase Walfall
// ID Number: 2102044
// Module: Object Oriented Programming
// Date: November 7, 2022
// Description: The system should accept general student details
// Creation of student file for enrollment
package models;

import java.io.FileWriter;
import java.io.IOException; // Import the IOException class to handle errors
import javax.swing.*;
import java.io.File; // Import the File class
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.*;
// Enrollfor Semester:

// Page 3 of 5
// • View Programme Details – the system should display all courses in the programme.
// • Add Course – the system should allow the selection of courses from the enrolled
// programme.
// • Generate Fee Breakdown for Semester – the system should display all courses 
// enrolled in for the semester and the total cost (i.e. number of credits * cost per credit), 
// it should also switch students enrolled status to one (1).

public class Student extends User { // Initializing Student class

	private String idNumber;
	private String firstName;
	private String lastName;
	private String parish;
	private String streetName;
	private String zipCode;
	private String dateEnrolled;
	private String programmeCode;
	private int enrollmentstatus;
	private String contactNumber;
	// private int numberOfCourses;
	private int sequenceNum;
	// private Programme prog;

	// Note Well: The Actions to be performed can be implemented inside
	// The model call themselves. Theres not need to have an external class
	// to create files

	// Default Constructor
	public Student() {
		idNumber = "No ID Number available";
		firstName = "Null";
		lastName = "Null";
		parish = "Null";
		streetName = "Null";
		zipCode = "Null";
		dateEnrolled = "Null";
		programmeCode = "Null";
		enrollmentstatus = 0;
		contactNumber = "Null";
		sequenceNum = 0;
	}

	// Primary Constructor
	public Student(String id, String fName, String lName, String parish, String streetName, String zipCode,
			String dateEnrolled, String programmeCode,
			int enrollmentstatus, String contactNumber, int sequenceNum) {
		this.idNumber = id;
		this.firstName = fName;
		this.lastName = lName;
		this.parish = parish;
		this.streetName = streetName;
		this.zipCode = zipCode;
		this.dateEnrolled = dateEnrolled;
		this.programmeCode = programmeCode;
		this.enrollmentstatus = enrollmentstatus;
		this.contactNumber = contactNumber;
		// this.numberOfCourses = numberOfCourses;
		this.sequenceNum = sequenceNum;
	}

	// Copy Constructor
	public Student(Student student) {
		idNumber = student.idNumber;
		firstName = student.firstName;
		lastName = student.lastName;
		parish = student.parish;
		zipCode = student.zipCode;
		streetName = student.streetName;
		dateEnrolled = student.dateEnrolled;
		programmeCode = student.programmeCode;
		enrollmentstatus = student.enrollmentstatus;
		contactNumber = student.contactNumber;
		sequenceNum = student.sequenceNum;
	}

	// Getting ID Number by returning it to the attribute
	public String getIdNumber() {
		return idNumber;
	}

	// Setting the student's ID number
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	// Getting Student's first name by returning it to the attribute
	public String getFirstName() {
		return firstName;
	}

	// Setting the student's first name
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	// Getting Student's last name by returning it to the attribute
	public String getLastName() {
		return lastName;
	}

	// Setting the student's last name
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	// Getting the parish the student resides by returning it to the attribute
	public String getParish() {
		return parish;
	}

	// Setting the parish of the student's address
	public void setParish(String parish) {
		this.parish = parish;
	}

	// Getting the student's street number by returning it to the attribute
	public String getStreetName() {
		return streetName;
	}

	// Setting the student's street name of their address
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	// Getting the student's zipcode by returning it to the attribute
	public String getZipCode() {
		return zipCode;
	}

	// Setting the student's zipcode
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	// Getting the date the student was enrolled by returning it to the attribute
	public String getDateEnrolled() {
		return dateEnrolled;
	}

	// Setting the student's enrollment date
	public void setDateEnrolled(String dateEnrolled) {
		this.dateEnrolled = dateEnrolled;
	}

	// Getting Programme code by returning it to the attribute
	public String getProgrammeCode() {
		return programmeCode;
	}

	// Setting the Programme code
	public void setProgrammeCode(String programmeCode) {
		this.programmeCode = programmeCode;
	}

	// Getting the student's enrollment status by returning it to the attribute
	public int getEnrollmentstatus() {
		return enrollmentstatus;
	}

	// Setting the student's enrollment status
	public void setEnrollmentstatus(int enrollmentstatus) {
		this.enrollmentstatus = enrollmentstatus;
	}

	// Getting the student's contact number by returning it to the attribute
	public String getContactNumber() {
		return contactNumber;
	}

	// Setting the student's contact number
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	// public int getNumberOfCourses() {
	// return numberOfCourses;
	// }

	// public void setNumberOfCourses(int numberOfCourses) {
	// this.numberOfCourses = numberOfCourses;
	// }
	// Getting the student's sequence number by returning it to the attribute
	public int getSequenceNum() {
		return sequenceNum;
	}

	// Setting the student's sequence number
	public void setSequenceNum(int sequenceNum) {
		this.sequenceNum = sequenceNum;
	}

	public String studentEnrollment(String idNumber) {
		String filePathCourse = "";

		String studentCourseName = " ";

		File studentCourseFile = null;

		File createFile = null;

		String programmeCode = getCode(idNumber);

		programmeCode = programmeCode.toUpperCase();

		int max = getMaxCourse(programmeCode);

		if (max == 4) {
			filePathCourse = "src/Files/Certificate/" + programmeCode + "Course.txt";
			studentCourseName = "src/Files/Certificate/" + idNumber + "Enrollment.txt";
		} else if (max == 6) {
			filePathCourse = "src/Files/Diploma/" + programmeCode + "Course.txt";
			studentCourseName = "src/Files/Diploma/" + idNumber + "Enrollment.txt";
		} else if (max == 8) {
			filePathCourse = "src/Files/Associates/" + programmeCode + "Course.txt";
			studentCourseName = "src/Files/Associates/" + idNumber + "Enrollment.txt";
		}
		try {
			studentCourseFile = new File(studentCourseName);

			Scanner enrollmentReader = null;
			if (!studentCourseFile.exists()) {

				createFile = new File(studentCourseName);
				createFile.createNewFile();
			} else if (studentCourseFile.exists()) {
				enrollmentReader = new Scanner(new File(studentCourseName));
				if (enrollmentReader.hasNext()) {
					System.out.println("You have already Enrolled for the semester");
					JOptionPane.showMessageDialog(
							null,
							"Student  " + idNumber + " has already enrolled for the Semester",
							"File Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(
							null,
							"Student  " + idNumber + " needs to add course and generate fee breakdown",
							"File Error",
							JOptionPane.ERROR_MESSAGE);

				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("An error has occurred when closing File in studentEnrollment");
			JOptionPane.showMessageDialog(null,
					"An error has occurred when closing File in studentEnrollment",
					"File Error",
					JOptionPane.ERROR_MESSAGE);
		}
		return filePathCourse;
	}

	public String getCode(String idNumber) {
		String studentFileName = "src/Files/StudentRecord.txt";
		String programmeFileName = "src/Files/AllProgrammeRecord.txt";
		Scanner studentReader = null;
		Scanner programmeReader = null;
		String progCode = "";

		try {
			studentReader = new Scanner(new File(studentFileName));
			programmeReader = new Scanner(new File(programmeFileName));
			while (studentReader.hasNext()) {
				int Num = studentReader.nextInt();
				String Code = studentReader.next();
				String id = studentReader.next();
				String token = studentReader.nextLine();
				if (id.equals(idNumber)) {
					while (programmeReader.hasNext()) {
						progCode = programmeReader.next();
						token = programmeReader.nextLine();
						if (progCode.equals(Code)) {
							break;

						}
					}
					break;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error when reading from file");
			JOptionPane.showMessageDialog(
					null,
					"Error when reading from file",
					"File Error",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();

		} finally {
			if (studentReader != null && programmeReader != null) {
				studentReader.close();
				programmeReader.close();
			}
		}
		return progCode;

	}

	public int getMaxCourse(String programmeCode) {

		String programmeFileName = "src/Files/AllProgrammeRecord.txt";

		Scanner programmeReader = null;

		int max = 0;

		try {
			programmeReader = new Scanner(new File(programmeFileName));
			while (programmeReader.hasNext()) {
				String progCode = programmeReader.next();
				String name = programmeReader.next();
				max = programmeReader.nextInt();
				String token = programmeReader.nextLine();
				if (progCode.equals(programmeCode)) {
					break;

				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Error when reading from file");
			JOptionPane.showMessageDialog(
					null,
					"Error when reading from file",
					"File Error",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();

		} finally {
			if (programmeReader != null) {
				programmeReader.close();
			}
		}
		return max;

	}

	// Definition of the add course method
	public void addCourse(String courseCode, String idNumber) {
		FileWriter courseWriter = null;
		int checkCourseRec = 0;
		int count = 0;
		Scanner studentCourseReader;
		Scanner courseReader;
		String programmeFileName = "null";
		// String courseFileName = "src/Files/Course.txt";
		String course = "null";
		String filePathCourse = "";
		courseCode = courseCode.toUpperCase();
		String programmeCode = getCode(idNumber);
		int max = getMaxCourse(programmeCode);

		if (max == 4) {
			programmeFileName = "src/Files/Certificate/" + idNumber + "Enrollment.txt";
			filePathCourse = "src/Files/Certificate/" + programmeCode + "Course.txt";
		} else if (max == 6) {
			programmeFileName = "src/Files/Diploma/" + idNumber + "Enrollment.txt";
			filePathCourse = "src/Files/Diploma/" + programmeCode + "Course.txt";
		} else if (max == 8) {
			programmeFileName = "src/Files/Associates/" + idNumber + "Enrollment.txt";
			filePathCourse = "src/Files/Associates/" + programmeCode + "Course.txt";
		}
		try {
			studentCourseReader = new Scanner(new File(programmeFileName));
			courseWriter = new FileWriter(programmeFileName, true);
			courseReader = new Scanner(new File(filePathCourse));
			while (studentCourseReader.hasNext()) {
				String courseFileCode = studentCourseReader.next();
				if (courseFileCode.equals(courseCode)) {
					checkCourseRec = -1;
					break;
				}
				for (int i = 0; i < 7; i++) {
					String token = studentCourseReader.next();
				}
				count++;
			}
			studentCourseReader.close();
			if (checkCourseRec == -1) {
				JOptionPane.showMessageDialog(
						null,
						"The Course:  " + courseCode + " has already been added",
						"Course Limit",
						JOptionPane.ERROR_MESSAGE);
			} else {
				if (count == max) {
					JOptionPane.showMessageDialog(
							null,
							"You have reached the maximum course limit",
							"Course Limit",
							JOptionPane.ERROR_MESSAGE);
				} else if (count < max) {
					max = max - count;
					JOptionPane.showMessageDialog(
							null,
							idNumber +
									"\t" +
									" has a  maximum of " +
									"\t" +
									max +
									"\t" +
									" courses that can be added",
							"Course Limit",
							JOptionPane.ERROR_MESSAGE);

					while (courseReader.hasNext()) {
						String courseFileCode = courseReader.next();
						if (courseFileCode.equals(courseCode)) {
							String token = courseReader.nextLine();

							course = courseFileCode + "\t" + token + " \t\n";

							courseWriter.write(course);
						}
					}
					if (course.equals("null")) {
						JOptionPane.showMessageDialog(
								null,
								"This course does not exist",
								"Course Invalid",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(
					null,
					"The File " + "\t" + programmeCode + "\t" + "does not exists",
					"File not Found",
					JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(
					null,
					"The File" + "\t" + programmeCode + "\t" + "can't be opened__",
					"File Reading Error",
					JOptionPane.ERROR_MESSAGE);
		} finally {
			try {
				if (courseWriter != null) {
					courseWriter.close();
				}
			} catch (IOException e) {
				JOptionPane.showMessageDialog(
						null,
						"The File" + "\t" + programmeCode + "\t" + "can't be opened__",
						"File Reading Error",
						JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
				System.out.println("An error has occurred when closing File in studentAddCourse");
				JOptionPane.showMessageDialog(
						null,
						"An error has occurred when closing File in studentAddCourse",
						"File Error",
						JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}

	}

	// Definition of the Generate Programme Report Method
	public float generateFeeBreakDown(String idNumber) {

		String programmeCode = getCode(idNumber);

		programmeCode = programmeCode.toUpperCase();

		int max = getMaxCourse(programmeCode);

		String studentRecordName = "src/Files/StudentRecord.txt";

		String allEnrollmentNm = "src/Files/Enrollment.txt";

		String studentCourseName = "";

		String studentEnrollmentNm = "";

		String token = "";

		Scanner courseReader = null;

		Scanner studentReader = null;

		File stuEnrollmentFile = null;

		FileWriter enrollmentWriter = null;

		FileWriter stuEnrollmentWriter = null;

		float totalCost = 0;

		if (max == 4) {
			studentEnrollmentNm = "src/Files/Certificate/" + idNumber + "Enrollment.txt";
			studentCourseName = "src/Files/Certificate/" + idNumber + "allCourse.txt";
		} else if (max == 6) {
			studentEnrollmentNm = "src/Files/Diploma/" + idNumber + "Enrollment.txt";
			studentCourseName = "src/Files/Diploma/" + idNumber + "allCourse.txt";
		} else if (max == 8) {
			studentEnrollmentNm = "src/Files/Associates/" + idNumber + "Enrollment.txt";
			studentCourseName = "src/Files/Associates/" + idNumber + "allCourse.txt";
		}
		try {
			stuEnrollmentFile = new File(studentEnrollmentNm);
			courseReader = new Scanner(new File(studentEnrollmentNm));
			studentReader = new Scanner(new File(studentRecordName));
			if (!stuEnrollmentFile.exists()) {
				JOptionPane.showMessageDialog(
						null,
						"Student" + idNumber + "\t" + "needs to add course before generating fee breakdown",
						"File not Found",
						JOptionPane.ERROR_MESSAGE);

			} else {
				if (!courseReader.hasNext()) {
					JOptionPane.showMessageDialog(
							null,
							"Student" + idNumber + "\t" + " needs to add cousrse before generating fee breakdown",
							"File not Found",
							JOptionPane.ERROR_MESSAGE);
				} else {

					stuEnrollmentWriter = new FileWriter(allEnrollmentNm, true);
					enrollmentWriter = new FileWriter(studentCourseName, true);

					while (courseReader.hasNext()) {
						token = courseReader.nextLine();
						enrollmentWriter.write(token+"\n");
						System.out.println(token);
					}
					courseReader.close();
					courseReader = new Scanner(new File(studentEnrollmentNm));
					while (courseReader.hasNext()) {
						for (int i = 0; i < 5; i++) {
							token = courseReader.next();
							System.out.println("TOKEN!"+ token);
						}
						float courseCost = courseReader.nextFloat();
						System.out.println("C C"+ courseCost);
						totalCost += courseCost;
						token = courseReader.next();
						token = courseReader.next();
					}
					courseReader.close();
					System.out.println("--------------------------------------------------");
					System.out.println("STUDENT " + idNumber + " FEE BREAKDOWN  ");
					System.out.println("--------------------------------------------------");

					System.out.println("--------------------------------------------------");
					System.out.println(token);
					System.out.println("--------------------------------------------------");
					System.out.println("TOTAL COST OF ENROLLMENT: $" + totalCost);
					System.out.println("--------------------------------------------------");

					while (studentReader.hasNext()) {
						int seqNum = studentReader.nextInt();
						String progCode = studentReader.next();
						String id = studentReader.next();
						int enrollment = studentReader.nextInt();
						String fname = studentReader.next();
						String lname = studentReader.next();
						String contactNumber = studentReader.next();

						String dateEnroll = studentReader.next();
						String parish = studentReader.next();
						String streetName = studentReader.next();
						String zipCode = studentReader.next();
						if (id.equals(idNumber)) {
							enrollment++;
							String record = "\t" + seqNum + "\t" + id + "\t" + progCode + "\t" + enrollment + "\t" + fname
									+ "\t" + lname + "\t" +
									contactNumber + "\t" + dateEnroll + "\t" + parish + "\t" + streetName + "\t"
									+ zipCode + "\n";
							stuEnrollmentWriter.write(record);
							break;
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("An error has occurred when closing File in generateFeeBreakDown");
			JOptionPane.showMessageDialog(
					null,
					"An error has occurred when closing File in generateFeeBreakDown when closing File",
					"File Error",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();

		} finally {
			try {
				if (stuEnrollmentWriter != null && enrollmentWriter != null && courseReader != null
						&& studentReader != null) {
					stuEnrollmentWriter.close();
					enrollmentWriter.close();
					courseReader.close();
					studentReader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("An error has occurred when closing File in generateFeeBreakDown when closing File");
				JOptionPane.showMessageDialog(
						null,
						"An error has occurred when closing File in generateFeeBreakDown when closing File",
						"File Error",
						JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}
		System.out.println("OUT TRY "+totalCost);
		return totalCost;
	}

	public ArrayList<Course> generateProgressReport(String idNumber) {
		Scanner courseReader;
		String programmeCode = getCode(idNumber);
		String studentCourseName = "";
		int check = 0;
		String id = "";
		ArrayList<Course> courselist = new ArrayList<Course>();

		programmeCode = programmeCode.toUpperCase();

		int max = getMaxCourse(programmeCode);
		try {
			courseReader = new Scanner(new File("src/Files/Enrollment.txt"));
			while (courseReader.hasNext()) {
				id = courseReader.next();
				if (id.equals(idNumber)) {
					check = -1;
				}
			}
			courseReader.close();
			if (check == 0) {
				JOptionPane.showMessageDialog(
						null,
						"The Student:  " + idNumber + " needs to Enroll",
						"Course Limit",
						JOptionPane.ERROR_MESSAGE);
			} else {
				if (max == 4) {
					studentCourseName = "src/Files/Certificate/" + idNumber + "allCourse.txt";
				} else if (max == 6) {
					studentCourseName = "src/Files/Diploma/" + idNumber + "allCourse.txt";
				} else if (max == 8) {
					studentCourseName = "src/Files/Associates/" + idNumber + "allCourse.txt";
				}
				System.out.println("--------------------------------------------------");
				System.out.println("STUDENT " + id + "'S PROGRESS REPORT");
				System.out.println("--------------------------------------------------");
				courseReader = new Scanner(new File(studentCourseName));
				while (courseReader.hasNext()) {
					String courseCode = courseReader.next();

					String name = courseReader.next();

					String progCode = courseReader.next();

					float costPerCredit = courseReader.nextFloat();

					int numCredits = courseReader.nextInt();

					float courseCost = courseReader.nextFloat();

					String preRequiste = courseReader.next();

					String description = courseReader.next();

					Course course = new Course(courseCode, name, description, numCredits, preRequiste, costPerCredit,
							courseCost, progCode);
					courselist.add(course);
					String token = courseReader.nextLine();
					System.out.println("--------------------------------------------------");
					System.out.println(token);
					System.out.println("--------------------------------------------------");
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(
					null,
					"The File " + "\t" + programmeCode + "\t" + "does not exists",
					"File not Found",
					JOptionPane.ERROR_MESSAGE);
		}
		return courselist;
	}

	@Override
	public boolean verifyLogin(String user, String pass) {
		try {
			String studentCredentials = "src/Files/StudentCredentials.txt";
			File myObj = new File(studentCredentials);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String userIdfile = myReader.next();
				String passwordfile = myReader.next();
				if (userIdfile.equals(user) && passwordfile.equals(pass)) {
					myReader.close();
					JOptionPane.showMessageDialog(null,
							"Login Successfully",
							"\nSuccess",
							JOptionPane.INFORMATION_MESSAGE);
					return true;
				}
			}
			myReader.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return false;

	}

}
