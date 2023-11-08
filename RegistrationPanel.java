package project;

import java.awt.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

class RegistrationPanel extends ContentPanel {
    private JPanel registerPanel;
    private ContentPanel registrationBGPanel;
    private JLabel NameLabel;
    private JLabel firstNameLabel, middleNameLabel, lastNameLabel, studentIDLabel, sectionLabel, emailLabel, contactNumberLabel, departmentLabel, yearLabel, courseLabel, dateLabel;
    private JTextField firstNameTF, middleNameTF, lastNameTF, studentIDTF, sectionTF, emailTF, courseTF, contactTF;
    private JComboBox yearCB, departmentCB, datemonthCB, datedayCB, dateyearCB;
    private JButton register, clear;
    private JLayeredPane layeredPane;
    private JLabel text_0, text_1, text_2, text_3, text_4, text_5, text_6, text_7;
    private HomeFrame homeFrame;

    RegistrationPanel(int color, HomeFrame homeFrame) {
        super(color);
        this.homeFrame = homeFrame;

        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 1185, 585);

        registrationBGPanel = new ContentPanel(0xFFBD59);
        registrationBGPanel.addImage("C:\\Users\\Charles\\Downloads\\RegistrationBG.png", 1185, 585);

        registerPanel = new JPanel();
        registerPanel.setBackground(new Color(0x293478));
        registerPanel.setBounds(85, 250, 1013, 320);
        registerPanel.setLayout(null);

        NameLabel = new JLabel("NAME:");
        NameLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
        NameLabel.setForeground(Color.WHITE);
        NameLabel.setBounds(15, 30, 200, 25);

        firstNameLabel = new JLabel("FIRST NAME");
        firstNameLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        firstNameLabel.setForeground(Color.WHITE);
        firstNameLabel.setBounds(210, 5, 150, 25);

        firstNameTF = new JTextField();
        firstNameTF.setBounds(115, 30, 280, 25);
        firstNameTF.setBackground(Color.WHITE);
        firstNameTF.setFont(new Font("Tahoma", Font.BOLD, 15));
        firstNameTF.setCaretColor(Color.BLACK);
        firstNameTF.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                firstNameTF.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (firstNameTF.getText().isEmpty()) {
                    firstNameTF.setBorder(BorderFactory.createLineBorder(Color.RED));
                    text_0.setText("You need to fill this up!");
                } else {
                    firstNameTF.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    text_0.setText("");
                }
            }
        });

        text_0 = new JLabel();
        text_0.setForeground(Color.RED);
        text_0.setFont(new Font("Tahoma", Font.BOLD, 10));
        text_0.setBounds(115, 52, 273, 25);

        // Middle Name Label
        middleNameLabel = new JLabel("MIDDLE NAME");
        middleNameLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        middleNameLabel.setForeground(Color.WHITE);
        middleNameLabel.setBounds(515, 5, 150, 25);
		
		//Middle Name Box
		middleNameTF = new JTextField();
		middleNameTF.setBackground(Color.WHITE);
		middleNameTF.setBounds(410, 30, 280, 25);
		middleNameTF.setFont(new Font("Tahoma", Font.BOLD, 15));
		middleNameTF.setCaretColor(Color.BLACK);
		middleNameTF.addFocusListener(new FocusListener() {
	            @Override
	            public void focusGained(FocusEvent e) {
	                // Reset border color to BLACK when the text field gains focus
	            	middleNameTF.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	            }

	            @Override
	            public void focusLost(FocusEvent e) {
	                // Set border color to red if the text field is empty
	                if (middleNameTF.getText().isEmpty()) {
	                	middleNameTF.setBorder(BorderFactory.createLineBorder(Color.RED));
	                	text_1.setText("You need to fill this up!");
	                } else {
	                	middleNameTF.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	                	text_1.setText("");
	                }
	            }
	        });
		
		text_1 = new JLabel();
		text_1.setForeground(Color.RED);
		text_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		text_1.setBounds(410, 52, 273, 25);



		
		//Last Name
		lastNameLabel = new JLabel("LAST NAME");
		lastNameLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lastNameLabel.setForeground(Color.WHITE);
		lastNameLabel.setBounds(820, 5, 150, 25);

		//Last Name Box
		lastNameTF = new JTextField();
		lastNameTF.setBackground(Color.WHITE);
		lastNameTF.setBounds(710, 30, 280, 25);
		lastNameTF.setFont(new Font("Tahoma", Font.BOLD, 15));
		lastNameTF.setCaretColor(Color.BLACK);
		lastNameTF.addFocusListener(new FocusListener() {
	            @Override
	            public void focusGained(FocusEvent e) {
	                // Reset border color to BLACK when the text field gains focus
	            	lastNameTF.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	            }

	            @Override
	            public void focusLost(FocusEvent e) {
	                // Set border color to red if the text field is empty
	                if (lastNameTF.getText().isEmpty()) {
	                	lastNameTF.setBorder(BorderFactory.createLineBorder(Color.RED));
	                    text_2.setText("You need to fill this up!");
	                } else {
	                	lastNameTF.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	                    text_2.setText("");
	                }
	            }
	        });
		
		text_2 = new JLabel();
		text_2.setForeground(Color.RED);
		text_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		text_2.setBounds(710, 52, 273, 25);



		//Student Number
		studentIDLabel = new JLabel("STUDENT NUMBER:");
		studentIDLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		studentIDLabel.setForeground(Color.WHITE);
		studentIDLabel.setBounds(15, 80, 250, 25);

		//Student Number Box
		studentIDTF = new JTextField();
		studentIDTF.setBackground(Color.WHITE);
		studentIDTF.setBounds(270, 80, 180, 25);
		studentIDTF.setFont(new Font("Tahoma", Font.BOLD, 15));
		studentIDTF.setCaretColor(Color.BLACK);
		studentIDTF.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Reset border color to BLACK when the text field gains focus
            	studentIDTF.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Set border color to red if the text field is empty
                if (studentIDTF.getText().isEmpty()) {
                	studentIDTF.setBorder(BorderFactory.createLineBorder(Color.RED));
                    text_3.setText("You need to fill this up!");
                } else {
                	studentIDTF.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    text_3.setText("");
                }
            }
        });
		
		text_3 = new JLabel();
		text_3.setForeground(Color.RED);
		text_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		text_3.setBounds(270, 102, 273, 25);
		

		//Section
		sectionLabel = new JLabel("SECTION:");
		sectionLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		sectionLabel.setForeground(Color.WHITE);
		sectionLabel.setBounds(473, 80, 250, 25);

		//Section Box
		sectionTF = new JTextField();
		sectionTF.setBackground(Color.WHITE);
		sectionTF.setBounds(610, 80, 180, 25);
		sectionTF.setFont(new Font("Tahoma", Font.BOLD, 15));
		sectionTF.setCaretColor(Color.BLACK);
		sectionTF.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Reset border color to BLACK when the text field gains focus
            	sectionTF.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Set border color to red if the text field is empty
                if (sectionTF.getText().isEmpty()) {
                	sectionTF.setBorder(BorderFactory.createLineBorder(Color.RED));
                    text_4.setText("You need to fill this up!");
                } else {
                	sectionTF.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    text_4.setText("");
                }
            }
        });
		
		text_4 = new JLabel();
		text_4.setForeground(Color.RED);
		text_4.setFont(new Font("Tahoma", Font.BOLD, 10));
		text_4.setBounds(610, 102, 273, 25);

		//Year
		yearLabel = new JLabel("YEAR:");
		yearLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		yearLabel.setForeground(Color.WHITE);
		yearLabel.setBounds(810, 80, 150, 25);
		
		String years[] = {"1", "2", "3", "4"};
		
		yearCB = new JComboBox(years);
		yearCB.setForeground(Color.BLACK);
		yearCB.setBackground(Color.WHITE);
		((JLabel) yearCB.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		yearCB.setBounds(895, 80, 93, 25);




		//Email
		emailLabel = new JLabel("EMAIL:");
		emailLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		emailLabel.setForeground(Color.WHITE);
		emailLabel.setBounds(15, 130, 110, 25);
		
		//Email Box
		emailTF = new JTextField();
		emailTF.setBackground(Color.WHITE);
		emailTF.setBounds(115, 130, 310, 25);
		emailTF.setFont(new Font("Tahoma", Font.BOLD, 15));
		emailTF.setCaretColor(Color.BLACK);
		emailTF.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Reset border color to BLACK when the text field gains focus
            	emailTF.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Set border color to red if the text field is empty
                if (emailTF.getText().isEmpty()) {
                	emailTF.setBorder(BorderFactory.createLineBorder(Color.RED));
                    text_5.setText("You need to fill this up!");
                } else {
                	emailTF.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    text_5.setText("");
                }
            }
        });
		
		text_5 = new JLabel();
		text_5.setForeground(Color.RED);
		text_5.setFont(new Font("Tahoma", Font.BOLD, 10));
		text_5.setBounds(115, 151, 273, 25);
		
		
		//Department
		departmentLabel = new JLabel("DEPARTMENT:");
		departmentLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		departmentLabel.setForeground(Color.WHITE);
		departmentLabel.setBounds(450, 130, 200, 25);
	
		String department[] = {"College of Allied Health", 
								"College of Architecture", 
								"College of Business and Accountancy", 
								"College of Computing and Information Technologies", 
								"College of Education, Arts and Sciences", 
								"College of Engineering"};
		
		departmentCB = new JComboBox(department);
		departmentCB.setForeground(Color.BLACK);
		departmentCB.setBackground(Color.WHITE);
		((JLabel) departmentCB.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		departmentCB.setBounds(645, 130, 344, 25);


		

		//Course
		courseLabel = new JLabel("COURSE:");
		courseLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		courseLabel.setForeground(Color.WHITE);
		courseLabel.setBounds(15, 180, 130, 25);
		
		//Course Box
		courseTF = new JTextField();
		courseTF.setBackground(Color.WHITE);
		courseTF.setBounds(140, 180, 850, 25);
		courseTF.setFont(new Font("Tahoma", Font.BOLD, 15));
		courseTF.setCaretColor(Color.BLACK);
		courseTF.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Reset border color to BLACK when the text field gains focus
            	courseTF.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Set border color to red if the text field is empty
                if (courseTF.getText().isEmpty()) {
                	courseTF.setBorder(BorderFactory.createLineBorder(Color.RED));
                    text_6.setText("You need to fill this up!");
                } else {
                	courseTF.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    text_6.setText("");
                }
            }
        });
		
		text_6 = new JLabel();
		text_6.setForeground(Color.RED);
		text_6.setFont(new Font("Tahoma", Font.BOLD, 10));
		text_6.setBounds(140, 202, 273, 25);




		//Contact Number
		contactNumberLabel = new JLabel("CONTACT NUMBER:");
		contactNumberLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		contactNumberLabel.setForeground(Color.WHITE);
		contactNumberLabel.setBounds(15, 230, 250, 25);
		
		contactTF = new JTextField();
		contactTF.setBackground(Color.WHITE);
		contactTF.setBounds(275, 230, 273, 25);
		contactTF.setFont(new Font("Tahoma", Font.BOLD, 15));
		contactTF.setCaretColor(Color.BLACK);
		contactTF.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Reset border color to BLACK when the text field gains focus
            	contactTF.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Set border color to red if the text field is empty
                if (contactTF.getText().isEmpty()) {
                	contactTF.setBorder(BorderFactory.createLineBorder(Color.RED));
                	text_7.setText("You need to fill this up!");
                } else {
                	contactTF.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                	text_7.setText("");
                }
            }
        });
		
		text_7 = new JLabel();
		text_7.setForeground(Color.RED);
		text_7.setFont(new Font("Tahoma", Font.BOLD, 10));
		text_7.setBounds(275, 252, 273, 25);





		//Date Today
		dateLabel = new JLabel("DATE TODAY:");
		dateLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		dateLabel.setForeground(Color.WHITE);
		dateLabel.setBounds(580, 230, 180, 25);
		
		String month[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		
		datemonthCB = new JComboBox(month);
		datemonthCB.setForeground(Color.BLACK);
		datemonthCB.setBackground(Color.WHITE);
		((JLabel) datemonthCB.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		datemonthCB.setBounds(765, 230, 93, 25);

		String days[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", 
						 "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", 
						 "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };

		datedayCB = new JComboBox(days);
		datedayCB.setForeground(Color.BLACK);
		datedayCB.setBackground(Color.WHITE);
		((JLabel) datedayCB.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		datedayCB.setBounds(864, 230, 50, 25);

		String yearsy[] = {"2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032"};

		dateyearCB = new JComboBox(yearsy);
		dateyearCB.setForeground(Color.BLACK);
		dateyearCB.setBackground(Color.WHITE);
		((JLabel) dateyearCB.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		dateyearCB.setBounds(920, 230, 70, 25);


		// Checking Information to Register
		register = new JButton("REGISTER");
		register.setHorizontalAlignment(SwingConstants.CENTER);
		register.setFont(new Font("Tahoma", Font.BOLD, 15));
		register.setBackground(Color.ORANGE);
		register.setForeground(Color.BLACK);
		register.setBounds(860, 280, 130, 25);
		register.setFocusable(false);
		register.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            if (e.getSource() == register) {
	                // Validate the form fields
	                boolean isValid = validateFields();
	                if (isValid) {
	                	String firstName = firstNameTF.getText();
                                String middleName = middleNameTF.getText();
	                	String lastName = lastNameTF.getText();
                                String studentID = studentIDTF.getText();
				String section = sectionTF.getText();
				String email = emailTF.getText();
				String course = courseTF.getText();
	                	String contactNumber = contactTF.getText();
	                	String yearlevel = (String) yearCB.getSelectedItem();
				String departments = (String) departmentCB.getSelectedItem();
				String months = (String) datemonthCB.getSelectedItem();
				String days = (String) datedayCB.getSelectedItem();
				String years = (String) dateyearCB.getSelectedItem();
                                String department = String.valueOf(departments);
				String datemonth = String.valueOf(months);
	                	int year = Integer.parseInt(yearlevel);
				int dateday = Integer.parseInt(days);
				int dateyear = Integer.parseInt(years);
	                	
	                	Users users = new Users(firstName, middleName, lastName, studentID, section, department, email, course, year, contactNumber, datemonth, dateday, dateyear);
	                    
	                    // Show success message
	                    JOptionPane.showMessageDialog(null, "Registered Successful!", "Registration", JOptionPane.PLAIN_MESSAGE);
	                    
	                    UserManagement userManagement = new UserManagement(firstName, middleName, lastName, studentID, section, department, email, course, year, contactNumber, datemonth, dateday, dateyear);
	                    
	                    userManagement.addUsers(users);

	                    // Clear fields and perform other actions if needed
	                    clearFields();
	                    homeFrame.dispose();
                            
	                    DocumentRequestFrame documents = new DocumentRequestFrame("NU Document Request Management System");
	                }
	            }
	        }
	    });

		
		clear = new JButton("CLEAR");
		clear.setHorizontalAlignment(SwingConstants.CENTER);
		clear.setFont(new Font("Tahoma", Font.BOLD, 15));
		clear.setBackground(Color.BLACK);
		clear.setForeground(Color.WHITE);
		clear.setBounds(720, 280, 130, 25);
		clear.setFocusable(false);
		clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == clear) {
                        clearFields();   
                }
            }
        });
		
		registerPanel.add(NameLabel);
		registerPanel.add(firstNameLabel);
		registerPanel.add(middleNameLabel);
		registerPanel.add(lastNameLabel);
		registerPanel.add(studentIDLabel);
		registerPanel.add(sectionLabel);
		registerPanel.add(contactNumberLabel);
		registerPanel.add(departmentLabel);
		registerPanel.add(emailLabel);
		registerPanel.add(courseLabel);
		registerPanel.add(dateLabel);
		registerPanel.add(firstNameTF);
		registerPanel.add(middleNameTF);
		registerPanel.add(lastNameTF);
		registerPanel.add(contactTF);
		registerPanel.add(studentIDTF);
		registerPanel.add(sectionTF);
		registerPanel.add(courseTF);
		registerPanel.add(departmentCB);
		registerPanel.add(emailTF);
		registerPanel.add(yearLabel);
		registerPanel.add(yearCB);
		registerPanel.add(departmentCB);
		registerPanel.add(datemonthCB);
		registerPanel.add(datedayCB);
		registerPanel.add(dateyearCB);
		registerPanel.add(register);
		registerPanel.add(clear);
		registerPanel.add(text_0);
		registerPanel.add(text_1);
		registerPanel.add(text_2);
		registerPanel.add(text_3);
		registerPanel.add(text_4);
		registerPanel.add(text_5);
		registerPanel.add(text_6);
		registerPanel.add(text_7);

		layeredPane.add(registerPanel, Integer.valueOf(1));
		layeredPane.add(registrationBGPanel.getPanel(), Integer.valueOf(0));
		
		addLP(layeredPane);
	}
	
	private boolean validateFields() {
        String first_name = firstNameTF.getText();
	String middle_name = middleNameTF.getText();
        String last_name = lastNameTF.getText();
        String studentID = studentIDTF.getText();
	String section = sectionTF.getText();
        String email = emailTF.getText();
	String course = courseTF.getText();
        String contactNumber = contactTF.getText();

    // Define regex patterns for validation
    	String namePattern = "^[A-Za-z\\s]+$";
     	String studentIDPattern = "^\\d{4}-\\d{6}$";
	String sectionPattern = "^[A-Z]{3}\\d{3}$";
        String emailPattern = "^\\w+@students\\.national-u\\.edu\\.ph$";
	String coursePattern = "^Bachelor [A-Za-z]+(\\s[A-Za-z]+)*$";
     	String contactNumberPattern = "^\\d{11}$";

        // Validate fields
        if (!validateField(first_name, namePattern, "First Name")) {
            return false;
        }

		if (!validateField(middle_name, namePattern, "Middle Name")) {
            return false;
        }
        
        if (!validateField(last_name, namePattern, "Last Name")) {
            return false;
        }
        
        if (!validateField(studentID, studentIDPattern, "Student ID")) {
            return false;
        }

		if (!validateField(section, sectionPattern, "Section")) {
            return false;
        }
        
        if (!validateField(email, emailPattern, "Email")) {
            return false;
        }

		if (!validateField(course, coursePattern, "Course")) {
            return false;
        }
        
        if (!validateField(contactNumber, contactNumberPattern, "Contact Number")) {
            return false;
        }
        return true;
    }

    private boolean validateField(String fieldValue, String pattern, String fieldName) {
        Pattern regexPattern = Pattern.compile(pattern);
        Matcher matcher = regexPattern.matcher(fieldValue);
        boolean isValid = matcher.matches();
        if (!isValid) {
            JOptionPane.showMessageDialog(null, "Invalid " + fieldName, "Validation Error", JOptionPane.ERROR_MESSAGE);
        }
        return isValid;
    }
    
    void clearFields() {
        firstNameTF.setText("");
	middleNameTF.setText("");
        lastNameTF.setText("");
        studentIDTF.setText("");
	sectionTF.setText("");
        emailTF.setText("");
	courseTF.setText("");
        contactTF.setText("");
    }
    
    private String getFirstname(){
        String firstName = null;
        return firstName;
    }
}