package dorofeev;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public final class WorkWithText {
    private static final int NUMBER_OF_MOST_COMMON_WORDS = 10;
    private static final String regex = "\\s+";

    private WorkWithText() {
    }

    /**
     * @param str Обрабатываемая строка.
     * @return Возвращает массив не более чем из 10 часто встречаемых слов в порядке убывания.
     * @throws EmptyStringException Если строка пустая, то будет выброшено исключение такого типа.
     */
    public static String[] frequencyOfWordsInTheText(@NotNull String str) throws EmptyStringException {
        if (str.isEmpty())
            throw new EmptyStringException("Пустая строка!");
        return getObjectLongLinkedHashMap(str, regex);
    }

    /**
     * @param str         Обрабатываемая строка.
     * @param customRegex Пользовательское регулярное выражение.
     * @return Возвращает массив не более чем из 10 часто встречаемых слов в порядке убывания.
     * @throws EmptyStringException Если строка пустая, то будет выброшено исключение такого типа.
     */
    public static String[] frequencyOfWordsInTheText(@NotNull String str, @NotNull String customRegex) throws EmptyStringException {
        if (str.isEmpty())
            throw new EmptyStringException("Пустая строка!");

        return getObjectLongLinkedHashMap(str, customRegex);
    }

    private static String[] getObjectLongLinkedHashMap(@NotNull String str, String regex) {
        Map<String, Long> collect = Arrays.stream(str.split(regex))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));

        return collect
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder((value1, value2) ->
                        value1.getValue().equals(value2.getValue()) ?
                                (value1.getKey()).compareTo(value2.getKey()) :
                                (value1.getValue().compareTo(value2.getValue()))))
                .limit(NUMBER_OF_MOST_COMMON_WORDS)
                .map(Map.Entry::getKey)
                .toArray(String[]::new);
    }
}

