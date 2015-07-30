package datamanagement;

public class StudentUnitRecordProxy implements IStudentUnitRecord {
  private Integer studentId_;
  private String unitCode_;
  private StudentUnitRecordManager recordManager_;


  
  public StudentUnitRecordProxy(Integer id, String code) {
    this.studentId_ = id;
    this.unitCode_ = code;
    this.recordManager_ = StudentUnitRecordManager.getInstance();
  }


  
  public Integer getStudentId() {
    return studentId_;
  }


  
  public String getUnitCode() {
    return unitCode_;
  }


  
  public void setAsg1Mark(float mark) {
    IStudentUnitRecord record = getRecord();
    record.setAsg1Mark(mark);
  }


  
  public float getAsg1Mark() {
    IStudentUnitRecord record = getRecord();
    float asg1Mark = record.getAsg1Mark();
    return asg1Mark;
  }


  
  public void setAsg2Mark(float mark) {
    IStudentUnitRecord record = getRecord();
    record.setAsg2Mark(mark);
  }


  
  public float getAsg2Mark() {
    IStudentUnitRecord record = getRecord();
    float asg2Mark = record.getAsg2Mark();
    return asg2Mark;
  }


  
  public void setExamMark(float mark) {
    IStudentUnitRecord record = getRecord();
    record.setExamMark(mark);
  }


  
  public float getExamMark() {
    IStudentUnitRecord record = getRecord();
    float examMark = record.getExamMark();
    return examMark;
  }


  
  public float getTotalMark() {
    IStudentUnitRecord record = getRecord();
    return record.getTotalMark();
  }
  

  
  private IStudentUnitRecord getRecord() {
    IStudentUnitRecord record = recordManager_.getStudentUnitRecord(studentId_, unitCode_);
    return record;
  }
}
