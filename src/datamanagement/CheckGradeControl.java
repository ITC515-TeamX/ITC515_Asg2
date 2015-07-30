package datamanagement;

public class CheckGradeControl {

	private cgUI checkGradeUi_;
	private String currentUnitCode_ = null;
	private Integer currentStudentId_ = null;
	private boolean marksChanged_ = false;


	
	public CheckGradeControl() {
	}


	
	public void execute() {
		checkGradeUi_ = new cgUI(this);
		checkGradeUi_.setState1(false);

		checkGradeUi_.setState2(false);
		checkGradeUi_.setState3(false);
		checkGradeUi_.setState4(false);
		checkGradeUi_.setState5(false);
		checkGradeUi_.setState6(false);
		checkGradeUi_.Refresh3();

		ListUnitsCTL luCTL = new ListUnitsCTL();
		luCTL.listUnits(checkGradeUi_);
		checkGradeUi_.setVisible(true);
		checkGradeUi_.setState1(true);
	}


	
	public void unitSelected(String unitCode) {
		if (unitCode.equals("NONE"))
			checkGradeUi_.setState2(false);
		else {
			ListStudentsCTL lsCTL = new ListStudentsCTL();
			lsCTL.listStudents(checkGradeUi_, unitCode);
			currentUnitCode_ = unitCode;
			checkGradeUi_.setState2(true);
		}
		checkGradeUi_.setState3(false);
	}


	
	public void studentSelected(Integer studentId) {
		currentStudentId_ = studentId;
		if (currentStudentId_.intValue() == 0) {
			checkGradeUi_.Refresh3();
			checkGradeUi_.setState3(false);
			checkGradeUi_.setState4(false);
			checkGradeUi_.setState5(false);
			checkGradeUi_.setState6(false);
		}

		else {
			IStudent student = StudentManager.getInstance().getStudent(studentId);

			IStudentUnitRecord record = student.getUnitRecord(currentUnitCode_);

			checkGradeUi_.setRecord(record);
			checkGradeUi_.setState3(true);
			checkGradeUi_.setState4(true);
			checkGradeUi_.setState5(false);
			checkGradeUi_.setState6(false);
			marksChanged_ = false;

		}
	}

	public String checkGrade(float asg1Mark, float asg2Mark, float examMark) {
		IUnit unit = UnitManager.getInstance().getUnit(currentUnitCode_);
		String grade = unit.getGrade(asg1Mark, asg2Mark, examMark);
		checkGradeUi_.setState4(true);
		checkGradeUi_.setState5(false);
		if (marksChanged_) {
			checkGradeUi_.setState6(true);
		}
		return grade;
	}

	public void enableChangeMarks() {
		checkGradeUi_.setState4(false);
		checkGradeUi_.setState6(false);
		checkGradeUi_.setState5(true);
		marksChanged_ = true;
	}

	public void saveGrade(float asg1, float asg2, float exam) {
		IStudent student = StudentManager.getInstance().getStudent(currentStudentId_);

		IStudentUnitRecord record = student.getUnitRecord(currentUnitCode_);
		record.setAsg1(asg1);
		record.setAsg2(asg2);
		record.setExam(exam);
		StudentUnitRecordManager.instance().saveRecord(record);
		checkGradeUi_.setState4(true);
		checkGradeUi_.setState5(false);
		checkGradeUi_.setState6(false);
	}
}
