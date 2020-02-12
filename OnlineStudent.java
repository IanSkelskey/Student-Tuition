//**************************************************************************************************
// CLASS: OnlineStudent
//
// DESCRIPTION
// Contains information specific to online students and 
// an overrided method for calculating tuition
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

@Override
  public void calcTuition() {
    double tempTuition = 0;
    tempTuition = getCredits() * TuitionConstants.ONLINE_CREDIT_RATE;
    if (mTechFee) {
      tempTuition += TuitionConstants.ONLINE_TECH_FEE;
    }
    setTuition(tempTuition);
  }
}