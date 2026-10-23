
import java.util.Scanner;

abstract class Bill {
    abstract void calculateBill(int units);
}

class EBill extends Bill {
    String name;
    int id;

    EBill(String name, int id) {
        this.name = name;
        this.id = id;
    }

    void calculateBill(int units) {
        double bill = 0;

        for (int i = 1; i <= units; i++) {
            if (i <= 100)
                bill += 1.5;
            else if (i <= 200)
                bill += 2.5;
            else
                bill += 4.0;
        }

        System.out.println("\nE-BILL");
        System.out.println("Name : " + name);
        System.out.println("ID   : " + id);
        System.out.println("Units : " + units);
        System.out.println("Bill : Rs." + bill);
    }
}

public class Main6B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        System.out.print("Enter Units: ");
        int units = sc.nextInt();

        EBill e = new EBill(name, id);
        Bill b = e;
        b.calculateBill(units);

        sc.close();
    }
}
