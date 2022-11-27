package guiPKG.screens;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import models.Student;
import models.Staff;

public class genList extends JFrame implements ActionListener {

        // Variables declaration - do not modify
        private JButton genListBtn;
        private JLabel genListLabel;
        private JPanel genListPanel;
        private JScrollPane genListScPane;
        private JTable genLostSc;
        private JLabel jLabel1;
        private JLabel jLabel2;
        private JPanel jPanel1;
        private JTextField jTextField1;
        private JPanel titlePanel;
        // End of variables declaration
        //private int count;
        private DefaultTableModel tModel;
        private JTable genTable;
        //private Student[] courselist;
        private Staff staff;

        public genList() {
                initializeComponents();
                setWindowProperties();
                registerListeners();
        }

        private void registerListeners() {
                genListBtn.addActionListener(this);
        }

        private void setWindowProperties() {
                setTitle("Home & Away Institute");
                setBackground(Color.darkGray);
                setVisible(true);
                setSize(800, 800);
                setLocationRelativeTo(null);
        }

        private void initializeComponents() {

                jPanel1 = new JPanel();

                jPanel1.setBackground(Color.orange);
                jLabel1 = new JLabel("GENERATE LIST");
                jLabel1.setFont(new Font("Arial", 1, 48)); // NOI18N
                jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
                jLabel1.setHorizontalTextPosition(SwingConstants.CENTER);

                String[] defaultCols = { "Id", "First name", "Last name", "Parish",
                                "Street name", "ZIP", "Date Enrolled", "Program Code", "Enrollment Status",
                                "Contact number", "Sequence" };

                tModel = new DefaultTableModel(defaultCols, 0) {
                };

                genTable = new JTable(tModel);
                genTable.setColumnSelectionAllowed(true);

                genListScPane = new JScrollPane();
                genListScPane.setViewportView(genTable);
                genTable.getColumnModel().getSelectionModel()
                                .setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

                GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 800,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jLabel1)
                                                                .addContainerGap()));

                getContentPane().add(jPanel1, BorderLayout.PAGE_START);

                genListPanel = new JPanel();
                genListPanel.setBackground(Color.gray);
                genListPanel.setMaximumSize(new Dimension(1000, 32767));
                genListPanel.setPreferredSize(new Dimension(800, 342));

                genListLabel = new JLabel("Programs Details");
                genListLabel.setFont(new Font("Arial", 1, 12)); // NOI18N

                genLostSc = new JTable();
                genLostSc.setMinimumSize(new Dimension(300, 300));
                genListScPane.setViewportView(genTable);

                genListBtn = new JButton();
                genListBtn = new JButton("Submit");
                genListBtn.setBackground(Color.orange);
                genListBtn.setFont(new Font("Arial", 1, 12)); // NOI18N

                genListBtn.setMaximumSize(new Dimension(100, 21));
                genListBtn.setMinimumSize(new Dimension(100, 21));
                genListBtn.setPreferredSize(new Dimension(100, 21));

                titlePanel = new JPanel();
                titlePanel.setLayout(new BorderLayout());

                jTextField1 = new JTextField();

                jLabel2 = new JLabel("Enter Program Code");

                GroupLayout genListPanelLayout = new GroupLayout(genListPanel);
                genListPanel.setLayout(genListPanelLayout);
                genListPanelLayout.setHorizontalGroup(
                                genListPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(genListPanelLayout.createSequentialGroup()
                                                                .addGroup(genListPanelLayout
                                                                                .createParallelGroup(
                                                                                                GroupLayout.Alignment.LEADING)
                                                                                .addGroup(GroupLayout.Alignment.TRAILING,
                                                                                                genListPanelLayout
                                                                                                                .createSequentialGroup()
                                                                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                                                                .addComponent(titlePanel,
                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                800,
                                                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(genListPanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(246, 246, 246)
                                                                                                .addComponent(genListLabel,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                150,
                                                                                                                GroupLayout.PREFERRED_SIZE)))
                                                                .addContainerGap())
                                                .addGroup(genListPanelLayout.createSequentialGroup()
                                                                .addContainerGap(GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 138,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE,
                                                                                71,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(genListBtn, GroupLayout.PREFERRED_SIZE,
                                                                                150,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                .addGroup(GroupLayout.Alignment.TRAILING,
                                                                genListPanelLayout.createSequentialGroup()
                                                                                .addGap(71, 71, 71)
                                                                                .addComponent(genListScPane)
                                                                                .addGap(71, 71, 71)));

                genListPanelLayout.linkSize(SwingConstants.HORIZONTAL,
                                new Component[] { genListBtn, jTextField1 });

                genListPanelLayout.setVerticalGroup(
                                genListPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(genListPanelLayout.createSequentialGroup()
                                                                .addGap(48, 48, 48)
                                                                .addComponent(genListLabel)
                                                                .addPreferredGap(
                                                                                LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(titlePanel, GroupLayout.PREFERRED_SIZE,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(genListScPane, GroupLayout.DEFAULT_SIZE,
                                                                                140, Short.MAX_VALUE)
                                                                .addGap(62, 62, 62)
                                                                .addGroup(genListPanelLayout
                                                                                .createParallelGroup(
                                                                                                GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(jLabel2)
                                                                                .addGroup(genListPanelLayout
                                                                                                .createParallelGroup(
                                                                                                                GroupLayout.Alignment.BASELINE)
                                                                                                .addComponent(jTextField1,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(genListBtn,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(37, 37, 37)));

                genListPanelLayout.linkSize(SwingConstants.VERTICAL,
                                new Component[] { jLabel2, jTextField1 });

                getContentPane().add(genListPanel, BorderLayout.CENTER);
        }// </editor-fold>

        public static void main(String args[]) {

                new genList().setVisible(true);

        }

        @Override
        public void actionPerformed(ActionEvent e) {

                if (e.getSource().equals(genListBtn)) {
                        int count = 0;

                        staff = new Staff();
                        ArrayList<Student> studentlist = staff.generateStudentList(jTextField1.getText().toUpperCase());

                        for (Student std : studentlist) {
                                tModel.insertRow(count, new Object[] {
                                                std.getIdNumber(),
                                                std.getFirstName(),
                                                std.getLastName(),
                                                std.getParish(),
                                                std.getStreetName(),
                                                std.getZipCode(),
                                                std.getDateEnrolled(),
                                                std.getProgrammeCode(),
                                                std.getEnrollmentstatus(),
                                                std.getContactNumber(),
                                                std.getSequenceNum(),

                                });
                                count++;
                        }
                }
        }
}
