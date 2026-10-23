import java.util.Scanner;

interface Customer {
    void customerDetails();
}

interface Bill {
    void calculateBill();
}

class EBilling implements Customer, Bill {
    String name;
    int id;
    int units;
    double total;

    EBilling(String name, int id, int units) {
        this.name = name;
        this.id = id;
        this.units = units;
    }

    public void customerDetails() {
        System.out.println("Customer Name: " + name);
        System.out.println("ID           : " + id);
    }

    public void calculateBill() {
        total = 0;

        for (int i = 1; i <= units; i++) {
            if (i <= 100) {
                total += 1.5;
            } else if (i <= 200) {
                total += 2.5;
            } else {
                total += 4.0;
            }
        }

        System.out.println("Units        : " + units);
        System.out.println("Bill         : Rs. " + total);
    }
}

public class Main6A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        System.out.print("Enter Units: ");
        int units = sc.nextInt();

        EBilling e = new EBilling(name, id, units);

        System.out.println("\n--- E-BILL ---");
        e.customerDetails();
        e.calculateBill();

        sc.close();
    }
}