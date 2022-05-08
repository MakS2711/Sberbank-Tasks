package dorofeev;


import dorofeev.exception.EmptyStackException;

import java.util.Arrays;

public class Stack {
    private final int SIZE_ARRAY = 100;

    public Stack() {
        stackArray = new Object[SIZE_ARRAY];
    }

    private Object[] stackArray;
    private int countElementsArray = 0;

    /**
     * Метод принимает объект и помещает его в стек сверху.
     *
     * @param element вставляемый элемент.
     */
    public void push(Object element) {
        if (stackArray.length == countElementsArray) {
            stackArray = resizeArray();
        }

        stackArray[countElementsArray] = element;
        countElementsArray++;

    }

    /**
     * Метод проверяет стек на наличие объектов, после удаляет и возвращает верхний элемент при выполнение условия.
     *
     * @return возвращает верхний элемент после удаления или выбрасывает исключение "EmptyStackException"
     */
    public Object pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException("Стек пуст!");
        }

        countElementsArray--;
        var returnElement = stackArray[countElementsArray];
        stackArray[countElementsArray] = null;

        return returnElement;
    }

    /**
     * Проверяет стек на наличие объектов.
     *
     * @return возвращает boolean-значение в зависимости от условия.
     */
    public boolean isEmpty() {
        return stackArray[0] == null;
    }

    /**
     * @return возвращает верхний элемент стека без его удаления или выбрасывает исключение "EmptyStackException".
     */
    public Object top() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException("Стек пуст!");
        }
        return stackArray[countElementsArray - 1];
    }

    /**
     * Метод увеличивает размер массива, если тот был заполнен.
     * Увелечение происходит в 2 раза.
     *
     * @return возвращает измененный размер массива.
     */
    private Object[] resizeArray() {
        Object[] tempArray;
        tempArray = Arrays.copyOf(stackArray, stackArray.length * 2);
        return tempArray;
    }

}
