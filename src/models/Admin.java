// Author/Name: Christoph Banton 
// ID Number: 2100760
// Module: Object Oriented Programming
// Date: November 7, 2022
// Description: The initial system configuration that allows the
                //administrator to create user accounts for staff members.



package models;

import java.io.File; // Import the File class
import java.io.FileWriter;
import java.io.IOException; // Import the IOException class to handle errors
import java.util.Scanner;

import javax.swing.JOptionPane;

import java.util.*;

public class Admin extends Staff {

    private String admFName;
    private String admLName;

    public Admin() {
        admFName = "Chris";
        admLName = "Banton";
        userId = "Admin";
        password = "Admin";
    }

    public Admin(String fName, String lName) {
        this.firstName = fName;
        this.lastName = lName;
    }

    public Admin(Admin admin) {
        admFName = admin.admFName;
        admLName = admin.admLName;
    }

    public void registerStaff(String firstName, String lastName, String address, String year, String day, String month,
            String faculty, String department) {
        sequenceNum = 0;
        int check=-1;
        FileWriter staffRec = null;
        Scanner readStff = null;
        try {
            File f = new File("src/Files/StaffRecord.txt");
            if (f.exists() && !f.isDirectory()) {
       
                readStff = new Scanner(f);

                while (readStff.hasNextLine()) {
                    int increment = readStff.nextInt();
                    for (int i = 0; i < 9; i++) {
                        String token = readStff.next();
                    }
                    increment++;
                    sequenceNum = increment;
                }
                readStff.close();
                idNumber = createId(faculty, year, sequenceNum);

                staffRec = new FileWriter("src/Files/StaffRecord.txt", true);

                Staff staff = new Staff(idNumber, firstName, lastName, address, year, day, month, faculty, department,
                        sequenceNum);

                String record = "\n" + staff.getSequenceNum() + "\t" + staff.getIdNumber() + "\t"
                        + staff.getFirstName()
                        + "\t" + staff.getLastName() + "\t" + staff.getAddress() + "\t" + staff.getDepartment() + "\t"
                        + staff.getFaculty() + "\t"
                        + staff.getDay() + "\t"
                        + staff.getMonth() + "\t" + staff.getYear();
                staffRec.write(record);
                staffRec.close();
                createCredentials(staff.getIdNumber(), staff);
            } else {
        
                staffRec = new FileWriter("src/Files/StaffRecord.txt", false);

                Staff staff = new Staff();

                sequenceNum = staff.getSequenceNum();

                idNumber = createId(faculty, year, sequenceNum);

                staff = new Staff(idNumber, firstName, lastName, address, year, day, month, faculty, department,
                        sequenceNum);

                String record = "\n" + staff.getSequenceNum() + "\t" + staff.getIdNumber() + "\t"
                        + staff.getFirstName()
                        + "\t" + staff.getLastName() + "\t" + staff.getAddress() + "\t" + staff.getDepartment() + "\t"
                        + staff.getFaculty() + "\t"
                        + staff.getDay() + "\t"
                        + staff.getMonth() + "\t" + staff.getYear();
                staffRec.write(record);
                createCredentials(staff.getIdNumber(), staff);

            }

        } catch (IOException e) {
            check=0;
            e.printStackTrace();
            JOptionPane.showMessageDialog(
                null,
                "An error Occured",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        } finally {
            if (staffRec != null) {
                try {
                    staffRec.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        if(check == -1){
            JOptionPane.showMessageDialog(null, "Sucessfully Registered", "Success",JOptionPane.INFORMATION_MESSAGE);
        }
        
    }

    public String createId(String fac, String yr, int sequence) {

        String id = fac.substring(0, 2) + yr + String.valueOf(sequence);

        String idNumber = id.toUpperCase();

        return idNumber;

    }

    public void createCredentials(String Idnumber, Staff staff) {
        File f = new File("src/Files/StaffCredentials.txt");
        if (f.exists() && !f.isDirectory()) {
            try {
                FileWriter staffcred = new FileWriter("src/Files/StaffCredentials.txt", true);
                staff.setUserId(Idnumber);
                staff.setPassword(passGen());

                String record = "\n" + staff.getUserId() + "\t" + staff.getPassword();

                staffcred.write(record);
                staffcred.close();

                JOptionPane.showMessageDialog(null, "USER ID:" + "\t" + staff.getUserId() + "\n" + "PASSWORD:" + "\t" +  staff.getPassword(), "Staff Credentials",JOptionPane.INFORMATION_MESSAGE);
                

            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "An Error has occured in registration file", "Registration File",
                        JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        } else {
            try {
                FileWriter staffcred = new FileWriter("src/Files/StaffCredentials.txt", true);
                staff.setUserId(Idnumber);
                staff.setPassword(passGen());
                String record = "\n" + staff.getUserId() + "\t" + staff.getPassword();

                staffcred.write(record);
                staffcred.close();

            } catch (IOException e) {
                JOptionPane.showMessageDialog(
                null,
                "An Error Occured",
                "File Error",
                JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
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
        return new String(pass);
        // https://www.youtube.com/watch?v=niay2OKGmlM&ab_channel=CSCORNERSunitaRai

    }

    @Override
    public boolean verifyLogin(String user, String pass) {
        try {
            if (userId.equals(user) && password.equals(pass)) {
                JOptionPane.showMessageDialog(null,
					"Login Successful",
					"\nSuccess",
					JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(
                null,
                "An error Occured",
                "Error",
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

        return false;

    }

}