package datamanagement;

public class Student implements IStudent {

  private Integer studentId_;
  private String firstName_;
  private String lastname_;
  private StudentUnitRecordList subjectRecords_;


  
  public Student(Integer id, String fn, String ln, StudentUnitRecordList su) {
    this.studentId_ = id;
    this.firstName_ = fn;
    this.lastname_ = ln;
    this.subjectRecords_ = su == null ? new StudentUnitRecordList() : su;
  }


  
  public Integer getId() {
    return this.studentId_;
  }


  
  public String getFirstName() {
    return firstName_;
  }


  
  public void setFirstName(String firstName) {
    this.firstName_ = firstName;
  }


  
  public String getLastName() {
    return lastname_;
  }


  
  public void setLastName(String lastName) {
    this.lastname_ = lastName;
  }


  
  public void addUnitRecord(IStudentUnitRecord record) {
    subjectRecords_.add(record);
  }

 
  
  public IStudentUnitRecord getUnitRecord(String unitCode) {
    for (IStudentUnitRecord record : subjectRecords_) {
      if (record.getUnitCode().equals(unitCode)) {
        return record;
      }
    }
    return null;
  }


  
  public StudentUnitRecordList getUnitRecords() {
    return subjectRecords_;
  }
}
