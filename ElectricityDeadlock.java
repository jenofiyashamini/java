class ElectricityDeadlock extends Thread {

    static Object meter = new Object();
    static Object printer = new Object();

    int choice;

    ElectricityDeadlock(int choice) {
        this.choice = choice;
    }

    public void run() {

        if (choice == 1) {

            synchronized (meter) {

                System.out.println("Thread 1 locked Electricity Meter");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }

                synchronized (printer) {
                    System.out.println("Thread 1 locked Printer");
                }
            }

        } else {

            synchronized (printer) {

                System.out.println("Thread 2 locked Printer");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }

                synchronized (meter) {
                    System.out.println("Thread 2 locked Electricity Meter");
                }
            }
        }
    }

    public static void main(String[] args) {

        ElectricityDeadlock t1 = new ElectricityDeadlock(1);
        ElectricityDeadlock t2 = new ElectricityDeadlock(2);

        t1.start();
        t2.start();
    }
}