package datamanagement;

import java.util.List;
import org.jdom.*;

public class StudentUnitRecordManager {

  private static StudentUnitRecordManager studentManager_ = null;
  private StudentUnitRecordMap records_;
  private java.util.HashMap<String, StudentUnitRecordList> recordsByUnit_;
  private java.util.HashMap<Integer, StudentUnitRecordList> recordsByStudent_;


  
  public static StudentUnitRecordManager getInstance() {
    if (studentManager_ == null) {
      studentManager_ = new StudentUnitRecordManager();
    }
    return studentManager_;
  }


  
  private StudentUnitRecordManager() {
    records_ = new StudentUnitRecordMap();
    recordsByUnit_ = new java.util.HashMap<>();
    recordsByStudent_ = new java.util.HashMap<>();
  }


  
  public IStudentUnitRecord getStudentUnitRecord(Integer studentId, String unitCode) {
    String recordKey = studentId.toString() + unitCode;
    IStudentUnitRecord record = records_.get(recordKey);
    if (record == null) {
      record = createStudentUnitRecord(studentId, unitCode);
    }
    return record; 
  }


  
  private IStudentUnitRecord createStudentUnitRecord(Integer studentId, String unitCode) {
    @SuppressWarnings("unchecked")
    List<Element> recordElements = (List<Element>) XmlFileManager.getInstance().getDocument().getRootElement()
                                    .getChild("studentUnitRecordTable")
                                    .getChildren("record");

    for (Element el : recordElements) {
      String sid = el.getAttributeValue("sid");
      String ucd = el.getAttributeValue("uid");
      float asg1Mark = new Float(el.getAttributeValue("asg1")).floatValue();
      float asg2Mark = new Float(el.getAttributeValue("asg2")).floatValue();
      float examMark = new Float(el.getAttributeValue("exam")).floatValue();
      if (studentId.toString().equals(sid) && unitCode.equals(ucd)) {
        IStudentUnitRecord record = new StudentUnitRecord(studentId, unitCode, asg1Mark, asg2Mark, examMark);
        String recordKey = studentId.toString() + unitCode;
        records_.put(recordKey, record);
        return record;
      }
    }
    throw new RuntimeException("DBMD: createStudent : student unit record not in file");
  }


  
  public StudentUnitRecordList getRecordsByUnit(String unitCode) {
    StudentUnitRecordList records = recordsByUnit_.get(unitCode);
    if (records != null) {
      return records;
    }    
    @SuppressWarnings("unchecked")
    List<Element> recordElements = (List<Element>) XmlFileManager.getInstance().getDocument().getRootElement()
                                    .getChild("studentUnitRecordTable")
                                    .getChildren("record");
    records = new StudentUnitRecordList();
    for (Element el : recordElements) {
      String ucd = el.getAttributeValue("uid");
      if (unitCode.equals(ucd)) {
        Integer studentId = new Integer(el.getAttributeValue("sid"));
        IStudentUnitRecord record = new StudentUnitRecordProxy(studentId, unitCode);
        records.add(record);
      }
    }
    
    // if record list contains records, add it to recordsByUnit map   
    if (records.size() > 0) {
      recordsByUnit_.put(unitCode, records); 
    }
    return records;
  }



  public StudentUnitRecordList getRecordsByStudent(Integer studentId) {
    StudentUnitRecordList records = recordsByStudent_.get(studentId);
    if (records != null) {
      return records;
    }
    
    @SuppressWarnings("unchecked")
    List<Element> recordElements = (List<Element>) XmlFileManager.getInstance().getDocument().getRootElement()
                                    .getChild("studentUnitRecordTable")
                                    .getChildren("record");
    records = new StudentUnitRecordList();
    for (Element el : recordElements) {
      String sid = el.getAttributeValue("sid");
      if (studentId.toString().equals(sid)) {
        String unitCode = el.getAttributeValue("uid");
        IStudentUnitRecord record = new StudentUnitRecordProxy(studentId, unitCode);
        records.add(record);
      }
    }
    
    // if record list contains records, add it to recordsByStudent map   
    if (records.size() > 0) {
      recordsByStudent_.put(studentId, records); 
    }
    return records;
  }

  
  
  public void saveRecord(IStudentUnitRecord record) {
    @SuppressWarnings("unchecked")
    List<Element> recordElements = (List<Element>) XmlFileManager.getInstance().getDocument().getRootElement()
                                    .getChild("studentUnitRecordTable")
                                    .getChildren("record");
    for (Element el : recordElements) {
      Integer studentId = record.getStudentId();
      String unitCode = record.getUnitCode();
      String sid = el.getAttributeValue("sid");
      String ucd = el.getAttributeValue("uid");
      
      if (studentId.toString().equals(sid) && unitCode.equals(ucd)) {
        String asg1MarkStr = new Float(record.getAsg1Mark()).toString();
        String asg2MarkStr = new Float(record.getAsg2Mark()).toString();
        String examMarkStr = new Float(record.getExamMark()).toString();
        
        el.setAttribute("asg1", asg1MarkStr);
        el.setAttribute("asg2", asg2MarkStr);
        el.setAttribute("exam", examMarkStr);

        // write out the XML file for continuous save
        XmlFileManager.getInstance().saveDocument(); 
        return;
      }
    }

    //only get to here if no records found
    throw new RuntimeException("DBMD: saveRecord : no such student record in data");
  }
}
