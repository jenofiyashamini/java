class ElectricityThread extends Thread {

    String name = "Jenofiya";
    int units = 250;
    double bill;

    void calculateBill() {
        bill = 0;

        for (int i = 1; i <= units; i++) {

            if (i <= 100)
                bill += 1.5;

            else if (i <= 200)
                bill += 2.5;

            else if (i <= 500)
                bill += 4;

            else
                bill += 6;
        }
    }

    public void run() {

        calculateBill();

        System.out.println("Name  : " + name);
        System.out.println("Units : " + units);
        System.out.println("Bill  : Rs." + bill);
        System.out.println("Bill Paid");
    }

    public static void main(String[] args) {

        ElectricityBill t = new ElectricityBill();

        System.out.println("Electricity Bill");

        t.start();

        System.out.println("Electricity Bill for this month");
    }
}