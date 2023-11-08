package project;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class OrderSlipSummary extends JFrame {
    private DefaultTableModel tableModel;
    private JPanel topPanel, summaryPanel, tablePanel;
    private ImageIcon logo;
    private Image image, resizedImage;
    private JLabel logoLabel, headings, noteLabel, userInfo, orderSlipInfo;
    private JLabel totalLabel, nameLabel, studentIDLabel, departmentLabel, yearLabel, dateLabel;
    private JTextField total;
    private JButton payment;
    private JTable table;
    private JScrollPane tableSP;

    OrderSlipSummary(String _totalAmount) {
        setTitle("NU Document Request Management System");

        topPanel = new JPanel();
        topPanel.setBackground(new Color(0x293478));
        topPanel.setBounds(0, 0, 520, 80);
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));

        logo = new ImageIcon("C:\\Users\\Charles\\Documents\\NetBeansProjects\\Student Docqueue\\NU LOGO.png");
        image = logo.getImage();
        resizedImage = image.getScaledInstance(100, 70, java.awt.Image.SCALE_SMOOTH);
        logo = new ImageIcon(resizedImage);

        logoLabel = new JLabel("<html> <font size=\"6\"> STUDENT DOCQUEUE </font> <br> <font size=\"5\"> NATIONAL UNIVERSITY </font> <html>");
        logoLabel.setFont(new java.awt.Font("Tahoma", Font.BOLD, 20));
        logoLabel.setIconTextGap(10);
        logoLabel.setForeground(Color.WHITE);
        logoLabel.setIcon(logo);

        topPanel.add(logoLabel, BorderLayout.CENTER);

        summaryPanel = new JPanel();
        summaryPanel.setBackground(new Color(0xf2cc19));
        summaryPanel.setLayout(null);
        summaryPanel.setBounds(20, 90, 465, 515);

        UserManagement users = new UserManagement("", "", "", "", "", "", "", "", 0, "", "", 0, 0);

        String studentId = users.getStudentID();
        String name = users.getName();
        String dept = users.getDepartment();
        int year = users.getYear();

        headings = new JLabel("REQUESTED DOCUMENTS");
        headings.setHorizontalAlignment(JLabel.CENTER);
        headings.setFont(new Font("Tahoma", Font.BOLD, 20));
        headings.setForeground(new Color(0x293476));
        headings.setBounds(0, 10, 475, 25);

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String formattedDate = currentDate.format(formatter);

        dateLabel = new JLabel("Date: " + formattedDate);
        dateLabel.setBounds(335, 40, 150, 15);
        dateLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        dateLabel.setForeground(Color.BLACK);

        userInfo = new JLabel("PERSONAL INFORMATION");
        userInfo.setFont(new Font("Tahoma", Font.BOLD, 15));
        userInfo.setForeground(new Color(0x293476));
        userInfo.setBounds(15, 60, 230, 15);

        studentIDLabel = new JLabel("STUDENT ID: " + studentId);
        studentIDLabel.setBounds(15, 80, 250, 20);
        studentIDLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        studentIDLabel.setForeground(Color.BLACK);

        nameLabel = new JLabel("NAME: " + name);
        nameLabel.setBounds(15, 100, 250, 20);
        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        nameLabel.setForeground(Color.BLACK);

        departmentLabel = new JLabel("DEPARTMENT: " + dept);
        departmentLabel.setBounds(15, 120, 450, 20);
        departmentLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        departmentLabel.setForeground(Color.BLACK);

        yearLabel = new JLabel("YEAR: " + year);
        yearLabel.setBounds(15, 140, 250, 20);
        yearLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        yearLabel.setForeground(Color.BLACK);

        orderSlipInfo = new JLabel("ORDER SLIP SUMMARY");
        orderSlipInfo.setFont(new Font("Tahoma", Font.BOLD, 15));
        orderSlipInfo.setForeground(new Color(0x293476));
        orderSlipInfo.setBounds(15, 165, 230, 15);

        tablePanel = new JPanel();
        tablePanel.setBounds(10, 185, 445, 280);
        tablePanel.setLayout(new BorderLayout());

        String[] columnNames = {"ITEM CODE", "TERM", "COPIES", "UNIT PRICE", "AMOUNT"};

        tableModel = new DefaultTableModel();
        for (String columnName : columnNames) {
            tableModel.addColumn(columnName);
        }

        table = new JTable(tableModel);
        table.getTableHeader().setReorderingAllowed(false);
        table.setRowHeight(20);
        table.setEnabled(false);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);

        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumnModel columnModel = table.getColumnModel();

        columnModel.getColumn(0).setPreferredWidth(110);
        columnModel.getColumn(1).setPreferredWidth(62);
        columnModel.getColumn(2).setPreferredWidth(90);
        columnModel.getColumn(3).setPreferredWidth(90);
        columnModel.getColumn(4).setPreferredWidth(90);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, centerRenderer);

        tableSP = new JScrollPane(table);

        table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 12));
        table.getTableHeader().setForeground(Color.WHITE);
        table.getTableHeader().setBackground(new Color(0x293478));
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);
        table.setOpaque(true);
        table.setEnabled(false);

        total = new JTextField(_totalAmount);
        total.setFont(new Font("Tahoma", Font.BOLD, 15));
        total.setForeground(Color.WHITE);
        total.setBackground(new Color(0x293478));
        total.setHorizontalAlignment(SwingConstants.RIGHT);
        total.setEditable(false);

        tablePanel.add(tableSP, BorderLayout.CENTER);
        tablePanel.add(total, BorderLayout.SOUTH);

        String note = "Please confirm your personal information and the documents you requested before proceeding to payment.";
        noteLabel = new JLabel("<html><div style='text-align: center;'>" + note + "</div></html>");
        noteLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
        noteLabel.setHorizontalAlignment(JLabel.CENTER);
        noteLabel.setBounds(10, 470, 445, 35);

        payment = new JButton("PAYMENT");
        payment.setHorizontalAlignment(SwingConstants.CENTER);
        payment.setFont(new Font("Tahoma", Font.BOLD, 15));
        payment.setBackground(new Color(0x00FF00));
        payment.setForeground(Color.WHITE);
        payment.setBounds(170, 620, 150, 25);
        payment.setFocusable(false);
        payment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); 
                String firstName = getName(); 
                PaymentFrame payment = new PaymentFrame ("NU Document Request Management System");
            }
        });

        summaryPanel.add(headings);
        summaryPanel.add(noteLabel);
        summaryPanel.add(dateLabel);
        summaryPanel.add(userInfo);
        summaryPanel.add(studentIDLabel);
        summaryPanel.add(nameLabel);
        summaryPanel.add(departmentLabel);
        summaryPanel.add(yearLabel);
        summaryPanel.add(orderSlipInfo);
        summaryPanel.add(tablePanel);

        add(summaryPanel);
        add(payment);
        add(topPanel);

        setSize(520, 700);
        setLayout(null);
        getContentPane().setBackground(new Color(0x293478));
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    private String getFirstname(){
        String firstName = null;
        return firstName;
    }

    public void addColumnsToDestinationTable(Vector<Vector<Object>> columnData) {
        table.getModel();
        for (Vector<Object> rowData : columnData) {
            tableModel.addRow(rowData);
        }
    }
}
