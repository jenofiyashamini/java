package electricity;

public class ElectricityBill {
    String customerName;
    int units;
    double billAmount;

    public ElectricityBill(String customerName, int units) {
        this.customerName = customerName;
        this.units = units;
    }

    public void calculateBill() {
        if (units <= 100) {
            billAmount = units * 1.50;
        } else if (units <= 200) {
            billAmount = 100 * 1.50 + (units - 100) * 2.50;
        } else {
            billAmount = 100 * 1.50 + 100 * 2.50 + (units - 200) * 4.00;
        }
    }

    public void display() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Units Consumed: " + units);
        System.out.println("Bill Amount: Rs." + billAmount);
    }
}
import java.util.Scanner;
import electricity.ElectricityBill;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String name = sc.nextLine();

        System.out.print("Enter units consumed: ");
        int units = sc.nextInt();

        ElectricityBill e = new ElectricityBill(name, units);

        e.calculateBill();

        System.out.println("\nElectricity Bill Details:");
        e.display();

        sc.close();
    }
}