//**************************************************************************************************
// CLASS: Main
//
// DESCRIPTION
// The Main class for Project 2.
//
// COURSE AND PROJECT INFO
//CSE205 Object Oriented Programming and Data Structures, Fall 2019
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
        if (type.equals("C")) {
          OnCampusStudent ocs = new OnCampusStudent(infile.next(), infile.next(), infile.next());
          ocs.setResidency(infile.next().equals("R"));
          ocs.setProgramFee(infile.nextDouble());
          ocs.setCredits(infile.nextInt());
          ocs.calcTuition();
          studentList.add(ocs);
        } else if (type.equals("O")) {
          OnlineStudent ols = new OnlineStudent(infile.next(), infile.next(), infile.next());
          ols.setTechFee(infile.next().equals("T"));
          ols.setCredits(infile.nextInt());
          ols.calcTuition();
          studentList.add(ols);
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
