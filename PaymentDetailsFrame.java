package project;

import java.awt.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

public class PaymentDetailsFrame extends JFrame implements ActionListener {
    private JPanel topPanel, topLeftPanel, topRightPanel;
    private ImageIcon logo;
    private Image image, resizedImage;
    private JLabel logoLabel, docuRequestLabel, accNameLabel, text_0, text_1, text_2, text_3, text_4, text_5, text_6, text_7, transactNumLabel, amtPaidLabel, MoPLabel, dateLabel;
    private JLayeredPane layeredPane;
    private JPanel qrPanel;
    private PaymentPanel paymentPanel;
    private JMenu menu;
    private JMenuBar menuBar;
    private JMenuItem logout;
    private JButton continueButton, backButton;
    private JTextField accNameTF, transactNumTF, amtPaidTF;
    private JComboBox MoPCB, datedayCB, datemonthCB, dateyearCB;


    PaymentDetailsFrame(String title) {
        setTitle("NU Document Request Management System");

        topPanel = new JPanel();
        topPanel.setBackground(new Color(0x293478));
        topPanel.setBounds(0, 0, 1185, 80);
        topPanel.setLayout(new BorderLayout());

        topLeftPanel = new JPanel();
        topLeftPanel.setBackground(new Color(0x293478));
        topLeftPanel.setPreferredSize(new Dimension(450, 80));
        topLeftPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 20, 5));

        logo = new ImageIcon("C:\\Users\\Charles\\Downloads\\NU LOGO.png");
        image = logo.getImage();
        resizedImage = image.getScaledInstance(100, 70, java.awt.Image.SCALE_SMOOTH);
        logo = new ImageIcon(resizedImage);

        logoLabel = new JLabel("NATIONAL UNIVERSITY");
        logoLabel.setFont(new java.awt.Font("Tahoma", Font.BOLD, 20));        logoLabel.setIconTextGap(10);
        logoLabel.setForeground(Color.WHITE);
        logoLabel.setIcon(logo);

        docuRequestLabel = new JLabel("Payment Details");
        docuRequestLabel.setFont(new java.awt.Font("Tahoma", Font.BOLD, 18));
        docuRequestLabel.setIconTextGap(10);
        docuRequestLabel.setForeground(Color.WHITE);
        docuRequestLabel.setBounds(3, 5, 5, 5);

        topLeftPanel.add(logoLabel);

        topRightPanel = new JPanel();
        topRightPanel.setBackground(new Color(0x293478));
        topRightPanel.setPreferredSize(new Dimension(1000, 80));
        topRightPanel.setLayout(new FlowLayout(FlowLayout.TRAILING, 10, 0));

        menu = new JMenu("Menu");
        menu.setPreferredSize(new Dimension(100, 80));
        menu.setHorizontalTextPosition(SwingConstants.CENTER);
        menu.setFont(new Font("Tahoma", Font.BOLD, 18));
        menu.setForeground(Color.WHITE);
        menu.setFocusable(false);
        menu.setBorderPainted(false);
        menu.addActionListener(this);

        menuBar = new JMenuBar();
        menuBar.setBackground(new Color(0x293478));

        logout = new JMenuItem("LOGOUT");
        logout.setOpaque(true);
        logout.setBackground(new Color(0XFF3333));
        logout.setFont(new Font("Tahoma", Font.BOLD, 18));
        logout.setPreferredSize(new Dimension(100, 20));
        logout.setForeground(Color.WHITE);
        logout.setFocusable(false);
        logout.setBorderPainted(false);
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == logout) {
                    int leave = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Logout",
                            JOptionPane.YES_NO_OPTION);
                    if (leave == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null,
                                "Thank you for using NU Bulldog Exchange Queueing Management!");

                        dispose();
                        HomeFrame home = new HomeFrame("");
                    }
                }
            }
        });

        menu.add(logout);
        menuBar.add(menu);

        topRightPanel.add(docuRequestLabel);
        topRightPanel.add(menuBar);

        topPanel.add(topLeftPanel, BorderLayout.WEST);
        topPanel.add(topRightPanel, BorderLayout.EAST);

        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 80, 1185, 585);

        paymentPanel = new PaymentPanel(0x001840);
        paymentPanel.addImage("C:\\Users\\Charles\\Documents\\NetBeansProjects\\Student Docqueue\\PaymentDetailsBG.png", 1185, 585);

        layeredPane.add(paymentPanel.getPanel(), Integer.valueOf(1));
        
        accNameLabel = new JLabel("ACCOUNT NAME:");
	accNameLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
	accNameLabel.setForeground(Color.WHITE);
	accNameLabel.setBounds(415, 295, 500, 25);
        
        accNameTF = new JTextField();
        accNameTF = new JTextField();
	accNameTF.setBounds(630, 295, 450, 25);
	accNameTF.setBackground(Color.WHITE);
	accNameTF.setFont(new Font("Tahoma", Font.BOLD, 15));
	accNameTF.setCaretColor(Color.BLACK);
        accNameTF.addFocusListener(new FocusListener() {
	            @Override
	            public void focusGained(FocusEvent e) {
	                // Reset border color to BLACK when the text field gains focus
	            	accNameTF.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	            }
	            @Override
	            public void focusLost(FocusEvent e) {
	                // Set border color to red if the text field is empty
	                if (accNameTF.getText().isEmpty()) {
	                	accNameTF.setBorder(BorderFactory.createLineBorder(Color.RED));
	                	text_0.setText("You need to fill this up!");
	                } else {
	                	accNameTF.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	                	text_0.setText("");
	                }
	            }
	        });
		
		text_0 = new JLabel();
		text_0.setForeground(Color.RED);
		text_0.setFont(new Font("Tahoma", Font.BOLD, 10));
		text_0.setBounds(630, 315, 273, 25);
                
                        //Transaction Number
	transactNumLabel = new JLabel("TRANSACTION NUMBER:");
	transactNumLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
	transactNumLabel.setForeground(Color.WHITE);
	transactNumLabel.setBounds(415, 350, 400, 25);
	//Transaction Number Box
	transactNumTF = new JTextField();
	transactNumTF.setBackground(Color.WHITE);
	transactNumTF.setBounds(730, 350, 350, 25);
	transactNumTF.setFont(new Font("Tahoma", Font.BOLD, 15));
	transactNumTF.setCaretColor(Color.BLACK);
        transactNumTF.addFocusListener(new FocusListener() {
	            @Override
	            public void focusGained(FocusEvent e) {
	                // Reset border color to BLACK when the text field gains focus
	            	transactNumTF.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	            }

	            @Override
	            public void focusLost(FocusEvent e) {
	                // Set border color to red if the text field is empty
	                if (transactNumTF.getText().isEmpty()) {
	                	transactNumTF.setBorder(BorderFactory.createLineBorder(Color.RED));
	                	text_1.setText("You need to fill this up!");
	                } else {
	                	transactNumTF.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	                	text_1.setText("");
	                }
	            }
	        });
		
		text_1 = new JLabel();
		text_1.setForeground(Color.RED);
		text_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		text_1.setBounds(730, 370, 273, 25);
	
        //Amount Paid
	amtPaidLabel = new JLabel("AMOUNT PAID:");
	amtPaidLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
	amtPaidLabel.setForeground(Color.WHITE);
	amtPaidLabel.setBounds(415, 405, 250, 25);
	//Amount Paid Box
	amtPaidTF = new JTextField();
	amtPaidTF.setBackground(Color.WHITE);
	amtPaidTF.setBounds(610, 405, 100, 25);
	amtPaidTF.setFont(new Font("Tahoma", Font.BOLD, 15));
	amtPaidTF.setCaretColor(Color.BLACK);
        amtPaidTF.addFocusListener(new FocusListener() {
	            @Override
	            public void focusGained(FocusEvent e) {
	                // Reset border color to BLACK when the text field gains focus
	            	amtPaidTF.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	            }

	            @Override
	            public void focusLost(FocusEvent e) {
	                // Set border color to red if the text field is empty
	                if (amtPaidTF.getText().isEmpty()) {
	                	amtPaidTF.setBorder(BorderFactory.createLineBorder(Color.RED));
	                    text_2.setText("You need to fill this up!");
	                } else {
	                	amtPaidTF.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	                    text_2.setText("");
	                }
	            }
	        });
		
		text_2 = new JLabel();
		text_2.setForeground(Color.RED);
		text_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		text_2.setBounds(610, 425, 273, 25);
        
        //MoP
	MoPLabel = new JLabel("MODE OF PAYMENT:");
	MoPLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
	MoPLabel.setForeground(Color.WHITE);
	MoPLabel.setBounds(720, 405, 300, 25);
		
	String MoP[] = {"GCASH", "MAYA", "Bank Transfer"};
	
	MoPCB = new JComboBox(MoP);
	MoPCB.setForeground(Color.BLACK);
	MoPCB.setBackground(Color.WHITE);
	((JLabel) MoPCB.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
	MoPCB.setBounds(980, 405, 100, 25);
        
        //Date Today
	dateLabel = new JLabel("DATE TODAY:");
	dateLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
	dateLabel.setForeground(Color.WHITE);
	dateLabel.setBounds(415, 460, 180, 25);
		
	String month[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	
	datemonthCB = new JComboBox(month);
	datemonthCB.setForeground(Color.BLACK);
	datemonthCB.setBackground(Color.WHITE);
	((JLabel) datemonthCB.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
	datemonthCB.setBounds(600, 460, 150, 25);

        String days[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", 
		 "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", 
		 "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };

	datedayCB = new JComboBox(days);
	datedayCB.setForeground(Color.BLACK);
	datedayCB.setBackground(Color.WHITE);
	((JLabel) datedayCB.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
	datedayCB.setBounds(765, 460, 150, 25);

	String years[] = {"2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032"};

	dateyearCB = new JComboBox(years);
	dateyearCB.setForeground(Color.BLACK);
	dateyearCB.setBackground(Color.WHITE);
	((JLabel) dateyearCB.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
	dateyearCB.setBounds(930, 460, 150, 25);

        layeredPane.add(accNameLabel, Integer.valueOf(4));
        layeredPane.add(accNameTF, Integer.valueOf(4));
        layeredPane.add(text_0, Integer.valueOf(4));
        layeredPane.add(transactNumLabel, Integer.valueOf(4));
        layeredPane.add(transactNumTF, Integer.valueOf(4));
        layeredPane.add(text_1, Integer.valueOf(4));
        layeredPane.add(amtPaidLabel, Integer.valueOf(4));
        layeredPane.add(amtPaidTF, Integer.valueOf(4));
        layeredPane.add(text_2, Integer.valueOf(4));
        layeredPane.add(MoPCB, Integer.valueOf(4));
        layeredPane.add(MoPLabel, Integer.valueOf(4));
        layeredPane.add(dateLabel, Integer.valueOf(4));
        layeredPane.add(datedayCB, Integer.valueOf(4));
        layeredPane.add(datemonthCB, Integer.valueOf(4));
        layeredPane.add(dateyearCB, Integer.valueOf(4));
        
        continueButton = new JButton("Continue");
        continueButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        continueButton.setBackground(new Color(0xF9B60E));
        continueButton.setForeground(Color.white);
        continueButton.setFocusable(false);
        continueButton.setBounds(975, 535, 100, 25); // Set the dimensions and position of the button
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == continueButton) {
                    // Validate the form fields
                    boolean isValid = validateFields();
                    if (isValid) {
                        String accName = accNameTF.getText();
                        String transactionNo = transactNumTF.getText();
                        String amtPaid = amtPaidTF.getText();
                        JOptionPane.showMessageDialog(null, 
                                "Thanks for your confirmation!", "Payment Details", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        ReservationFrame reserve = new ReservationFrame("NU Document Request Management System");
                    }
                }
            }
        });
                
        
        backButton = new JButton("Back");
        backButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        backButton.setBackground(new Color(0xF9B60E));
        backButton.setForeground(Color.white);
        backButton.setFocusable(false);
        backButton.setBounds(825, 535, 100, 25);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                PaymentFrame payment = new PaymentFrame ("NU Document Request Management System");
            }
        });
        
        
        layeredPane.add(continueButton, Integer.valueOf(4));
        layeredPane.add(backButton, Integer.valueOf(4));
        
        add(topPanel);
        add(layeredPane);

        setSize(new Dimension(1200, 700));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }
    
    private boolean validateFields() {
        String accName = accNameTF.getText();
	String transactionNo = transactNumTF.getText();
        String amtPaid = amtPaidTF.getText();
        
    	String accNamePattern = "^[A-Za-z\\s]+$";
     	String transactionNoPattern = "^\\d{1,15}$";
	String amtPaidPattern = "^\\d+\\.00$";
        

        // Validate fields
        if (!validateField(accName, accNamePattern, "Account Name")) {
            return false;
        }

	if (!validateField(transactionNo, transactionNoPattern, "Transaction Number")) {
            return false;
        }
        
        if (!validateField(amtPaid, amtPaidPattern, "Amount Paid")) {
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(menu)) {
            menu.setForeground(Color.orange);
        }
    }

    public static void main(String[] args) {
        PaymentDetailsFrame paymentDetailsFrame = new PaymentDetailsFrame("NU Document Request Management System");
        paymentDetailsFrame.setVisible(true);
    }
}
