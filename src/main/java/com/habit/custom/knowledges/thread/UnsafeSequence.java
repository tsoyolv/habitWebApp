package com.habit.custom.knowledges.thread;

import javax.annotation.concurrent.NotThreadSafe;

/**
 * two threads can get the same digit
 * this read-modify-write example */
@NotThreadSafe
public class UnsafeSequence {
    private int value;

    public int getNext() {
        return value++;
    }

    public static class Run implements Runnable {

        private UnsafeSequence unsafeSequence;
        public Run(){}
        public Run(UnsafeSequence unsafeSequence) {
            this.unsafeSequence = unsafeSequence;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread() + " " + unsafeSequence.getNext());
            }
        }
    }
}