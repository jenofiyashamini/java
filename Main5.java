import java.util.Scanner;

class Bill {
    void calculateBill(int units) {
        System.out.println("Bill calculation");
    }
}

class EBilling extends Bill {
    String name;
    int id;

    EBilling(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    void calculateBill(int units) {
        double bill;

        if (units <= 100) {
            bill = units * 1.5;
        } else if (units <= 200) {
            bill = 100 * 1.5 + (units - 100) * 2.5;
        } else {
            bill = 100 * 1.5 + 100 * 2.5
                    + (units - 200) * 4.0;
        }

        System.out.println("\n--- E-BILL ---");
        System.out.println("Customer Name : " + name);
        System.out.println("Customer ID   : " + id);
        System.out.println("Units Consumed: " + units);
        System.out.println("Total Bill    : Rs. " + bill);
    }
}

public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Customer ID: ");
        int id = sc.nextInt();

        System.out.print("Enter Units Consumed: ");
        int units = sc.nextInt();

        EBilling obj = new EBilling(name, id);
        obj.calculateBill(units);

        sc.close();
    }
}