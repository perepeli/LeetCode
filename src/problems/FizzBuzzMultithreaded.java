package problems;

import java.util.function.IntConsumer;

public class FizzBuzzMultithreaded {
    private int n;
    private int num = 1;

    public FizzBuzzMultithreaded(int n) {// give lock access to next thread that executes proper next function?
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public synchronized void fizz(Runnable printFizz) throws InterruptedException {
        while(num <= n) {
            if(num % 3 != 0 || num % 5 == 0) {
                wait();
                continue;
            }
            printFizz.run();
            num++;
            notifyAll();
        }
    }

    // printBuzz.run() outputs "buzz".
    public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
        while(num <= n) {
            if(num % 5 != 0 || num % 3 == 0) {
                wait();
                continue;
            }
            printBuzz.run();
            num++;
            notifyAll();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while(num <= n) {
            if(num % 15 != 0) {
                wait();
                continue;
            }
            printFizzBuzz.run();
            num++;
            notifyAll();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void number(IntConsumer printNumber) throws InterruptedException {
        while(num <= n) {
            if(num % 3 == 0 || num % 5 == 0) {
                wait();
                continue;
            }
            printNumber.accept(num);
            num++;
            notifyAll();
        }
    }
}
