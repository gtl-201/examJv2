public class PrintEvenOddTester {

    public static void main(String... args) {
        Printer print = new Printer();
        Thread t1 = new Thread(new TaskEvenOdd(print, 100, false));
        Thread t2 = new Thread(new TaskEvenOdd(print, 100, true));
        t1.start();
        t2.start();
    }

}

class TaskEvenOdd implements Runnable {

    private int max;
    private Printer print;
    private boolean isEvenNumber;

    TaskEvenOdd(Printer print, int max, boolean isEvenNumber) {
        this.print = print;
        this.max = max;
        this.isEvenNumber = isEvenNumber;
    }

    @Override
    public void run() {
        int number = isEvenNumber == false ? 0 : 1;
        while (number <= max) {
            if (isEvenNumber) {
                if(number + 2 < 100 ){
                    if(number >=3 ){
                        number +=2;
                    }
                    print.printEven(number);
                    number += 2;
                }
            } else {
                print.printOdd(number);
                number += 2;
            }
        }
    }

}

class Printer {

    boolean isOdd = false;

    synchronized void printEven(int number) {

        while (isOdd == false) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("--" + number);
        System.out.println("--" + (number + 2));
        isOdd = false;
        notifyAll();
    }

    synchronized void printOdd(int number) {
        while (isOdd == true) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(number);
        isOdd = true;
        notifyAll();
    }

}