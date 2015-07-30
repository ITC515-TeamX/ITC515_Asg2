package datamanagement;

public class StudentUnitRecord implements IStudentUnitRecord {

  private Integer studentId_;
  private String unitCode_;
  private float asg1Mark_;
  private float asg2Mark_;
  private float examMark_;


  
  public StudentUnitRecord(Integer studentId, String unitCode, float asg1Mark, float asg2Mark, float examMark) {
    this.studentId_ = studentId;
    this.unitCode_ = unitCode;
    this.setAsg1Mark(asg1Mark);
    this.setAsg2Mark(asg2Mark);
    this.setExamMark(examMark);
  }


  
  public Integer getStudentId() {
    return studentId_;
  }


  
  public String getUnitCode() {
    return unitCode_;
  }


  
  public void setAsg1Mark(float asg1Mark) {
    IUnit unit = UnitManager.getInstance().getUnit(unitCode_);
    int assessmentWeight = unit.getAsg1Weight();
    
    if (asg1Mark < 0 || asg1Mark > assessmentWeight) {
      throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
    }
    this.asg1Mark_ = asg1Mark;
  }

  
  
  public float getAsg1Mark() {
    return asg1Mark_;
  }


  
  public void setAsg2Mark(float asg2Mark) {
    IUnit unit = UnitManager.getInstance().getUnit(unitCode_);
    int assessmentWeight = unit.getAsg2Weight();
    
    if (asg2Mark < 0 || asg2Mark > assessmentWeight) {
      throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
    }
    this.asg2Mark_ = asg2Mark;
  }


  
  public float getAsg2Mark() {
    return asg2Mark_;
  }


  
  public void setExamMark(float examMark) {
    IUnit unit = UnitManager.getInstance().getUnit(unitCode_);
    int assessmentWeight = unit.getExamWeight();
    
    if (examMark < 0 || examMark > assessmentWeight) {
      throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
    }
    this.examMark_ = examMark;
  }



  public float getExamMark() {
    return examMark_;
  }


  
  public float getTotalMark() {
    float totalMark = asg1Mark_ + asg2Mark_ + examMark_;
    return totalMark;

  }

}
