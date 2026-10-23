import java.util.Scanner;

class Customer {
    int customerId;
    String customerName;

    void getDetails() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Customer ID: ");
        customerId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Customer Name: ");
        customerName = sc.nextLine();
    }
}

class ElectricityBill extends Customer {
    int units;
    double bill;

    void getUnits() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Units Consumed: ");
        units = sc.nextInt();
    }

    void calculateBill() {
        if (units <= 100) {
            bill = units * 1.50;
        } else if (units <= 200) {
            bill = (100 * 1.50) + (units - 100) * 2.50;
        } else if (units <= 300) {
            bill = (100 * 1.50) + (100 * 2.50)
                    + (units - 200) * 4.00;
        } else {
            bill = (100 * 1.50) + (100 * 2.50)
                    + (100 * 4.00) + (units - 300) * 5.50;
        }
    }

    void displayBill() {
        System.out.println("\n--- Electricity Bill ---");
        System.out.println("Customer ID   : " + customerId);
        System.out.println("Customer Name : " + customerName);
        System.out.println("Units Used    : " + units);
        System.out.println("Total Bill    : Rs. " + bill);
    }
}

public class Main {
    public static void main(String[] args) {
        ElectricityBill eb = new ElectricityBill();

        eb.getDetails();
        eb.getUnits();
        eb.calculateBill();
        eb.displayBill();
    }
}