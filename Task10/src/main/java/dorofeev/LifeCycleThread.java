package dorofeev;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

public class LifeCycleThread {

    public static Thread.State newStateThread() {
        return new Thread(() -> {}).getState();
    }

    public static Thread.State runnableStateThread() {
        return currentThread().getState();
    }

    public static Thread.State waitingStateThread() {
        Object sync = new Object();
        Thread thread = new Thread(() -> {
            synchronized (sync) {
                try {
                    sync.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return thread.getState();
    }

    public static Thread.State blockedStateThread() {
        Thread thread = new Thread(new ClassForSampleBlockedThread());
        Thread blockedThread = new Thread(new ClassForSampleBlockedThread());

        thread.start();
        blockedThread.start();

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return blockedThread.getState();
    }

    public static Thread.State terminatedStateThread() {
        Thread thread = new Thread(() -> {
        });
        thread.start();

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return thread.getState();
    }

    public static Thread.State timedWaitingStateThread() {
        Thread thread = new Thread(() -> {
            try {
                sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return thread.getState();
    }
}

class ClassForSampleBlockedThread implements Runnable {
    @Override
    public void run() {
        blockedThread();
    }

    public static synchronized void blockedThread() {
        while (true) {

        }
    }
}



