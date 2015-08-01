package datamanagement;

import org.jdom.*;
import java.util.List;



public class StudentManager {

  private static StudentManager self = null;
  private StudentMap students_;
  private java.util.HashMap<String, StudentMap> units_;


  
  public static StudentManager getInstance() {
    if (self == null){
      self = new StudentManager();
    }
    return self;
  }


  
  private StudentManager() {
    students_ = new StudentMap();
    units_ = new java.util.HashMap<>();
  }


  
  public IStudent getStudent(Integer id) {
    IStudent is = students_.get(id);
    if (is == null ) {
    	is = createStudent(id);
    }
    return is;
  }


  
  private Element getStudentElement(Integer studentId) {    
    @SuppressWarnings("unchecked")
    List<Element> studentElements = (List<Element>) XmlFileManager.getInstance().getDocument()
                                     .getRootElement().getChild("studentTable")
                                     .getChildren("student");
    for (Element el : studentElements) {
      String sid = el.getAttributeValue("sid");
      if (studentId.toString().equals(sid)) {
        return el;
      }
    }
    return null;
  }


  
  private IStudent createStudent(Integer id) {
    Element el = getStudentElement(id);
    if (el != null) {
      StudentUnitRecordList rlist = StudentUnitRecordManager.instance().getRecordsByStudent(id);
      String fName = el.getAttributeValue("fname");
      String lName = el.getAttributeValue("lname");
      
      IStudent is = new Student(id, fName, lName, rlist);

      students_.put(is.getId(), is);
      return is;
    }
    throw new RuntimeException("DBMD: createStudent : student not in database");
  }


  
  private IStudent createStudentProxy(Integer id) {
    Element el = getStudentElement(id);
    if (el != null) {
      String fName = el.getAttributeValue("fname");
      String lName = el.getAttributeValue("lname");
      IStudent sp = new StudentProxy(id, fName, lName);
      return sp;
    }
    throw new RuntimeException("DBMD: createStudent : student not in file");
  }


  
  public StudentMap getStudentsByUnit(String unitCode) {
    StudentMap students = units_.get(unitCode);
    if (students != null) {
      return students;
    }
    students = new StudentMap();
    IStudent is;
    StudentUnitRecordList unitRecords = StudentUnitRecordManager.instance().getRecordsByUnit(unitCode);
    for (IStudentUnitRecord studentRecord : unitRecords) {
      Integer studentId = new Integer(studentRecord.getStudentID());
      is = createStudentProxy(studentId);
      students.put(is.getId(), is);
    }
    units_.put(unitCode, students);
    return students;
  }
  
  
}

