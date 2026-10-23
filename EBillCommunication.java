class EBillCommunication {

    int units;
    double bill;
    boolean calculated = false;

    synchronized void calculateBill() {

        System.out.println("Calculating electricity bill...");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        bill = 0;

        if (units <= 100)
            bill = units * 1.5;
        else if (units <= 200)
            bill = 100 * 1.5 + (units - 100) * 2.5;
        else
            bill = 100 * 1.5 + 100 * 2.5 + (units - 200) * 4;

        calculated = true;

        System.out.println("Bill calculation completed.");

        notify();
    }

    synchronized void displayBill() {

        try {
            while (!calculated) {
                System.out.println("Waiting for bill calculation...");
                wait();
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("\nElectricity Bill");
        System.out.println("----------------");
        System.out.println("Units : " + units);
        System.out.println("Bill  : Rs." + bill);
    }

    public static void main(String[] args) {

        EBillCommunication ebill = new EBillCommunication();

        ebill.units = 250;

        Thread t1 = new Thread(() -> {
            ebill.calculateBill();
        });

        Thread t2 = new Thread(() -> {
            ebill.displayBill();
        });

        t2.start();
        t1.start();
    }
}