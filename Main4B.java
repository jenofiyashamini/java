import java.util.Scanner;

class Customer {
    int customerId;
    String customerName;

    void getCustomerDetails() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Customer ID: ");
        customerId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Customer Name: ");
        customerName = sc.nextLine();
    }
}

class Electricity extends Customer {
    int units;

    void getUnits() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Units Consumed: ");
        units = sc.nextInt();
    }
}

class Bill extends Electricity {
    double bill, surcharge, totalBill;

    void calculateBill() {
        if (units <= 100) {
            bill = units * 2.0;
        } else if (units <= 200) {
            bill = units * 3.5;
        } else if (units <= 300) {
            bill = units * 5.0;
        } else {
            bill = units * 6.5;
        }

        bill = bill + 100;

        if (bill > 1000) {
            surcharge = bill * 0.05;
        } else {
            surcharge = 0;
        }

        totalBill = bill + surcharge;
    }

    void displayBill() {
        System.out.println("\n--- Electricity Bill ---");
        System.out.println("Customer ID   : " + customerId);
        System.out.println("Customer Name : " + customerName);
        System.out.println("Units Consumed: " + units);
        System.out.println("Energy Charge : Rs. " + bill);
        System.out.println("Surcharge (5%): Rs. " + surcharge);
        System.out.println("Total Bill    : Rs. " + totalBill);
    }
}

public class Main4B {
    public static void main(String[] args) {
        Bill b = new Bill();

        b.getCustomerDetails();
        b.getUnits();
        b.calculateBill();
        b.displayBill();
    }
}