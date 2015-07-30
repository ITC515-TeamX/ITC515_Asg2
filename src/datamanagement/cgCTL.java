package datamanagement;

public class cgCTL {

	CheckGradeUi CGUI;
	String cuc = null;
	Integer currentStudentID = null;
	boolean changed = false;

	public cgCTL() {
	}

	public void execute() {
		CGUI = new CheckGradeUi(this);
		CGUI.enableUnitSelectable(false);

		CGUI.enableStudentSelectable(false);
		CGUI.enableCheckButton(false);
		CGUI.enableChangeButton(false);
		CGUI.enableMarkFieldsEditable(false);
		CGUI.enableSaveButton(false);
		CGUI.resetAllFields();

		ListUnitsCTL luCTL = new ListUnitsCTL();
		luCTL.listUnits(CGUI);
		CGUI.setVisible(true);
		CGUI.enableUnitSelectable(true);
	}

	public void unitSelected(String code) {

		if (code.equals("NONE"))
			CGUI.enableStudentSelectable(false);
		else {
			ListStudentsCTL lsCTL = new ListStudentsCTL();
			lsCTL.listStudents(CGUI, code);
			cuc = code;
			CGUI.enableStudentSelectable(true);
		}
		CGUI.enableCheckButton(false);
	}

	public void studentSelected(Integer id) {
		currentStudentID = id;
		if (currentStudentID.intValue() == 0) {
			CGUI.resetAllFields();
			CGUI.enableCheckButton(false);
			CGUI.enableChangeButton(false);
			CGUI.enableMarkFieldsEditable(false);
			CGUI.enableSaveButton(false);
		}

		else {
			IStudent s = StudentManager.get().getStudent(id);

			IStudentUnitRecord r = s.getUnitRecord(cuc);

			CGUI.setRecord(r);
			CGUI.enableCheckButton(true);
			CGUI.enableChangeButton(true);
			CGUI.enableMarkFieldsEditable(false);
			CGUI.enableSaveButton(false);
			changed = false;

		}
	}

	public String checkGrade(float f, float g, float h) {
		IUnit u = UnitManager.getInstance().getUnit(cuc);
		String s = u.getGrade(f, g, h);
		CGUI.enableChangeButton(true);
		CGUI.enableMarkFieldsEditable(false);
		if (changed) {
			CGUI.enableSaveButton(true);
		}
		return s;
	}

	public void enableChangeMarks() {
		CGUI.enableChangeButton(false);
		CGUI.enableSaveButton(false);
		CGUI.enableMarkFieldsEditable(true);
		changed = true;
	}

	public void saveGrade(float asg1, float asg2, float exam) {

		IUnit u = UnitManager.getInstance().getUnit(cuc);
		IStudent s = StudentManager.get().getStudent(currentStudentID);

		IStudentUnitRecord r = s.getUnitRecord(cuc);
		r.setAsg1Mark(asg1);
		r.setAsg2Mark(asg2);
		r.setExamMark(exam);
		StudentUnitRecordManager.getInstance().saveRecord(r);
		CGUI.enableChangeButton(true);
		CGUI.enableMarkFieldsEditable(false);
		CGUI.enableSaveButton(false);
	}
}
