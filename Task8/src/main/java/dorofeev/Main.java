package dorofeev;

import java.util.ArrayList;
import java.util.List;

public class Main {
    /**
     * @param array  Массив входных значений.
     * @param filter Фильтр для работы со значениями.
     * @param <T>    Тип элементов.
     * @return Список отфилтрованных элементов.
     */
    public static <T> List<T> filter(T[] array, Filter<T> filter) {
        List<T> list = new ArrayList<>();

        for (var i : array) {
            if (filter.apply(i)) {
                list.add(i);
            }
        }
        return list;
    }
}

@FunctionalInterface
interface Filter<T> {
    boolean apply(T element);
}