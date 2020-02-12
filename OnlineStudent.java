//**************************************************************************************************
// CLASS: OnlineStudent
//
// DESCRIPTION
// Contains information specific to online students and 
// an overrided method for calculating tuition
//
// COURSE AND PROJECT INFO
//CSE205 Object Oriented Programming and Data Structures, Fall 2019
//
// AUTHOR
// Ian Skelskey, iskelske, ianskelskey@gmail.com
// 
//**************************************************************************************************
public class OnlineStudent extends Student {

  boolean mTechFee;

  public OnlineStudent(String pId, String pFirstName, String pLastName) {
    super(pId, pFirstName, pLastName);
  }

  public boolean getTechFee() {
    return mTechFee;
  }

  public void setTechFee(boolean pTechFee) {
    mTechFee = pTechFee;
  }

  public void calcTuition() {
    double tempTuition = 0;
    tempTuition = getCredits() * TuitionConstants.ONLINE_CREDIT_RATE;
    if (mTechFee) {
      tempTuition += TuitionConstants.ONLINE_TECH_FEE;
    }
    setTuition(tempTuition);
  }
}