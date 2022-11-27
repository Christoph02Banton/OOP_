// Author/Name: Chase Walfall
// ID Number: 2102044
// Module: Object Oriented Programming
// Date: November 7, 2022
// Description: 
package guiPKG.screens;

// Import Files
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import models.Course;
import models.Programme;
import models.Staff;

public class StaffScreen implements ActionListener, ItemListener { // Initialzing Staff Screen Class
        private JFrame frame;
        static JPanel regActionPanel, mainPanel;
        private JLabel appTitle;
        private JTextField fnField, lnField;
        private JLabel fnLabel;
        private JButton registerBtn, progBtn, listBtn;
        int count = 0;
        private JLabel panTitle, streetLabel, zipLabel, parishLabel, dEnrollLabel, progCodeLabel;

        // Attribute Declaration for Staff, Student and Program
        private JLabel contactLabel;
        private JPanel actionMenu;
        private JTextField streetField, zipField, parishField, dEnrollField, progCodeField, contactField;
        private JLabel lnLabel;
        private JPanel menuPanel;
        private JPanel regPanel;
        private JPanel topPanel;
        private GroupLayout regPanelLayout;
        private JButton signOutBtn;
        private JButton registerStudent;

        private JTextField acreddField;
        private JLabel acreddLabel;
        private JPanel createActionPanel;
        private JButton submitProgBtn;
        // private JRadioButton associateRadio;
        // private JRadioButton certRadio;
        private JPanel createPanel;
        // private JRadioButton diplomaRadio;
        // private JLabel jLabel1;
        private JLabel jLabel5;
        private JLabel jLabel6;
        private JLabel progDetialsLabel;
        private JTextField progNameField;
        private JLabel progNameLabel;

        // Variables declaration for programme modifications
        private JPanel coursePanel, modCoursePanel, titlePanel;
        private JScrollPane courseScPane, progScPane;
        private JTable courseTable, progTable;
        private JComboBox<String> jComboBox1;
        private JLabel courseAvLabel, progTypeLabel, progAvLabel, title, pCode;
        // End of variables declaration

        private JButton addCoursesBtn;
        private JLabel pCodeInLabel;
        private JLabel cCodeINLabel;
        private JButton submitPrBtn;
        private JTextField cCodeINField;
        private JTextField pCodeINField;
        private JButton modCourseBtn;
        private int progType1 = 0;
        private String awardString = "null";
        private ButtonGroup bg, bg1, bg2;

        private JRadioButton certRadio, diplomaRadio, associateRadio;
        private JRadioButton certRadio1, diplomaRadio1, associateRadio1;
        private JRadioButton certRadio2, diplomaRadio2, associateRadio2;
        private JButton deleteBtn;
        private JButton editBtn;
        private JLabel jLabel1, courseAv;
        private JScrollPane jScrollPane1;
        private JTable modTable;

        private DefaultTableModel tModel;
        private String[] defaultCols;
        private JButton createCourseBtn;

        public StaffScreen(JFrame frame) {
                initializeComponents(frame);
                addComponents();
                registerListeners();
                setWindowProperties();
        }

        private void registerListeners() {
                signOutBtn.addActionListener(this);
                registerBtn.addActionListener(this);
                progBtn.addActionListener(this);
                modCourseBtn.addActionListener(this);
                registerStudent.addActionListener(this);
                submitProgBtn.addActionListener(this);
                listBtn.addActionListener(this);
                addCoursesBtn.addActionListener(this);
                associateRadio.addItemListener(this);
                certRadio.addItemListener(this);
                diplomaRadio.addItemListener(this);
                associateRadio1.addItemListener(this);
                certRadio1.addItemListener(this);
                diplomaRadio1.addItemListener(this);
                associateRadio2.addItemListener(this);
                certRadio2.addItemListener(this);
                diplomaRadio2.addItemListener(this);
                createCourseBtn.addActionListener(this);
                deleteBtn.addActionListener(this);
                editBtn.addActionListener(this);
        }

        private void addComponents() {
                mainPanel.add(topPanel, BorderLayout.PAGE_START);
                mainPanel.add(actionMenu, BorderLayout.WEST);
                topPanel.add(appTitle, BorderLayout.CENTER);
                topPanel.add(menuPanel, BorderLayout.PAGE_END);
                regActionPanel.add(panTitle, BorderLayout.NORTH);
                regActionPanel.add(regPanel, BorderLayout.CENTER);
                createActionPanel.add(titlePanel, BorderLayout.PAGE_START);
                titlePanel.add(jLabel1, BorderLayout.CENTER);

                bg.add(associateRadio);
                bg.add(certRadio);
                bg.add(diplomaRadio);

                bg1.add(associateRadio1);
                bg1.add(certRadio1);
                bg1.add(diplomaRadio1);

                bg2.add(associateRadio2);
                bg2.add(certRadio2);
                bg2.add(diplomaRadio2);
        }

        // Setting Frame Heading for Staff Screen
        private void setWindowProperties() {
                frame.setTitle("HOME & AWAY INSTITUTE - STAFF SCREEN");
                frame.pack();
                frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
                frame.setVisible(true);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }

        // Intializing the Components for the frame
        private void initializeComponents(JFrame frame) {
                this.frame = frame;
                mainPanel = new JPanel();
                mainPanel.setLayout(new BorderLayout());

                topPanel = new JPanel();
                topPanel.setBackground(Color.orange);
                topPanel.setPreferredSize(new Dimension(1000, 150));
                topPanel.setLayout(new BorderLayout());

                appTitle = new JLabel("HOME & AWAY INSTITUTE"); // Setting frame heading along with font size and colour
                appTitle.setFont(new Font("Arial Black", 1, 48)); // NOI18N
                appTitle.setForeground(Color.darkGray);
                appTitle.setHorizontalAlignment(SwingConstants.CENTER);

                // Setting Menu Panel Size along with Background colour
                menuPanel = new JPanel();
                menuPanel.setBackground(Color.orange);
                menuPanel.setPreferredSize(new Dimension(800, 50));
                menuPanel.setLayout(new BorderLayout());

                // Setting Action Panel Size along with Background colour
                regActionPanel = new JPanel();
                regActionPanel.setBackground(Color.gray);
                regActionPanel.setLayout(new BorderLayout());
                regActionPanel.setVisible(false);

                actionMenu = new JPanel();
                actionMenu.setMaximumSize(new Dimension(550, 32767));
                actionMenu.setPreferredSize(new Dimension(400, 400));

                // Setting register student button along with Background colour, frame size and
                // other details
                registerBtn = new JButton("Register Student");
                registerBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
                registerBtn.setBackground(Color.orange);
                registerBtn.setMargin(new Insets(0, 0, 0, 0));
                registerBtn.setMaximumSize(new Dimension(200, 30));
                registerBtn.setPreferredSize(new Dimension(100, 23));

                // Setting create programme button along with Background colour, frame size and
                // other details
                progBtn = new JButton("Create Programme");
                progBtn.setBackground(Color.orange);
                progBtn.setMaximumSize(new Dimension(200, 30));
                progBtn.setPreferredSize(new Dimension(100, 23));

                modCourseBtn = new JButton("Modify Programme");
                modCourseBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
                modCourseBtn.setBackground(Color.orange);
                modCourseBtn.setMargin(new Insets(0, 0, 0, 0));
                modCourseBtn.setMaximumSize(new Dimension(200, 30));
                modCourseBtn.setPreferredSize(new Dimension(100, 23));

                // Setting generate list button along with Background colour and frame size
                listBtn = new JButton("Generate Lists");
                listBtn.setBackground(Color.orange);
                listBtn.setMaximumSize(new Dimension(200, 30));
                listBtn.setPreferredSize(new Dimension(100, 23));

                // Setting sign out button along with Background colour and frame size
                signOutBtn = new JButton("SIGN OUT");
                signOutBtn.setBackground(Color.orange);
                signOutBtn.setMaximumSize(new Dimension(200, 30));
                signOutBtn.setPreferredSize(new Dimension(100, 23));

                // Setting submit register student button along with Background colour, frame,
                // size and other details
                registerStudent = new JButton("Register Student");
                registerStudent.setBackground(Color.orange);
                registerStudent.setFont(new Font("Arial", 1, 12)); // NOI18N
                registerStudent.setCursor(new Cursor(Cursor.HAND_CURSOR));
                registerStudent.setMaximumSize(new Dimension(200, 30));
                registerStudent.setPreferredSize(new Dimension(100, 23));

                // Setting panel title
                panTitle = new JLabel("REGISTER STUDENTS");
                panTitle.setFont(new Font("Arial", 1, 36)); //
                panTitle.setHorizontalAlignment(SwingConstants.CENTER);
                panTitle.setHorizontalTextPosition(SwingConstants.CENTER);

                regPanel = new JPanel();
                regPanel.setBackground(Color.gray);
                regPanel.setMinimumSize(new Dimension(500, 580));
                regPanel.setPreferredSize(new Dimension(500, 54));

                fnLabel = new JLabel("First name");
                fnField = new JTextField();

                lnLabel = new JLabel("Last name");
                lnLabel.setHorizontalAlignment(SwingConstants.RIGHT);
                lnLabel.setMinimumSize(new Dimension(56, 10));
                lnLabel.setPreferredSize(new Dimension(56, 10));

                lnField = new JTextField();
                streetLabel = new JLabel("Street");
                streetLabel.setHorizontalAlignment(SwingConstants.RIGHT);

                streetField = new JTextField();
                zipLabel = new JLabel("ZIP");
                zipLabel.setHorizontalAlignment(SwingConstants.RIGHT);

                zipField = new JTextField();

                parishLabel = new JLabel();
                parishLabel.setHorizontalAlignment(SwingConstants.RIGHT);
                parishLabel.setText("Parish");

                associateRadio = new JRadioButton("Associate");
                associateRadio.setPreferredSize(new Dimension(100, 21));

                diplomaRadio = new JRadioButton("Diploma");
                diplomaRadio.setPreferredSize(new Dimension(100, 21));

                certRadio = new JRadioButton("Certificate");
                certRadio.setPreferredSize(new Dimension(100, 21));

                associateRadio1 = new JRadioButton("Associate");
                associateRadio1.setPreferredSize(new Dimension(100, 21));

                diplomaRadio1 = new JRadioButton("Diploma");
                diplomaRadio1.setPreferredSize(new Dimension(100, 21));

                certRadio1 = new JRadioButton("Certificate");
                certRadio1.setPreferredSize(new Dimension(100, 21));

                associateRadio2 = new JRadioButton("Associate");
                associateRadio2.setPreferredSize(new Dimension(100, 21));

                diplomaRadio2 = new JRadioButton("Diploma");
                diplomaRadio2.setPreferredSize(new Dimension(100, 21));

                certRadio2 = new JRadioButton("Certificate");
                certRadio2.setPreferredSize(new Dimension(100, 21));

                parishField = new JTextField();
                dEnrollLabel = new JLabel();
                dEnrollField = new JTextField();
                progCodeLabel = new JLabel();
                progCodeField = new JTextField();
                contactLabel = new JLabel();
                contactField = new JTextField();

                GroupLayout actionMenuLayout = new GroupLayout(actionMenu);
                actionMenu.setLayout(actionMenuLayout);
                actionMenuLayout.setHorizontalGroup(
                                actionMenuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(actionMenuLayout.createSequentialGroup()
                                                                .addGap(125, 125, 125)
                                                                .addGroup(actionMenuLayout
                                                                                .createParallelGroup(
                                                                                                GroupLayout.Alignment.TRAILING,
                                                                                                false)
                                                                                .addComponent(registerBtn,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                150,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(listBtn,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(progBtn,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(modCourseBtn,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(signOutBtn,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addGap(30, 30, 30))

                                                                .addContainerGap(25, Short.MAX_VALUE)));
                actionMenuLayout.setVerticalGroup(
                                actionMenuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(actionMenuLayout.createSequentialGroup()
                                                                .addGap(200, 200, 200)
                                                                .addComponent(registerBtn,
                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                25,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(progBtn,
                                                                                GroupLayout.PREFERRED_SIZE, 25,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addGap(20, 20, 20)
                                                                .addComponent(modCourseBtn,
                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                25,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addGap(20, 20, 20)
                                                                .addComponent(listBtn,
                                                                                GroupLayout.PREFERRED_SIZE, 25,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addGap(180, 180, 180)
                                                                .addComponent(signOutBtn,
                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                25,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(150, Short.MAX_VALUE)));

                fnLabel.setHorizontalAlignment(SwingConstants.RIGHT);

                dEnrollLabel.setHorizontalAlignment(SwingConstants.RIGHT);
                dEnrollLabel.setText("Date Enrolled");

                progCodeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
                progCodeLabel.setText("Program Code");

                contactLabel.setHorizontalAlignment(SwingConstants.RIGHT);
                contactLabel.setText("Contact Number");

                regPanelLayout = new GroupLayout(regPanel);
                regPanel.setLayout(regPanelLayout);
                regPanelLayout.setHorizontalGroup(
                                regPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(GroupLayout.Alignment.TRAILING, regPanelLayout
                                                                .createSequentialGroup()
                                                                .addContainerGap(GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(regPanelLayout.createParallelGroup(
                                                                                GroupLayout.Alignment.LEADING)
                                                                                .addComponent(fnLabel,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                150,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(lnLabel,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                150,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(streetLabel,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                150,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(zipLabel,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                150,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(parishLabel,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                150,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(dEnrollLabel,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                150,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(progCodeLabel,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                150,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(contactLabel,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                150,
                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                .addGap(33, 33, 33)
                                                                .addGroup(regPanelLayout.createParallelGroup(
                                                                                GroupLayout.Alignment.LEADING)
                                                                                .addComponent(fnField,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                200,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(lnField,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                200,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(streetField,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                200,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(zipField,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                200,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(parishField,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                200,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(dEnrollField,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                200,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(progCodeField,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                200,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(contactField,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                200,
                                                                                                GroupLayout.PREFERRED_SIZE)

                                                                                .addComponent(certRadio,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(associateRadio,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(diplomaRadio,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                GroupLayout.PREFERRED_SIZE))

                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addContainerGap(248, Short.MAX_VALUE))

                                                .addGroup(regPanelLayout.createSequentialGroup()
                                                                .addContainerGap(GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(registerStudent,
                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                128,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));
                regPanelLayout.setVerticalGroup(
                                regPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(regPanelLayout.createSequentialGroup()
                                                                .addGap(100, 100, 100)
                                                                .addGroup(regPanelLayout.createParallelGroup(
                                                                                GroupLayout.Alignment.LEADING)
                                                                                .addGroup(regPanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(regPanelLayout
                                                                                                                .createParallelGroup(
                                                                                                                                GroupLayout.Alignment.BASELINE)
                                                                                                                .addComponent(fnLabel,
                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                25,
                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(fnField,
                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                20,
                                                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                                                .addGap(11, 11, 11)
                                                                                                .addComponent(lnLabel,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                25,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(17, 17, 17)
                                                                                                .addComponent(streetLabel,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                25,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(13, 13, 13)
                                                                                                .addComponent(zipLabel,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                25,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(19, 19, 19)
                                                                                                .addComponent(parishLabel,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                25,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(15, 15, 15)
                                                                                                .addComponent(dEnrollLabel,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                25,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(11, 11, 11)
                                                                                                .addComponent(progCodeLabel,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                25,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(17, 17, 17)
                                                                                                .addComponent(contactLabel,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                25,
                                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(regPanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(42, 42, 42)
                                                                                                .addComponent(lnField,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                20,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(streetField,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                20,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(24, 24, 24)
                                                                                                .addComponent(zipField,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                20,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(20, 20, 20)
                                                                                                .addComponent(parishField,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                20,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(16, 16, 16)
                                                                                                .addComponent(dEnrollField,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                20,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(22, 22, 22)
                                                                                                .addComponent(progCodeField,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                20,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(contactField,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                20,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(100, 100, 100)
                                                                                                .addComponent(associateRadio,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(diplomaRadio,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(certRadio,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                GroupLayout.PREFERRED_SIZE)))

                                                                .addComponent(registerStudent,
                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                25,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addGap(50, 50, 50)));

                // }
                regActionPanel.setVisible(true);

                createActionPanel = new JPanel();
                titlePanel = new JPanel();
                jLabel1 = new JLabel();
                createPanel = new JPanel();
                progTypeLabel = new JLabel();
                submitProgBtn = new JButton();
                progDetialsLabel = new JLabel();
                progNameField = new JTextField();
                acreddField = new JTextField();
                progNameLabel = new JLabel();
                jLabel5 = new JLabel();
                jLabel6 = new JLabel();
                acreddLabel = new JLabel();

                createActionPanel.setLayout(new BorderLayout());

                titlePanel.setLayout(new BorderLayout());

                jLabel1.setFont(new Font("Arial", 1, 48)); // NOI18N
                jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
                jLabel1.setText("CREATE PROGRAM");
                jLabel1.setHorizontalTextPosition(SwingConstants.CENTER);
                titlePanel.add(jLabel1, BorderLayout.CENTER);

                createPanel.setBackground(Color.gray);

                progTypeLabel.setFont(new Font("Arial", 1, 18)); // NOI18N
                progTypeLabel.setText("Program Type");

                submitProgBtn.setBackground(Color.orange);
                submitProgBtn.setFont(new Font("Arial", 1, 12)); // NOI18N
                submitProgBtn.setText("Courses");

                progDetialsLabel.setFont(new Font("Arial", 1, 16)); // NOI18N
                progDetialsLabel.setText("Program Details");

                progNameLabel.setText("Program Name");

                jLabel5.setText("Program Code");

                jLabel6.setFont(new Font("Arial", 1, 12)); // NOI18N
                jLabel6.setText("Code");

                acreddLabel.setText("Program Acredditation");

                bg = new ButtonGroup();
                bg1 = new ButtonGroup();
                bg2 = new ButtonGroup();

                GroupLayout createPanelLayout = new GroupLayout(createPanel);
                createPanel.setLayout(createPanelLayout);
                createPanelLayout.setHorizontalGroup(
                                createPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(createPanelLayout.createSequentialGroup()
                                                                .addGroup(createPanelLayout.createParallelGroup(
                                                                                GroupLayout.Alignment.LEADING)
                                                                                .addGroup(createPanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(24, 24, 24)
                                                                                                .addComponent(jLabel5,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                85,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(jLabel6,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                70,
                                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(createPanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addContainerGap(
                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addGroup(createPanelLayout
                                                                                                                .createParallelGroup(
                                                                                                                                GroupLayout.Alignment.LEADING,
                                                                                                                                false)
                                                                                                                .addComponent(progNameLabel,
                                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(progNameField,
                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                150,
                                                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                                                .addGap(50, 50, 50)
                                                                                                .addGroup(createPanelLayout
                                                                                                                .createParallelGroup(
                                                                                                                                GroupLayout.Alignment.LEADING,
                                                                                                                                false)
                                                                                                                .addComponent(acreddField,
                                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                                150,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(acreddLabel,
                                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE))))
                                                                .addContainerGap(
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                .addGroup(createPanelLayout.createSequentialGroup()
                                                                .addContainerGap(
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(createPanelLayout.createParallelGroup(
                                                                                GroupLayout.Alignment.LEADING)
                                                                                .addComponent(progDetialsLabel,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                130,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(progTypeLabel,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                130,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(submitProgBtn,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                130,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(createPanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(certRadio1,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(associateRadio1,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(diplomaRadio1,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                GroupLayout.PREFERRED_SIZE)))
                                                                .addContainerGap(
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));
                createPanelLayout.setVerticalGroup(
                                createPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(createPanelLayout.createSequentialGroup()
                                                                .addGap(24, 24, 24)
                                                                .addGroup(createPanelLayout.createParallelGroup(
                                                                                GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel5)
                                                                                .addComponent(jLabel6))
                                                                .addGap(18, 18, 18)
                                                                .addComponent(progDetialsLabel)
                                                                .addGap(18, 18, 18)
                                                                .addGroup(createPanelLayout.createParallelGroup(
                                                                                GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(progNameLabel)
                                                                                .addComponent(acreddLabel))
                                                                .addPreferredGap(
                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(createPanelLayout.createParallelGroup(
                                                                                GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(progNameField,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(acreddField,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                .addGap(58, 58, 58)
                                                                .addComponent(progTypeLabel)
                                                                .addGap(18, 18, 18)
                                                                .addGroup(createPanelLayout.createParallelGroup(
                                                                                GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(associateRadio1,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(diplomaRadio1,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(certRadio1,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                .addGap(40, 40, 40)
                                                                .addComponent(submitProgBtn)
                                                                .addContainerGap(23, Short.MAX_VALUE)));
                /*
                 * 
                 * 
                 * 
                 * 
                 * 
                 * 
                 * 
                 * 
                 */
                createActionPanel.add(createPanel, BorderLayout.CENTER);
                createActionPanel.setVisible(true);

                titlePanel = new JPanel();
                titlePanel.setLayout(new BorderLayout());

                modCoursePanel = new JPanel();
                modCoursePanel.setLayout(new BorderLayout());

                title = new JLabel("CREATE PROGRAM");
                title.setFont(new Font("Arial", 1, 48)); // NOI18N
                title.setHorizontalAlignment(SwingConstants.CENTER);
                title.setHorizontalTextPosition(SwingConstants.CENTER);

                coursePanel = new JPanel();
                coursePanel.setBackground(Color.gray);

                progTypeLabel = new JLabel("Program Type");
                progTypeLabel.setFont(new Font("Arial", 1, 18)); // NOI18N
                progTypeLabel.setHorizontalAlignment(SwingConstants.CENTER);

                addCoursesBtn = new JButton("Add Course");
                addCoursesBtn.setBackground(Color.orange);
                addCoursesBtn.setFont(new Font("Arial", 1, 12)); // NOI18N
                addCoursesBtn.setMaximumSize(new Dimension(100, 21));
                addCoursesBtn.setMinimumSize(new Dimension(100, 21));
                addCoursesBtn.setPreferredSize(new Dimension(100, 21));

                progCodeLabel = new JLabel("Program Code");

                pCode = new JLabel("Code");
                pCode.setFont(new Font("Arial", 1, 12)); // NOI18N
                pCode.setText("Code");

                jComboBox1 = new JComboBox<>();
                jComboBox1.setModel(
                                new DefaultComboBoxModel<>(
                                                new String[] { "Certificate", "Diploma", "Associate" }));
                jComboBox1.setPreferredSize(new Dimension(75, 22));

                courseScPane = new JScrollPane();
                courseScPane.setViewportView(courseTable);
                courseTable = new JTable();

                progAvLabel = new JLabel();
                progAvLabel.setFont(new Font("Arial", 1, 12)); // NOI18N
                progAvLabel.setText("Programs Available");

                courseAvLabel = new JLabel();
                courseAvLabel.setFont(new Font("Arial", 1, 12)); // NOI18N
                courseAvLabel.setText("Courses Available");

                progScPane = new JScrollPane();
                progScPane.setViewportView(progTable);
                progTable = new JTable();

                pCodeInLabel = new JLabel("Enter Program Code");

                pCodeINField = new JTextField();

                cCodeINLabel = new JLabel("Enter Course Code");
                cCodeINField = new JTextField();

                submitPrBtn = new JButton("Submit Program");
                submitPrBtn.setBackground(Color.orange);
                submitPrBtn.setFont(new Font("Arial", 1, 12)); // NOI18N
                submitPrBtn.setMaximumSize(new Dimension(100, 20));
                submitPrBtn.setMinimumSize(new Dimension(100, 20));
                submitPrBtn.setPreferredSize(new Dimension(100, 20));

                GroupLayout coursePanelLayout = new GroupLayout(coursePanel);
                coursePanel.setLayout(coursePanelLayout);
                coursePanelLayout.setHorizontalGroup(
                                coursePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(coursePanelLayout.createSequentialGroup()
                                                                .addGap(50, 50, 50)
                                                                .addGroup(coursePanelLayout
                                                                                .createParallelGroup(
                                                                                                GroupLayout.Alignment.LEADING)

                                                                                .addGroup(coursePanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(progCodeLabel,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                85,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(pCode,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                70,
                                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                                .addComponent(addCoursesBtn,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                150,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(coursePanelLayout
                                                                                                .createParallelGroup(
                                                                                                                GroupLayout.Alignment.TRAILING,
                                                                                                                false)
                                                                                                .addComponent(cCodeINField,
                                                                                                                GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(cCodeINLabel,
                                                                                                                GroupLayout.Alignment.LEADING,
                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(pCodeInLabel,
                                                                                                                GroupLayout.Alignment.LEADING,
                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addGroup(coursePanelLayout
                                                                                                                .createSequentialGroup()
                                                                                                                .addComponent(jComboBox1,
                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                100,
                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                .addGap(25, 25, 25))
                                                                                                .addComponent(progTypeLabel,
                                                                                                                GroupLayout.Alignment.LEADING,
                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                150,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(pCodeINField,
                                                                                                                GroupLayout.Alignment.LEADING,
                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                150,
                                                                                                                Short.MAX_VALUE))
                                                                                .addComponent(submitPrBtn,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                150,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(25, 25, 25))
                                                                .addGroup(
                                                                                coursePanelLayout
                                                                                                .createParallelGroup(
                                                                                                                GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(progScPane,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                400,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(progAvLabel,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                150,
                                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                .addGap(100, 100, 100)
                                                                .addGroup(
                                                                                coursePanelLayout
                                                                                                .createParallelGroup(
                                                                                                                GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(courseAvLabel,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                150,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(courseScPane,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                400,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(50, 50, 50))
                                                                .addContainerGap(GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));
                coursePanelLayout.setVerticalGroup(
                                coursePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(coursePanelLayout.createSequentialGroup()
                                                                .addGap(24, 24, 24)
                                                                .addGroup(coursePanelLayout
                                                                                .createParallelGroup(
                                                                                                GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(progCodeLabel)
                                                                                .addComponent(pCode))
                                                                .addGroup(coursePanelLayout
                                                                                .createParallelGroup(
                                                                                                GroupLayout.Alignment.LEADING)
                                                                                .addGroup(coursePanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(31, 31, 31)
                                                                                                .addGroup(coursePanelLayout
                                                                                                                .createParallelGroup(
                                                                                                                                GroupLayout.Alignment.BASELINE)
                                                                                                                .addComponent(progAvLabel)
                                                                                                                .addComponent(courseAvLabel))
                                                                                                .addGap(18, 18, 18)
                                                                                                .addGroup(coursePanelLayout
                                                                                                                .createParallelGroup(
                                                                                                                                GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(progScPane,
                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                500,
                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(courseScPane,
                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                500,
                                                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                                                .addContainerGap(
                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE))
                                                                                .addGroup(coursePanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(50, 50, 50)
                                                                                                .addComponent(progTypeLabel)
                                                                                                .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.UNRELATED)

                                                                                                .addComponent(jComboBox1,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(75, 75, 75)
                                                                                                .addComponent(pCodeInLabel)
                                                                                                .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(pCodeINField,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(cCodeINLabel)
                                                                                                .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(cCodeINField,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(40, 40, 40)
                                                                                                .addComponent(addCoursesBtn,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(50, 50, 50)
                                                                                                .addComponent(submitPrBtn,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                GroupLayout.PREFERRED_SIZE)))
                                                                .addContainerGap(GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));
                coursePanel.setVisible(false);
                /*
                 * 
                 * 
                 * 
                 * 
                 * 
                 * 
                 * 
                 * 
                 */
                // initializing components for modCoursePanel
                titlePanel = new JPanel();
                jLabel1 = new JLabel();

                modCoursePanel = new JPanel();
                modCoursePanel.setBackground(Color.gray);
                modCoursePanel.setMaximumSize(new Dimension(1000, 32767));
                modCoursePanel.setPreferredSize(new Dimension(800, 342));

                progTypeLabel = new JLabel("Program Type");
                progTypeLabel.setFont(new Font("Arial", 1, 18)); // NOI18N
                progTypeLabel.setHorizontalAlignment(SwingConstants.CENTER);

                createCourseBtn = new JButton("Add Course");
                createCourseBtn.setBackground(Color.orange);
                createCourseBtn.setFont(new Font("Arial", 1, 12)); // NOI18N
                createCourseBtn.setMaximumSize(new Dimension(100, 21));
                createCourseBtn.setMinimumSize(new Dimension(100, 21));
                createCourseBtn.setPreferredSize(new Dimension(100, 21));

                courseAv = new JLabel("Courses Available");
                courseAv.setFont(new Font("Arial", 1, 12)); // NOI18N

                pCodeInLabel = new JLabel("Enter Program Code");
                pCodeINField = new JTextField();
                cCodeINLabel = new JLabel("Enter Course Code");
                cCodeINField = new JTextField();

                deleteBtn = new JButton("Delete Course");
                deleteBtn.setBackground(Color.orange);
                deleteBtn.setFont(new Font("Arial", 1, 12)); // NOI18N
                deleteBtn.setMaximumSize(new Dimension(100, 21));
                deleteBtn.setMinimumSize(new Dimension(100, 21));
                deleteBtn.setPreferredSize(new Dimension(100, 21));

                editBtn = new JButton("Edit Course");
                editBtn.setBackground(Color.orange);
                editBtn.setFont(new Font("Arial", 1, 12)); // NOI18N
                editBtn.setMaximumSize(new Dimension(100, 21));
                editBtn.setMinimumSize(new Dimension(100, 21));
                editBtn.setPreferredSize(new Dimension(100, 21));

                String[] defaultCols = { "CourseCode", "CourseName", "ProgCode", "CreditCost",
                                "# of Credits", "Cost", "Prequisite", "Desc" };

                tModel = new DefaultTableModel(defaultCols, 0) {
                };

                modTable = new JTable(tModel);
                modTable.setColumnSelectionAllowed(true);

                jScrollPane1 = new JScrollPane();
                jScrollPane1.setViewportView(modTable);
                modTable.getColumnModel().getSelectionModel()
                                .setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

                GroupLayout modCoursePanelLayout = new GroupLayout(modCoursePanel);
                modCoursePanel.setLayout(modCoursePanelLayout);
                modCoursePanelLayout.setHorizontalGroup(
                                modCoursePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(modCoursePanelLayout.createSequentialGroup()
                                                                .addGap(100, 100, 100)
                                                                .addGroup(modCoursePanelLayout.createParallelGroup(
                                                                                GroupLayout.Alignment.LEADING)
                                                                                .addComponent(createCourseBtn,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                150,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(modCoursePanelLayout
                                                                                                .createParallelGroup(
                                                                                                                GroupLayout.Alignment.TRAILING,
                                                                                                                false)
                                                                                                .addComponent(cCodeINField,
                                                                                                                GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(cCodeINLabel,
                                                                                                                GroupLayout.Alignment.LEADING,
                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(pCodeInLabel,
                                                                                                                GroupLayout.Alignment.LEADING,
                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(progTypeLabel,
                                                                                                                GroupLayout.Alignment.LEADING,
                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                150,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(pCodeINField,
                                                                                                                GroupLayout.Alignment.LEADING))
                                                                                .addComponent(deleteBtn,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                150,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(certRadio2,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                98,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(diplomaRadio2,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                98,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(associateRadio2,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                98,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(editBtn,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                150,
                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                .addGap(66, 66, 66)
                                                                .addGroup(modCoursePanelLayout.createParallelGroup(
                                                                                GroupLayout.Alignment.LEADING)
                                                                                .addComponent(courseAv,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                150,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jScrollPane1))
                                                                .addGap(32, 32, 32)));
                modCoursePanelLayout.setVerticalGroup(
                                modCoursePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(modCoursePanelLayout.createSequentialGroup()
                                                                .addGap(59, 59, 59)
                                                                .addComponent(courseAv)
                                                                .addPreferredGap(
                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(modCoursePanelLayout.createParallelGroup(
                                                                                GroupLayout.Alignment.LEADING)
                                                                                .addGroup(modCoursePanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(progTypeLabel)
                                                                                                .addGap(30, 30, 30)
                                                                                                .addComponent(certRadio2)
                                                                                                .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                .addComponent(diplomaRadio2)
                                                                                                .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                .addComponent(associateRadio2)
                                                                                                .addGap(22, 22, 22)
                                                                                                .addComponent(pCodeInLabel)
                                                                                                .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(pCodeINField,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(cCodeINLabel)
                                                                                                .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(cCodeINField,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(30, 30, 30)
                                                                                                .addComponent(createCourseBtn,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(deleteBtn,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(editBtn,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                                .addComponent(jScrollPane1,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                443,
                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                .addContainerGap(48, Short.MAX_VALUE)));

                titlePanel.setLayout(new BorderLayout());

                jLabel1.setFont(new Font("Arial", 1, 48)); // NOI18N
                jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
                jLabel1.setText("MODIFY PROGRAM");
                jLabel1.setHorizontalTextPosition(SwingConstants.CENTER);
        }
        /*
         * 
         * 
         * 
         * 
         * 
         * 
         * 
         */

        public boolean validateFields() {
                return fnField.getText().isEmpty() || lnField.getText().isEmpty()
                                || streetField.getText().isEmpty() || zipField.getText().isEmpty()
                                || parishField.getText().isEmpty()
                                || dEnrollField.getText().isEmpty() || progCodeField.getText().isEmpty()
                                || contactField.getText().isEmpty();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                String pCode = pCodeINField.getText();
                String cCode = cCodeINField.getText();
                Staff staff = new Staff();
                int count = 0;
                Programme programme = new Programme();

                if (e.getSource().equals(registerBtn)) {
                        while (tModel.getRowCount() > 0) {
                                tModel.removeRow(0);
                        }
                        mainPanel.remove(createActionPanel);
                        mainPanel.remove(coursePanel);
                        mainPanel.remove(modCoursePanel);
                        mainPanel.add(regActionPanel, BorderLayout.CENTER);
                        mainPanel.revalidate();
                        mainPanel.repaint();
                       
                }

                if (e.getSource().equals(progBtn)) {
                        while (tModel.getRowCount() > 0) {
                                tModel.removeRow(0);
                        }

                        mainPanel.remove(regActionPanel);
                        mainPanel.remove(coursePanel);
                        mainPanel.remove(modCoursePanel);
                        mainPanel.add(createActionPanel, BorderLayout.CENTER);
                        mainPanel.revalidate();
                        mainPanel.repaint();
                }
                if (e.getSource().equals(submitProgBtn)) {
                        while (tModel.getRowCount() > 0) {
                                tModel.removeRow(0);
                        }
                        mainPanel.remove(regActionPanel);
                        mainPanel.remove(coursePanel);
                        mainPanel.remove(createActionPanel);
                        mainPanel.repaint();
                        programme.setAccreditation(acreddField.getText());
                        programme.setAward(awardString);
                        programme.setProgrammeName(progNameField.getText().replaceAll(" ", "_"));
                        new createCoursePanel(programme, progType1, true, 1);
                        System.out.println(progType1);
                
                }

                if (e.getSource().equals(modCourseBtn)) {
                        while (tModel.getRowCount() > 0) {
                                tModel.removeRow(0);
                        }
                        mainPanel.remove(createActionPanel);
                        mainPanel.remove(regActionPanel);
                        mainPanel.remove(coursePanel);
                        mainPanel.add(modCoursePanel, BorderLayout.CENTER);
                        mainPanel.revalidate();
                        mainPanel.repaint();
                    
                        ArrayList<Course> courselist = staff.generateCourseList();
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

                if (e.getSource().equals(listBtn)) {
                        new genList();
                        while (tModel.getRowCount() > 0) {
                                tModel.removeRow(0);
                        }
                }

                if (e.getSource().equals(signOutBtn)) {
                        mainPanel.setVisible(false);
                        new LoginScreen(frame);
                }

                if (e.getSource().equals(editBtn)) {
                        programme.setProgrammeCode(pCode);
                        Course course = new Course();

                        course.setCourseCode(cCode);

                        programme.setCourse(course);

                        int choice = 2;

                        new createCoursePanel(programme, progType1, false, choice);
                        System.out.println(progType1);
                }

                if (e.getSource().equals(deleteBtn)) {
                        staff.removeCourse(progType1, pCode, cCode);
                        System.out.println(progType1);
                }

                if (e.getSource().equals(createCourseBtn)) {
                        staff.addCourse(progType1, pCode, cCode);
                }

                if (e.getSource().equals(registerStudent)) {
                        if (!validateFields()) {
                                staff = new Staff();
                                staff.studentRegistration(progType1, fnField.getText().replaceAll(" ", "_"),
                                                lnField.getText().replaceAll(" ", "_"),
                                                parishField.getText().replaceAll(" ", "_"),
                                                streetField.getText().replaceAll(" ", "_"),
                                                zipField.getText().replaceAll(" ", "_"),
                                                dEnrollField.getText().replaceAll(" ", "_"),
                                                progCodeField.getText().replaceAll(" ", "_"),
                                                contactField.getText().replaceAll(" ", "_"));
                        } else {
                                JOptionPane.showMessageDialog(null, "One or more fields Empty", "Missing Information",
                                                JOptionPane.WARNING_MESSAGE);
                        }
                }
        }

        @Override
        public void itemStateChanged(ItemEvent e) {

                if (associateRadio.isSelected()) {
                        this.progType1 = 3;
                        this.awardString = "Associate";
                        setProgType1(progType1);
                        setAwardString(awardString);
                } else if (certRadio.isSelected()) {
                        this.progType1 = 1;
                        this.awardString = "Certificate";
                        setProgType1(progType1);
                        setAwardString(awardString);
                } else if (diplomaRadio.isSelected()) {
                        this.progType1 = 2;
                        this.awardString = "Diploma";
                        setProgType1(progType1);
                        setAwardString(awardString);
                }

                if (associateRadio2.isSelected()) {
                        this.progType1 = 3;
                        this.awardString = "Associate";
                        setProgType1(progType1);
                        setAwardString(awardString);
                } else if (certRadio2.isSelected()) {
                        this.progType1 = 1;
                        this.awardString = "Certificate";
                        setProgType1(progType1);
                        setAwardString(awardString);
                } else if (diplomaRadio2.isSelected()) {
                        this.progType1 = 2;
                        this.awardString = "Diploma";
                        setProgType1(progType1);
                        setAwardString(awardString);
                }

                if (associateRadio1.isSelected()) {
                        this.progType1 = 3;
                        this.awardString = "Associate";
                        setProgType1(progType1);
                        setAwardString(awardString);
                } else if (certRadio1.isSelected()) {
                        this.progType1 = 1;
                        this.awardString = "Certificate";
                        setProgType1(progType1);
                        setAwardString(awardString);
                } else if (diplomaRadio1.isSelected()) {
                        this.progType1 = 2;
                        this.awardString = "Diploma";
                        setProgType1(progType1);
                        setAwardString(awardString);
                }
        }

       

        public void setProgType1(int progType1) {
                this.progType1 = progType1;
        }

        public void setAwardString(String awardString) {
                this.awardString = awardString;
        }

}