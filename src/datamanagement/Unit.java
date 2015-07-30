package datamanagement;

public class Unit implements IUnit {

  private String unitCode_;
  private String unitName_;
  private float  psCutoff_;
  private float  crCutoff_;
  private float  diCutoff_;
  private float  hdCutoff_;
  private float  aeCutoff_;
  private int    asg1Weight_;
  private int    asg2Weight_;
  private int    examWeight_;

  private StudentUnitRecordList studentRecords_;


  
  public Unit(String unitCode, String unitName, 
		  float psCutoff, float crCutoff, float diCutoff, float hdCutoff, float aeCutoff, 
          int asg1Weight, int asg2Weight, int examWeight,
          StudentUnitRecordList studentRecords) {

    unitCode_ = unitCode;
    unitName_ = unitName;
    this.setCutoffs(psCutoff, crCutoff, diCutoff, hdCutoff, aeCutoff);
    this.setAssessmentWeights(asg1Weight, asg2Weight, examWeight);
    
    if (studentRecords == null) {
      studentRecords_ = new StudentUnitRecordList();
    }
    else {
      studentRecords_ = studentRecords;
    }
  }

  
  
  public String getUnitCode() {
    return this.unitCode_;
  }

  
  
  public String getUnitName() {
    return this.unitName_;
  }

  
  
  public void setPsCutoff(float cutoff) {
    this.psCutoff_ = cutoff;
  }

  
  
  public float getPsCutoff() {
    return this.psCutoff_;
  }

  
  
  public void setCrCutoff(float cutoff) {
    this.crCutoff_ = cutoff;
  }

  
  
  public float getCrCutoff() {
    return this.crCutoff_;
  }

  
  
  public void setDiCutoff(float cutoff) {
    this.diCutoff_ = cutoff;
  }

  
  
  public float getDiCutoff() {
    return this.diCutoff_;
  }

  
  
  public void HDCutoff(float cutoff) {
    this.hdCutoff_ = cutoff;
  }

  public void setHdCutoff(float cutoff) {
    this.hdCutoff_ = cutoff;
  }

  
  
  public float getHdCutoff() {
    return this.hdCutoff_;

  }

  
  
  public void setAeCutoff(float cutoff) {
    this.aeCutoff_ = cutoff;
  }

  
  
  public float getAeCutoff() {
    return this.aeCutoff_;
  }

  public void addStudentRecord(IStudentUnitRecord record) {
    studentRecords_.add(record);
  }

  
  
  public IStudentUnitRecord getStudentRecord(int studentId) {
    for (IStudentUnitRecord record : studentRecords_) {
      if (record.getStudentId() == studentId) {
        return record;
      }
    }
    return null;
  }

  
  
  public StudentUnitRecordList listStudentRecords() {
    return studentRecords_;
  }

  
  
  @Override
  public int getAsg1Weight() {
    return asg1Weight_;
  }

  
  
  @Override
  public int getAsg2Weight() {
    return asg2Weight_;
  }

  
  
  @Override
  public int getExamWeight() {
    return examWeight_;
  }

  
  
  @Override
  public void setAssessmentWeights(int asg1Weight, int asg2Weight, int examWeight) {
    if (asg1Weight < 0 || asg1Weight > 100 || 
        asg2Weight < 0 || asg2Weight > 100 || 
        examWeight < 0 || examWeight > 100) {
      throw new RuntimeException("Assessment weights cant be less than zero or greater than 100");
    }
    if (asg1Weight + asg2Weight + examWeight != 100) {
      throw new RuntimeException("Assessment weights must add to 100");
    }
    this.asg1Weight_ = asg1Weight;
    this.asg2Weight_ = asg2Weight;
    this.examWeight_ = examWeight;
  }

  
  
  private void setCutoffs(float psCutoff, float crCutoff, float diCutoff, float hdCutoff, float aeCutoff) {
    if (psCutoff < 0 || psCutoff > 100 || 
        crCutoff < 0 || crCutoff > 100 || 
        diCutoff < 0 || diCutoff > 100 || 
        hdCutoff < 0 || hdCutoff > 100 || 
        aeCutoff < 0 || aeCutoff > 100) {
      throw new RuntimeException("Assessment cutoffs cannot be less than zero or greater than 100");
    }
    if (aeCutoff >= psCutoff) {
      throw new RuntimeException("AE cutoff must be less than PS cutoff");
    }
    if (psCutoff >= crCutoff) {
      throw new RuntimeException("PS cutoff must be less than CR cutoff");
    }
    if (crCutoff >= diCutoff) {
      throw new RuntimeException("CR cutoff must be less than DI cutoff");
    }
    if (diCutoff >= hdCutoff) {
      throw new RuntimeException("DI cutoff must be less than HD cutoff");
    }
    // cutoffs OK, so set them
    psCutoff_ = psCutoff;
    crCutoff_ = crCutoff;
    diCutoff_ = diCutoff;
    hdCutoff_ = hdCutoff;
    aeCutoff_ = aeCutoff;
  }

  
  
  public String getGrade(float asg1Mark, float asg2Mark, float examMark) {
    float totalMark = asg1Mark + asg2Mark + examMark;

    if (asg1Mark < 0 || asg1Mark > asg1Weight_ || 
        asg2Mark < 0 || asg2Mark > asg2Weight_ || 
        examMark < 0 || examMark > examWeight_) {
      throw new RuntimeException("marks cannot be less than zero or greater than assessment weights");
    }

    if (totalMark < aeCutoff_) {
      return "FL";
    } 
    else if (totalMark < psCutoff_) {
      return "AE";
    }
    else if (totalMark < crCutoff_) {
      return "PS";
    }
    else if (totalMark < diCutoff_) {
      return "CR";
    }
    else if (totalMark < hdCutoff_) {
      return "DI";
    }
    else {
      return "HD";
    }
  }

}