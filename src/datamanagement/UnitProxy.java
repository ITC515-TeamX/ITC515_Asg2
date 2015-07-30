package datamanagement;

public class UnitProxy implements IUnit {
  private String unitCode_;
  private String unitName_;

  UnitManager unitManager_;


  
  public UnitProxy(String unitCode, String unitName) {
    this.unitCode_ = unitCode;
    this.unitName_ = unitName;
    unitManager_ = UnitManager.getInstance();
  }


  
  public String getUnitCode() {
    return this.unitCode_;
  }


  
  public String getUnitName() {
    return this.unitName_;
  }


  
  public void setPsCutoff(float cutoff) {
    IUnit unit = unitManager_.getUnit(unitCode_);
    unit.setPsCutoff(cutoff);
  }


  
  public float getPsCutoff() {
    IUnit unit = unitManager_.getUnit(unitCode_);
    float cutoff = unit.getPsCutoff();
    return cutoff;
  }


  
  public void setCrCutoff(float cutoff) {
    IUnit unit = unitManager_.getUnit(unitCode_);
    unit.setCrCutoff(cutoff);
  }


  
  public float getCrCutoff() {
    IUnit unit = unitManager_.getUnit(unitCode_);
    float cutoff = unit.getCrCutoff();
    return cutoff;
  }


  
  public void setDiCutoff(float cutoff) {
    IUnit unit = unitManager_.getUnit(unitCode_);
    unit.setDiCutoff(cutoff);
  }


  
  public float getDiCutoff() {
    IUnit unit = unitManager_.getUnit(unitCode_);
    float cutoff = unit.getDiCutoff();
    return cutoff;
  }


  
  public void setHdCutoff(float cutoff) {
    IUnit unit = unitManager_.getUnit(unitCode_);
    unit.setHdCutoff(cutoff);
  }


  
  public float getHdCutoff() {
    IUnit unit = unitManager_.getUnit(unitCode_);
    float cutoff = unit.getHdCutoff();
    return cutoff;
  }


  
  public void setAeCutoff(float cutoff) {
    IUnit unit = unitManager_.getUnit(unitCode_);
    unit.setAeCutoff(cutoff);
  }


  
  public float getAeCutoff() {
    IUnit unit = unitManager_.getUnit(unitCode_);
    float cutoff = unit.getAeCutoff();
    return cutoff;
  }


  
  public String getGrade(float asg1Mark, float asg2Mark, float examMark) {
    IUnit unit = unitManager_.getUnit(unitCode_);
    String grade = unit.getGrade(asg1Mark, asg2Mark, examMark);
    return grade;
  }


  
  public void addStudentRecord(IStudentUnitRecord record) {
    IUnit unit = unitManager_.getUnit(unitCode_);
    unit.addStudentRecord(record);
  }


  
  public IStudentUnitRecord getStudentRecord(int studentId) {
    IUnit unit = unitManager_.getUnit(unitCode_);
    IStudentUnitRecord record =  unit.getStudentRecord(studentId);
    return record;
  }



  public StudentUnitRecordList listStudentRecords() {
    IUnit unit = unitManager_.getUnit(unitCode_);
    StudentUnitRecordList records = unit.listStudentRecords();
    return records;
  }



  public int getAsg1Weight() {
    IUnit unit = unitManager_.getUnit(unitCode_);
    int weight = unit.getAsg1Weight();
    return weight;
  }


  
  public int getAsg2Weight() {
    IUnit unit = unitManager_.getUnit(unitCode_);
    int weight = unit.getAsg2Weight();
    return weight;
  }


  
  public int getExamWeight() {
    IUnit unit = unitManager_.getUnit(unitCode_);
    int weight = unit.getExamWeight();
    return weight;
  }


  
  public void setAssessmentWeights(int asg1Wgt, int asg2Wgt, int examWgt) {
    IUnit unit = unitManager_.getUnit(unitCode_);
    unit.setAssessmentWeights(asg1Wgt, asg2Wgt, examWgt);
  }
  
  
}
