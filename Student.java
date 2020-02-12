//**************************************************************************************************
// CLASS: Student
//
// DESCRIPTION
// Student is an abstract class and is the superclass for the OnCampusStudent and OnlineStudent
// classes. Remember that in a class hierarchy, the superclass declares data and methods that are
// common to all types of students.
//
// COURSE AND PROJECT INFO
// CSE205 Object Oriented Programming and Data Structures, Fall 2019
//
// AUTHOR
// Ian Skelskey, iskelske, ianskelskey@gmail.com
// 
//**************************************************************************************************
public abstract class Student implements Comparable<Student> {

  private int mCredits;
  private String mId;
  private String mLastName;
  private String mFirstName;
  private double mTuition;

  public Student(String pId, String pFirstName, String pLastName) {
    mId = pId;
    mFirstName = pFirstName;
    mLastName = pLastName;
  }

  public int getCredits() {
    return mCredits;
  }

  public void setCredits(int pCredits) {
    this.mCredits = pCredits;
  }

  public String getId() {
    return mId;
  }

  public void setId(String pId) {
    this.mId = pId;
  }

  public String getLastName() {
    return mLastName;
  }

  public void setLastName(String pLastName) {
    this.mLastName = pLastName;
  }

  public String getFirstName() {
    return mFirstName;
  }

  public void setFirstName(String pFirstName) {
    this.mFirstName = pFirstName;
  }

  public double getTuition() {
    return mTuition;
  }

  protected void setTuition(double pTuition) {
    mTuition = pTuition;
  }

  public abstract void calcTuition();

  @Override
  public int compareTo(Student pStudent) {
    return getId().compareTo(pStudent.getId());
  }
}