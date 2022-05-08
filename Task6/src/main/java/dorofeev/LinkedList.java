package dorofeev;

import java.util.NoSuchElementException;

public class LinkedList {
    private Node head;
    private Node tail;
    private int count = 0;


    /**
     * Элемент помещается в конец списка.
     *
     * @param e элемент, помещаемый в список.
     */
    public void add(Object e) {
        addLast(e);
    }

    /**
     * Элемент помещается в начало списка.
     *
     * @param e элемент, помещаемый в список.
     */
    public void addFirst(Object e) {
        Node firstElement = new Node(e);

        if (isEmpty()) {
            tail = firstElement;
        } else {
            head.prev = firstElement;
        }

        firstElement.next = head;
        head = firstElement;

        count++;
    }

    /**
     * Элемент помещается в конец списка.
     *
     * @param e элемент, помещаемый в список.
     */
    public void addLast(Object e) {
        Node lastElement = new Node(e);

        if (isEmpty()) {
            head = lastElement;
        } else {
            lastElement.prev = tail;
            tail.next = lastElement;
        }
        tail = lastElement;

        count++;
    }

    /**
     * Метод принимает индекс искомого элемента и возвращает элемент, если тот был найден.
     * Иначе выбрасывает исключение типа "NoSuchElementException".
     *
     * @param index индекс искомого элемента.
     * @return возвращает искомый элемент.
     */
    public Object get(int index) {
        if (!isEmpty()) {
            Node temp;
            int tempCount = 0;

            if (index == 0) {
                return getFirst();
            } else if (index == count - 1) {
                return getLast();
            } else {
                if ((index + 1) > count / 2) {
                    temp = tail;
                    tempCount = count - 1;

                    while (tempCount > index) {
                        temp = temp.prev;
                        tempCount--;
                    }
                } else {
                    temp = head;

                    while (tempCount < index) {
                        temp = temp.next;
                        tempCount++;
                    }
                }
                return temp.data;
            }
        }
        throw new NoSuchElementException();
    }

    /**
     * Метод возвращает первый элемент списка или исключение типа "NoSuchElementException".
     *
     * @return возвращает первый элемент списка.
     */
    public Object getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.data;
    }

    /**
     * Метод возвращает последний элемент списка или исключение типа "NoSuchElementException".
     *
     * @return возвращает последний элемент списка.
     */
    public Object getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return tail.data;
    }

    /**
     * Метод принимает в качестве парамента элемент. И выполняет поиск в списке.
     * Если элемент найден - удаляет. Если список пуст возвращает исключение типа "NoSuchElementException".
     *
     * @return возвращает true, если элемент удален, иначе - исключение типа "NoSuchElementException".
     */
    public boolean remove(Object e) {
        if (!isEmpty()) {
            Node temp = head;

            if (e == head.data) {
                removeFirst();
            } else if (e == tail.data) {
                removeLast();
            } else {
                while (temp.data != e && temp.next != null) {
                    temp = temp.next;
                }

                if (temp.next == null) {
                    return false;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }

                count--;
            }
            return true;
        }
        throw new NoSuchElementException();
    }

    /**
     * @return возращает true, если первый элемент списка удален, иначе - исключение типа "NoSuchElementException".
     */
    public boolean removeFirst() {
        if (!isEmpty()) {
            if (head.next == null) {
                tail = null;
            } else {
                head.next.prev = null;
            }

            head = head.next;
            count--;
            return true;
        }
        throw new NoSuchElementException();
    }

    /**
     * @return возращает true, если последний элемент списка удален, иначе - исключение типа "NoSuchElementException".
     */
    public boolean removeLast() {
        if (!isEmpty()) {
            if (head.next == null) {
                head = null;
            } else {
                tail.prev.next = null;
            }

            tail = tail.prev;
            count--;
            return true;
        }
        throw new NoSuchElementException();
    }

    /**
     * @return возращает boolean-значение в зависимости от наличия элементов списка.
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * @return возращает количество элементов.
     */
    public int length() {
        return count;
    }

    /**
     * Печатает список в консоль.
     */
    public void print() {
        Node temp = head;

        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    private static class Node {
        private final Object data;
        private Node next;
        private Node prev;

        private Node(Object data) {
            this.data = data;
        }
    }
}
