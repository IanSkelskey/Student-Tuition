//**************************************************************************************************
// CLASS: OnCampusStudent
//
// DESCRIPTION
// Contains information specific to on campus students and 
// an overrided method for calculating tuition
//
// AUTHOR
// Ian Skelskey, iskelske, ianskelskey@gmail.com
// 
//**************************************************************************************************
public class OnCampusStudent extends Student {

  boolean mResident;
  double mProgramFee;

  public OnCampusStudent(String pId, String pFirstName, String pLastName) {
    super(pId, pFirstName, pLastName);
  }

  public void setResidency(Boolean pResidency) {
    mResident = pResidency;
  }

  public boolean getResidency() {
    return mResident;
  }

  public void setProgramFee(double pProgramFee) {
    mProgramFee = pProgramFee;
  }

  public double getProgramFee() {
    return mProgramFee;
  }

  @Override
  public void calcTuition() {
    double tempTuition = 0;
    if (mResident) {
      tempTuition = TuitionConstants.ONCAMP_RES_BASE;
    } else {
      tempTuition = TuitionConstants.ONCAMP_NONRES_BASE;
    }
    if (getCredits() > TuitionConstants.ONCAMP_MAX_CREDITS) {
      tempTuition += TuitionConstants.ONCAMP_ADD_CREDITS * (getCredits() - TuitionConstants.ONCAMP_MAX_CREDITS);
    }
    setTuition(tempTuition);
  }
}