package dorofeev;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestLifeCycleThread {

    @Test
    void newStateThread_ReturnStateNew() {
        Assertions.assertEquals("NEW", LifeCycleThread.newStateThread().toString());
    }

    @Test
    void runnableStateThread_ReturnStateRunnable() {
        Assertions.assertEquals("RUNNABLE", LifeCycleThread.runnableStateThread().toString());
    }

    @Test
    void waitingStateThread_ReturnStateWaiting() {
        Assertions.assertEquals("WAITING", LifeCycleThread.waitingStateThread().toString());
    }

    @Test
    void waitingStateThread_ReturnStateTimedWaiting() {
        Assertions.assertEquals("TIMED_WAITING", LifeCycleThread.timedWaitingStateThread().toString());
    }

    @Test
    void waitingStateThread_ReturnStateTerminated() {
        Assertions.assertEquals("TERMINATED", LifeCycleThread.terminatedStateThread().toString());
    }

    @Test
    void waitingStateThread_ReturnStateBlocked() {
        Assertions.assertEquals("BLOCKED", LifeCycleThread.blockedStateThread().toString());
    }
}