package guiPKG.utils;

import java.io.File; // Import the File class
import java.io.FileNotFoundException;
import java.io.IOException; // Import the IOException class to handle errors
import java.util.Scanner;

import models.Course;


public class mainFile {

  protected static File myObj;
  protected static String f;

  public static void main(String[] args) throws FileNotFoundException {
    String directry = "src/Files";
    String filename = "/loginDetail";
    String filend = ".txt";
    //Create file and append
    try {
     Course course= new Course();
     
     System.out.println(course);
      String lol = String.join(filename, directry, filend);

      System.out.println("File Name: " + lol);

      Scanner myReader = new Scanner(new File(directry + filename + filend));

      // Append to file
      

      File f = new File(directry + filename + filend);
      if (f.exists() && !f.isDirectory()) {
        System.out.println("File already exists.");
      } else {
        System.out.println("File created: " + f.getName());

      }
      if(myReader.hasNextLine()){
        System.out.println("aefgeg");

      }

      
 

      // write to file
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}
    // }
    // try {
    //   FileWriter myObj = new FileWriter(directry + filename + filend, true);
    //   Student stu = new Student();
    //   stu.setIdNumber("112313");
    //   String record = "\n" + stu.getFirstName() + "\t" + stu.getIdNumber();
    //   myObj.write(record);
    //   myObj.close();

    // } catch (IOException e) {
    //   System.out.println("An error occurred.");
    //   e.printStackTrace();
    // }

    // Search file perform tasks( to update or delete) Display
  //   try {
  //     String searchid = "112313";
  //     boolean found = false;
  //      String userIdfile = "112313";
  //     String passwordfile = "null";
  //     // FileWriter myObj = new
  //     // FileWriter(String.join(fileanem,directry,filend),true);
  //     // File myObj = new File(directry+filename+filend);

  //     Scanner myReader = new Scanner(new File(directry + filename + filend));
  //     // while (myReader.hasNextLine()) {
  //     //   passwordfile = myReader.next();
  //     //   userIdfile = myReader.nextLine();
  //     //   if (searchid == userIdfile) {
  //     //     found = true;
  //     //     break;
  //     //   }
  //     // }
  //     // // if (found == true) {
  //     // //
  //     // System.out.println(userIdfile);
  //     // System.out.println(passwordfile);
  //     // }
  //     // View ALL
  //     while (myReader.hasNextLine()) {
  //       passwordfile = myReader.next();
  //       userIdfile = myReader.nextLine();
  //       System.out.println(userIdfile);
  //       System.out.println(passwordfile);
  //     }
  //     myReader.close();
  //   } catch (IOException e) {
  //     JOptionPane.showMessageDialog(null, "Login Information is Invalid \n Try Again", "Invalid Login",
  //         JOptionPane.ERROR_MESSAGE);
  //     e.printStackTrace();
  //   }

  // }
// }

// public static void write(String a) {
// try {
// if ("filename.txt".length() == 0) {
// writer = new PrintWriter("filename.txt");
// writer.print("Start Writing\n");
// writer.print("Start Writing\n");
// writer.close();
// } else {
// writer.append(a + " ");
// writer.close();
// }
// } catch (FileNotFoundException e) {
// System.out.println("An error occurred.");
// e.printStackTrace();
// }
// }

// }
// // if(passwordfile==password && userIdfile==userId){

// // // return true;
// // }