package datamanagement;

import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Color;

public class CheckGradeUi extends javax.swing.JFrame implements IUnitLister, IStudentLister {

  private static final long serialVersionUID = -5838201041812945722L;
  private CheckGradeControl checkGradeControl_;
  private javax.swing.DefaultComboBoxModel<String> unitModel_;
  private javax.swing.DefaultComboBoxModel<String> studentModel_;
  private float asg1Mark_;
  private float asg2Mark_;
  private float examMark_;
  private Integer studentId_;


  public CheckGradeUi(CheckGradeControl ctl) {
    this.checkGradeControl_ = ctl;
    unitModel_ = new javax.swing.DefaultComboBoxModel<String>(new String[0]);
    studentModel_ = new javax.swing.DefaultComboBoxModel<String>(new String[0]);
    initComponents();
    unitSelectionComboBox_.setModel(unitModel_);
    studentSelectionComboBox_.setModel(studentModel_);
    errorMsgLabel_.setText("");
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  // <editor-fold defaultstate="collapsed"
  // desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    javax.swing.JLabel titleLabel = new javax.swing.JLabel();
    javax.swing.JPanel unitPanel = new javax.swing.JPanel();
    unitSelectionComboBox_ = new javax.swing.JComboBox<String>();
    javax.swing.JPanel studentPanel = new javax.swing.JPanel();
    studentSelectionComboBox_ = new javax.swing.JComboBox<String>();
    javax.swing.JPanel markPanel = new javax.swing.JPanel();
    javax.swing.JLabel asg1Label = new javax.swing.JLabel();
    javax.swing.JLabel asg2Label = new javax.swing.JLabel();
    javax.swing.JLabel examLabel = new javax.swing.JLabel();
    asg1MarkField_ = new javax.swing.JTextField();
    asg2MarkField_ = new javax.swing.JTextField();
    examMarkField_ = new javax.swing.JTextField();
    changeButton_ = new javax.swing.JButton();
    javax.swing.JPanel gradePanel = new javax.swing.JPanel();
    gradeTextField_ = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    titleLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
    titleLabel.setText("Check Grade UI");

    unitPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Unit"));

    unitSelectionComboBox_.setModel(unitModel_);
    unitSelectionComboBox_.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(java.awt.event.ItemEvent evt) {
        unitSelectionBoxItemStateChanged(evt);
      }
    });

    javax.swing.GroupLayout gl_unitPanel = new javax.swing.GroupLayout(unitPanel);
    unitPanel.setLayout(gl_unitPanel);
    gl_unitPanel.setHorizontalGroup(gl_unitPanel.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(gl_unitPanel.createSequentialGroup().addContainerGap()
            .addComponent(unitSelectionComboBox_, javax.swing.GroupLayout.PREFERRED_SIZE, 185,
                javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
    gl_unitPanel.setVerticalGroup(gl_unitPanel.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(gl_unitPanel.createSequentialGroup()
            .addComponent(unitSelectionComboBox_, javax.swing.GroupLayout.PREFERRED_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

    studentPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Student"));

    studentSelectionComboBox_.setModel(studentModel_);
    studentSelectionComboBox_.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(java.awt.event.ItemEvent evt) {
        studentSelectionBoxItemStateChanged(evt);
      }
    });

    javax.swing.GroupLayout gl_studentPanel = new javax.swing.GroupLayout(studentPanel);
    studentPanel.setLayout(gl_studentPanel);
    gl_studentPanel.setHorizontalGroup(gl_studentPanel.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(gl_studentPanel.createSequentialGroup().addContainerGap()
            .addComponent(studentSelectionComboBox_, javax.swing.GroupLayout.PREFERRED_SIZE, 185,
                javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
    gl_studentPanel.setVerticalGroup(gl_studentPanel.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(gl_studentPanel.createSequentialGroup()
            .addComponent(studentSelectionComboBox_, javax.swing.GroupLayout.PREFERRED_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

    markPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Marks"));

    asg1Label.setText("Asg1:");

    asg2Label.setText("Asg2:");

    examLabel.setText("Exam:");

    asg1MarkField_.setEditable(false);
    asg1MarkField_.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(java.awt.event.KeyEvent evt) {
        markFieldKeyTyped(evt);
      }
    });

    asg2MarkField_.setEditable(false);
    asg2MarkField_.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(java.awt.event.KeyEvent evt) {
        markFieldKeyTyped(evt);
      }
    });

    examMarkField_.setEditable(false);
    examMarkField_.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(java.awt.event.KeyEvent evt) {
        markFieldKeyTyped(evt);
      }
    });

    changeButton_.setText("Change");
    changeButton_.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        changeButtonActionPerformed(evt);
      }
    });
    checkGradeButton_ = new javax.swing.JButton();
    checkGradeButton_.setText("Check Grade");
    //checkGradeButton_.setActionCommand("checkGrade");
    checkGradeButton_.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        checkGradeButtonActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout gl_markPanel = new javax.swing.GroupLayout(markPanel);
    gl_markPanel
        .setHorizontalGroup(
            gl_markPanel
                .createParallelGroup(
                    Alignment.LEADING)
                .addGroup(
                    gl_markPanel.createSequentialGroup()
                        .addGroup(gl_markPanel.createParallelGroup(Alignment.LEADING)
                            .addGroup(gl_markPanel.createSequentialGroup().addContainerGap().addComponent(asg1Label)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(asg1MarkField_, GroupLayout.PREFERRED_SIZE, 59,
                                    GroupLayout.PREFERRED_SIZE)
                                .addGap(18).addComponent(asg2Label))
                    .addGroup(gl_markPanel.createSequentialGroup().addGap(85).addComponent(changeButton_,
                        GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))).addGap(18).addGroup(
                            gl_markPanel.createParallelGroup(Alignment.TRAILING)
                                .addGroup(gl_markPanel.createSequentialGroup()
                                    .addComponent(asg2MarkField_, GroupLayout.PREFERRED_SIZE, 59,
                                        GroupLayout.PREFERRED_SIZE)
                                    .addGap(18).addComponent(examLabel))
                                .addComponent(checkGradeButton_))
                        .addGap(18)
                        .addComponent(examMarkField_, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                        .addGap(15)));
    gl_markPanel.setVerticalGroup(gl_markPanel.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_markPanel.createSequentialGroup()
            .addGroup(gl_markPanel.createParallelGroup(Alignment.BASELINE).addComponent(asg1Label)
                .addComponent(asg1MarkField_, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                    GroupLayout.PREFERRED_SIZE)
            .addComponent(asg2Label)
            .addComponent(asg2MarkField_, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                GroupLayout.PREFERRED_SIZE).addComponent(examLabel).addComponent(examMarkField_,
                    GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(ComponentPlacement.UNRELATED).addGroup(gl_markPanel.createParallelGroup(Alignment.BASELINE)
            .addComponent(changeButton_).addComponent(checkGradeButton_)).addContainerGap()));
    markPanel.setLayout(gl_markPanel);

    gradePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Grade"));

    gradeTextField_.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
    gradeTextField_.setForeground(new java.awt.Color(255, 0, 0));
    gradeTextField_.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    gradeTextField_.setText("grade");

    javax.swing.GroupLayout gl_gradePanel = new javax.swing.GroupLayout(gradePanel);
    gradePanel.setLayout(gl_gradePanel);
    gl_gradePanel.setHorizontalGroup(
        gl_gradePanel.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(gradeTextField_,
            javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE));
    gl_gradePanel.setVerticalGroup(gl_gradePanel.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(gl_gradePanel.createSequentialGroup().addGap(34, 34, 34).addComponent(gradeTextField_)
            .addContainerGap(43, Short.MAX_VALUE)));

    errorMsgLabel_ = new JLabel();
    errorMsgLabel_.setText("Error message");
    errorMsgLabel_.setForeground(Color.RED);
    errorMsgLabel_.setFont(new Font("Tahoma", Font.PLAIN, 12));
    saveGradeButton_ = new javax.swing.JButton();

    saveGradeButton_.setText("Save");
    saveGradeButton_.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        saveButtonActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap().addComponent(errorMsgLabel_,
                    GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup().addContainerGap()
                .addGroup(layout.createParallelGroup(Alignment.LEADING, false)
                    .addComponent(markPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(Alignment.LEADING)
                            .addComponent(unitPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                            .addComponent(studentPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE))
                        .addGap(18).addComponent(gradePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                            GroupLayout.PREFERRED_SIZE))))
            .addGroup(layout.createSequentialGroup().addGap(157).addComponent(titleLabel))
            .addGroup(layout.createSequentialGroup().addGap(165).addComponent(saveGradeButton_,
                GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)))
            .addContainerGap()));
    layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
        .addContainerGap().addComponent(titleLabel).addGap(13)
        .addGroup(layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(unitPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                    GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.RELATED).addComponent(studentPanel, GroupLayout.PREFERRED_SIZE,
                    GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addComponent(gradePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(markPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(ComponentPlacement.RELATED).addComponent(saveGradeButton_).addGap(11)
        .addComponent(errorMsgLabel_, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE).addContainerGap()));
    getContentPane().setLayout(layout);

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void unitSelectionBoxItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_jComboBox1ItemStateChanged
    String currentUnit = (String) unitSelectionComboBox_.getSelectedItem();
    resetAllFields();
    clearStudents();
    if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
      if (currentUnit.equals(unitSelectionComboBox_.getItemAt(0))) {
        currentUnit = "NONE";
      }
      checkGradeControl_.unitSelected(currentUnit);
    }
  }// GEN-LAST:event_jComboBox1ItemStateChanged

  private void studentSelectionBoxItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_jComboBox2ItemStateChanged
    resetAllFields();
    String currentStudent = (String) studentSelectionComboBox_.getSelectedItem();
    if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
      if (currentStudent.equals(studentSelectionComboBox_.getItemAt(0))) {
        studentId_ = new Integer(0);
        checkGradeControl_.studentSelected(studentId_);
      } else {
        studentId_ = new Integer(currentStudent.split("\\s")[0]);
      }
      checkGradeControl_.studentSelected(studentId_);
    }
  }// GEN-LAST:event_jComboBox2ItemStateChanged

  private void checkGradeButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton3ActionPerformed
    asg1Mark_ = new Float(asg1MarkField_.getText()).floatValue();
    asg2Mark_ = new Float(asg2MarkField_.getText()).floatValue();
    examMark_ = new Float(examMarkField_.getText()).floatValue();
    // lblErrMsg.setText("");
    try {
      String s = checkGradeControl_.checkGrade(asg1Mark_, asg2Mark_, examMark_);
      gradeTextField_.setText(s);
    } catch (RuntimeException re) {
      errorMsgLabel_.setText(re.getMessage());
    }
  }// GEN-LAST:event_jButton3ActionPerformed

  private void changeButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
    checkGradeControl_.enableChangeMarks();
    gradeTextField_.setText("");
    // lblErrMsg.setText("");
  }// GEN-LAST:event_jButton1ActionPerformed

  private void markFieldKeyTyped(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jTextField1KeyTyped
    gradeTextField_.setText("");
    errorMsgLabel_.setText("");
  }// GEN-LAST:event_jTextField1KeyTyped

  private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
    float asg1Mark = new Float(asg1MarkField_.getText()).floatValue();
    float asg2Mark = new Float(asg2MarkField_.getText()).floatValue();
    float examMark = new Float(examMarkField_.getText()).floatValue();
    errorMsgLabel_.setText("");
    
    try {
      checkGradeControl_.saveGrade(asg1Mark, asg2Mark, examMark);
    } 
    catch (RuntimeException re) {
      errorMsgLabel_.setText(re.getMessage());
    }
  }// GEN-LAST:event_jButton2ActionPerformed

  public void clearUnits() {
    unitModel_.removeAllElements();
    unitModel_.addElement("<none selected>");
    clearStudents();
  }

  public void addUnit(IUnit u) {
    unitModel_.addElement(u.getUnitCode());
  }

  public void enableUnitSelectable(boolean b) {
    unitSelectionComboBox_.setEnabled(b);
    errorMsgLabel_.setText("");
  }

  public void clearStudents() {
    studentModel_.removeAllElements();
    studentModel_.addElement("<none selected>");
  }

  public void addStudent(IStudent student) {
    studentModel_.addElement(student.getId().toString() + " : " + student.getFirstName() + " " + student.getLastName());
  }

  public void enableStudentSelectable(boolean b) {
    studentSelectionComboBox_.setEnabled(b);
    errorMsgLabel_.setText("");
  }

  public void setRecord(IStudentUnitRecord record) {
    asg1MarkField_.setText(new Float(record.getAsg1Mark()).toString());
    asg2MarkField_.setText(new Float(record.getAsg2Mark()).toString());
    examMarkField_.setText(new Float(record.getExamMark()).toString());
    gradeTextField_.setText("");
  }

  public void resetAllFields() {
    asg1MarkField_.setText("");
    asg2MarkField_.setText("");
    examMarkField_.setText("");
    gradeTextField_.setText("");
    errorMsgLabel_.setText("");
    asg1MarkField_.setEditable(false);
    asg2MarkField_.setEditable(false);
    examMarkField_.setEditable(false);
  }

  public void enableCheckButton(boolean b) {
    checkGradeButton_.setEnabled(b);
  }

  public void enableChangeButton(boolean b) {
    changeButton_.setEnabled(b);
    // gradeLB.setText("");
  }

  public void enableMarkFieldsEditable(boolean b) {
    asg1MarkField_.setEditable(b);
    asg2MarkField_.setEditable(b);
    examMarkField_.setEditable(b);
  }

  public void enableSaveButton(boolean b) {
    saveGradeButton_.setEnabled(b);
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton changeButton_;
  private javax.swing.JButton checkGradeButton_;
  private javax.swing.JButton saveGradeButton_;
  private javax.swing.JComboBox<String> unitSelectionComboBox_;
  private javax.swing.JComboBox<String> studentSelectionComboBox_;
  private javax.swing.JLabel gradeTextField_;
  private javax.swing.JLabel errorMsgLabel_;
  private javax.swing.JTextField asg1MarkField_;
  private javax.swing.JTextField asg2MarkField_;
  private javax.swing.JTextField examMarkField_;
}
