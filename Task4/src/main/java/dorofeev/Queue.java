package dorofeev;

import dorofeev.exception.EmptyQueueException;

import java.util.Arrays;

public class Queue {
    private final int SIZE_ARRAY = 100;

    public Queue() {
        queueArray = new Object[SIZE_ARRAY];
    }

    private Object[] queueArray;
    private int countElementsArray = 0;

    /**
     * Метод принимает объект и вставляет его в конец очереди.
     *
     * @param element вставляемый объект
     */
    public void enqueue(Object element) {
        if (queueArray.length == countElementsArray) {
            queueArray = resizeArray();
        }
        queueArray[countElementsArray] = element;
        countElementsArray++;
    }

    /**
     * Метод удаляет первый элемент в очереди.
     * Если очередь пуста метод выбросит исключение "EmptyQueueException"
     */
    public void dequeue() throws EmptyQueueException {
        if (queueArray[0] != null) {
            if (countElementsArray - 1 >= 0) {
                System.arraycopy(queueArray, 1, queueArray, 0, countElementsArray - 1);
            }
            countElementsArray--;
            queueArray[countElementsArray] = null;
        } else {
            throw new EmptyQueueException("Очередь пуста!");
        }
    }

    /**
     * Проверяет очередь на наличие объектов.
     *
     * @return возвращает boolean-значение в зависимости от условия.
     */
    public boolean isEmpty() {
        return queueArray[0] == null;
    }

    /**
     * @return возвращает первый элемент из очереди не удаляя его. Или выбросывает исключение типа "EmptyQueueException", если очередь пуста.
     */
    public Object top() throws EmptyQueueException {
        if (queueArray[0] == null) {
            throw new EmptyQueueException("Очередь пуста!");
        }
        return queueArray[0];
    }

    /**
     * Метод увеличивает размер массива, если тот был заполнен.
     * Увелечение происходит в 2 раза.
     *
     * @return возвращает измененный размер массива.
     */
    private Object[] resizeArray() {
        Object[] tempArray;
        tempArray = Arrays.copyOf(queueArray, queueArray.length * 2);
        return tempArray;
    }
}


