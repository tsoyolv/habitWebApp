package com.habit.custom.knowledges;

import com.habit.custom.knowledges.thread.UnsafeSequence;

/**
 * Created by OLTS on 26.01.2017.
 */
public class Solution {

    public static void main(String[] args) {
        execUnsafeSeq();
    }



    private static void execUnsafeSeq() {
        UnsafeSequence unsafeSequence = new UnsafeSequence();
        Thread a = new Thread(new UnsafeSequence.Run(unsafeSequence));
        Thread b = new Thread(new UnsafeSequence.Run(unsafeSequence));
        a.start(); b.start();
         /* possible result
    Thread[Thread-0,5,main] 0
Thread[Thread-1,5,main] 0
Thread[Thread-1,5,main] 1
Thread[Thread-1,5,main] 2
Thread[Thread-1,5,main] 3
Thread[Thread-1,5,main] 4
Thread[Thread-1,5,main] 5
Thread[Thread-1,5,main] 6
Thread[Thread-1,5,main] 7
Thread[Thread-1,5,main] 8
Thread[Thread-1,5,main] 9
Thread[Thread-0,5,main] 10
Thread[Thread-0,5,main] 11
Thread[Thread-0,5,main] 12
Thread[Thread-0,5,main] 13
Thread[Thread-0,5,main] 14
Thread[Thread-0,5,main] 15
Thread[Thread-0,5,main] 16
Thread[Thread-0,5,main] 17
Thread[Thread-0,5,main] 18
*/
    }

}
