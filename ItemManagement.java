package project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;

public class ItemManagement extends Item {
    private List<Item> items;

    public ItemManagement(String itemCode, String name, String size, double unitPrice) {
        super(itemCode, name, size, unitPrice);
        items = new ArrayList<>();
        loadItemsFromFile();
    }

    private void loadItemsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Charles\\Documents\\Projects\\Trial\\documents.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] itemInfo = line.split(",");
                if (itemInfo.length >= 4) {
                    String itemCode = itemInfo[0];
                    String name = itemInfo[1];
                    String size = itemInfo[2];
                    double unitPrice = Double.parseDouble(itemInfo[3]);

                    Item item = new Item(itemCode, name, size, unitPrice);
                    items.add(item);
                } 
                
                else {
                    System.err.println("Invalid line: " + line);
                }
            }
        } 
        
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double getPrice(String itemCode, String size) {
        for (Item item : items) {
            if (item.getItemCode().equals(itemCode) && item.getSize().equals(size)) {
                return item.getUnitPrice();
            }
        }
        return 0.0;
    }

    public String getItem(String itemCode) {
        for (Item item : items) {
            if (item.getItemCode().equals(itemCode)) {
                return item.getName();
            }
        }
        return null;
    }

    public String getItemCode(String itemCode) {
        for (Item item : items) {
            if (item.getItemCode().equals(itemCode)) {
                return item.getItemCode();
            }
        }
        return null;
    }
}
