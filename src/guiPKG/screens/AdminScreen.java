// Author/Name: Christoph Banton 
// ID Number: 2100760
// Module: Object Oritented Programming
// Date: November 7, 2022
// Description: Creating Display Screens for Administration

package guiPKG.screens;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.io.IOException;
import java.io.File; // Import the File class
// import java.io.IOException; // Import the IOException class to handle errors
import java.util.Scanner;

import models.Admin;

public class AdminScreen implements ActionListener {
    private JFrame frame;
    private JLabel appTitle, fNLabel, lNLabel, idNumLabel, facLabel, depLabel, dateEmpLabel, yearLabel, dayLabel,
            monthLabel, actTitLabel;
    private JPanel actionPanel, adminPanel, topPanel, topPanel2;
    private JButton submitButton, signoutButton;
    private JTextField yearEmpField, dayEmpField, monthEmpField;
    private JTextField idNumField, fNField, lNField, facField, depField;

    public AdminScreen(JFrame frame) { // Initializing AdminScreen Class

        initializeComponents(frame);
        addComponentsToPanel();
        setWindowProperties();
        registerListeners();
    }

    // Initializing frame components
    public void initializeComponents(JFrame frame) {
        this.frame = frame;

        adminPanel = new JPanel();
        adminPanel.setSize(800, 600);
        adminPanel.setOpaque(true);
        adminPanel.setLayout(new BorderLayout());

        topPanel = new JPanel();
        topPanel.setBackground(Color.ORANGE);
        topPanel.setPreferredSize(new Dimension(800, 150));
        topPanel.setLayout(new BorderLayout(2, 5));

        topPanel2 = new JPanel();
        topPanel2.setBackground(Color.ORANGE);
        topPanel2.setPreferredSize(new Dimension(800, 50));
        // topPanel2.setLayout(new BorderLayout());
        // topPanel2.setOpaque(false);

        appTitle = new JLabel("Home & Away Institute");
        appTitle.setFont(new Font("Arial", Font.BOLD, 40));
        appTitle.setPreferredSize(new Dimension(300, 100));
        appTitle.setForeground(Color.black);

        signoutButton = new JButton("Sign Out");
        signoutButton.setPreferredSize(new Dimension(150, 25));

        actionPanel = new JPanel();
        actionPanel.setSize(1800, 600);
        actionPanel.setLayout(null);
        actionPanel.setBackground(Color.GRAY);

        actTitLabel = new JLabel("REGISTER STAFF");
        actTitLabel.setFont(new Font("Arial", Font.BOLD, 50));
        actTitLabel.setBounds(0, 50, 500, 50);

        idNumLabel = new JLabel("ID Number:");
        idNumLabel.setBounds(200, 200, 150, 25);

        idNumField = new JTextField("", 30);
        idNumField.setBounds(300, 200, 150, 25);

        fNLabel = new JLabel("First Name:");
        fNLabel.setBounds(200, 250, 150, 25);

        fNField = new JTextField("", 30);
        fNField.setBounds(300, 250, 250, 25);

        lNLabel = new JLabel("Last Name:");
        lNLabel.setBounds(600, 250, 150, 25);

        lNField = new JTextField("", 30);
        lNField.setBounds(700, 250, 250, 25);

        facLabel = new JLabel("Faculty:");
        facLabel.setBounds(200, 300, 250, 25);

        facField = new JTextField("", 20);
        facField.setBounds(300, 300, 250, 25);

        depLabel = new JLabel("Department:");
        depLabel.setBounds(600, 300, 150, 25);

        depField = new JTextField("", 20);
        depField.setBounds(700, 300, 250, 25);

        dateEmpLabel = new JLabel("Date Employed");
        dateEmpLabel.setBounds(200, 350, 250, 25);

        yearLabel = new JLabel("Year:");
        yearLabel.setBounds(200, 375, 100, 25);

        dayLabel = new JLabel("Day:");
        dayLabel.setBounds(400, 375, 100, 25);

        monthLabel = new JLabel("Month:");
        monthLabel.setBounds(600, 375, 100, 25);

        yearEmpField = new JTextField();
        yearEmpField.setBounds(250, 375, 100, 25);

        dayEmpField = new JTextField();
        dayEmpField.setBounds(450, 375, 100, 25);

        monthEmpField = new JTextField();
        monthEmpField.setBounds(650, 375, 100, 25);

        submitButton = new JButton("Register Staff");
        submitButton.setBounds(200, 500, 200, 50);

    }
    // Adding components to the panel
    public void addComponentsToPanel() {
        adminPanel.add(topPanel, BorderLayout.NORTH);
        adminPanel.add(actionPanel, BorderLayout.CENTER);
        // adminPanel.add(appTitle);

        topPanel.add(topPanel2, BorderLayout.PAGE_END);
        topPanel.add(appTitle, BorderLayout.CENTER);
        topPanel2.add(signoutButton, BorderLayout.LINE_END);

        actionPanel.add(actTitLabel);
        actionPanel.add(depField);
        actionPanel.add(depLabel);
        actionPanel.add(fNLabel);
        actionPanel.add(fNField);
        actionPanel.add(lNLabel);
        actionPanel.add(lNField);
        actionPanel.add(facLabel);
        actionPanel.add(facField);
        actionPanel.add(dateEmpLabel);
        actionPanel.add(yearLabel);
        actionPanel.add(yearEmpField);
        actionPanel.add(dayLabel);
        actionPanel.add(dayEmpField);
        actionPanel.add(monthLabel);
        actionPanel.add(monthEmpField);
        actionPanel.add(submitButton);

    }
    // Setting window properties 
    public void setWindowProperties() {
        frame.pack();
        frame.add(adminPanel);
        // frame.setLayout(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public void registerListeners() {
        signoutButton.addActionListener(this);
        submitButton.addActionListener(this);
       
    }
    // Checking to see if fields are empty
    public boolean validateFields() {
        return depField.getText().isEmpty() || fNField.getText().isEmpty()
                || lNField.getText().isEmpty() || facField.getText().isEmpty() || dayEmpField.getText().isEmpty()
                || yearEmpField.getText().isEmpty() || monthEmpField.getText().isEmpty();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(signoutButton)) {
            adminPanel.setVisible(false);
            new LoginScreen(frame);
        }
        if (e.getSource().equals(submitButton)) {
            if (!validateFields()) {
                Admin admin = new Admin();
                admin.registerStaff(fNField.getText().trim().replaceAll(" ", "_"), lNField.getText().trim().replaceAll(" ", "_"), "Blank", yearEmpField.getText().trim().replaceAll(" ", "_"),
                        monthEmpField.getText().trim().replaceAll(" ", "_"), dayEmpField.getText().trim().replaceAll(" ", "_"), facField.getText().trim().replaceAll(" ", "_"), depField.getText().trim().replaceAll(" ", "_"));
            } else {
                JOptionPane.showMessageDialog(null, "One or more fields Empty", "Missing Information",
                        JOptionPane.WARNING_MESSAGE);
            } 
        }

    }
    
}