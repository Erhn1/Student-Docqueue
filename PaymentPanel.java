package project;

import javax.swing.*;

class PaymentPanel extends ContentPanel {
    private JPanel paymentPanel;
    
    PaymentPanel(int color) {
        super(color);

        paymentPanel = new JPanel();
        paymentPanel.setBackground(null);
        paymentPanel.setBounds(452, 250, 648, 315);
        paymentPanel.setLayout(null);
        paymentPanel.setVisible(false);
        addPanel(paymentPanel);
    }
}

