class BillSystem {
    private int consumerId = 101;
    private String name = "Rahul";
    private int units = 250;
    private double bill;

    public void calculateBill() {
        bill = units * 4;
    }

    public void calculateBill(double surcharge) {
        bill = (units * 4) + surcharge;
    }

    public static void companyInfo() {
        System.out.println("***** ABC ELECTRICITY BOARD *****");
    }

    public void display() {
        System.out.println("\n----- Electricity Bill -----");
        System.out.println("Consumer ID   : " + consumerId);
        System.out.println("Consumer Name : " + name);
        System.out.println("Units Used    : " + units);
        System.out.println("Bill Amount   : $" + bill);
        System.out.println("Status        : Paid");
    }

    public static void main(String[] args) {
        companyInfo();

        BillSystem e = new BillSystem();
        e.calculateBill();
        e.display();
    }
}