package dorofeev;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class TestLinkedList {

    LinkedList linkedList;

    @BeforeEach
    public void createLinkedList() {
        linkedList = new LinkedList();
    }

    @Test
    public void add_InsertElement() {
        linkedList.add(1);
        Assertions.assertEquals(1, linkedList.getLast());
        linkedList.add(2);
        Assertions.assertEquals(2, linkedList.getLast());
        linkedList.add(3);
        Assertions.assertEquals(3, linkedList.getLast());
        linkedList.add(4);
        Assertions.assertEquals(4, linkedList.getLast());
    }

    @Test
    public void addFirst_InsertElementInBeginning() {
        linkedList.addFirst("Third");
        Assertions.assertEquals("Third", linkedList.getFirst());
        linkedList.addFirst("Second");
        Assertions.assertEquals("Second", linkedList.getFirst());
        linkedList.addFirst("First");
        Assertions.assertEquals("First", linkedList.getFirst());
    }

    @Test
    public void addFirst_InsertElementInEnd() {
        linkedList.addLast("First");
        Assertions.assertEquals("First", linkedList.getLast());
        linkedList.addLast("Second");
        Assertions.assertEquals("Second", linkedList.getLast());
        linkedList.addLast("Third");
        Assertions.assertEquals("Third", linkedList.getLast());
    }

    @Test
    public void get_ReturnElementByIndex() {
        linkedList.add("First");
        linkedList.add(2);
        linkedList.add("Third");
        linkedList.add(4);
        linkedList.add("Five");

        Assertions.assertEquals("First", linkedList.get(0));
        Assertions.assertEquals(2, linkedList.get(1));
        Assertions.assertEquals("Third", linkedList.get(2));
        Assertions.assertEquals(4, linkedList.get(3));
        Assertions.assertEquals("Five", linkedList.get(4));
    }

    @Test
    public void get_ThrowNoSuchElementException() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            linkedList.get(0);
        });
    }

    @Test
    public void getFirst_ReturnFirstElement() {
        linkedList.add("First");
        linkedList.add(2);
        linkedList.add("Third");

        Assertions.assertEquals("First", linkedList.getFirst());

        linkedList.addFirst(1);

        Assertions.assertEquals(1, linkedList.getFirst());
    }

    @Test
    public void getFirst_ThrowNoSuchElementException() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            linkedList.getFirst();
        });
    }

    @Test
    public void getLast_ReturnLastElement() {
        linkedList.add("First");
        linkedList.add(2);
        linkedList.add("Third");

        Assertions.assertEquals("Third", linkedList.getLast());

        linkedList.addLast("Last");

        Assertions.assertEquals("Last", linkedList.getLast());
    }

    @Test
    public void getLast_ThrowNoSuchElementException() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            linkedList.getLast();
        });
    }

    @Test
    public void remove_DeleteAnItem() {
        linkedList.add("First");
        linkedList.add(2);
        linkedList.add("Third");
        linkedList.remove(2);

        Assertions.assertEquals("Third", linkedList.get(1));

        linkedList.remove("First");

        Assertions.assertEquals("Third", linkedList.get(0));
    }

    @Test
    public void remove_DeleteNonExistingElement() {
        linkedList.add("First");
        linkedList.add("Second");
        linkedList.add("Third");

        Assertions.assertFalse(linkedList.remove("non-existing elements"));
        Assertions.assertFalse(linkedList.remove(55));
        Assertions.assertFalse(linkedList.remove("secondary"));
        Assertions.assertFalse(linkedList.remove(3));
    }

    @Test
    public void remove_ThrowNoSuchElementException() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            linkedList.remove("element");
        });
    }

    @Test
    public void removeFirst_DeleteFirstElement() {
        linkedList.addFirst("First");
        linkedList.addFirst("Second");
        linkedList.addFirst("Third");
        linkedList.addFirst("Four");

        linkedList.removeFirst();

        Assertions.assertEquals("Third", linkedList.getFirst());

        linkedList.removeFirst();

        Assertions.assertEquals("Second", linkedList.getFirst());

        linkedList.removeFirst();

        Assertions.assertEquals("First", linkedList.getFirst());

        linkedList.removeFirst();

        Assertions.assertEquals(0, linkedList.length());
    }

    @Test
    public void removeFirst_ThrowNoSuchElementException() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            linkedList.removeFirst();
        });
    }

    @Test
    public void removeLast_DeleteLastElement() {
        linkedList.addFirst("First");
        linkedList.addFirst("Second");
        linkedList.addFirst("Third");
        linkedList.addFirst("Four");

        linkedList.removeLast();

        Assertions.assertEquals("Second", linkedList.getLast());

        linkedList.removeLast();

        Assertions.assertEquals("Third", linkedList.getLast());

        linkedList.removeLast();

        Assertions.assertEquals("Four", linkedList.getLast());

        linkedList.removeLast();

        Assertions.assertEquals(0, linkedList.length());

    }

    @Test
    public void removeLast_ThrowNoSuchElementException() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            linkedList.removeLast();
        });
    }

    @Test
    public void isEmpty_ReturnTrue() {
        Assertions.assertTrue(linkedList.isEmpty());
    }

    @Test
    public void isEmpty_ReturnFalse() {
        linkedList.add("a");

        Assertions.assertFalse(linkedList.isEmpty());
    }

    @Test
    public void length_ReturnTheNumberOfListItems() {
        Assertions.assertEquals(0, linkedList.length());

        linkedList.add(1);

        Assertions.assertEquals(1, linkedList.length());

        linkedList.add(1);
        linkedList.add(1);
        linkedList.add(1);
        linkedList.add(1);

        Assertions.assertEquals(5, linkedList.length());

        linkedList.remove(1);
        linkedList.remove(1);
        linkedList.remove(1);
        linkedList.remove(1);
        linkedList.remove(1);

        Assertions.assertEquals(0, linkedList.length());
    }


}
