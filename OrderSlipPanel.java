package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.table.*;

class OrderSlipPanel extends ContentPanel {

    private DefaultTableModel tableModel;
    private JPanel orderSlipPanel, tablePanel;
    private JTable table;
    private JScrollPane tableSP;
    private JTextField amount;
    private JLabel orderSlipLabel, note;

    private JLabel itemCodeLabel, quantityLabel, sizeLabel;
    private JTextField itemCodeLabelTF;
    private JButton confirm, add, remove;
    private JComboBox sizeCB, quantityCB;

    private ArrayList<Integer> numberList = new ArrayList<>();

    OrderSlipPanel(int color) {
        super(color);

        orderSlipPanel = new JPanel();
        orderSlipPanel.setBackground(null);
        orderSlipPanel.setBounds(475, 250, 648, 315);
        orderSlipPanel.setLayout(null);

        orderSlipLabel = new JLabel("ORDER SLIP FORM");
        orderSlipLabel.setHorizontalAlignment(JLabel.CENTER);
        orderSlipLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
        orderSlipLabel.setForeground(new Color(0x293476));
        //orderSlipLabel.setBounds(20, 20, 460, 30);

        String text = "Before you add items please check the size chart and items offered";

        note = new JLabel("<html><div style='text-align: center;'>" + text + "</div></html>");
        note.setHorizontalAlignment(JLabel.CENTER);
        note.setFont(new Font("Tahoma", Font.BOLD, 11));
        //note.setBounds(20, 60, 460, 15);

        itemCodeLabel = new JLabel("ITEM CODE:");
        itemCodeLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
        itemCodeLabel.setForeground(Color.white);
        itemCodeLabel.setBounds(15, 13, 250, 20);

        itemCodeLabelTF = new JTextField();
        itemCodeLabelTF.setFont(new Font("Tahoma", Font.BOLD, 16));
        itemCodeLabelTF.setForeground(Color.BLACK);
        itemCodeLabelTF.setBounds(170, 13, 150, 25);

        quantityLabel = new JLabel("COPIES:");
        quantityLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
        quantityLabel.setForeground(Color.white);
        quantityLabel.setBounds(350, 13, 120, 20);

        String qty[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

        quantityCB = new JComboBox(qty);
        quantityCB.setForeground(Color.BLACK);
        quantityCB.setBackground(Color.WHITE);
        ((JLabel) quantityCB.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        quantityCB.setBounds(460, 13, 170, 25);

        sizeLabel = new JLabel("TERM:");
        sizeLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
        sizeLabel.setForeground(Color.WHITE);
        sizeLabel.setBounds(15, 60, 120, 20);

        String sizes[] = {"1", "2", "3", "N/A"};

        sizeCB = new JComboBox(sizes);
        sizeCB.setForeground(Color.BLACK);
        sizeCB.setBackground(Color.WHITE);
        ((JLabel) sizeCB.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        sizeCB.setBounds(100, 60, 220, 25);

        add = new JButton("ADD");
        add.setHorizontalAlignment(SwingConstants.CENTER);
        add.setFont(new Font("Tahoma", Font.BOLD, 15));
        add.setBackground(new Color(0x33FF33));
        add.setForeground(Color.WHITE);
        add.setBounds(350, 60, 135, 25);
        add.setFocusable(false);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItem();
            }
        });

        remove = new JButton("REMOVE");
        remove.setHorizontalAlignment(SwingConstants.CENTER);
        remove.setFont(new Font("Tahoma", Font.BOLD, 15));
        remove.setBackground(new Color(0XFF3333));
        remove.setForeground(Color.WHITE);
        remove.setBounds(495, 60, 135, 25);
        remove.setFocusable(false);
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String select = JOptionPane.showInputDialog(null, "ENTER THE ID:", "Delete Item", JOptionPane.INFORMATION_MESSAGE);
                if (select != null && !select.isEmpty()) {
                    int id = Integer.parseInt(select);

                    int rowCount = tableModel.getRowCount();
                    boolean found = false;
                    for (int i = 0; i < rowCount; i++) {
                        int rowId = (int) tableModel.getValueAt(i, 0);
                        if (rowId == id) {
                            tableModel.removeRow(i);
                            numberList.remove(i);
                            updateRowNumbers();
                            found = true;
                            break;
                        }
                    }

                    if (found) {
                        updateTotal();
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid ID", "Error", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No ID entered", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        tablePanel = new JPanel();
        tablePanel.setBounds(13, 100, 620, 170);
        tablePanel.setLayout(new BorderLayout());

        String[] columnNames = {"ID", "ITEM CODE", "DOCUMENT TYPE", "TERM", "COPIES", "UNIT PRICE", "AMOUNT"};

        tableModel = new DefaultTableModel();
        for (String columnName : columnNames) {
            tableModel.addColumn(columnName);
        }

        table = new JTable(tableModel);
        table.setRowHeight(40);
        table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 12));
        table.getTableHeader().setForeground(Color.WHITE);
        table.getTableHeader().setBackground(new Color(0x293478));
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);
        table.setOpaque(true);
        table.setEnabled(false);

        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumnModel columnModel = table.getColumnModel();

        columnModel.getColumn(0).setPreferredWidth(25);
        columnModel.getColumn(1).setPreferredWidth(90);
        columnModel.getColumn(2).setPreferredWidth(380);
        columnModel.getColumn(3).setPreferredWidth(100);
        columnModel.getColumn(4).setPreferredWidth(100);
        columnModel.getColumn(5).setPreferredWidth(100);
        columnModel.getColumn(6).setPreferredWidth(100);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, centerRenderer);

        tableSP = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        amount = new JTextField(10);
        amount.setFont(new Font("Tahoma", Font.BOLD, 15));
        amount.setForeground(Color.WHITE);
        amount.setBackground(new Color(0x293478));
        amount.setHorizontalAlignment(SwingConstants.RIGHT);
        amount.setEditable(false);

        tablePanel.add(tableSP, BorderLayout.CENTER);
        tablePanel.add(amount, BorderLayout.SOUTH);

        confirm = new JButton("CONFIRM");
        confirm.setHorizontalAlignment(SwingConstants.CENTER);
        confirm.setFont(new Font("Tahoma", Font.BOLD, 15));
        confirm.setBackground(new Color(0xF9B60E));
        confirm.setForeground(Color.WHITE);
        confirm.setBounds(515, 280, 115, 25);
        confirm.setFocusable(false);
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tableModel.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "No item selected.", "Order Confirmation", JOptionPane.WARNING_MESSAGE);
                } else {
                    int confirmation = JOptionPane.showConfirmDialog(null, "Do you want to confirm your orders?", "Order Confirmation", JOptionPane.YES_NO_OPTION);
                    if (confirmation == JOptionPane.YES_OPTION) {
                        String _totalAmount = getTotalAmount();
                        OrderSlipSummary summary = new OrderSlipSummary(_totalAmount);
                        int[] selectedColumns = {1, 3, 4, 5, 6};
                        summary.addColumnsToDestinationTable(getColumnData(tableModel, selectedColumns));

                        tableModel.setRowCount(0);
                        numberList.clear();
                        updateTotal();
                    }
                }
            }
        });

        orderSlipPanel.add(tablePanel);
        orderSlipPanel.add(itemCodeLabel);
        orderSlipPanel.add(quantityLabel);
        orderSlipPanel.add(sizeLabel);
        orderSlipPanel.add(itemCodeLabelTF);
        orderSlipPanel.add(quantityCB);
        orderSlipPanel.add(sizeCB);
        orderSlipPanel.add(add);
        orderSlipPanel.add(remove);
        orderSlipPanel.add(confirm);

        addPanel(orderSlipPanel);
    }
    
    private void addItem() {
	ItemManagement itemManagement = new ItemManagement("", "", "", 0);

	String itemCode = itemCodeLabelTF.getText();
	String validateItemCode = itemManagement.getItemCode(itemCode);
	String item = itemManagement.getItem(itemCode);
	String size = (String) sizeCB.getSelectedItem();
	String quantity = (String) quantityCB.getSelectedItem();
	double unitPrice = itemManagement.getPrice(itemCode, size);

	if (!itemCode.isEmpty() && !quantity.isEmpty() && !size.isEmpty()) {
            if (!itemCode.equals(validateItemCode)) {
                JOptionPane.showMessageDialog(null, "Invalid item code!", "Error", JOptionPane.ERROR_MESSAGE);
            } 
                
            else {
                JOptionPane.showMessageDialog(null, "Successfully added item!", "Add item", JOptionPane.INFORMATION_MESSAGE);
	    		
                int qty = Integer.parseInt(quantity);
                double price = unitPrice;
                double amount = qty * price;
                int rowNumber = numberList.size() + 1;
                numberList.add(rowNumber);
                tableModel.addRow(new Object[]{rowNumber, itemCode, item, size, quantity, price, amount});
		clearFields();
		updateTotal();
            }
	} 
            
        else {
            JOptionPane.showMessageDialog(null, "You need to insert ITEM CODE!", "Error", JOptionPane.ERROR_MESSAGE);
	}
    }
	
    private void updateTotal() {
        double total = 0.0;
        int rowCount = tableModel.getRowCount();

        for (int i = 0; i < rowCount; i++) {
            String priceString = tableModel.getValueAt(i, 6).toString();
            double price = Double.parseDouble(priceString);
            total += price;
        }

        amount.setText("Total Amount: " + total);
    }
	
    private void updateRowNumbers() {
	int rowCount = tableModel.getRowCount();
        for (int i = 0; i < rowCount; i++) {
	    tableModel.setValueAt(i + 1, i, 0);
	    numberList.set(i, i + 1);
	}
    }
	
    private void clearFields() {
        itemCodeLabelTF.setText("");
        quantityCB.setSelectedItem(Integer.valueOf(0));
 	sizeCB.setSelectedItem(Integer.valueOf(0));
    }
	
    private Vector<Vector<Object>> getColumnData(DefaultTableModel model, int[] columnIndices) {
        Vector<Vector<Object>> columnData = new Vector<>();

        for (int i = 0; i < model.getRowCount(); i++) {
            Vector<Object> rowData = new Vector<>();
            for (int columnIndex : columnIndices) {
                rowData.add(model.getValueAt(i, columnIndex));
            }
            columnData.add(rowData);
        }
        return columnData;
    }
	
    private String getTotalAmount() {
        String totalAmount = amount.getText();
        String total_amount = totalAmount;
        return total_amount;
    }
    
}

