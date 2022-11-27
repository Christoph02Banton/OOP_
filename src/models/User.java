// Author/Name: Christoph Banton 
// ID Number: 2100760
// Module: Object Oriented Programming
// Date: November 7, 2022
// Description: Setting Login Credentials
package models;

// import javax.swing.*;
import java.io.File; // Import the File class
// import java.io.IOException; // Import the IOException class to handle errors
import java.util.Scanner;

import javax.swing.JOptionPane;

import java.io.FileNotFoundException;
// import java.util.*;

public class User { // Initializing User Class

  // Initializing Attributes:
  protected String userId;
  protected String password;

  public User() {
    userId = "null";
    password = "null";
  }

  // Verification of Login Information
  public boolean verifyLogin(String user, String pass) {
    try {
      File myObj = new File("filename.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String userIdfile = myReader.next();
        String passwordfile = myReader.next();
        System.out.println("User: " + userIdfile);
        System.out.println("Pasword: " + passwordfile);
        if (userIdfile.equals(user) && passwordfile.equals(pass)) {
          System.out.println(userIdfile);
          myReader.close();
          return true;
        }
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
			JOptionPane.showMessageDialog(
					null,
					"File could not be found",
					"File not Found",
					JOptionPane.ERROR_MESSAGE); // Statement to be displayed if an error occured
      e.printStackTrace();
    }
    try {
      File myObj = new File("filename.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String userIdfile = myReader.next();
        String passwordfile = myReader.next();
        
        if (userIdfile.equals(user) && passwordfile.equals(pass)) { 
          myReader.close();
          return true;
        }
      }
      myReader.close();
    } catch (FileNotFoundException e) {
       e.printStackTrace();
			JOptionPane.showMessageDialog(
					null,
					"File could not be found",
					"File not Found",
					JOptionPane.ERROR_MESSAGE); // Statement to be displayed if an error occured
      e.printStackTrace();
    }
    return false;
  }

  // Getting User ID by returning the value to the attribute
  public String getUserId() {
    return userId;
  }

  // Setting User ID
  public void setUserId(String userId) {
    this.userId = userId;
  }

  // Getting User Password by returning the value to the attribute
  public String getPassword() {
    return password;
  }

  // Setting user password
  public void setPassword(String password) {
    this.password = password;
  }
}
