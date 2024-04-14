package top.cadecode.learn.leetcode.answer;

import java.util.function.IntConsumer;

public class P1195FizzBuzz {
    private int n;

    private volatile int num = 1;

    public P1195FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (num <= n) {
            synchronized (this) {
                while (num <= n && !(num % 3 == 0 && num % 5 != 0)) {
                    this.wait();
                }
                if (num > n) {
                    this.notifyAll();
                    break;
                }
                printFizz.run();
                num++;
                this.notifyAll();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (num <= n) {
            synchronized (this) {
                while (num <= n && !(num % 5 == 0 && num % 3 != 0)) {
                    this.wait();
                }
                if (num > n) {
                    this.notifyAll();
                    break;
                }
                printBuzz.run();
                num++;
                this.notifyAll();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (num <= n) {
            synchronized (this) {
                while (num <= n && !(num % 5 == 0 && num % 3 == 0)) {
                    this.wait();
                }
                if (num > n) {
                    this.notifyAll();
                    break;
                }
                printFizzBuzz.run();
                num++;
                this.notifyAll();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (num <= n) {
            synchronized (this) {
                while (num <= n && !(num % 5 != 0 && num % 3 != 0)) {
                    this.wait();
                }
                if (num > n) {
                    this.notifyAll();
                    break;
                }
                printNumber.accept(num);
                num++;
                this.notifyAll();
            }
        }
    }
}
