package guiPKG.screens;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import models.Course;
import models.Student;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentScreen implements ActionListener {

        // Variables declaration - do not modify
        private JTextField courseInField;
        private JButton enrollBtn;
        private JPanel enrollPanel;
        private JPanel enrollPanel1;
        private JButton genFeeBtn;
        private JButton progressBtn;
        private JLabel jLabel1;
        private JLabel jLabel2;
        private JLabel jLabel3;
        private JScrollPane jScrollPane1;
        private JTable genTable;
        private JButton signOutBtn;
        private JPanel stuMenu;
        private JPanel studentPanel;
        private JPanel titlePanel;
        // End of variables declaration
        private JFrame frame;

        private String idNumber;
        private DefaultTableModel tModel;
        private JButton addCourse;

        /**
         * Creates new form Student
         */
        public StudentScreen(JFrame frame, String id) {
                initializeComponents(frame, id);
                registerListeners();
                setWindowProperties();
        }

        private void registerListeners() {
                signOutBtn.addActionListener(this);
                enrollBtn.addActionListener(this);
                genFeeBtn.addActionListener(this);
                progressBtn.addActionListener(this);
                addCourse.addActionListener(this);
        }

        private void setWindowProperties() {
                frame.setTitle("HOME & AWAY INSTITUTE - STUDENT SCREEN");
                frame.getContentPane().add(studentPanel, BorderLayout.CENTER);
                // frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }

        // <editor-fold defaultstate="collapsed" desc="Generated Code">
        private void initializeComponents(JFrame frame, String IdN) {
                this.frame = frame;
                this.idNumber = IdN;
                studentPanel = new JPanel();
                jLabel3 = new JLabel();
                stuMenu = new JPanel();
                enrollBtn = new JButton();
                progressBtn = new JButton();
                signOutBtn = new JButton();
                addCourse = new JButton();
                jLabel2 = new JLabel();
                enrollPanel = new JPanel();
                jScrollPane1 = new JScrollPane();
                genTable = new JTable();
                enrollPanel1 = new JPanel();
                courseInField = new JTextField();
                genFeeBtn = new JButton();
                titlePanel = new JPanel();
                jLabel1 = new JLabel();

                studentPanel.setBackground(Color.gray);
                studentPanel.setLayout(new BorderLayout());

                jLabel3.setText("ProgramCode");
                studentPanel.add(jLabel3, BorderLayout.PAGE_END);

                stuMenu.setMaximumSize(new Dimension(250, 32767));

                enrollBtn.setBackground(Color.orange);
                enrollBtn.setFont(new Font("Arial", 1, 12)); // NOI18N
                enrollBtn.setText("Enroll");
                enrollBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
                enrollBtn.setMargin(new Insets(0, 0, 0, 0));
                enrollBtn.setMaximumSize(new Dimension(200, 30));
                enrollBtn.setPreferredSize(new Dimension(100, 23));

                progressBtn.setBackground(Color.orange);
                progressBtn.setFont(new Font("Arial", 1, 12)); // NOI18N
                progressBtn.setText("Generate Progress Report");
                progressBtn.setMaximumSize(new Dimension(200, 30));
                progressBtn.setPreferredSize(new Dimension(100, 23));

                signOutBtn.setBackground(Color.orange);
                signOutBtn.setText("SIGN OUT");
                signOutBtn.setMaximumSize(new Dimension(200, 30));
                signOutBtn.setPreferredSize(new Dimension(100, 23));

                addCourse.setBackground(Color.orange);
                addCourse.setText("ADD COURSE");
                addCourse.setMaximumSize(new Dimension(200, 30));
                addCourse.setPreferredSize(new Dimension(100, 23));

                jLabel2.setText(IdN);

                GroupLayout stuMenuLayout = new GroupLayout(stuMenu);
                stuMenu.setLayout(stuMenuLayout);
                stuMenuLayout.setHorizontalGroup(
                                stuMenuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(stuMenuLayout.createSequentialGroup()
                                                                .addGroup(stuMenuLayout.createParallelGroup(
                                                                                GroupLayout.Alignment.LEADING)
                                                                                .addGroup(stuMenuLayout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(100, 100, 100)
                                                                                                .addGroup(stuMenuLayout
                                                                                                                .createParallelGroup(
                                                                                                                                GroupLayout.Alignment.TRAILING)
                                                                                                                .addComponent(enrollBtn,
                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                150,
                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(signOutBtn,
                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                150,
                                                                                                                                GroupLayout.PREFERRED_SIZE)))
                                                                                .addGroup(stuMenuLayout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(45, 45, 45)
                                                                                                .addComponent(jLabel2,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                100,
                                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(stuMenuLayout
                                                                                                .createSequentialGroup()
                                                                                                .addContainerGap(80,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(progressBtn,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                190,
                                                                                                                GroupLayout.PREFERRED_SIZE)))
                                                                .addContainerGap(80, Short.MAX_VALUE)));
                stuMenuLayout.setVerticalGroup(
                                stuMenuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(stuMenuLayout.createSequentialGroup()
                                                                .addGap(45, 45, 45)
                                                                .addComponent(jLabel2)
                                                                .addGap(98, 98, 98)
                                                                .addComponent(enrollBtn, GroupLayout.PREFERRED_SIZE, 25,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addGap(126, 126, 126)
                                                                .addComponent(progressBtn, GroupLayout.PREFERRED_SIZE,
                                                                                25,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                                                                                161,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(signOutBtn, GroupLayout.PREFERRED_SIZE,
                                                                                25,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addGap(171, 171, 171)));

                studentPanel.add(stuMenu, BorderLayout.WEST);

                enrollPanel.setBackground(Color.gray);

                String[] defaultCols = { "CourseCode", "CourseName", "ProgCode", "CreditCost",
                                "# of Credits", "Cost", "Prequisite", "Desc" };

                tModel = new DefaultTableModel(defaultCols, 0) {
                };

                genTable = new JTable(tModel);
                genTable.setColumnSelectionAllowed(true);

                jScrollPane1 = new JScrollPane();
                jScrollPane1.setViewportView(genTable);
                genTable.getColumnModel().getSelectionModel()
                                .setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

                jScrollPane1.setViewportView(genTable);

                genFeeBtn.setBackground(Color.orange);
                genFeeBtn.setFont(new Font("Arial", 1, 12)); // NOI18N
                genFeeBtn.setText("Generate Fee Breakdown");
                genFeeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
                genFeeBtn.setMargin(new Insets(0, 0, 0, 0));
                genFeeBtn.setMaximumSize(new Dimension(200, 30));
                genFeeBtn.setPreferredSize(new Dimension(100, 23));

                GroupLayout enrollPanel1Layout = new GroupLayout(enrollPanel1);
                enrollPanel1.setLayout(enrollPanel1Layout);
                enrollPanel1Layout.setHorizontalGroup(
                                enrollPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(GroupLayout.Alignment.TRAILING, enrollPanel1Layout
                                                                .createSequentialGroup()
                                                                .addContainerGap(GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(courseInField, GroupLayout.PREFERRED_SIZE,
                                                                                150,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addGap(50, 50, 50)
                                                                .addComponent(addCourse, GroupLayout.PREFERRED_SIZE,
                                                                                150,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                .addGroup(GroupLayout.Alignment.TRAILING, enrollPanel1Layout
                                                                .createSequentialGroup()
                                                                .addContainerGap(GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(genFeeBtn, GroupLayout.PREFERRED_SIZE,
                                                                                150,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));
                enrollPanel1Layout.setVerticalGroup(
                                enrollPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(GroupLayout.Alignment.TRAILING, enrollPanel1Layout
                                                                .createSequentialGroup()
                                                                .addGap(21, 21, 21)
                                                                .addGroup(enrollPanel1Layout
                                                                                .createParallelGroup(
                                                                                                GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(addCourse,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                25,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(courseInField,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addComponent(genFeeBtn, GroupLayout.PREFERRED_SIZE, 25,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(12, Short.MAX_VALUE)));

                GroupLayout enrollPanelLayout = new GroupLayout(enrollPanel);
                enrollPanel.setLayout(enrollPanelLayout);
                enrollPanelLayout.setHorizontalGroup(
                                enrollPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(enrollPanelLayout.createSequentialGroup()
                                                                .addGap(50, 50, 50)
                                                                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE,
                                                                                473, Short.MAX_VALUE)
                                                                .addGap(50, 50, 50))
                                                .addGroup(enrollPanelLayout.createSequentialGroup()
                                                                .addContainerGap(GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(enrollPanel1, GroupLayout.DEFAULT_SIZE,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addContainerGap(GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));
                enrollPanelLayout.setVerticalGroup(
                                enrollPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(GroupLayout.Alignment.TRAILING, enrollPanelLayout
                                                                .createSequentialGroup()
                                                                .addGap(50, 50, 50)
                                                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addGap(114, 114, 114)
                                                                .addComponent(enrollPanel1, GroupLayout.DEFAULT_SIZE,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                studentPanel.add(enrollPanel, BorderLayout.CENTER);

                titlePanel.setLayout(new BorderLayout());

                jLabel1.setFont(new Font("Arial", 1, 48)); // NOI18N
                jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
                jLabel1.setText("STUDENT");
                jLabel1.setHorizontalTextPosition(SwingConstants.CENTER);
                titlePanel.add(jLabel1, BorderLayout.CENTER);

                studentPanel.add(titlePanel, BorderLayout.PAGE_START);

        }// </editor-fold>

        @Override
        public void actionPerformed(ActionEvent e) {
                String programmeCode = "";

                String filePathCourse = "";

                int max = 0;

                int count = 0;

                Student student = new Student();

                if (e.getSource().equals(addCourse)) {

                        student.addCourse(courseInField.getText().toUpperCase(), idNumber);

                }
                if (e.getSource().equals(enrollBtn)) {
                        while (tModel.getRowCount() > 0) {
                                tModel.removeRow(0);
                        }
                        student.studentEnrollment(idNumber);

                        programmeCode = student.getCode(idNumber);
                        System.out.println(programmeCode);

                        max = student.getMaxCourse(programmeCode);

                        System.out.println(max);

                        if (max == 4) {
                                filePathCourse = "src/Files/Certificate/" + programmeCode + "Course.txt";
                        } else if (max == 6) {
                                filePathCourse = "src/Files/Diploma/" + programmeCode + "Course.txt";
                        } else if (max == 8) {
                                filePathCourse = "src/Files/Associates/" + programmeCode + "Course.txt";
                        }
                        ArrayList<Course> courselist = new ArrayList<>();
                        try {

                                Scanner courseReader = new Scanner(new File(filePathCourse));

                                while (courseReader.hasNext()) {
                                        String courseFileCode = courseReader.next();

                                        String courseFileNme = courseReader.next();

                                        String progFileCode = courseReader.next();

                                        float costPerCreditFile = courseReader.nextFloat();

                                        int numCreditsFile = courseReader.nextInt();

                                        float courseCostFile = courseReader.nextFloat();

                                        String preRequisiteFile = courseReader.next();

                                        String descripFile = courseReader.next();

                                        Course course = new Course(courseFileCode, courseFileNme,
                                                        descripFile, numCreditsFile, preRequisiteFile,
                                                        costPerCreditFile, courseCostFile,
                                                        progFileCode);

                                        courselist.add(course);

                                }
                        } catch (FileNotFoundException ex) {

                        }
                        for (Course course : courselist) {
                                System.out.println(course);

                                tModel.insertRow(count, new Object[] {
                                                course.getCourseCode(),
                                                course.getName(),
                                                course.getProgrammeCode(),
                                                course.getCostPerCredit(),
                                                course.getNumCredits(),
                                                course.getCourseCost(),
                                                course.getPreRequisite(),
                                                course.getDescription()
                                });
                                count++;

                        }

                }

                if (e.getSource().equals(progressBtn)) {
                        while (tModel.getRowCount() > 0) {
                                tModel.removeRow(0);
                        }
                        ArrayList<Course> courselist = student.generateProgressReport(idNumber);
                        for (Course course : courselist) {
                                System.out.println(course);

                                tModel.insertRow(count, new Object[] {
                                                course.getCourseCode(),
                                                course.getName(),
                                                course.getProgrammeCode(),
                                                course.getCostPerCredit(),
                                                course.getNumCredits(),
                                                course.getCourseCost(),
                                                course.getPreRequisite(),
                                                course.getDescription()
                                });
                                count++;
                        }

                }
                if (e.getSource().equals(genFeeBtn)) {

                        while (tModel.getRowCount() > 0) {
                                tModel.removeRow(0);
                        }

                        Float cost = student.generateFeeBreakDown(idNumber);
                        String cosString = String.valueOf(cost);
                        String studentEnrollmentNm = "";
                        programmeCode = student.getCode(idNumber);
                        max = student.getMaxCourse(programmeCode);
                        count = 0;
                        courseInField.setText(cosString);
                        if (cost != 0) {
                                if (max == 4) {
                                        studentEnrollmentNm = "src/Files/Certificate/" + idNumber + "Enrollment.txt";
                                } else if (max == 6) {
                                        studentEnrollmentNm = "src/Files/Diploma/" + idNumber + "Enrollment.txt";
                                } else if (max == 8) {
                                        studentEnrollmentNm = "src/Files/Associates/" + idNumber + "Enrollment.txt";
                                }
                                ArrayList<Course> courselist = new ArrayList<>();
                                try {
                                        Scanner courseReader = new Scanner(new File(studentEnrollmentNm));

                                        while (courseReader.hasNext()) {
                                                String courseFileCode = courseReader.next();

                                                String courseFileNme = courseReader.next();

                                                String progFileCode = courseReader.next();

                                                float costPerCreditFile = courseReader.nextFloat();

                                                int numCreditsFile = courseReader.nextInt();

                                                float courseCostFile = courseReader.nextFloat();

                                                String preRequisiteFile = courseReader.next();

                                                String descripFile = courseReader.next();

                                                Course course = new Course(courseFileCode, courseFileNme,
                                                                descripFile, numCreditsFile, preRequisiteFile,
                                                                costPerCreditFile, courseCostFile,
                                                                progFileCode);

                                                courselist.add(course);

                                        }
                                } catch (FileNotFoundException ex) {
                                        JOptionPane.showMessageDialog(
                                                        null,
                                                        "File Could Not Be found ",
                                                        "File Not Found",
                                                        JOptionPane.ERROR_MESSAGE);
                                }
                                for (Course course : courselist) {
                                        System.out.println(course);

                                        tModel.insertRow(count, new Object[] {
                                                        course.getCourseCode(),
                                                        course.getName(),
                                                        course.getProgrammeCode(),
                                                        course.getCostPerCredit(),
                                                        course.getNumCredits(),
                                                        course.getCourseCost(),
                                                        course.getPreRequisite(),
                                                        course.getDescription()
                                        });
                                        count++;
                                }
                        }
                }
                if (e.getSource().equals(signOutBtn)) {
                        studentPanel.setVisible(false);
                        studentPanel.setVisible(false);
                        new LoginScreen(frame);
                }

        }
}

// </editor-fold>

//