package datamanagement;

public class CheckGradeControl {

	private CheckGradeUi checkGradeUi_;
	private String currentUnitCode_ = null;
	private Integer currentStudentId_ = null;
	private boolean marksChanged_ = false;


	
	public CheckGradeControl() {
	}


	
	public void execute() {
		checkGradeUi_ = new CheckGradeUi(this);
		checkGradeUi_.enableUnitSelectable(false);

		checkGradeUi_.enableStudentSelectable(false);
		checkGradeUi_.enableCheckButton(false);
		checkGradeUi_.enableChangeButton(false);
		checkGradeUi_.enableMarkFieldsEditable(false);
		checkGradeUi_.enableSaveButton(false);
		checkGradeUi_.resetAllFields();

		ListUnitsCTL luCTL = new ListUnitsCTL();
		luCTL.listUnits(checkGradeUi_);
		checkGradeUi_.setVisible(true);
		checkGradeUi_.enableUnitSelectable(true);
	}


	
	public void unitSelected(String unitCode) {
		if (unitCode.equals("NONE")) {
			checkGradeUi_.enableStudentSelectable(false);
		}
		else {
			ListStudentsControl lsCTL = new ListStudentsControl();
			lsCTL.listStudents(checkGradeUi_, unitCode);
			currentUnitCode_ = unitCode;
			checkGradeUi_.enableStudentSelectable(true);
		}
		checkGradeUi_.enableCheckButton(false);
	}


	
	public void studentSelected(Integer studentId) {
		currentStudentId_ = studentId;
		if (currentStudentId_.intValue() == 0) {
			checkGradeUi_.resetAllFields();
			checkGradeUi_.enableCheckButton(false);
			checkGradeUi_.enableChangeButton(false);
			checkGradeUi_.enableMarkFieldsEditable(false);
			checkGradeUi_.enableSaveButton(false);
		}
		else {
			IStudent student = StudentManager.getInstance().getStudent(studentId);

			IStudentUnitRecord record = student.getUnitRecord(currentUnitCode_);

			checkGradeUi_.setRecord(record);
			checkGradeUi_.enableCheckButton(true);
			checkGradeUi_.enableChangeButton(true);
			checkGradeUi_.enableMarkFieldsEditable(false);
			checkGradeUi_.enableSaveButton(false);
			marksChanged_ = false;
		}
	}


	
	public String checkGrade(float asg1Mark, float asg2Mark, float examMark) {
		IUnit unit = UnitManager.getInstance().getUnit(currentUnitCode_);
		String grade = unit.getGrade(asg1Mark, asg2Mark, examMark);
		checkGradeUi_.enableChangeButton(true);
		checkGradeUi_.enableMarkFieldsEditable(false);
		if (marksChanged_) {
			checkGradeUi_.enableSaveButton(true);
		}
		return grade;
	}


	
	public void enableChangeMarks() {
		checkGradeUi_.enableChangeButton(false);
		checkGradeUi_.enableSaveButton(false);
		checkGradeUi_.enableMarkFieldsEditable(true);
		marksChanged_ = true;
	}


	
	public void saveGrade(float asg1, float asg2, float exam) {
		IStudent student = StudentManager.getInstance().getStudent(currentStudentId_);

		IStudentUnitRecord record = student.getUnitRecord(currentUnitCode_);
		record.setAsg1Mark(asg1);
		record.setAsg2Mark(asg2);
		record.setExamMark(exam);
		StudentUnitRecordManager.getInstance().saveRecord(record);
		checkGradeUi_.enableChangeButton(true);
		checkGradeUi_.enableMarkFieldsEditable(false);
		checkGradeUi_.enableSaveButton(false);
	}
}
