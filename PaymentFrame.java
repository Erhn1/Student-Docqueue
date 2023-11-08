package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PaymentFrame extends JFrame implements ActionListener {
    private JPanel topPanel, topLeftPanel, topRightPanel;
    private ImageIcon logo;
    private Image image, resizedImage;
    private JLabel logoLabel, docuRequestLabel;
    private JLayeredPane layeredPane;
    private PaymentPanel paymentPanel;
    private JMenu menu;
    private JMenuBar menuBar;
    private JMenuItem logout;
    private JButton continueButton;

    PaymentFrame(String title) {
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

        docuRequestLabel = new JLabel("Payment");
        docuRequestLabel.setFont(new java.awt.Font("Tahoma", Font.BOLD, 18));
        docuRequestLabel.setIconTextGap(10);
        docuRequestLabel.setForeground(Color.WHITE);
        docuRequestLabel.setBounds(3, 5, 5, 5);

        topLeftPanel.add(logoLabel);

        topRightPanel = new JPanel();
        topRightPanel.setBackground(new Color(0x293478));
        topRightPanel.setPreferredSize(new Dimension(1000, 80));
        topRightPanel.setLayout(new FlowLayout(FlowLayout.TRAILING, 10, 0));

        menu = new JMenu("Menu" );
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
                        JOptionPane.showMessageDialog(null, "Thank you for using NU Document Request Management System!");

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
        paymentPanel.addImage("C:\\Users\\Charles\\Downloads\\PaymentQRBG.png", 1185, 585);

        layeredPane.add(paymentPanel.getPanel(), Integer.valueOf(1));

        continueButton = new JButton("Continue");
        continueButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        continueButton.setBackground(new Color(0xF9B60E));
        continueButton.setForeground(Color.white);
        continueButton.setFocusable(false);
        continueButton.setBounds(975, 535, 100, 25); 
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                PaymentDetailsFrame paymentDetailsFrame = new PaymentDetailsFrame("NU Document Request Management System");
            }
        });
        
        layeredPane.add(continueButton, Integer.valueOf(4));

        add(topPanel);
        add(layeredPane);

        setSize(new Dimension(1200, 700));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(menu)) {
            menu.setForeground(Color.orange);
        }
    }

    public static void main(String[] args) {
        PaymentFrame paymentFrame = new PaymentFrame("NU Document Request Management System");
        paymentFrame.setVisible(true);
    }
}
