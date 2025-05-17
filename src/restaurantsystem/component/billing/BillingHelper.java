package restaurantsystem.component.billing;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class BillingHelper {
    private Scanner scan;
    private final StringBuilder fullNames;
    private static final String ORDER_FILE_PATH = "storage/order.txt";

    public BillingHelper() {
        fullNames = new StringBuilder();
        processOrderFile();
    }

    public StringBuilder getFullNames() {
        return fullNames;
    }

    public String getTotal() {
        double totalPrice = 0;

        try (Scanner fileScanner = new Scanner(new FileInputStream(ORDER_FILE_PATH))) {
            while (fileScanner.hasNextLine()) {
                fileScanner.nextLine(); // Skip name
                fileScanner.nextLine(); // Skip quantity
                String price = fileScanner.nextLine();
                totalPrice += Double.parseDouble(price);
            }
        } catch (IOException e) {
            System.err.println("Error calculating total: " + e.getMessage());
        }

        return "Total Price is: " + totalPrice;
    }

    private void processOrderFile() {
        try {
            scan = new Scanner(new File(ORDER_FILE_PATH));
            readFileContents();
        } catch (IOException e) {
            System.err.println("Order file not found: " + ORDER_FILE_PATH);
        } finally {
            if (scan != null) {
                scan.close();
            }
        }
    }

    private void readFileContents() {
        try {
            while (scan.hasNextLine()) {
                String name = scan.nextLine();
                String quantity = scan.nextLine();
                String price = scan.nextLine();
                fullNames.append(name).append(" \t")
                        .append(quantity).append("\t")
                        .append(price).append("\n");
            }
        } catch (Exception e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}