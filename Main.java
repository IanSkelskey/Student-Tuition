//**************************************************************************************************
// CLASS: Main
//
// DESCRIPTION
// The Main class for student tuition calculator.
//
// AUTHOR
// Ian Skelskey, iskelske, ianskelskey@gmail.com
// 
//**************************************************************************************************
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  // Calls other methods to implement the sw requirements.
  public static void main(String args[]) {
    new Main().run();
  }

  private void run() {
    Scanner infile;
    // * Declare ArrayList<Student> object named studentList and initialize it to
    // null
    ArrayList<Student> studentList = new ArrayList<Student>();
    try {
      infile = new Scanner(new File("p02-students.txt"));
      while (infile.hasNext()) {
        String type = infile.next();
        if (type.equals("C")) { //is on campus student
          OnCampusStudent ocs = new OnCampusStudent(infile.next(), infile.next(), infile.next()); //create an on campus student object called ocs and sets ID, first name, and last name
          ocs.setResidency(infile.next().equals("R")); //ocs is resident 
          ocs.setProgramFee(infile.nextDouble()); //stores student ID
          ocs.setCredits(infile.nextInt());
          ocs.calcTuition(); //calculates tuition. function defined in OnCampusStudent.java
          studentList.add(ocs); //adds student to array
        } else if (type.equals("O")) { //is online student
          OnlineStudent ols = new OnlineStudent(infile.next(), infile.next(), infile.next());//create an online student object called ocs and sets ID, first name, and last name
          ols.setTechFee(infile.next().equals("T"));
          ols.setCredits(infile.nextInt());
          ols.calcTuition(); //calculates tuition. function defined in OnlineStudent.java
          studentList.add(ols);//adds student to array
        }
      }
      infile.close();

      Sorter sorter = new Sorter();
      sorter.insertionSort(studentList, Sorter.SORT_ASCENDING);

      PrintWriter writer = new PrintWriter("p02-tuition.txt");
      Student s;
      for (int i = 0; i < studentList.size(); i++) {
        s = studentList.get(i);
        writer.printf("%-15s %-12s %-12s %8.2f\n", s.getId(), s.getFirstName(), s.getLastName(), s.getTuition());
      }
      writer.close();
      System.out.println("created output file p02-tuition.txt");
    } catch (FileNotFoundException e) {
      System.out.println("Sorry, could not open 'p02-students.txt' for reading. Stopping.");
    }

  }
}
