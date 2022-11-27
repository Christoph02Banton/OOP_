package guiPKG.screens;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

import models.Course;
import models.Programme;
import models.Staff;

public class createCoursePanel extends JFrame implements ItemListener, WindowListener, ActionListener {

        // Variables declaration - do not modify
        private JRadioButton aRadio;
        private ButtonGroup bg;
        private JRadioButton cRadio;
        private JTextField costPerCredit;
        private JTextField courseName;
        private JLabel credCost;
        private JRadioButton dRadio;
        private JLabel desc;
        private JTextArea description;
        private JPanel jPanel1;
        private JScrollPane jScrollPane1;
        private JLabel name;
        private JLabel numCred;
        private JTextField numOfCredits;
        private JLabel prereq;
        private JTextField prerequisite;
        private JLabel progType;
        private JLabel title;
        private JPanel titlePanel;
        private Programme programme;
        private int proType;
        private boolean verify;
        private String awardString;

        // End of variables declaration
        private JButton createBtn;
        private int choice;

        public createCoursePanel(Programme programme, int protype, boolean verify, int choice) {
                initializeComponents(programme, proType, verify, choice);
                setWindowProperties();
                addComponents();
        }

        private void addComponents() {
                addWindowListener(this);
                setWindowProperties();
        }

        private void setWindowProperties() {
                // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                // setLayout(new BorderLayout());
                setTitle("Home & Away Institute");
                setBackground(Color.darkGray);
                setVisible(true);
                setSize(500, 500);
                setLocationRelativeTo(null);
        }

        private void initializeComponents(Programme programme, int proType, boolean verify, int choice) {

                this.programme = programme;
                this.proType = proType;
                this.verify = verify;
                this.choice = choice;

                bg = new ButtonGroup();
                titlePanel = new JPanel();
                title = new JLabel();
                jPanel1 = new JPanel();
                cRadio = new JRadioButton();
                dRadio = new JRadioButton();
                aRadio = new JRadioButton();
                progType = new JLabel();
                courseName = new JTextField();
                name = new JLabel();
                numOfCredits = new JTextField();
                numCred = new JLabel();
                credCost = new JLabel();
                costPerCredit = new JTextField();
                prereq = new JLabel();
                prerequisite = new JTextField();
                jScrollPane1 = new JScrollPane();
                description = new JTextArea();
                desc = new JLabel();

                setLayout(new BorderLayout());

                titlePanel.setBackground(Color.orange);
                titlePanel.setPreferredSize(new Dimension(206, 50));
                titlePanel.setLayout(new BorderLayout());

                title.setFont(new Font("Arial", 1, 24)); // NOI18N
                title.setHorizontalAlignment(SwingConstants.CENTER);
                title.setText("CREATE COURSE/MODIFY COURSE");
                title.setHorizontalTextPosition(SwingConstants.CENTER);
                titlePanel.add(title, BorderLayout.CENTER);

                add(titlePanel, BorderLayout.PAGE_START);

                jPanel1.setBackground(Color.gray);

                cRadio.setText("Certificate");
                cRadio.addItemListener(this);

                dRadio.setText("Diploma");
                dRadio.addItemListener(this);

                aRadio.setText("Associate");
                aRadio.addItemListener(this);

                bg = new ButtonGroup();
                bg.add(cRadio);
                bg.add(dRadio);
                bg.add(aRadio);

                createBtn = new JButton("Create Course");
                createBtn.setBackground(Color.orange);
                createBtn.setFont(new Font("Arial", 1, 12)); // NOI18N
                createBtn.setMaximumSize(new Dimension(100, 21));
                createBtn.setMinimumSize(new Dimension(100, 21));
                createBtn.setPreferredSize(new Dimension(100, 21));

                progType.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
                progType.setText("Select Program Type");

                courseName.setMaximumSize(new Dimension(120, 22));
                courseName.setMinimumSize(new Dimension(120, 22));

                name.setText("Course Name");

                numOfCredits.setMaximumSize(new Dimension(120, 22));
                numOfCredits.setMinimumSize(new Dimension(120, 22));

                numCred.setText("# of Credits");

                credCost.setText("Cost per Credit");

                costPerCredit.setMaximumSize(new Dimension(120, 22));
                costPerCredit.setMinimumSize(new Dimension(120, 22));

                prereq.setText("Prerequisite");

                prerequisite.setMaximumSize(new Dimension(120, 22));
                prerequisite.setMinimumSize(new Dimension(120, 22));

                description.setColumns(20);
                description.setRows(5);
                jScrollPane1.setViewportView(description);

                desc.setText("Description");

                GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addContainerGap(20, Short.MAX_VALUE)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(name)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(courseName,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                120,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(numCred)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(numOfCredits,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                120,
                                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(credCost)
                                                                                                                .addComponent(desc))
                                                                                                .addGap(12, 12, 12)
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                GroupLayout.Alignment.LEADING,
                                                                                                                                false)
                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addComponent(costPerCredit,
                                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                                120,
                                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addGap(18, 18, 18)
                                                                                                                                .addComponent(prereq)
                                                                                                                                .addGap(16, 16, 16)
                                                                                                                                .addComponent(prerequisite,
                                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                                120,
                                                                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                                                                .addComponent(jScrollPane1)))
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(124, 124, 124)
                                                                                                .addComponent(cRadio)
                                                                                                .addGap(10, 10, 10)
                                                                                                .addComponent(dRadio)
                                                                                                .addGap(10, 10, 10)
                                                                                                .addComponent(aRadio))
                                                                                .addComponent(progType))
                                                                .addContainerGap(89, Short.MAX_VALUE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout
                                                                .createSequentialGroup()
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(createBtn,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                150,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(100, Short.MAX_VALUE)));

                jPanel1Layout.linkSize(SwingConstants.HORIZONTAL,
                                new Component[] { aRadio, cRadio, dRadio });

                jPanel1Layout.linkSize(SwingConstants.HORIZONTAL, new Component[] { credCost, desc });

                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout
                                                                .createSequentialGroup()
                                                                .addGap(16, 16, 16)
                                                                .addComponent(progType)
                                                                .addGap(20, 20, 20)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(cRadio)
                                                                                .addComponent(dRadio)
                                                                                .addComponent(aRadio))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(name)
                                                                                .addComponent(courseName,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(numCred)
                                                                                .addComponent(numOfCredits,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                .addGap(20, 20, 20)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(credCost)
                                                                                .addComponent(costPerCredit,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(prereq)
                                                                                .addComponent(prerequisite,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                .addGap(20, 20, 20)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jScrollPane1,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(desc)

                                                                                .addComponent(createBtn,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addContainerGap(15, Short.MAX_VALUE)));

                add(jPanel1, BorderLayout.CENTER);
                setVisible(true);
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
                if (cRadio.isSelected()) {
                        proType = 1;
                        awardString = "Certificate";
                        // setProgType(proType);
                        // setAwardString(awardString);
                }

                if (dRadio.isSelected()) {
                        proType = 2;
                        awardString = "Diploma";
                        // setProgType(proType);
                        // setAwardString(awardString);
                }

                if (aRadio.isSelected()) {
                        proType = 3;
                        awardString = "Associates";
                        // setProgType(proType);
                        // setAwardString(awardString);
                }

        }

        @Override
        public void windowClosing(WindowEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "Would you like to continue?");
                Staff staff = new Staff();
                switch (result) {
                        case JOptionPane.YES_OPTION:
                               
                                if (choice == 1) {
                                        programme=staff.createProgramme(proType,
                                                        programme.getProgrammeName().replaceAll(" ", "_"),
                                                        programme.getAward(), programme.getAccreditation().replaceAll(" ", "_"),
                                                        courseName.getText().replaceAll(" ", "_"),
                                                        description.getText().replaceAll(" ", "_"),
                                                        Integer.parseInt(numOfCredits.getText()),
                                                        prerequisite.getText().replaceAll(" ","_"),
                                                        Float.parseFloat(costPerCredit.getText()), verify,programme);
                                        choice = 1;
                                } else {
                                        Course course = programme.getCourse();
                                        staff.modifyProgramme(proType, course.getCourseCode(),
                                                        programme.getProgrammeCode(),
                                                        courseName.getText().replaceAll(" ", "_"),
                                                        description.getText().replaceAll(" ", "_"), Integer.parseInt(numOfCredits.getText()),
                                                        prerequisite.getText(),
                                                        Float.parseFloat(costPerCredit.getText()));
                                        choice = 2;
                                        System.out.println(programme.getProgrammeCode());
                                }
                                dispose();
                                new createCoursePanel(programme, proType, false, choice);
                                break;
                        case JOptionPane.NO_OPTION:
                        if (choice == 1) {
                                staff.createProgramme(proType,
                                                programme.getProgrammeName().replaceAll(" ", "_"),
                                                programme.getAward(), programme.getAccreditation(),
                                                courseName.getText().replaceAll(" ", "_"),
                                                description.getText().replaceAll(" ", "_"),
                                                Integer.parseInt(numOfCredits.getText()),
                                                prerequisite.getText().replaceAll(" ","_"),
                                                Float.parseFloat(costPerCredit.getText()), verify,programme);
                                verify = false;
                                choice = 1;
                        } else {
                                Course course = programme.getCourse();
                                staff.modifyProgramme(proType, course.getCourseCode(),
                                                programme.getProgrammeCode(),
                                                courseName.getText().replaceAll(" ", "_"),
                                                description.getText(), Integer.parseInt(numOfCredits.getText()),
                                                prerequisite.getText(),
                                                Float.parseFloat(costPerCredit.getText()));
                                choice = 2;
                        }
                                break;
                        case JOptionPane.CANCEL_OPTION:
                                System.out.println("Cancel");
                                break;
                        case JOptionPane.CLOSED_OPTION:
                                System.out.println("Closed");
                                break;
                }

        }

        @Override
        public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

        }

        @Override
        public void windowOpened(WindowEvent e) {
                // TODO Auto-generated method stub

        }

        @Override
        public void windowClosed(WindowEvent e) {
                // TODO Auto-generated method stub

        }

        @Override
        public void windowIconified(WindowEvent e) {
                // TODO Auto-generated method stub

        }

        @Override
        public void windowDeiconified(WindowEvent e) {
                // TODO Auto-generated method stub

        }

        @Override
        public void windowActivated(WindowEvent e) {
                // TODO Auto-generated method stub

        }

        @Override
        public void windowDeactivated(WindowEvent e) {
                // TODO Auto-generated method stub

        }

        public void setProgType(int proType) {
                this.proType = proType;
        }

        public void setAwardString(String awardString) {
                this.awardString = awardString;
        }

}
