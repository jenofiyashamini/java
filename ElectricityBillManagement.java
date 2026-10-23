import java.util.Scanner;

class ElectricityBillManagement {
    private int consumerId;
    private String consumerName;
    private int units;
    private double bill;

    public void getDetails() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Consumer ID: ");
        consumerId = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Consumer Name: ");
        consumerName = sc.nextLine();

        System.out.print("Enter Units Consumed: ");
        units = sc.nextInt();
    }

    public void calculateBill() {
        bill = units * 5;
    }

    public void calculateBill(double surcharge) {
        bill = (units * 5) + surcharge;
    }

    public static void companyInfo() {
        System.out.println("\n***** ABC ELECTRICITY BOARD *****");
    }

    public void display() {
        System.out.println("\n----- Electricity Bill -----");
        System.out.println("Consumer ID   : " + consumerId);
        System.out.println("Consumer Name : " + consumerName);
        System.out.println("Units Used    : " + units);
        System.out.println("Bill Amount   : $" + bill);
    }

    public static void main(String[] args) {
        ElectricityBillManagement e =
            new ElectricityBillManagement();

        e.getDetails();
        companyInfo();
        e.calculateBill();
        e.display();
    }
}