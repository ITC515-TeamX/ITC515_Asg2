package datamanagement;

public class ListStudentsControl {

  private StudentManager studentManager_;


  
  public ListStudentsControl() {
    studentManager_ = StudentManager.getInstance();
  }


  
  public void listStudents(IStudentLister lister, String unitCode) {
    lister.clearStudents();
    
    StudentMap students = studentManager_.getStudentsByUnit(unitCode);    
    for (Integer studentId : students.keySet()) {
      IStudent student = students.get(studentId);
      lister.addStudent(student);
    }
  }
}
