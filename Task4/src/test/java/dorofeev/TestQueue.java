package dorofeev;

import dorofeev.exception.EmptyQueueException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestQueue {

    Queue queue;

    @BeforeEach
    public void createNewQueue() {
        queue = new Queue();
    }

    @Test
    public void enqueue_mustInsertElement() throws EmptyQueueException {
        queue.enqueue("First");
        queue.enqueue(2);
        queue.dequeue();

        Assertions.assertEquals(2, queue.top());
    }

    @Test
    public void dequeue_mustDeleteElement() throws EmptyQueueException {
        queue.enqueue("First");
        queue.enqueue(2);
        queue.dequeue();

        Assertions.assertEquals(2, queue.top());
    }


    @Test()
    public void dequeue_mustThrowEmptyQueueException() {
        Assertions.assertThrows(EmptyQueueException.class, () -> {
            queue.dequeue();
        });

    }

    @Test
    public void top_mustReturnFirstElementWithoutDeletingIt() throws EmptyQueueException {
        queue.enqueue("First");
        queue.enqueue(2);
        queue.enqueue("Third");
        queue.enqueue(4);

        Assertions.assertEquals("First", queue.top());
    }

    @Test
    public void top_mustThrowEmptyQueueException() {
        Assertions.assertThrows(EmptyQueueException.class, () -> {
            queue.top();
        });
    }

    @Test
    public void isEmpty_mustReturnTrue() {
        Assertions.assertTrue(queue.isEmpty());
    }


}
