package project;

import Project.ReservationSummaryFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ReservationFrame extends JFrame implements ActionListener {
    private JPanel topPanel, topLeftPanel, topRightPanel;
    private ImageIcon logo;
    private Image image, resizedImage;
    private JLabel logoLabel, docuRequestLabel;
    private JLayeredPane layeredPane;
    private PaymentPanel paymentPanel;
    private JMenu menu;
    private JMenuBar menuBar;
    private JMenuItem logout;
    
    private JPanel slotReservationPanel;
    private JLabel slotReservationLabel, slotReservationMessageLabel;
    private JLabel dateNote, purposeLabel, selectDateLabel, monthLabel, dayLabel, yearLabel, amLabel, pmLabel, selectTimeLabel, calendarLabel;
    private ImageIcon calendar[];
    private JComboBox monthsCB, purposeCB, daysCB;
    private JTextField yearTF;
    private JButton nextButton, previousButton, confirmButton;
    private JRadioButton time_1, time_2, time_3, time_4, time_5;
    private ReservationSummaryFrame reservationSummary;
    int i;
    
    ReservationFrame(String title) {
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
        logoLabel.setFont(new java.awt.Font("Tahoma", Font.BOLD, 20));        
        logoLabel.setIconTextGap(10);
        logoLabel.setForeground(Color.WHITE);
        logoLabel.setIcon(logo);

        docuRequestLabel = new JLabel("Reservation");
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
        menu.setPreferredSize(new Dimension(150, 80));
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
        logout.setPreferredSize(new Dimension(150, 20));
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
        paymentPanel.addImage("C:\\Users\\Charles\\Documents\\NetBeansProjects\\Student Docqueue\\ReservationBG.png", 1185, 585);

        layeredPane.add(paymentPanel.getPanel(), Integer.valueOf(1));
        				
        purposeLabel = new JLabel("PURPOSE:");
	purposeLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
	purposeLabel.setForeground(Color.white);
	purposeLabel.setBounds(620, 500, 150, 20);
        
	String purposes[] = {"Claiming of Documents", "Returning of Documents"};
		
	purposeCB = new JComboBox(purposes);
	purposeCB.setForeground(Color.BLACK);
	purposeCB.setBackground(Color.WHITE);
	purposeCB.setBounds(760, 500, 200, 25);
        
        selectDateLabel = new JLabel("SELECT DATE:");
        selectDateLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
        selectDateLabel.setForeground(Color.white);
        selectDateLabel.setBounds(620, 240, 250, 20);
        
        dateNote = new JLabel("(NOTE: Tuesday and Friday are the only days of claiming)");
        dateNote.setFont(new Font("Tahoma", Font.BOLD, 10));
        dateNote.setForeground(Color.white);
        dateNote.setBounds(800, 240, 300, 20);
        
        String months[] = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };

        monthsCB = new JComboBox(months);
        monthsCB.setForeground(Color.BLACK);
        monthsCB.setBackground(Color.WHITE);
        ((JLabel) monthsCB.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        monthsCB.setBounds(620, 280, 150, 25);
        
        String[] daysOfMonth = new String[31];

        for (int i = 0; i < 31; i++) {
            daysOfMonth[i] = Integer.toString(i + 1);
        }

        daysCB = new JComboBox(daysOfMonth);
        daysCB.setForeground(Color.BLACK);
        daysCB.setBackground(Color.WHITE);
        ((JLabel) daysCB.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        daysCB.setBounds(780, 280, 150, 25);
        
        yearTF = new JTextField("2023");
        yearTF.setForeground(Color.BLACK);
        yearTF.setBackground(Color.WHITE);
        yearTF.setFont(new Font(null, Font.BOLD, 12));
        yearTF.setHorizontalAlignment(SwingConstants.CENTER);
        yearTF.setEditable(false);
        yearTF.setBounds(940, 280, 150, 25);
        
        selectTimeLabel = new JLabel("AVAILABLE SLOTS:");
        selectTimeLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
        selectTimeLabel.setForeground(Color.white);
        selectTimeLabel.setBounds(620, 330, 250, 20);

        amLabel = new JLabel("AM SCHEDULE");
        amLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        amLabel.setHorizontalAlignment(SwingConstants.LEFT);
        amLabel.setForeground(Color.white);
        amLabel.setBounds(685, 370, 120, 20);

        pmLabel = new JLabel("PM SCHEDULE");
        pmLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        pmLabel.setHorizontalAlignment(SwingConstants.LEFT);
        pmLabel.setForeground(Color.white);
        pmLabel.setBounds(930, 370, 150, 20);
        
        time_1 = new JRadioButton("08:30 AM to 09:30 AM");
        time_1.setBounds(620, 400, 235, 20);
        time_1.setFont(new Font(null, Font.BOLD, 20));
        time_1.setForeground(Color.white);
        time_1.setBackground(new Color(0x001840));
        time_1.setFocusable(false);
        time_1.addActionListener(this);

        time_2 = new JRadioButton("09:30 AM to 10:30 AM");
        time_2.setBounds(620, 430, 235, 20);
        time_2.setFont(new Font(null, Font.BOLD, 20));
        time_2.setForeground(Color.white);
        time_2.setBackground(new Color(0x001840));
        time_2.setFocusable(false);
        time_2.addActionListener(this);

        time_3 = new JRadioButton("10:30 AM to 11:30 AM");
        time_3.setBounds(620, 460, 235, 20);
        time_3.setFont(new Font(null, Font.BOLD, 20));
        time_3.setForeground(Color.white);
        time_3.setBackground(new Color(0x001840));
        time_3.setFocusable(false);
        time_3.addActionListener(this);

        time_4 = new JRadioButton("01:00 PM to 02:00 PM");
        time_4.setBounds(870, 400, 235, 20);
        time_4.setFont(new Font(null, Font.BOLD, 20));
        time_4.setForeground(Color.white);
        time_4.setBackground(new Color(0x001840));
        time_4.setFocusable(false);
        time_4.addActionListener(this);

        time_5 = new JRadioButton("02:00 PM to 03:30 PM");
        time_5.setBounds(870, 430, 235, 20);
        time_5.setFont(new Font(null, Font.BOLD, 20));
        time_5.setForeground(Color.white);
        time_5.setBackground(new Color(0x001840));
        time_5.setFocusable(false);
        time_5.addActionListener(this);

        ButtonGroup timeOptions = new ButtonGroup();
        timeOptions.add(time_1);
        timeOptions.add(time_2);
        timeOptions.add(time_3);
        timeOptions.add(time_4);
        timeOptions.add(time_5);

        confirmButton = new JButton("Confirm");
        confirmButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        confirmButton.setBackground(new Color(0xF9B60E));
        confirmButton.setForeground(Color.white);
        confirmButton.setFocusable(false);
        confirmButton.setBounds(980, 500, 100, 25); // Set the dimensions and position of the button
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean reservationConfirmed = false;
                if (e.getSource().equals(confirmButton)) {
                    if (!time_1.isSelected() && !time_2.isSelected() && !time_3.isSelected() && !time_4.isSelected() && !time_5.isSelected()) {
                        JOptionPane.showMessageDialog(null, "You need to select one time option!", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        int confirmation = JOptionPane.showConfirmDialog(null, "Do you want to confirm your reservation?", "Reservation Confirmation", JOptionPane.YES_NO_OPTION);
                        if (confirmation == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(null, "Reservation confirmed!");
                            reservationConfirmed = true;
                            String date = getDate();
                            String time = getTime();
                            String purpose = getPurpose();
                            reservationSummary = new ReservationSummaryFrame(purpose, date, time);
                            reservationSummary.setVisible(true);
                        } else {
                            reservationConfirmed = false;
                        }
                    }
                }
            }
        });
        
        calendarLabel = new JLabel();
        calendarLabel.setBounds(83, 135, 800, 450);

        calendar = new ImageIcon[12];
        calendar[0] = new ImageIcon("C:\\Users\\Charles\\Documents\\NetBeansProjects\\Student Docqueue\\BE Calendar 2023\\JANUARY.png");
        calendar[1] = new ImageIcon("C:\\Users\\Charles\\Documents\\NetBeansProjects\\Student Docqueue\\BE Calendar 2023\\FEBRUARY.png");
        calendar[2] = new ImageIcon("C:\\Users\\Charles\\Documents\\NetBeansProjects\\Student Docqueue\\BE Calendar 2023\\MARCH.png");
        calendar[3] = new ImageIcon("C:\\Users\\Charles\\Documents\\NetBeansProjects\\Student Docqueue\\BE Calendar 2023\\APRIL.png");
        calendar[4] = new ImageIcon("C:\\Users\\Charles\\Documents\\NetBeansProjects\\Student Docqueue\\BE Calendar 2023\\MAY.png");
        calendar[5] = new ImageIcon("C:\\Users\\Charles\\Documents\\NetBeansProjects\\Student Docqueue\\BE Calendar 2023\\JUNE.png");
        calendar[6] = new ImageIcon("C:\\Users\\Charles\\Documents\\NetBeansProjects\\Student Docqueue\\BE Calendar 2023\\JULY.png");
        calendar[7] = new ImageIcon("C:\\Users\\Charles\\Documents\\NetBeansProjects\\Student Docqueue\\BE Calendar 2023\\AUGUST.png");
        calendar[8] = new ImageIcon("C:\\Users\\Charles\\Documents\\NetBeansProjects\\Student Docqueue\\BE Calendar 2023\\SEPTEMBER.png");
        calendar[9] = new ImageIcon("C:\\Users\\Charles\\Documents\\NetBeansProjects\\Student Docqueue\\BE Calendar 2023\\OCTOBER.png");
        calendar[10] = new ImageIcon("C:\\Users\\Charles\\Documents\\NetBeansProjects\\Student Docqueue\\BE Calendar 2023\\NOVEMBER.png");
        calendar[11] = new ImageIcon("C:\\Users\\Charles\\Documents\\NetBeansProjects\\Student Docqueue\\BE Calendar 2023\\DECEMBER.png");

        int desiredWidth = 480;
        int desiredHeight = 260; 

        for (int i = 0; i < calendar.length; i++) {
            Image originalImage = calendar[i].getImage();
            Image resizedImage = originalImage.getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);
            calendar[i] = new ImageIcon(resizedImage); 
        }

        calendarLabel.setIcon(calendar[0]);
        
        nextButton = new JButton("Next");
        nextButton.setHorizontalAlignment(SwingConstants.CENTER);
        nextButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        nextButton.setBackground(new Color(0xF9B60E));
        nextButton.setForeground(Color.WHITE);
        nextButton.setBounds(330, 505, 100, 25);
        nextButton.setFocusable(false);
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == nextButton) {
                    if (i == calendar.length - 1) {
                    } else {
                        i = i + 1;
                        calendarLabel.setIcon(calendar[i]);
                    }
                }
            }
        });
        
        previousButton = new JButton("Previous");
        previousButton.setHorizontalAlignment(SwingConstants.CENTER);
        previousButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        previousButton.setBackground(new Color(0xF9B60E));
        previousButton.setForeground(Color.WHITE);
        previousButton.setBounds(210, 505, 100, 25);
        previousButton.setFocusable(false);
        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == previousButton) {
                    if (i == 0) {
                    } else {
                        i = i - 1;
                        calendarLabel.setIcon(calendar[i]);
                    }
                }
            }
        });
        
        layeredPane.add(confirmButton, Integer.valueOf(4));
        layeredPane.add(selectDateLabel, Integer.valueOf(4));
        layeredPane.add(dateNote, Integer.valueOf(4));
        layeredPane.add(monthsCB, Integer.valueOf(4));
        layeredPane.add(daysCB, Integer.valueOf(4));
        layeredPane.add(yearTF, Integer.valueOf(4));
        layeredPane.add(selectTimeLabel, Integer.valueOf(4));
        layeredPane.add(purposeCB, Integer.valueOf(4));
        layeredPane.add(amLabel, Integer.valueOf(4));
        layeredPane.add(pmLabel, Integer.valueOf(4));
        layeredPane.add(time_1, Integer.valueOf(4));
        layeredPane.add(time_2, Integer.valueOf(4));
        layeredPane.add(time_3, Integer.valueOf(4));
        layeredPane.add(time_4, Integer.valueOf(4));
        layeredPane.add(time_5, Integer.valueOf(4));
        layeredPane.add(calendarLabel, Integer.valueOf(4));
        layeredPane.add(nextButton, Integer.valueOf(4));
        layeredPane.add(previousButton, Integer.valueOf(4));
        layeredPane.add(purposeLabel, Integer.valueOf(4));


        add(topPanel);
        add(layeredPane);

        setSize(new Dimension(1200, 700));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }
    
    private String getDate() {
        String month = (String) monthsCB.getSelectedItem();
        String day = (String) daysCB.getSelectedItem();
        String year = yearTF.getText();

        String date = month + " " + day + ", " + year;

        return date;
    }
    
    private String getPurpose() {
    	String purpose = (String) purposeCB.getSelectedItem();
    	String purposeStr =  purpose;
    	
    	return purposeStr;
    }

    private String getTime() {
        String time = "";

        if (time_1.isSelected()) {
            time = time_1.getText();
        } 
        
        else if (time_2.isSelected()) {
            time = time_2.getText();
        } 
        
        else if (time_3.isSelected()) {
            time = time_3.getText();
        } 
        
        else if (time_4.isSelected()) {
            time = time_4.getText();
        } 
        
        else if (time_5.isSelected()) {
            time = time_5.getText();
        }
        
        String timeStr = time;
    	return timeStr;
    }

    @Override
    public void actionPerformed(ActionEvent e) {		
    }
    
    public static void main(String[] args) {
        ReservationFrame reserve = new ReservationFrame("NU Document Request Management System");
        reserve.setVisible(true);
    }
}
