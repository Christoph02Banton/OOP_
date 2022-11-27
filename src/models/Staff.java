// Author/Name: Chase Walfall
// ID Number: 2102044
// Module: Object Oriented Programming
// Date: November 7, 2022
// Description: // Register Student – the system should accept student’s details and generate a student
// record. The student id number should be generated using the current year, programme code
// and a sequence that starts at zero (0), and the enrollment status should be set to zero (0).
// Programme Administration:
// • Create Programme – the system should accept general programme details.
// • Modify Programme Details – the system should allow f the addition, removal, and
// editing of courses for the programme.
// • Generate Student List – the system should accept a programme code then displays
// the list of student currently enrolled in the programme.
package models;

import java.io.File; // Import the File class
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException; // Import the IOException class to handle errors
import java.time.Year;
import java.util.*;
import java.util.Scanner;
import javax.swing.*;
import java.util.ArrayList;

public class Staff extends User {

	protected String idNumber;
	protected String firstName;
	protected String lastName;
	protected String address;
	protected String year;
	protected String day;
	protected String month;
	protected String faculty;
	protected String department;
	protected int sequenceNum = -1;

	// Default Constructor
	public Staff() {
		idNumber = "null";
		firstName = "null";
		lastName = "null";
		address = "null";
		year = "null";
		month = "null";
		day = "null";
		faculty = "null";
		department = "null";
		sequenceNum = 0;
	}

	// Primary Constructor
	public Staff(
			String idNumber,
			String firstName,
			String lastName,
			String address,
			String year,
			String day,
			String month,
			String faculty,
			String department,
			int sequenceNum) {
		this.idNumber = idNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.year = year;
		this.day = day;
		this.month = month;
		this.faculty = faculty;
		this.department = department;
		this.sequenceNum = sequenceNum;
	}

	// Copy Contructors
	Staff(Staff staff) {
		idNumber = staff.idNumber;
		firstName = staff.firstName;
		lastName = staff.lastName;
		address = staff.address;
		faculty = staff.faculty;
		department = staff.department;
		year = staff.year;
		month = staff.month;
		day = staff.day;
	}

	// Setters and Getters
	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getSequenceNum() {
		return sequenceNum;
	}

	public void setSequenceNum(int sequenceNum) {
		this.sequenceNum = sequenceNum;
	}

	/// Create programe and a number of course based on programme type
	public Programme  createProgramme(
			int option,
			String programmeName,
			String award,
			String accreditation,
			String courseName,
			String description,
			int numCredits,
			String preRequisite,
			float costPerCredit,
			boolean setter,Programme programme) { // beginninig of method body
		FileWriter programmeWriter = null;
		FileWriter courseWriter = null;
		FileWriter courseProgrammeWriter = null;
		FileWriter allProgramme = null;
		FileWriter allProgrammeRecord = null;
		String filePathProg;
		String filePathCourse;
		String fileCourseName = "src/Files/Course.txt";
		String allProgrammeName = "null";
		String allProgPath = "src/Files/AllProgrammeRecord.txt";
		Course course = new Course();
		String programmeCode="";
		String courseCode="";
		int max;
		if(setter==true){
			programmeCode = createCode(award, programmeName);
			courseCode = createCode(programmeCode, courseName);
		}
		if(setter==false){
		   programmeCode=programme.getProgrammeCode();
		   courseCode = createCode(programmeCode, courseName);
		}
		switch (option) {
			case 1:
				max = 4;
				filePathProg = "src/Files/Certificate/Certificate.txt";
				filePathCourse = "src/Files/Certificate/" + programmeCode + "Course.txt";
				allProgrammeName = "src/Files/Certificate/AllProgrammeCode.txt";
				break;
			case 2:
				max = 6;
				filePathProg = "src/Files/Diploma/Diploma.txt";
				filePathCourse = "src/Files/Diploma/" + programmeCode + "Course.txt";
				allProgrammeName = "src/Files/Certificate/AllProgrammeCode.txt";
				break;
			case 3:
				max = 8;
				filePathProg = "src/Files/Associates/Associate.txt";
				filePathCourse = "src/Files/Associates/" + programmeCode + "Course.txt";
				allProgrammeName = "src/Files/Certificate/AllProgrammeCode.txt";
				break;
			default:
				filePathCourse = "null";
				filePathProg = "null";
				max = 0;
				allProgrammeName = "null";
		}

		try {

			programmeWriter = new FileWriter(filePathProg, true);

			courseWriter = new FileWriter(filePathCourse, true);

			courseProgrammeWriter = new FileWriter(fileCourseName, true);

			allProgramme = new FileWriter(allProgrammeName, true);

			allProgrammeRecord = new FileWriter(allProgPath, true);

			course.setCourseCost(numCredits, costPerCredit, 0);

			programme = new Programme(programmeCode, programmeName, max, award, accreditation, courseName, courseCode,
					description, numCredits, preRequisite, costPerCredit,
					course.getCourseCost());

			course = programme.getCourse();

			String programmeRec = programme.getProgrammeCode() +
					"\t" +
					programme.getProgrammeName() +
					"\t" +
					programme.getMaxNumofCourses() +
					"\t" +
					programme.getAward() +
					"\t" +
					programme.getAccreditation() + "\n";

			String courseRec = course.getCourseCode() +
					"\t" +
					course.getName() +
					"\t" +
					course.getProgrammeCode() +
					"\t" +
					course.getCostPerCredit() +
					"\t" +
					course.getNumCredits() +
					"\t" +
					course.getCourseCost() +
					"\t" +
					course.getPreRequisite() +
					"\t" +
					course.getDescription() + "\n";

			String allProgrammeWrite = "\n" + programme.getProgrammeCode();
			if (setter == true) {
				programmeWriter.write(programmeRec);
				courseWriter.write(courseRec);
				courseProgrammeWriter.write(courseRec);
				allProgramme.write(allProgrammeWrite);
				allProgrammeRecord.write(programmeRec);
			} else if (setter == false) {
				courseWriter.write(courseRec);
				courseProgrammeWriter.write(courseRec);
				allProgramme.write(allProgrammeWrite);
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(
					null,
					"An error ocurred in the File \t" + programmeCode + "\n",
					"File Reading Error",
					JOptionPane.ERROR_MESSAGE);

			e.printStackTrace();
		} finally {
			if (programmeWriter != null &&
					courseWriter != null &&
					courseProgrammeWriter != null &&
					allProgramme != null) {
				try {
					programmeWriter.close();
					courseWriter.close();
					courseProgrammeWriter.close();
					allProgramme.close();
					allProgrammeRecord.close();
				} catch (IOException e) {
					System.out.println("An error occurred when closing file.");
					System.out.println("An error has occurred when closing File in studentEnrollment");
					JOptionPane.showMessageDialog(
							null,
							"An error has occurred while closing a file in studentEnrollment",
							"File Could Not Be Closed Error",
							JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
			}
		}
		return programme;
	}

	// Modify the courses of a programmme
	public void modifyProgramme(int programmeType, String courseCode, String programmeCode, String courseName,
			String description,
			int numCredits,
			String preRequisite,
			float costPerCredit) {
		programmeCode = programmeCode.toUpperCase();
		courseCode = courseCode.toUpperCase();
		String programmeFileName = "null";
		File tempFile = null;
		File oldFile = null;
		FileWriter courseWriter = null;
		Scanner courseReader = null;
		String courseRecord = "null";
		Course course = new Course();
		System.out.println("asgseges");
		boolean verify = verifyProg(programmeType, programmeCode);
		if (!verify) {
			JOptionPane.showMessageDialog(
					null,
					"This Programme does not exist",
					"Programme Code Invalid",
					JOptionPane.ERROR_MESSAGE);
		} else if (verify) {
			switch (programmeType) {
				case 1:
					programmeFileName = "src/Files/Certificate/" + programmeCode + "Course.txt";
					tempFile = new File("src/Files/Certificate/temp.txt");
					break;
				case 2:
					programmeFileName = "src/Files/Diploma/" + programmeCode + "Course.txt";
					tempFile = new File("src/Files/Diploma/temp.txt");
					break;
				case 3:
					programmeFileName = "src/Files/Associates/" + programmeCode + "Course.txt";
					tempFile = new File("src/Files/Associates/temp.txt");
					break;
			}
			try {
				courseWriter = new FileWriter(tempFile, true);
				courseReader = new Scanner(new File(programmeFileName));
				oldFile = new File(programmeFileName);

				while (courseReader.hasNext()) {
					String courseFileCode = courseReader.next();

					String courseFileNme = courseReader.next();

					String progFileCode = courseReader.next();

					float costPerCreditFile = courseReader.nextFloat();

					int numCreditsFile = courseReader.nextInt();

					float courseCostFile = courseReader.nextFloat();

					String preRequisiteFile = courseReader.next();

					String descripFile = courseReader.next();

					if (courseFileCode.equals(courseCode)) {
						course.setCourseCost(numCredits, costPerCredit, 0);
						float courseCost = course.getCourseCost();
						course = new Course(courseCode, courseName,
								description, numCredits, preRequisite, costPerCredit, courseCost, programmeCode);

						courseRecord = course.getCourseCode() + "\t" + course.getName()
								+ "\t" + course.getProgrammeCode() + "\t" + course.getCostPerCredit()
								+ "\t" + course.getNumCredits() + "\t" + course.getCourseCost() +
								"\t" + course.getPreRequisite() + "\t" + course.getDescription() + "\n";
						courseWriter.write(courseRecord);

					} else {
						course = new Course(courseFileCode, courseFileNme, descripFile, numCreditsFile,
								preRequisiteFile,
								costPerCreditFile, courseCostFile, progFileCode);

						courseRecord = course.getCourseCode() + "\t" + course.getName()
								+ "\t" + course.getProgrammeCode() + "\t" + course.getCostPerCredit()
								+ "\t" + course.getNumCredits() + "\t" + course.getCourseCost() +
								"\t" + course.getPreRequisite() + "\t" + course.getDescription() + "\n";

						courseWriter.write(courseRecord);
					}
				}
				courseReader.close();

				if (courseRecord.equals("null")) {
					JOptionPane.showMessageDialog(
							null,
							"This Program does not exist",
							"Course Limit",
							JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(
							null,
							"Course Updated SuccessFully",
							"Course Edit",
							JOptionPane.INFORMATION_MESSAGE);
				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(
						null,
						"The File " + "\t" + programmeCode + "\t" + "could not be found",
						"File not Found",
						JOptionPane.ERROR_MESSAGE);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(
						null,
						"The File" + "\t" + programmeCode + "\t" + "can't be oppened",
						"File Reading Error",
						JOptionPane.ERROR_MESSAGE);
			} finally {
				try {
					if (courseWriter != null) {
						courseWriter.close();
						oldFile.delete();
						File dump = new File(programmeFileName);
						tempFile.renameTo(dump);
					}
				} catch (IOException e) {
					JOptionPane.showMessageDialog(
							null,
							"The File" + "\t" + programmeCode + "\t" + "could not be closed",
							"File Reading Error",
							JOptionPane.ERROR_MESSAGE);

					e.printStackTrace();
				}
			}
		}

	}

	// Allows the user to delete course from the programme file
	public void removeCourse(
			int programmeType,
			String programmeCode,
			String courseCode) {
		FileWriter courseWriter = null;
		File tempFile = null;
		File oldFile = null;
		Scanner courseReader = null;
		String programmeFileName = "null";
		String course = "null";

		boolean verify = verifyProg(programmeType, programmeCode);
		if (!verify) {
			JOptionPane.showMessageDialog(
					null,
					"This Programme does not exist",
					"Programme Code Invalid",
					JOptionPane.ERROR_MESSAGE);
		} else if (verify) {
			switch (programmeType) {
				case 1:
					programmeFileName = "src/Files/Certificate/" + programmeCode + "Course.txt";
					tempFile = new File("src/Files/Certificate/temp.txt");
					break;
				case 2:
					programmeFileName = "src/Files/Diploma/" + programmeCode + "Course.txt";
					tempFile = new File("src/Files/Diploma/temp.txt");
					break;
				case 3:
					programmeFileName = "src/Files/Associates/" + programmeCode + "Course.txt";
					tempFile = new File("src/Files/Associates/temp.txt");
					break;
			}

			try {
				courseReader = new Scanner(new File(programmeFileName));
				courseWriter = new FileWriter(tempFile, true);
				oldFile = new File(programmeFileName);
				while (courseReader.hasNext()) {
					String courseFileCode = courseReader.next();
					String token = courseReader.nextLine();
					if (!courseFileCode.equals(courseCode)) {
						course = courseFileCode + "\t" + token + "\n";
						courseWriter.write(course);
					}
				}
				courseReader.close();

				if (course.equals("null")) {
					JOptionPane.showMessageDialog(
							null,
							"This Program does not exist",
							"Course Limit",
							JOptionPane.ERROR_MESSAGE);
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
						"The File" + "\t" + programmeCode + "\t" + "can't be oppened",
						"File Reading Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(
						null,
						"Something went wrong",
						"System Error",
						JOptionPane.ERROR_MESSAGE);
			} finally {
				try {
					if (courseWriter != null && oldFile != null) {
						courseWriter.close();
						oldFile.delete();
						File dump = new File(programmeFileName);
						tempFile.renameTo(dump);

						JOptionPane.showMessageDialog(
								null,
								"File Deleted Successfully",
								"Success",
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (IOException e) {
					JOptionPane.showMessageDialog(
							null,
							"The File" + "\t" + programmeCode + "\t" + "can't be closed",
							"File Reading Error",
							JOptionPane.ERROR_MESSAGE);

					e.printStackTrace();
				}
			}
		}
	}

	// This will generate all students who are enrolled in a specific programme

	public ArrayList<Student> generateStudentList(String programmeCode) {

		programmeCode = programmeCode.toUpperCase();

		int check = 0;
		ArrayList<Student> studentlist = new ArrayList<Student>();

		String studentRecordName = "src/Files/Enrollment.txt"; // This path should be the file where all students
																// are enrolled
		String studentRecord;
		Scanner studentReader = null;
		try {

			System.out.println("------------------------------------------------------------------------------------");
			System.out.println("ALL THE STUDENTS THAT ARE IN THE PROGRAMME " + programmeCode + "  FOR THIS SEMESTER");
			System.out.println("------------------------------------------------------------------------------------");
			studentReader = new Scanner(new File(studentRecordName));

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

				if (progCode.equals(programmeCode)) {
					Student student = new Student(id, fname, lname, parish, streetName, zipCode, dateEnroll,
							programmeCode, enrollment, contactNumber, seqNum);
					studentlist.add(student);
					studentRecord = student.getSequenceNum() +
							"\t" +
							student.getProgrammeCode() +
							"\t" +
							student.getIdNumber() +
							"\t" +
							student.getEnrollmentstatus() +
							"\t" +
							student.getFirstName() +
							"\t" +
							student.getLastName() +
							"\t" +
							student.getContactNumber() +
							"\t" +
							student.getDateEnrolled() +
							"\t" +
							student.getParish() +
							"\t" +
							student.getStreetName() +
							"\t" +
							student.getZipCode() +
							"\t" ;

					System.out.println(
							"----------------------------------------------------------------------------------");
					System.out.println(studentRecord);
					System.out.println(
							"----------------------------------------------------------------------------------");
					check = -1;
				}
			}
			if (check == 0) {
				JOptionPane.showMessageDialog(
						null,
						"There are no students in the Programme " + "\t" + programmeCode + "\n",
						"File not Found",
						JOptionPane.ERROR_MESSAGE);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(
					null,
					"The File " + "\t" + programmeCode + "\t" + " could not be found",
					"File not Found",
					JOptionPane.ERROR_MESSAGE);
		} finally {
			if (studentReader != null) {
				studentReader.close();
			}
		}
		return studentlist;

	}

	public void addCourse(int programmeType, String programmeCode, String courseCode) {
		FileWriter courseWriter = null;
		int max = 0;
		int checkCourseRec = 0;
		int count = 0;
		Scanner courseReader;
		String programmeFileName = "null";
		String courseFileName = "src/Files/Course.txt";
		String course = "null";
		programmeCode = programmeCode.toUpperCase();
		courseCode = courseCode.toUpperCase();
		boolean verify = verifyProg(programmeType, programmeCode);
		if (!verify) {
			JOptionPane.showMessageDialog(
					null,
					"This Programme does not exist",
					"Programme Code Invalid",
					JOptionPane.ERROR_MESSAGE);
		} else if (verify) {
			switch (programmeType) {
				case 1:
					max = 4;
					programmeFileName = "src/Files/Certificate/" + programmeCode + "Course.txt";
					break;
				case 2:
					max = 6;
					programmeFileName = "src/Files/Diploma/" + programmeCode + "Course.txt";
					break;
				case 3:
					max = 8;
					programmeFileName = "src/Files/Associates/" + programmeCode + "Course.txt";
					break;
			}

			try {   
				courseReader = new Scanner(new File(programmeFileName));
				courseWriter = new FileWriter(programmeFileName, true);
				while (courseReader.hasNext()) {
					String courseFileCode = courseReader.next();
					String token = courseReader.nextLine(); // Ignore strings that are not needed
					if (courseFileCode.equals(courseCode)) {
						checkCourseRec = -1;
						break;
					}
					count++;
				}
				courseReader.close();
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
								"This programme has reached its maximum course limit\nRemove a course to add a new one",
								"Course Limit",
								JOptionPane.ERROR_MESSAGE);
					} else if (count < max) {
						max = max - count;
						JOptionPane.showMessageDialog(
								null,
								programmeCode +
										"\t" +
										"has a  maximum of " +
										"\t" +
										max +
										"\t" +
										"courses that can be added",
								"Course Limit",
								JOptionPane.ERROR_MESSAGE);
						courseReader = new Scanner(new File(courseFileName));
					}

					while (courseReader.hasNext()) {
						String courseFileCode = courseReader.next();
						if (courseFileCode.equals(courseCode)) {
							String token = courseReader.nextLine();

							course = courseFileCode + "\t" + token + "\n";

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
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(
						null,
						"The File " + "\t" + programmeCode + "\t" + " could not be found",
						"File not Found",
						JOptionPane.ERROR_MESSAGE);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(
						null,
						"The File " + "\t" + programmeCode + "\t" + " could not be opened",
						"File Reading Error",
						JOptionPane.ERROR_MESSAGE);
			} finally {
				try {
					if (courseWriter != null) {
						courseWriter.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void studentRegistration(int programmeType,
			String fName,
			String lName,
			String parish,
			String streetName,
			String zipCode,
			String dateEnrolled,
			String programmeCode,
			String contactNumber) {
		int sequenceNum = 0;
		FileWriter studentRecords = null;

		FileWriter studentFileWriter = null;

		File studentReader = null;

		Scanner readStudent = null;

		String studentRecordName = "src/Files/StudentRecord.txt";

		String studentFileName = "null";

		Student student;

		switch (programmeType) {
			case 1:
				studentFileName = "src/Files/Certificate/StudentRecord.txt";
				break;
			case 2:
				studentFileName = "src/Files/Diploma/StudentRecord.txt";
				break;
			case 3:
				studentFileName = "src/Files/Associates/StudentRecord.txt";
				break;
		}
		try {
			boolean verify = verifyProg(programmeType, programmeCode);
			if (!verify) {
				JOptionPane.showMessageDialog(
						null,
						"This Programme does not exist",
						"Programme Code Invalid",
						JOptionPane.ERROR_MESSAGE);
			} else if (verify) {
				studentReader = new File(studentFileName);

				if (studentReader.exists() && !studentReader.isDirectory()) {
					System.out.println("File Already exists.");

					readStudent = new Scanner(new File(studentFileName));

					while (readStudent.hasNext()) {
						int increment = readStudent.nextInt();
						for (int i = 0; i < 10; i++) {
							String token = readStudent.next();
						}
						increment++;
						sequenceNum = increment;
					}
					readStudent.close();
					System.out.println("File already exists.");

					String idNumber = createId(
							programmeCode,
							Year.now().getValue(),
							sequenceNum);

					studentRecords = new FileWriter(studentRecordName, true);

					student = new Student();

					student = new Student(
							idNumber,
							fName,
							lName,
							parish,
							streetName,
							zipCode,
							dateEnrolled,
							programmeCode,
							student.getEnrollmentstatus(),
							contactNumber,
							sequenceNum);

					String record = student.getSequenceNum() +
							"\t" +
							student.getProgrammeCode() +
							"\t" +
							student.getIdNumber() +
							"\t" +
							student.getEnrollmentstatus() +
							"\t" +
							student.getFirstName() +
							"\t" +
							student.getLastName() +
							"\t" +
							student.getContactNumber() +
							"\t" +
							student.getDateEnrolled() +
							"\t" +
							student.getParish() +
							"\t" +
							student.getStreetName() +
							"\t" +
							student.getZipCode() +
							"\t\n";
					studentRecords.write(record);

					createCredentials(student.getIdNumber(), student);

					studentFileWriter = new FileWriter(studentFileName, true);

					studentFileWriter.write(record);
				} else {
					System.out.println("File created: " + studentReader.getName());
					studentRecords = new FileWriter(studentRecordName, false);

					student = new Student();

					sequenceNum = student.getSequenceNum();

					String idNumber = createId(
							programmeCode,
							Year.now().getValue(),
							sequenceNum);

					student = new Student(
							idNumber,
							fName,
							lName,
							parish,
							streetName,
							zipCode,
							dateEnrolled,
							programmeCode,
							student.getEnrollmentstatus(),
							contactNumber,
							sequenceNum);

					String record = student.getSequenceNum() +
							"\t" +
							student.getProgrammeCode() +
							"\t" +
							student.getIdNumber() +
							"\t" +
							student.getEnrollmentstatus() +
							"\t" +
							student.getFirstName() +
							"\t" +
							student.getLastName() +
							"\t" +
							student.getContactNumber() +
							"\t" +
							student.getDateEnrolled() +
							"\t" +
							student.getParish() +
							"\t" +
							student.getStreetName() +
							"\t" +
							student.getZipCode() +
							"\t" +
							student.getDateEnrolled() + "\n";
					studentRecords.write(record);

					studentFileWriter = new FileWriter(studentFileName, false);

					studentFileWriter.write(record);

					JOptionPane.showMessageDialog(
							null,
							"File Created Successfully",
							"Success",
							JOptionPane.INFORMATION_MESSAGE);

				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(
					null,
					"The File " + "\t" + idNumber + "\t" + " could not be found",
					"File not Found",
					JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(
					null,
					"The File" + "\t" + idNumber + "\t" + "can't be opened",
					"File Reading Error",
					JOptionPane.ERROR_MESSAGE);
		} finally {
			try {
				if (studentRecords != null && studentFileWriter != null) {
					studentRecords.close();
					studentFileWriter.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(
						null,
						"File could not be found",
						"File not Found",
						JOptionPane.ERROR_MESSAGE); // Statement to be displayed if an error occured
				e.printStackTrace();
			}
		}
	}

	public String createId(String programmeCode, int yr, int sequence) {
		String id = programmeCode + yr + sequence;

		id = id.toUpperCase();

		FileWriter studentProgramme = null;
		try {
			studentProgramme = new FileWriter("src/Files/studentProgrammeCode.txt", true);

			String record = programmeCode + "\t" + id + "\n" ;

			studentProgramme.write(record);
			JOptionPane.showMessageDialog(null,
					"ID Created Successfully",
					"\nSuccess",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (IOException e) {
			System.out.println("Input exception thrown");
			e.printStackTrace();
		} finally {
			if (studentProgramme != null) {
				try {
					studentProgramme.close();
				} catch (IOException e) {
					System.out.println("Input exception thrown");
					e.printStackTrace();
				}
			}
		}

		return id;
	}

	public boolean verifyProg(int programmeType, String programmeCode) {
		String prog = null;
		Scanner programmeReader = null;
		String programmePathName = "";

		switch (programmeType) {
			case 1:
				programmePathName = "src/Files/Certificate/AllProgrammeCode.txt";
				break;
			case 2:
				programmePathName = "src/Files/Diploma/AllProgrammeCode.txt";
				break;
			case 3:
				programmePathName = "src/Files/Associates/AllProgrammeCode.txt";
				break;
			default:
				JOptionPane.showMessageDialog(null,
						"The \t" + programmeType + "\t is invalid",
						"\nInvalid Program Type Error",
						JOptionPane.ERROR_MESSAGE);

				System.out.println("File Not Found Exception Thrown");

		}
		try {
			programmeReader = new Scanner(new File(programmePathName));

			while (programmeReader.hasNextLine()) {
				prog = programmeReader.next();
				if (prog.equals(programmeCode)) {
					return true;
				}
			}

			if (prog != programmeCode) {
				System.out.println("-------------------------------------------------------------");
				System.out.println("                 RECORD COULD NOT BE FOUND");
				System.out.println("-------------------------------------------------------------");
			}

		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,
					"The File \t" + programmeCode + "\t does not exist",
					"\nFile Reading Error",
					JOptionPane.ERROR_MESSAGE);

			System.out.println("File Not Found Exception Thrown");
			e.printStackTrace();
		} finally {
			if (programmeReader != null) {
				programmeReader.close();
			}
		}
		return false;
	}

	@Override
	public boolean verifyLogin(String user, String pass) {
		try {
			File myObj = new File("src/Files/StaffCredentials.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String userIdfile = myReader.next();
				String passwordfile = myReader.next();
				if (userIdfile.equals(user) && passwordfile.equals(pass)) {
					myReader.close();

					JOptionPane.showMessageDialog(null,
							"Login Successful",
							"Success",
							JOptionPane.INFORMATION_MESSAGE);
					return true;
				}
			}
			myReader.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,
					"An error occurred while accessing this file",
					"\nFile Reading Error",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

		return false;
	}

	public void createCredentials(String Idnumber, Student student) {
		File f = null;
		FileWriter studentcred = null;
		try {
			f = new File("src/Files/StudentCredentials.txt");
			if (f.exists() && !f.isDirectory()) {
				System.out.println("File already exists.");

				studentcred = new FileWriter(f, true);
				student.setUserId(Idnumber);
				student.setPassword(passGen());

				String record = "\n" + student.getUserId() + "\t" + student.getPassword();

				studentcred.write(record);
			} else {
				studentcred = new FileWriter("src/Files/StudentCredentials.txt", false);
				student.setUserId(Idnumber);
				student.setPassword(passGen());

				String record = student.getUserId() + "\t" + student.getPassword();

				studentcred.write(record);
				JOptionPane.showMessageDialog(null,
						"File Created Successfully",
						"\nSuccess",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,
					"An error occurred while accessing this file",
					"\nFile Reading Error",
					JOptionPane.ERROR_MESSAGE);

			e.printStackTrace();
		} finally {
			if (studentcred != null) {
				try {
					studentcred.close();
				} catch (IOException e) {
					System.out.println("Input exception thrown");
					e.printStackTrace();
				}
			}
		}
	}

	public String passGen() {
		String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lower = "abcdefghigklmnopqrstuvwxyz";
		String num = "1234567890";
		String special = "@#^&*!-";
		String combination = upper + lower + num + special;
		Random r = new Random();
		int len = 8;
		char[] pass = new char[len];

		for (int i = 0; i < 8; i++) {
			pass[i] = combination.charAt(r.nextInt(combination.length()));
		}
		JOptionPane.showMessageDialog(null,
				"Password Generated Successfully",
				"\nSuccess",
				JOptionPane.INFORMATION_MESSAGE);
		return new String(pass);
		// https://www.youtube.com/watch?v=niay2OKGmlM&ab_channel=CSCORNERSunitaRai

	}

	public String createCode(String award, String programmeName) {
		Random r = new Random();

		String progCode = award.substring(0, 2) +
				programmeName.substring(0, r.nextInt(programmeName.length())) +
				r.nextInt(1000);

		progCode = progCode.toUpperCase();

		return progCode;
	}

	public ArrayList<Course> generateCourseList() {

		String fileCourseName = "src/Files/Course.txt";

		ArrayList<Course> courselist = new ArrayList<Course>();

		try {
			Scanner courseReader = new Scanner(new File(fileCourseName));

			while (courseReader.hasNext()) {

				String courseCode = courseReader.next();

				String name = courseReader.next();

				String programmeCode = courseReader.next();

				float costPerCredit = courseReader.nextFloat();

				int numCredits = courseReader.nextInt();

				float courseCost = courseReader.nextFloat();

				String preRequiste = courseReader.next();

				String description = courseReader.next();

				Course course = new Course(courseCode, name, description, numCredits, preRequiste, costPerCredit,
						courseCost, programmeCode);
				courselist.add(course);
				System.out.println(course);
			}
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(
					null,
					"The File " + "\t" + fileCourseName + "\t" + " could not be found",
					"File Not Found",
					JOptionPane.ERROR_MESSAGE);
		}

		return courselist;
	}

}