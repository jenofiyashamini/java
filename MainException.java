import java.util.Scanner;

class BillException extends Exception {

    BillException(String message) {
        super(message);
    }
}

class ElectricityBill {

    String customerName;
    int units;
    double billAmount;

    ElectricityBill(String customerName, int units) {
        this.customerName = customerName;
        this.units = units;
    }

    void calculateBill() throws BillException {

        if (units < 0) {
            throw new BillException("Units cannot be negative");
        }

        if (units <= 100) {
            billAmount = units * 1.50;
        } 
        else if (units <= 200) {
            billAmount = 100 * 1.50 + (units - 100) * 2.50;
        } 
        else {
            billAmount = 100 * 1.50 + 100 * 2.50
                       + (units - 200) * 4.00;
        }

        System.out.println("Bill calculated successfully");
    }

    void display() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Units Consumed: " + units);
        System.out.println("Bill Amount: Rs." + billAmount);
    }
}

public class MainException {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String name = sc.nextLine();

        System.out.print("Enter units consumed: ");
        int units = sc.nextInt();

        ElectricityBill bill = new ElectricityBill(name, units);

        System.out.println("\nElectricity Bill Details:");
        bill.display();

        try {
            bill.calculateBill();
        }
        catch (BillException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        System.out.println("\nFinal Bill Details:");

        if (units >= 0) {
            bill.display();
        }

        sc.close();
    }
}